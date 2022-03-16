package pl.coderslab.webmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.webmvc.model.Book;
import pl.coderslab.webmvc.model.BookDao;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookDao bookDao;

    @Autowired
    public BookController(BookDao bookDao) {this.bookDao = bookDao;}

    //    GET /books zwraca listę wszystkich książek:
    @GetMapping("")
    @ResponseBody
    public List<Book> listAllBooks() {
        return bookDao.findAll();
    }

    @GetMapping("/")
    public String mainMenu(Model model) {
        model.addAttribute("booksList",bookDao.findAll());
        return "menu";
    }

//    GET /books/{id} wyświetla informacje o książce o podanym id:
    @GetMapping("/{id}")
    @ResponseBody
    public Book getBookById(@PathVariable int id) {
        return bookDao.getBookById(id);
    }

//     POST /books zapisuje nową książkę przekazaną formularzem do bazy danych
    @PostMapping("/")
    public String addBook(@RequestParam String isbn, @RequestParam String title, @RequestParam String author,
                        @RequestParam String publisher, @RequestParam String type) {
        Book book = new Book(isbn,title,author,publisher,type);
        bookDao.create(book);
        return "redirect:/books/";
    }

    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable int id, Model model) {
        model.addAttribute("book",bookDao.getBookById(id));
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String editBook(@PathVariable int id, @RequestParam String isbn, @RequestParam String title, @RequestParam String author,
                           @RequestParam String publisher, @RequestParam String type) {
        Book book = new Book(id,isbn,title,author,publisher,type);
        bookDao.update(book);
        return "redirect:/books/";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id) {
        bookDao.delete(id);
        return "redirect:/books/";
    }

}

