package pl.coderslab.webmvc.model;

import java.util.ArrayList;
import java.util.List;

public class MockBookService {

    private List<Book> list = new ArrayList<>();

    public MockBookService() {
        list.add(new Book(1L,"12345","Wiedźmin","Andrzej Sapkowski","Supernova","fantasy"));
        list.add(new Book(2L,"67891","W pustyni i w puszczy","Henryk Sienkiewicz","Idy","story"));
        list.add(new Book(3L, "23456","Harry Potter","J. Rowling","Wydawnictwo","fantasy"));
        list.add(new Book(4L, "789","Zaginiona","Remigiusz Mróz","Supernova","thriller"));
        list.add(new Book(5L, "012","Diuna","Frank Herbert","Supernova","fantasy"));
    }
}
