package com.uc.greet.entity;

public class Greeting {
    private final String content;

    public Greeting(String content){
        this.content = content;
    }

    public String getGreeting(){
        return content;
    }
}
