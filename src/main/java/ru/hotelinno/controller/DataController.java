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
import ru.hotelinno.domain.user.User;
import ru.hotelinno.repository.DataRepository;
import ru.hotelinno.validation.SearchDataValidator;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
public class DataController {

    private DataRepository dataRepository;

    private SearchDataValidator searchDataValidator;

    private String checkInDate, checkOutDate, cityName;
    private List<Result> allResults;
    private Result choosenHotelRoom;

    @Autowired
    public DataController(DataRepository dataRepository, SearchDataValidator searchDataValidator) {
        this.dataRepository = dataRepository;
        this.searchDataValidator = searchDataValidator;
    }

    /**
     * Get all records for index page.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getAllRecords(Model model) {
//        List<Book> allRecords = this.dataRepository
//                .listAll();
//        model.addAttribute("allRecords", allRecords);
        return "index";
    }

    /**
     * Get searching page without any searching parameters.
     */
    @RequestMapping(value = "search", method = RequestMethod.GET)
    public String search(Model model) {

        //так можно задавать значения по умолчанию
        WishfulRoomData wishfulRoomData = new WishfulRoomData("Kazan", "Comfort", "11/23/2016", "11/24/2016");

        model.addAttribute("defaultSearchData", wishfulRoomData);
//        model.addAttribute("defaultSearchData", new WishfulRoomData());

        return "search";
    }

