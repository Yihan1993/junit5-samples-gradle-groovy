package mockito3

import mockito3.*

import java.time.LocalDate
import org.junit.jupiter.api.Test
import static org.junit.Assert.*

public class BookServiceFakeTest {

    @Test
    public void testWithFakeClass() {
        BookRepository bookRepository = new FakeBookRepository()
        BookService bookService = new BookService(bookRepository)

        bookService.addBook(new Book(
            "1234", "Mocktio In Action", 250, LocalDate.now()))
        bookService.addBook(new Book(
            "12345", "Junit 5 In Action", 200, LocalDate.now()))

        assertEquals(2, bookService.findNumerOfBooks())

    }
}