package pl.coderslab.webmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.coderslab.webmvc.model.Book;
import pl.coderslab.webmvc.model.BookDao;
import pl.coderslab.webmvc.model.BookService;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
    @ResponseBody
    public
    List<Book> getList() {
        return bookService.getBooks();
    }

    @PostMapping("")
    public void addBook(@RequestBody Book book) {
        bookService.add(book);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Book getBook(@PathVariable Long id) {
        return this.bookService.get(id).orElseThrow(() -> {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        });
    }

    @DeleteMapping("/{id}")
    public void removeBook(@PathVariable Long id) {
        bookService.delete(id);
    }

    @PutMapping("")
    @ResponseBody
    public void updateBook(@RequestBody Book book) {
        bookService.update(book);
    }

    //    GET /books zwraca listę wszystkich książek:
//    @GetMapping("")
//    @ResponseBody
//    public List<Book> listAllBooks() {
//        return bookDao.findAll();
//    }

//    private final BookDao bookDao;
//
//    @Autowired
//    public BookController(BookDao bookDao) {this.bookDao = bookDao;}
//
////    Moja wersja rozwiązania z zastosowaniem BookDao:
//
//    @GetMapping("/")
//    public String mainMenu(Model model) {
//        model.addAttribute("booksList",bookDao.findAll());
//        return "menu";
//    }
//
////    GET /books/{id} wyświetla informacje o książce o podanym id:
//    @GetMapping("/{id}")
//    @ResponseBody
//    public Book getBookById(@PathVariable Long id) {
//        return bookDao.getBookById(id);
//    }
//
////     POST /books zapisuje nową książkę przekazaną formularzem do bazy danych
//    @PostMapping("/")
//    public String addBook(@RequestParam String isbn, @RequestParam String title, @RequestParam String author,
//                        @RequestParam String publisher, @RequestParam String type) {
//        Book book = new Book(isbn,title,author,publisher,type);
//        bookDao.create(book);
//        return "redirect:/books/";
//    }
//
////    GET /books/edit/{id} przekazywane z widoku menu do widoku edit
//    @GetMapping("/edit/{id}")
//    public String editBook(@PathVariable Long id, Model model) {
//        model.addAttribute("book",bookDao.getBookById(id));
//        return "edit";
//    }
//
////    POST /books/edit/{id} nadpisanie zmienionych danych w widoku edit dla wybranego id
//    @PostMapping("/edit/{id}")
//    public String editBook(@PathVariable Long id, @RequestParam String isbn, @RequestParam String title, @RequestParam String author,
//                           @RequestParam String publisher, @RequestParam String type) {
//        Book book = new Book(id,isbn,title,author,publisher,type);
//        bookDao.update(book);
//        return "redirect:/books/";
//    }
//
////    GET /books/delete/{id} przekazane z widoku menu id do usunięcia z bazy danych
//    @GetMapping("/delete/{id}")
//    public String deleteBook(@PathVariable Long id) {
//        bookDao.delete(id);
//        return "redirect:/books/";
//    }

}

