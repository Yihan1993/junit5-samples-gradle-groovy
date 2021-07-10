package mockito3

import java.util.HashMap
import java.util.Map
import java.util.Collection

public class FakeBookRepository implements BookRepository {

    Map<String, Book> bookStore = new HashMap<>()

    @Override
    public void save(Book book) {
        bookStore.put(book.getBookId(), book)
    }

    @Override
    public Collection<Book> findAll() {
        return bookStore.values()
    }
}