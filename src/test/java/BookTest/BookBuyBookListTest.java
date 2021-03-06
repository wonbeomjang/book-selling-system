package BookTest;

import com.wonbeomjang.bookselling.DataUtils.Book.BookCondition;
import com.wonbeomjang.bookselling.DataUtils.Book.Book;
import com.wonbeomjang.bookselling.DataUtils.Book.BookSaleList;
import com.wonbeomjang.bookselling.DataUtils.User.User;
import com.wonbeomjang.bookselling.Utils.SetUp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class BookBuyBookListTest {
    BookSaleList bookSaleList;
    User owner;
    Book book1;
    Book book2;
    Book book3;

    @BeforeEach
    void setUp() {

        SetUp.setup(true);

        bookSaleList = BookSaleList.getInstance();

        owner = new User("wonbeomjang", "3d4574a464a47ff83f69028d2354771ad371bde7c8a83675feb070f5cbd01a66", "장원범", "01037937352", "jtiger958" );
        book1 = new Book("Ubuntu", "1999", "장원범", "장원범", "1000", BookCondition.Excellent, owner.getUsername());

        bookSaleList.addBook(book1);
    }

    @Test
    void addBook() {
        int numBooks = bookSaleList.getNumBooks();
        book2 = new Book("Ubunu", "1999", "장원범", "장원범", "1000", BookCondition.Excellent, owner.getUsername());
        bookSaleList.addBook(book2);
        assertEquals(numBooks + 1, bookSaleList.getNumBooks());
        assertEquals(book2, bookSaleList.getBook(numBooks));
    }

    @Test
    void deleteBook() {
        int num_books = bookSaleList.getNumBooks();
        bookSaleList.deleteBook(book1);
        assertEquals(num_books - 1, bookSaleList.getNumBooks());

        book3 = new Book("Ubuntu", "1999", "장원범", "장원범", "1000", BookCondition.Excellent, owner.getUsername());
        assertFalse(bookSaleList.deleteBook(book3));
    }
}