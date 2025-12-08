package com.example.gossipgirl_;;

public enum View {
    LOGIN("login-view.fxml"),
    SIGNUP("signup-view.fxml"),
    START("hello-view.fxml"),
    MAIN("gossip-view.fxml");

    private String fileName;

    View(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}