package ru.hotelinno.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.hotelinno.Search.Searcher;
import ru.hotelinno.domain.RESULT.Result;
import ru.hotelinno.domain.WishfulRoomData;
import ru.hotelinno.domain.user.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
public class DataController {

    private String checkInDate, checkOutDate, cityName;
    private List<Result> allResults;
    private Result choosenHotelRoom;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getAllRecords() {
        return "index";
    }

    /**
     * Get searching page without any searching parameters.
     */
    @RequestMapping(value = "search", method = RequestMethod.GET)
    public String search(Model model) {
        model.addAttribute("defaultSearchData", new WishfulRoomData());
        return "search";
    }

    /**
     * Get searching parameters from user.
     */
    @RequestMapping(value = "search", method = RequestMethod.POST)
    public String search(@ModelAttribute("defaultSearchData") WishfulRoomData wishfulRoomData,
                         Model model){
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

        String roomType = wishfulRoomData.getRoomType();
        choosenHotelRoom.setRoomType(roomType);

        searchParamsList.add("'" + roomType + "'");
        searchParamsList.add("*"); //set price param
        allResults = null;
        try {
            allResults = searcher.searchRooms(searchParamsList);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (allResults != null)
            model.addAttribute("dbResponse", allResults);

        return "reservation";
    }

    @RequestMapping(value = "reservation", method = RequestMethod.POST)
    public String reservation(@ModelAttribute("userdata") User user,
                           Model model){
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
    public String reserveRoom(@PathVariable String hotelroomid,
                              Model model){
        int[] ints = parseHotelRoomID(hotelroomid);
        choosenHotelRoom.setHotelID(ints[0]);
        choosenHotelRoom.setRoomID(ints[1]);

        for (Result res : allResults) {
            if (res.getHotelID() == ints[0]
                    && res.getRoomID() == ints[1]) {
                choosenHotelRoom.setHotelName(res.getHotelName());
                choosenHotelRoom.setAddress(res.getAddress());
                choosenHotelRoom.setPrice(res.getPrice());
                break;
            }
        }

        model.addAttribute("choosenHotelRoom", choosenHotelRoom);
        User user = new User();
        model.addAttribute("userdata", user);
        return "userdetails";
    }

    private int[] parseHotelRoomID(String hotelroomid) {
        int len = Integer.parseInt(hotelroomid.substring(0, 1));
        int[] ints = new int[2];
        ints[0] = Integer.parseInt(hotelroomid.substring(1, ++len)); //hotelID

        ints[1] = Integer.parseInt(hotelroomid.substring(len, hotelroomid.length())); //roomID

        return ints;
    }
}