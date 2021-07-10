package mockito3

import mockito3.*

import java.time.LocalDate
import org.junit.Test
import static org.junit.Assert.*
import static org.mockito.Mockito.*
import org.mockito.Mockito

public class BookServiceWithStubTest {

    @Test
    public void testWithStub() {
		BookRepository bookRepository = new BookRepositoryStub()
		BookService bookService = new BookService(bookRepository)
		
		List<Book> newBooksWithAppliedDiscount =
            bookService.getNewBooksWithAppliedDiscount(10, 7)
		
		assertEquals(2, newBooksWithAppliedDiscount.size())
		assertEquals(450, newBooksWithAppliedDiscount.get(0).getPrice())
		assertEquals(360, newBooksWithAppliedDiscount.get(1).getPrice())
    }

    @Test
    public void testStubWithMockito() {
        BookRepository bookRepository = mock(BookRepository.class)
        BookService bookService = new BookService(bookRepository)

		Book book1 = new Book("1234", "Mockito In Action", 500, LocalDate.now())
		Book book2 = new Book("1235", "JUnit 5 In Action", 400, LocalDate.now())

        Collection<Book> newBooks = new ArrayList<>()

		newBooks.add(book1)
		newBooks.add(book2)
    
        when(bookRepository.findNewBooks(7)).thenReturn(newBooks)

        List<Book> newBooksWithAppliedDiscount =
            bookService.getNewBooksWithAppliedDiscount(10, 7)

		assertEquals(2, newBooksWithAppliedDiscount.size())
		assertEquals(450, newBooksWithAppliedDiscount.get(0).getPrice())
		assertEquals(360, newBooksWithAppliedDiscount.get(1).getPrice())
    }
}