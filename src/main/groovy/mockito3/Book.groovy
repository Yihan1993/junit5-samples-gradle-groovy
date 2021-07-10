package mockito3

import java.time.LocalDate

public class Book {

    private String bookId
    private String title
    private int price
    private LocalDate publishedDate

    public Book(String bookId, String title, int price, LocalDate publishedDate) {
        this.bookId = bookId
        this.title = title
        this.price = price
        this.publishedDate = publishedDate
    }

    public String getBookId() {
        return bookId
    }

    public void setBookId(String bookId) {
        this.bookId = bookId
    }

    public String getTitle() {
        return title
    }

    public void setTitle(String title) {
        this.title = title
    }

    public String getPrice() {
        return price
    }

    public void setPrice(int price) {
        this.price = price
    }

    public String getPublishedDate() {
        return publishedDate
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate
    }
}