    /**
     * Get searching parameters from user.
     */
    @RequestMapping(value = "search", method = RequestMethod.POST)
    public String search(@ModelAttribute("defaultSearchData") WishfulRoomData wishfulRoomData,
                         BindingResult bindingResult,
                         Model model){
//        this.searchDataValidator
//                .validate(wishfulRoomData, bindingResult);
//        if (bindingResult.hasErrors())
//            return "search";

        Searcher searcher = new Searcher();
        choosenHotelRoom = new Result();
        List<String> searchParamsList = new ArrayList<String>();
        cityName = wishfulRoomData.getCityName();
        searchParamsList.add(cityName);
        choosenHotelRoom.setCityName(cityName);

        checkInDate = wishfulRoomData.getCheckInDate();
        searchParamsList.add(getDateInRusFormat(checkInDate));
        choosenHotelRoom.setCheckInDate(getOnlyDate(checkInDate));

        checkOutDate = wishfulRoomData.getCheckOutDate();
        searchParamsList.add(getDateInRusFormat(checkOutDate));
        choosenHotelRoom.setCheckOutDate(getOnlyDate(checkOutDate));

        String roomType;
//        if (wishfulRoomData.getRoomType().equals("")
//                || wishfulRoomData.getRoomType() == null
////                || wishfulRoomData.getRoomType().equals(null)
////                || wishfulRoomData.getRoomType() == ""
//                )
//            //TODO оставить только нужную проверку
//            roomType = "*";
//        else
            roomType = wishfulRoomData.getRoomType();
        choosenHotelRoom.setRoomType(roomType);

        searchParamsList.add("'" + roomType + "'");
        searchParamsList.add("*"); //set price param
//        List<Result> dbResponse = null;
        allResults = null;
        try {
            allResults = searcher.searchRooms(searchParamsList);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (allResults != null) {
            model.addAttribute("dbResponse", allResults);
//            model.addAttribute("wishfulRoomData", wishfulRoomData);
        }

        return "reservation";
    }

    @RequestMapping(value = "reservation", method = RequestMethod.POST)
    public String reservation(@ModelAttribute("userdata") User user,
                           Model model){
//        Searcher searcher = new Searcher();
//        try {
//            searcher.insertBooking(wishfulRoomData);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return "redirect:/";
//
        return "reservation";
    }

    /**
     * Parse date "MM/dd/yyyy" to "yyyyMMdd130000".
     * MM - month number (with leading zeros if month is < 10)
     */
    private String getDateInRusFormat(String dateString) {
        DateTimeHandler uncorrectDateTimeHandler = new DateTimeHandler("MM/dd/yyyy");
        DateTimeHandler correctDateTimeHandler = new DateTimeHandler();

        long dateLong = uncorrectDateTimeHandler.getTimeStampInMinutes(dateString);
        dateString = correctDateTimeHandler.getFormattedDate(dateLong);

        return dateString;
    }

    /**
     * Parse date "yyyyMMdd130000" to "dd MMMM yyyy".
     * MM - month number (with leading zeros if month is < 10)
     * MMMM - full month name (February)
     */
    private String getOnlyDate(String dateString) {
        DateTimeHandler uncorrectDateTimeHandler = new DateTimeHandler("MM/dd/yyyy");
        DateTimeHandler correctDateTimeHandler = new DateTimeHandler("dd MMMM yyyy", Locale.ENGLISH);

        long dateLong = uncorrectDateTimeHandler.getTimeStampInMinutes(dateString);
        dateString = correctDateTimeHandler.getFormattedDate(dateLong);

        return dateString;
    }

    @RequestMapping(value = "reserveRoom/{hotelroomid}", method = RequestMethod.GET)
//    @PreAuthorize("hasRole('admin')")
//    @PreAuthorize("isAuthenticated()")
    public String reserveRoom(@PathVariable String hotelroomid,
//                              @ModelAttribute("defaultSearchData") WishfulRoomData wishfulRoomData,
                              Model model){
        int[] ints = parseHotelRoomID(hotelroomid);
//        Searcher searcher = new Searcher();
//        choosenHotelRoom = new Result();
        choosenHotelRoom.setHotelID(ints[0]);
        choosenHotelRoom.setRoomID(ints[1]);
//        choosenHotelRoom.setCheckInDate(checkInDate);
//        choosenHotelRoom.setCheckOutDate(checkOutDate);
//        choosenHotelRoom.setCityName(cityName);

        for (Result res : allResults) {
            if (res.getHotelID() == ints[0]
                    && res.getRoomID() == ints[1]) {
                choosenHotelRoom.setHotelName(res.getHotelName());
                choosenHotelRoom.setAddress(res.getAddress());
//                choosenHotelRoom.setRoomType(res.getRoomType());
                choosenHotelRoom.setPrice(res.getPrice());
//                choosenHotelRoom.setRoomType(res.getRoomType());
                break;
            }
        }
//        try {
//            searcher.insertBooking(wishfulRoomData);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return "redirect:/";

        model.addAttribute("choosenHotelRoom", choosenHotelRoom);
        User user = new User();
        model.addAttribute("userdata", user);
        return "userdetails";
    }

    private int[] parseHotelRoomID(String hotelroomid) {
        int len = Integer.parseInt(hotelroomid.substring(0, 1));
        int[] ints = new int[2];
//        String delimiter = "019";
//        int signDelimiterPosition = hotelroomid.indexOf(delimiter);
//        String s = hotelroomid.substring(0, signDelimiterPosition);
        ints[0] = Integer.parseInt(hotelroomid.substring(1, ++len)); //hotelID

//        hotelroomid = hotelroomid.substring(signDelimiterPosition, hotelroomid.length());
//        signDelimiterPosition = hotelroomid.indexOf(delimiter);
        ints[1] = Integer.parseInt(hotelroomid.substring(len, hotelroomid.length())); //roomID

//        hotelroomid = hotelroomid.substring(signDelimiterPosition, hotelroomid.length());
////        signDelimiterPosition = hotelroomid.indexOf(delimiter);
//        ints[2] = Integer.parseInt(hotelroomid.substring(0, 14)); //checkIn

////        hotelroomid = hotelroomid.substring(signDelimiterPosition, hotelroomid.length());
////        signDelimiterPosition = hotelroomid.indexOf(delimiter);
//        ints[3] = Integer.parseInt(hotelroomid.substring(14, hotelroomid.length())); //checkOut
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