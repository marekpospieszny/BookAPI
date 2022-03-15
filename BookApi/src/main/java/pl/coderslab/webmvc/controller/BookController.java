package pl.coderslab.webmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.webmvc.model.Book;
import pl.coderslab.webmvc.model.BookDao;
import pl.coderslab.webmvc.model.MockBookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

//    private final MockBookService mockBookService;
    private final BookDao bookDao;

//    @Autowired
//    public BookController(MockBookService mockBookService) {
//        this.mockBookService = mockBookService;
//    }
    @Autowired
    public BookController(BookDao bookDao) {this.bookDao = bookDao;}

//    @RequestMapping("/helloBook")
//    public Book helloBook() {
//        return new Book(1, "9788324631766", "Thinking in Java",
//                "Bruce Eckel", "Helion", "programming");
//    }

    //    GET /books zwraca listę wszystkich książek:
    @GetMapping("")
    public List<Book> listAllBooks() {
        return bookDao.findAll();
    }

////    GET /books zwraca listę wszystkich książek:
//    @GetMapping("")
//    public List<Book> listBooks() {
//        return mockBookService.getList();
//    }

//    GET /books/{id} wyświetla informacje o książce o podanym id:
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id) {
        return bookDao.getBookById(id);
    }

//    @GetMapping("/{id}")
//    public Book getBookById(@PathVariable int id) {
//        return mockBookService.getBookById(id);
//    }

//    @PostMapping("")
//    public List<Book> addBook(Book book) {
//        mockBookService.addBook(book);
//        return mockBookService.getList();
//    }


}

