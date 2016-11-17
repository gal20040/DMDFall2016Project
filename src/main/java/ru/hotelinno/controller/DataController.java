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
import ru.hotelinno.domain.Book;
import ru.hotelinno.domain.WishfulRoomData;
import ru.hotelinno.repository.DataRepository;
import ru.hotelinno.validation.SearchDataValidator;

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
    public String getAllRecords(Model model){ //getB ooks
        List<Book> allRecords = this.dataRepository
                .listAll();
        model.addAttribute("allRecords", allRecords);
        return "index";
    }

    /**
     * Get searching page without any searching parameters.
     */
    @RequestMapping(value = "search", method = RequestMethod.GET) //addB ook
    public String search(Model model){ //addB ook

//        WishfulRoomData wishfulRoomData = new WishfulRoomData(); //так можно задавать значения по умолчанию
//        wishfulRoomData.setCityName("wishfulRoomData.setCityName");
//        wishfulRoomData.setRoomType("wishfulRoomData.setRoomType");
//        model.addAttribute("defaultSearchData", wishfulRoomData);

//        model.addAttribute("defaultSearchData", new B ook()); //b ookq
        model.addAttribute("defaultSearchData", new WishfulRoomData());
        return "search"; //addB ook
    }

    /**
     * Get searching parameters from user.
     */
    @RequestMapping(value = "search", method = RequestMethod.POST) //addB ook
    public String search(@ModelAttribute("defaultSearchData") WishfulRoomData wishfulRoomData, //B ook b ook
                          BindingResult bindingResult,
                          Model model){ //addB ook //b ookq
        this.searchDataValidator
                .validate(wishfulRoomData, bindingResult);
        if (bindingResult.hasErrors())
            return "search"; //addB ook

//        this.b ookRepository
//                .search(wishfulRoomData); //addB ook

//        WishfulRoomData wishfulRoomData = new WishfulRoomData(b ook.getName() + "q", b ook.getGenre() + "a",
//                "" + "zxc", "" + "poi");
//        wishfulRoomData.setCityName(wishfulRoomData.getCityName() + 'q');
//        wishfulRoomData.setRoomType(wishfulRoomData.getRoomType() + 'q');
        model.addAttribute("wishfulRoomData", wishfulRoomData);
        return "search"; //addB ook
    }

    //удаление не работает почему-то - вроде бы починилось
    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET) //deleteB ook
    @PreAuthorize("hasRole('admin')")
//    @PreAuthorize("isAuthenticated()")
    public String delete(@PathVariable Integer id){ //deleteB ook
        this.dataRepository
                .remove(id);
        return "redirect:/";
    }
}