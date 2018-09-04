package com.fullstacktech;

/**
 * Created by TRUNGNGUYENHAU on 9/4/2018.
 */
public class HelloWorldAction {
    private String name;

    public String execute() throws Exception {
        return "success";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
} 