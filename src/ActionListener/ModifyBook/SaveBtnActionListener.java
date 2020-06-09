package ActionListener.ModifyBook;

import DataUtils.Book.BookOnSale;
import Layout.BookListUp.BookOnSaleTextPanel;
import Layout.Interface.ModifyBook;
import Layout.ModifyBook.ModifyBookListPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observer;

public class SaveBtnActionListener implements ActionListener {
    ModifyBook modifyBook = new DataUtils.Book.ModifyBook();
    ModifyBookListPanel modifyBookListPanel;

    public SaveBtnActionListener(ModifyBookListPanel deleteBookListPanel, Observer observer) {
        this.modifyBookListPanel = deleteBookListPanel;
        modifyBook.addObserver(observer);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<BookOnSaleTextPanel> bookOnSaleLabelPanels = modifyBookListPanel.getBookOnSaleTextPanels();
        BookOnSale newBook;
        BookOnSale oldBook = null;
        for (BookOnSaleTextPanel bookOnSaleLabelPanel : bookOnSaleLabelPanels) {
            try {
                oldBook = (BookOnSale)bookOnSaleLabelPanel.getBook();
                newBook = (BookOnSale)bookOnSaleLabelPanel.getNewBook();

                if(!newBook.getIsbn().equals(""))
                    Integer.parseInt(newBook.getIsbn());

                if(!newBook.getPrice().equals(""))
                    Integer.parseInt(newBook.getPrice());

                modifyBook.modify(oldBook, newBook);
            }
            catch (Exception error) {
                System.out.println(error);
                String string = "책: " + oldBook.getTitle() + "의 정보가 잘못되었습니다.";
                JOptionPane.showMessageDialog(null, string);
            }
        }
    }
}