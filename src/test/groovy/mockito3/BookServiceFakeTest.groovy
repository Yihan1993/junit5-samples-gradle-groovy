package mockito3

import mockito3.*

import java.time.LocalDate
import org.junit.Test
import static org.junit.Assert.*
import static org.mockito.Mockito.*
import org.mockito.Mockito

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

    @Test
    public void testFakewithMockito() {
        BookRepository bookRepository = mock(BookRepository.class)
        BookService bookService = new BookService(bookRepository)

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