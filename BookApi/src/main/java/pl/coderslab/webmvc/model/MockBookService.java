package pl.coderslab.webmvc.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MockBookService implements BookService {

    private List<Book> books;
    private static Long nextId = 4L;

    public MockBookService() {
        books = new ArrayList<>();
        books.add(new Book(1L,"12345","Wiedźmin","Andrzej Sapkowski","Supernova","fantasy"));
        books.add(new Book(2L,"67891","W pustyni i w puszczy","Henryk Sienkiewicz","Idy","story"));
        books.add(new Book(3L, "23456","Harry Potter","J. Rowling","Wydawnictwo","fantasy"));
    }

    public List<Book> getList() {
        return books;
    }

    public Book getBookById(Long id) {
        List<Book> list = getList();
        for (Book book : list) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void deleteBookById(Long id) {
        List<Book> list = getList();
    }

    @Override
    public List<Book> getBooks() {
        return books;
    }

    @Override
    public void add(Book book) {
        book.setId(nextId++);
        books.add(book);
    }

    @Override
    public Optional<Book> get(Long id) {
        return books.stream().filter(item -> item.getId().equals(id)).findFirst();
    }

    @Override
    public void delete(Long id) {
        if (get(id).isPresent()) {
            books.remove(this.get(id).get());
        }
    }

    @Override
    public void update(Book book) {
        if (this.get(book.getId()).isPresent()) {
            int indexOf = books.indexOf(this.get(book.getId()).get());
            books.set(indexOf, book);
        }
    }
}
