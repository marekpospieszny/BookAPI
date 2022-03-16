package pl.coderslab.webmvc.model;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> getBooks();

    void add(Book book);

    Optional<Book> get(int id);

    void delete(int id);

    void update(Book book);
}
