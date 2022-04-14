package pl.coderslab.webmvc.controller;

import org.dom4j.rule.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.webmvc.model.Book;
import pl.coderslab.webmvc.model.BookService;

import javax.naming.Binding;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/books")
public class ManageBookController {

    private final BookService bookService;

    public ManageBookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/all")
    public String showPosts(Model model) {
        List<Book> books = bookService.getBooks();
        model.addAttribute("books",books);
        return "books/all";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("book",new Book());
        return "books/add";
    }

    @PostMapping("/add")
    public String add(@Valid Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "books/add";
        }
        bookService.add(book);
        return "redirect:/admin/books/all";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("book",bookService.get(id));
        return "books/edit";
    }

    @PostMapping("/update")
    public String update(@Valid Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "books/edit";
        }
        bookService.update(book);
        return "redirect:/admin/books/all";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        bookService.delete(id);
        return "redirect:/admin/books/all";
    }

    @GetMapping("/{id}")
    public String details(@PathVariable Long id, Model model) {
        model.addAttribute("book",bookService.get(id).get());
        return "books/details";
    }
}
