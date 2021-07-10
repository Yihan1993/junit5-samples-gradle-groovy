package mockito3

import java.util.Collection

public interface BookRepository {

    void save(Book book)

    Collection<Book> findAll()

    List<Book> findNewBooks(int days)
}