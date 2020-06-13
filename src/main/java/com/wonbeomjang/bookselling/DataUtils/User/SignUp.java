package com.wonbeomjang.bookselling.DataUtils.User;

public class SignUp extends com.wonbeomjang.bookselling.Layout.Interface.SignUp {
    private final UserList userList;

    public SignUp() {
        this.userList = UserList.getInstance();
    }

    public boolean checkUniqueUserName(String username) {
        int numUsers = userList.getNumUsers();
        User user;
        for (int i = 0; i < numUsers; i++){
            user = userList.getUser(i);
            if(username.equals(user.getUsername())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean signUp(String username, String password, String email, String phoneNumber, String name) {

        if (username.equals("") || password.equals("") || email.equals("") || phoneNumber.equals("") || name.equals(""))
            return false;

        if(!checkUniqueUserName(username))
            return false;

        User newUser = new EndUser(username, password, name, phoneNumber, email);
        userList.addUser(newUser);
        userList.saveData();

        setChanged();
        notifyObservers(newUser);

        return true;
    }
}