package egg.education.library.controller;

import egg.education.library.entity.Book;
import egg.education.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    public ModelAndView getBooks(HttpServletRequest request){
        ModelAndView mav = new ModelAndView("table");

        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);

        if(inputFlashMap != null){
            mav.addObject("success", inputFlashMap.get("success"));
        }

        mav.addObject("books", bookService.getAll());
        return mav;
    }

    @GetMapping("/form")
    public ModelAndView getForm() {
        ModelAndView mav = new ModelAndView("form");
        mav.addObject("book",new Book());
        mav.addObject("action","create");
        return mav;
    }

    @GetMapping("/form/{id}")
    public ModelAndView getForm(@PathVariable int id) {
        ModelAndView mav = new ModelAndView("form");
        mav.addObject("book", bookService.getById(id));
        mav.addObject("action", "update");
        return mav;
    }

    @PostMapping("/create")
    public RedirectView create(Book book, RedirectAttributes attributes){
        RedirectView redirect = new RedirectView("/books");
        bookService.createBook(book);
        attributes.addFlashAttribute("success", "The operation has been carried out successfully");
        return redirect;
    }

    @PostMapping("/update")
    public RedirectView update(Book book, RedirectAttributes attributes){
        RedirectView redirect = new RedirectView("/books");
        bookService.updateBook(book);
        attributes.addFlashAttribute("success", "The operation has been carried out successfully");
        return redirect;
    }

    @PostMapping("/delete/{id}")
    public RedirectView delete(@PathVariable int id,  RedirectAttributes attributes){
        RedirectView redirect = new RedirectView("/books");
        bookService.deleteById(id);
        attributes.addFlashAttribute("success", "The book has been removed successfully");
        return redirect;
    }

}
