package mockito3

import mockito3.*

import java.time.LocalDate
import org.junit.Test
import static org.junit.Assert.*

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
}