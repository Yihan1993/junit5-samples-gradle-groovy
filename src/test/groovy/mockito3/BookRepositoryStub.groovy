package mockito3

import java.time.LocalDate
import java.util.List
import java.util.HashMap
import java.util.Map
import java.util.Collection

public class BookRepositoryStub implements BookRepository {

    @Override
    public void save(Book book) {}

    @Override
    public Collection<Book> findAll() {
        return null
    }

	@Override
	public List<Book> findNewBooks(int days) {
		List<Book> newBooks = new ArrayList<>()
		Book book1 = new Book("1234", "Mockito In Action", 500, LocalDate.now())
		Book book2 = new Book("1235", "JUnit 5 In Action", 400, LocalDate.now())
		
		newBooks.add(book1)
		newBooks.add(book2)
		
		return newBooks
    }
}