package egg.education.library.controller;

import egg.education.library.entity.Book;
import egg.education.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public ModelAndView getBooks(){
        ModelAndView mav = new ModelAndView("table");
        mav.addObject("books", bookService.getAll());
        return mav;
    }

    @GetMapping("/form")
    public ModelAndView getForm() {
        ModelAndView mav = new ModelAndView("form");
        mav.addObject("book",new Book());
        return mav;
    }

    @GetMapping("/form/{isbn}")
    public ModelAndView getForm(@PathVariable int isbn) {
        ModelAndView mav = new ModelAndView("formUpdate");
        mav.addObject("book", bookService.getByIsbn(isbn));
        return mav;
    }

    @PostMapping("/create")
    public ModelAndView create(@Valid Book book, Errors errors){
        ModelAndView mav = new ModelAndView("redirect:/books");
        if (errors.hasErrors()){
            mav.setViewName("form");
            return mav;
        }
        bookService.createBook(book);
        return mav;
    }

    @PostMapping("/update")
    public ModelAndView update(@Valid Book book, Errors errors){
        ModelAndView mav = new ModelAndView("redirect:/books");
        if (errors.hasErrors()){
            mav.setViewName("formUpdate");
            return mav;
        }
        bookService.updateBook(book);
        return mav;
    }

    @PostMapping("/delete/{isbn}")
    public ModelAndView delete(@PathVariable int isbn){
        ModelAndView mav = new ModelAndView("redirect:/books");
        bookService.deleteByIsbn(isbn);
        return mav;
    }

}
