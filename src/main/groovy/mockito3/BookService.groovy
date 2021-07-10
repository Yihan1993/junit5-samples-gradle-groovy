package mockito3

import java.util.List

public class BookService {

    private BookRepository bookRepository
    private EmailService emailService

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository
    }

    public BookService(BookRepository bookRepository, EmailService emailService) {
        this.bookRepository = bookRepository
        this.emailService = emailService
    }

    public void addBook(Book book) {
        bookRepository.save(book)
    }

    public int findNumerOfBooks() {
        return bookRepository.findAll().size()
    }

	public List<Book> getNewBooksWithAppliedDiscount(int discountRate, int days){
		List<Book> newBooks = bookRepository.findNewBooks(days)

		for(Book book : newBooks){
			int price = book.getPrice()
			int newPrice = price - (discountRate * price / 100)
			book.setPrice(newPrice)
		}
		
		return newBooks
	}

}
