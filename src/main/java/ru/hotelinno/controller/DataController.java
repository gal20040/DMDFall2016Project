package ru.hotelinno.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.hotelinno.Search.Searcher;
import ru.hotelinno.domain.RESULT.Result;
import ru.hotelinno.domain.WishfulRoomData;
import ru.hotelinno.domain.roombooking.Roombooking;
import ru.hotelinno.repository.DataRepository;
import ru.hotelinno.validation.SearchDataValidator;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DataController {

    private DataRepository dataRepository;

    private SearchDataValidator searchDataValidator;

    @Autowired
    public DataController(DataRepository dataRepository, SearchDataValidator searchDataValidator){
        this.dataRepository = dataRepository;
        this.searchDataValidator = searchDataValidator;
    }

    /**
     * Get all records for index page.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getAllRecords(Model model){
//        List<Book> allRecords = this.dataRepository
//                .listAll();
//        model.addAttribute("allRecords", allRecords);
        return "index";
    }

    /**
     * Get searching page without any searching parameters.
     */
    @RequestMapping(value = "search", method = RequestMethod.GET)
    public String search(Model model){

//        WishfulRoomData wishfulRoomData = new WishfulRoomData(); //так можно задавать значения по умолчанию
//        wishfulRoomData.setCityName("Kazan");
//        wishfulRoomData.setRoomType("Comfort");
//        wishfulRoomData.setCheckInDate("11/13/2016");
//        wishfulRoomData.setCheckOutDate("11/15/2016");

//        model.addAttribute("defaultSearchData", wishfulRoomData);
        model.addAttribute("defaultSearchData", new WishfulRoomData());

        return "search";
    }

    /**
     * Get searching parameters from user.
     */
    @RequestMapping(value = "search", method = RequestMethod.POST)
    public String search(@ModelAttribute("defaultSearchData") WishfulRoomData wishfulRoomData,
                          BindingResult bindingResult,
                          Model model){
        this.searchDataValidator
                .validate(wishfulRoomData, bindingResult);
        if (bindingResult.hasErrors())
            return "search";

        Searcher searcher = new Searcher();
        List<String> searchParamsList = new ArrayList<String>();
        searchParamsList.add(wishfulRoomData.getCityName());

        searchParamsList.add(getCorrectDate(wishfulRoomData.getCheckInDate()));
        searchParamsList.add(getCorrectDate(wishfulRoomData.getCheckOutDate()));

        String roomType;
        if (wishfulRoomData.getRoomType().equals(null)
                || wishfulRoomData.getRoomType().equals("")
                || wishfulRoomData.getRoomType() == null
                || wishfulRoomData.getRoomType() == "")
            //TODO оставить только нужную проверку
            roomType = "*";
        else
            roomType = wishfulRoomData.getRoomType();

        searchParamsList.add("'" + roomType + "'");
        searchParamsList.add("*");
        List<Result> dbResponse = null;
        try {
            dbResponse = searcher.searchRooms(searchParamsList);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (dbResponse != null) {
            model.addAttribute("dbResponse", dbResponse);
            model.addAttribute("wishfulRoomData", wishfulRoomData);
        }

        return "reservation";
    }

    @RequestMapping(value = "reservation", method = RequestMethod.POST)
    public String reserver(@ModelAttribute("result") WishfulRoomData wishfulRoomData,
                         BindingResult bindingResult,
                         Model model){
//        Searcher searcher = new Searcher();
//        List<String> searchParamsList = new ArrayList<String>();
//        searchParamsList.add(wishfulRoomData.getCityName());
//
//        searchParamsList.add(getCorrectDate(wishfulRoomData.getCheckInDate()));
//        searchParamsList.add(getCorrectDate(wishfulRoomData.getCheckOutDate()));
//
//        String roomType;
//        if (wishfulRoomData.getRoomType().equals(null)
//                || wishfulRoomData.getRoomType().equals("")
//                || wishfulRoomData.getRoomType() == null
//                || wishfulRoomData.getRoomType() == "")
//            //TODO оставить только нужную проверку
//            roomType = "*";
//        else
//            roomType = wishfulRoomData.getRoomType();
//
//        searchParamsList.add("'" + roomType + "'");
//        searchParamsList.add("*");
//        List<Result> dbResponse = null;
//        try {
//            dbResponse = searcher.searchRooms(searchParamsList);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        if (dbResponse != null) {
//            model.addAttribute("dbResponse", dbResponse);
//            model.addAttribute("wishfulRoomData", wishfulRoomData);
//        }
        System.out.println(wishfulRoomData);

        return "reservation";
    }

    /**
     * Parse date "MM/dd/yyyy" to "yyyyMMdd130000".
     */
    private String getCorrectDate(String checkInDateString) {
        DateTimeHandler unrightDateTimeHandler = new DateTimeHandler("MM/dd/yyyy");
        DateTimeHandler rightDateTimeHandler = new DateTimeHandler();

        long checkInDateLong = unrightDateTimeHandler.getTimeStampInMinutes(checkInDateString);
        checkInDateString = rightDateTimeHandler.getFormattedDate(checkInDateLong);

        return checkInDateString;
    }

    @RequestMapping(value = "reserveRoom/{hotelroomid}", method = RequestMethod.GET)
//    @PreAuthorize("hasRole('admin')")
//    @PreAuthorize("isAuthenticated()")
    public String reserveRoom(@PathVariable String hotelroomid,
                              @ModelAttribute("defaultSearchData") WishfulRoomData wishfulRoomData,
                              Model model){
//        int[] ints = parseHotelRoomID(hotelroomid);
//        Searcher searcher = new Searcher();
//        wishfulRoomData = new WishfulRoomData(ints[0] + "", ints[1] + "", ints[2] + "", ints[3] + "");
//        try {
//            searcher.insertBoocking(wishfulRoomData);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
////        return "redirect:/";
//        model.addAttribute("wishfulRoomData", wishfulRoomData);
        return "userdetails";
    }

    private int[] parseHotelRoomID(String hotelroomid) {
        int i = Integer.parseInt(hotelroomid.substring(0, 1));
        int[] ints = new int[4];
        String delimiter = "019";
        int signDelimiterPosition = hotelroomid.indexOf(delimiter);
        String s = hotelroomid.substring(0, signDelimiterPosition);
        ints[0] = Integer.parseInt(s); //hotelID

        hotelroomid = hotelroomid.substring(signDelimiterPosition, hotelroomid.length());
        signDelimiterPosition = hotelroomid.indexOf(delimiter);
        ints[1] = Integer.parseInt(hotelroomid.substring(0, signDelimiterPosition)); //roomID

        hotelroomid = hotelroomid.substring(signDelimiterPosition, hotelroomid.length());
//        signDelimiterPosition = hotelroomid.indexOf(delimiter);
        ints[2] = Integer.parseInt(hotelroomid.substring(0, 14)); //checkIn

//        hotelroomid = hotelroomid.substring(signDelimiterPosition, hotelroomid.length());
//        signDelimiterPosition = hotelroomid.indexOf(delimiter);
        ints[3] = Integer.parseInt(hotelroomid.substring(14, hotelroomid.length())); //checkOut
        return ints;
    }

//    @RequestMapping(value = "deleteBook/{id}", method = RequestMethod.GET)
////    @PreAuthorize("hasRole('admin')")
//    public String deleteBook(@PathVariable Integer id){
////        this.dataRepository
////                .removeBook(id);
//        System.out.println("asdasdasd");
//        return "redirect:/";
//    }
}