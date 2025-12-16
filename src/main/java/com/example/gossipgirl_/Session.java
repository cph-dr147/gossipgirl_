package com.example.gossipgirl_;

public class Session {

    private static User currentUser;

    private Session() {} // prevent instantiation

    public static void setCurrentUser(User user) {
        currentUser = user;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void clear() {
        currentUser = null;
    }
}
