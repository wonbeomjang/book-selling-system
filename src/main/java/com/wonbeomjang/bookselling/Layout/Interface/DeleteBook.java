package com.wonbeomjang.bookselling.Layout.Interface;

import com.wonbeomjang.bookselling.DataUtils.Book.Book;
import com.wonbeomjang.bookselling.DataUtils.User.User;

import java.util.Observable;

public abstract class DeleteBook extends Observable {
    public abstract boolean deleteBook(User user, Book book);
}
