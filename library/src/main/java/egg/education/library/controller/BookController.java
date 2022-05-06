package egg.education.library.controller;

import egg.education.library.entity.Book;
import egg.education.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

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
    public RedirectView create(Book book){
        bookService.createBook(book);
        return new RedirectView("/books");
    }

    @PostMapping("/update")
    public RedirectView update(Book book){
        bookService.updateBook(book);
        return new RedirectView("/books");
    }
}
