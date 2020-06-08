package Layout;

import DataUtils.Book.Book;
import DataUtils.Book.BookKeyType;
import DataUtils.Book.BookSaleList;
import DataUtils.Book.SearchBook;
import Layout.SearchBook.SearchBookPanelWoChkBox;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class ExampleFrame extends JFrame implements Observer {
    public ExampleFrame() {
        SearchBook searchBook = new SearchBook(BookSaleList.getInstance());
        Book[] books = searchBook.search("asdfs", BookKeyType.Username);

        setLayout(new BorderLayout());
        add(new SearchBookPanelWoChkBox(this));
        setSize(SearchBookPanelWoChkBox.getPanWidth(), SearchBookPanelWoChkBox.getPanHeight());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {
        Book[] books = (Book[])arg;
        setSize(SearchBookPanelWoChkBox.getPanWidth(), SearchBookPanelWoChkBox.getPanHeight(books.length));
    }
}
