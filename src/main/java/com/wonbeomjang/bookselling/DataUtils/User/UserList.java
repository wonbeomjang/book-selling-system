package com.wonbeomjang.bookselling.DataUtils.User;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wonbeomjang.bookselling.DataUtils.Book.BookSaleList;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class UserList implements Serializable {
    ArrayList<User> userList;
    String userDatafile;
    BookSaleList bookSaleList = BookSaleList.getInstance();
    ObjectMapper mapper = new ObjectMapper();

    private static final UserList instance = new UserList();

    private UserList() {}

    public static UserList getInstance() {
        return instance;
    }

    public void init(String userData) {
        try {
            userDatafile = userData;
            User[] users = mapper.readValue(new File(userData), User[].class);
            userList = new ArrayList<>(Arrays.asList(users));
        } catch (IOException e) {
            System.out.println("Create New File");
            userList = new ArrayList<>();
        }
    }

    public boolean addUser(User user) {
      userList.add(user);
      return true;
    }

    public boolean contain(User user) {
        return userList.contains(user);
    }

    public boolean deleteUser(User user) {
        if (!userList.contains(user))
            return false;
        userList.remove(user);
        return true;
    }

    public int getNumUsers() {
        return userList.size();
    }

    public User getUser(int index) {
        return userList.get(index);
    }

    public User[] getUsers() {
        return userList.toArray(new User[0]);
    }

    public void saveData() {
        for(User user: userList) {
            if(user.getUserState().equals(UserState.Deleted)) {
                userList.remove(user);
                bookSaleList.refresh(user);
            }
        }
        try {
            mapper.writeValue(new File(userDatafile), userList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (User user : userList) {
            stringBuilder.append(user.toString());
        }
        return stringBuilder.toString();
    }
}
