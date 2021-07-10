package mockito3

import mockito3.*

import java.time.LocalDate
import org.junit.Test
import static org.junit.Assert.*

public class BookServiceDummyTest {

    @Test
    public void testWithDummyClass() {
        BookRepository bookRepository = new FakeBookRepository()
        EmailService emailService = new DummyEmailService()
        BookService bookService = new BookService(bookRepository, emailService)

        bookService.addBook(new Book(
            "1234", "Mocktio In Action", 250, LocalDate.now()))
        bookService.addBook(new Book(
            "12345", "Junit 5 In Action", 200, LocalDate.now()))

        assertEquals(2, bookService.findNumerOfBooks())
    }
}