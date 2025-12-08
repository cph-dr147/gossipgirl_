package com.example.gossipgirl_;
import java.util.ArrayList;
import java.util.Scanner;

public class SignUp {
    private ArrayList<User> users; // store all users

    public SignUp(ArrayList<User> users) {
        this.users = users;
    }

    public void createUser() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = input.next();

        for (User u : users) {
            if (u.getUserName().equals(username)) {
                System.out.println("Username already exists. Try again.");
                return;
                //The loop checks all existing users to see if the new username is already used.
                //If it finds a match, it warns the user and stops the signup process.
                //If no match is found, the method continues to create the new user.
            }
        }
        System.out.print("Enter password: ");
        String password = input.next();



        User newUser = new User(username, password);
        users.add(newUser); // adds new user to ArrayList
        // her skal alle users gemmes i en fil
        System.out.println("User created successfully!");
    }

    public boolean askForSubscription() {
        Scanner input = new Scanner(System.in);
        System.out.println("Would you like to add subscribe?");

        while (true) {
            String answer = input.next();
            if (answer.equalsIgnoreCase("y")) {
                return true;
            }
            else if (answer.equalsIgnoreCase("n")) {
                return false;
            }
            else {
                System.out.println("please answer either yes (y) or no (n)");
            }
        }
    }
}

