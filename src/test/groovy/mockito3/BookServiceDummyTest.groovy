package mockito3

import mockito3.*

import java.time.LocalDate
import org.junit.Test
import static org.junit.Assert.*
import static org.mockito.Mockito.*
import org.mockito.Mockito

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

    @Test
    public void testDummyWithMockito() {
        BookRepository bookRepository = mock(BookRepository.class)
        EmailService emailService = mock(EmailService.class)
        BookService bookService = new BookService(bookRepository, emailService)

        Book book1 = new Book(
            "1234", "Mocktio In Action", 250, LocalDate.now())
        Book book2 = new Book(
            "12345", "Junit 5 In Action", 200, LocalDate.now()) 

        Collection<Book> books = new ArrayList<>()

        books.add(book1)
        books.add(book2)

        when(bookRepository.findAll()).thenReturn(books)

        assertEquals(2, bookService.findNumerOfBooks())
    }
}