package pl.coderslab.webmvc.model;

import org.springframework.stereotype.Component;
import pl.coderslab.webmvc.exception.NotFoundException;
import pl.coderslab.webmvc.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class BookDao {
//    Zapytania SQL
    private static final String FIND_ALL_BOOKS_QUERY = "SELECT * from books";
    private static final String CREATE_BOOK_QUERY = "INSERT INTO books(isbn,title,author,publisher,type) VALUES (?,?,?,?,?)";
    private static final String DELETE_BOOK_QUERY = "DELETE FROM books where id = ?";
    private static final String READ_BOOK_QUERY = "SELECT * from books where id = ?";
    private static final String UPDATE_BOOK_QUERY = "UPDATE books SET isbn = ?, title = ?, author = ?, publisher = ?, type = ? WHERE id = ?";

    public List<Book> findAll() {
        List<Book> bookList = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL_BOOKS_QUERY);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Book bookToAdd = new Book();
                bookToAdd.setId(resultSet.getInt("id"));
                bookToAdd.setIsbn(resultSet.getString("isbn"));
                bookToAdd.setTitle(resultSet.getString("title"));
                bookToAdd.setAuthor(resultSet.getString("author"));
                bookToAdd.setPublisher(resultSet.getString("publisher"));
                bookToAdd.setType(resultSet.getString("type"));
                bookList.add(bookToAdd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }

    public Book create(Book book) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement insertStm = connection.prepareStatement(CREATE_BOOK_QUERY,
                     PreparedStatement.RETURN_GENERATED_KEYS)) {
            insertStm.setString(1, book.getIsbn());
            insertStm.setString(1, book.getTitle());
            insertStm.setString(2, book.getAuthor());
            insertStm.setString(3, book.getPublisher());
            insertStm.setString(3, book.getType());
            int result = insertStm.executeUpdate();
            if (result != 1) {
                throw new RuntimeException("Execute update returned " + result);
            }
            try (ResultSet generatedKeys = insertStm.getGeneratedKeys()) {
                if (generatedKeys.first()) {
                    book.setId(generatedKeys.getInt(1));
                    return book;
                } else {
                    throw new RuntimeException("Generated key was not found");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Book getBookById(Integer bookId) {
        Book book = new Book();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(READ_BOOK_QUERY)
        ) {
            statement.setInt(1, bookId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    book.setId(resultSet.getInt("id"));
                    book.setIsbn(resultSet.getString("isbn"));
                    book.setTitle(resultSet.getString("title"));
                    book.setAuthor(resultSet.getString("author"));
                    book.setPublisher(resultSet.getString("publisher"));
                    book.setType(resultSet.getString("type"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }

    public void delete(Integer bookId) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_BOOK_QUERY)) {
            statement.setInt(1, bookId);
            statement.executeUpdate();
            boolean deleted = statement.execute();
            if (!deleted) {
                throw new NotFoundException("Product not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Book book) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_BOOK_QUERY)) {
            statement.setInt(6, book.getId());
            statement.setString(1, book.getIsbn());
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setString(3, book.getPublisher());
            statement.setString(3, book.getType());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
