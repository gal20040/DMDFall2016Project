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
import ru.hotelinno.repository.BookRepository;
import ru.hotelinno.validation.BookValidator;

import java.util.List;

@Controller
public class BookController {

    private BookRepository bookRepository;

    private BookValidator bookValidator;

    @Autowired
    public BookController(BookRepository bookRepository, BookValidator bookValidator){
        this.bookRepository = bookRepository;
        this.bookValidator = bookValidator;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getBooks(Model model){
        List<Book> allRecords = this.bookRepository
                .listAll();
        model.addAttribute("allRecords", allRecords);
        return "index";
    }

    @RequestMapping(value = "search", method = RequestMethod.GET) //addBook
    public String search(Model model){ //addBook

//        Book book = ; //так можно задавать значения по умолчанию
//        book.setName("book.setName");
//        book.setGenre("book.setGenre");
//        model.addAttribute("defaultSearchData", book);

        model.addAttribute("defaultSearchData", new Book()); //bookq
        return "search"; //addBook
    }

    @RequestMapping(value = "search", method = RequestMethod.POST) //addBook
    public String search(@ModelAttribute("defaultSearchData") Book book,
                          BindingResult bindingResult,
                          Model model){ //addBook //bookq
        this.bookValidator
                .validate(book, bindingResult);
        if (bindingResult.hasErrors())
            return "search"; //addBook

//        this.bookRepository
//                .search(wishfulRoomData); //addBook

        WishfulRoomData wishfulRoomData = new WishfulRoomData(book.getName() + "q", book.getGenre() + "a",
                "" + "zxc", "" + "poi");
        model.addAttribute("wishfulRoomData", wishfulRoomData);
//        return "redirect:/";
//        return returnString;
        return "search"; //addBook
    }

    @RequestMapping(value = "deleteBook/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasRole('admin')")
//    @PreAuthorize("isAuthenticated()")
    public String deleteBook(@PathVariable Integer id){
        this.bookRepository
                .removeBook(id);
        return "redirect:/";
    }
}