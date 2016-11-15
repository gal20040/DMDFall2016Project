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

import java.util.ArrayList;
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
        List<Book> books = this.bookRepository
                .listAll();
        model.addAttribute("books", books);
        return "index";
    }

    @RequestMapping(value = "addBook", method = RequestMethod.GET)
//    @PreAuthorize("isAuthenticated()")
    public String addBook(Model model){

//        Book book = ; //так можно задавать значения по умолчанию
//        book.setName("book.setName");
//        book.setGenre("book.setGenre");
//        model.addAttribute("book", book);

        model.addAttribute("bookq", new Book());
        return "addBook";
    }

    /**
     * Можно обрабатывать параметры из адресной строки.
     * UPDATE: Решили не использовать параметры из адресной строки.
     * @param paramString
     * @param model
     * @return
     */
//    @RequestMapping(value = "addBook{paramString}", method = RequestMethod.GET)
////    @PreAuthorize("isAuthenticated()")
//    public String addBook(@PathVariable String paramString,
//                          Model model){
//        Book book = new Book();
//        book.setName(paramString);
//        book.setGenre("book.setGenre");
//        model.addAttribute("bookq", book);
//        return "addBook";
//    }

    @RequestMapping(value = "addBook", method = RequestMethod.POST)
//    @PreAuthorize("isAuthenticated()")
    public String addBook(@ModelAttribute("bookq") Book book,
                          BindingResult bindingResult,
                          Model model){
//        this.bookValidator
//                .validate(wishfulRoomData, bindingResult);
//        if (bindingResult.hasErrors())
//            return "addBook";

//        this.bookRepository
//                .addBook(wishfulRoomData);
//        String returnString, cityName = "", cityGenre = "";
//        if (!book.getName().equals("")
//                || !book.getGenre().equals("")) {
//            if (!book.getName().equals("")) {
//                cityName = "cityName=" + book.getName() + "q"; TO DO String.format
//            }
//            if (!book.getGenre().equals("")) {
//                cityGenre = "cityGenre=" + book.getGenre() + "a"; TO DO cityGenre TO DO String.format
//            }
//            returnString = String.format("addBook?%s&%s", cityName, cityGenre);
//        } else
//            returnString = "addBook";

        WishfulRoomData wishfulRoomData = new WishfulRoomData(book.getName() + "q", book.getGenre() + "a",
                "" + "zxc", "" + "poi");
        model.addAttribute("wishfulRoomData", wishfulRoomData);
//        return "redirect:/";
//        return returnString;
        return "addBook";
    }

//    @RequestMapping(value = "addBook/?{paramString}", method = RequestMethod.GET)
//    public String deleteBook(@PathVariable String paramString){
//        WishfulRoomData wishfulRoomData = parseParamString(paramString);
////        this.bookRepository
////                .removeBook(id);
//        return "redirect:/";
//    }

//    private WishfulRoomData parseParamString(String paramString) {
////        fromName=Казань&toName=Ижевск&fromId=c43&toId=c44&when=завтра
//        WishfulRoomData wishfulRoomData = new WishfulRoomData();
//        ArrayList<String> listOfAllParams = wishfulRoomData.getListOfAllParams();
//        int cityNamePosition, roomTypePosition, checkInDatePosition, checkOutDatePosition, equalSignPosition;
//        String tempParamString, paramName;
//        String equalSign = "=";
//        int tempParamStringNumber;
//        boolean paramHasBeenFounded = false;
//
////        int index = paramString.indexOf("?");
////        paramString = paramString.substring(index + 1, paramString.length());
//
////        while (index < paramString.length()) {
//        ArrayList<String> stringArrayList = parseParamStringWithDelimiter(paramString);
//        while (stringArrayList.size() > 0) {
//            tempParamStringNumber = stringArrayList.size() - 1;
//            tempParamString = stringArrayList.get(tempParamStringNumber);
//            equalSignPosition = tempParamString.indexOf(equalSign);
//            assert (equalSignPosition >= 0) : "Знак '=' не найден в запросе."; //TODO сделать корректную передачу на страницу неполных данных с уведомлением.
//            assert (equalSignPosition == 0) : "До знака '=' в запросе нет имени параметра."; //TODO сделать корректную передачу на страницу неполных данных с уведомлением.
//            if (equalSignPosition > 0) {
//                paramName = tempParamString.substring(0, equalSignPosition);
//                for (int i = 0; i < listOfAllParams.size(); i++) {
//                    if (paramName.equals(listOfAllParams.get(i))) {
//                        paramHasBeenFounded = true;
//                        wishfulRoomData.se
//                        break;
//                    }
//                }
//                assert (paramHasBeenFounded) : "Неизвестный параметр в запросе."; //TODO сделать корректную передачу на страницу неполных данных с уведомлением.
//            }
//        }
//
////        cityNamePosition = paramString.indexOf("city=");
////        tempParamString = paramString.substring(cityNamePosition + 5, paramString.length());
////        ampersandPosition = tempParamString.indexOf("&");
//
//
////        }
//
//        return wishfulRoomData;
//    }

//    private ArrayList<String> parseParamStringWithDelimiter(String paramString) {
//        String defaultDelimiter = "&";
//        return parseParamStringWithDelimiter(paramString, defaultDelimiter);
//    }

    /**
     * Parse paramString in pieces with ampersand as delimiter
     * and return ArrayList of strings.
     * E.g. paramString: cityName=Kazan&roomType=Standard&checkInDate=20.11.2016&checkOutDate=22.11.2016
     * E.g. return: cityName=Kazan; roomType=Standard; checkInDate=20.11.2016; checkOutDate=22.11.2016
//     */
//    private ArrayList<String> parseParamStringWithDelimiter(String paramString, String delimiter) {
//        ArrayList<String> stringArrayList = new ArrayList<String>();
//        int ampersandPosition, equalSignPosition;
//        String tempString, equalSign = "=";
//        //TODO сделать проверки "амперсанд стоит первым в строке"+"амперсанда нет в строке" и обработать их.
//        while (paramString.length() > 0) {
//            ampersandPosition = paramString.indexOf(delimiter);
//            tempString = paramString.substring(0, ampersandPosition);
////            assert (tempString.indexOf(equalSign) > 0) : ""; //TODO сделать корректную передачу на страницу неполных данных с уведомлением.
//            equalSignPosition = tempString.indexOf(equalSign);
//            assert (equalSignPosition >= 0) : "Знак '=' не найден в запросе."; //TODO сделать корректную передачу на страницу неполных данных с уведомлением.
//            assert (equalSignPosition == 0) : "До знака '=' в запросе нет имени параметра."; //TODO сделать корректную передачу на страницу неполных данных с уведомлением.
//            stringArrayList.add(tempString);
//        }
//        return stringArrayList;
//    }

    @RequestMapping(value = "deleteBook/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasRole('admin')")
    public String deleteBook(@PathVariable Integer id){
        this.bookRepository
                .removeBook(id);
        return "redirect:/";
    }
}