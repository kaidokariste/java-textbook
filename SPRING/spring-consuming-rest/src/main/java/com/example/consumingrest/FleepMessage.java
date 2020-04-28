package com.example.consumingrest;

public class FleepMessage {
    private String message;
    private String user;

    public FleepMessage(){
    };

    public void setMessage(String message) {
        this.message = message;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public String getUser() {
        return user;
    }
}
