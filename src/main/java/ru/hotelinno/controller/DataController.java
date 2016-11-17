package ru.hotelinno.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

        WishfulRoomData wishfulRoomData = new WishfulRoomData(); //так можно задавать значения по умолчанию
        wishfulRoomData.setCityName("Kazan");
        wishfulRoomData.setRoomType("Econom");

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
        this.searchDataValidator
                .validate(wishfulRoomData, bindingResult);
        if (bindingResult.hasErrors())
            return "search";

        Searcher searcher = new Searcher();
        List<String> searchParamsList = new ArrayList<String>();
        searchParamsList.add(wishfulRoomData.getCityName());

        searchParamsList.add(getRightDate(wishfulRoomData.getCheckInDate()));
        searchParamsList.add(getRightDate(wishfulRoomData.getCheckOutDate()));

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

        if (dbResponse != null)
            model.addAttribute("dbResponse", dbResponse);

        return "reservation";
    }

    /**
     * Parse date "MM/dd/yyyy" to "yyyyMMdd130000".
     */
    private String getRightDate(String checkInDateString) {
        DateTimeHandler unrightDateTimeHandler = new DateTimeHandler("MM/dd/yyyy");
        DateTimeHandler rightDateTimeHandler = new DateTimeHandler();

        long checkInDateLong = unrightDateTimeHandler.getTimeStampInMinutes(checkInDateString);
        checkInDateString = rightDateTimeHandler.getFormattedDate(checkInDateLong);

        return checkInDateString;
    }

    //удаление не работает почему-то - вроде бы починилось
    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasRole('admin')")
//    @PreAuthorize("isAuthenticated()")
    public String delete(@PathVariable Integer id){
        this.dataRepository
                .remove(id);
        return "redirect:/";
    }
}