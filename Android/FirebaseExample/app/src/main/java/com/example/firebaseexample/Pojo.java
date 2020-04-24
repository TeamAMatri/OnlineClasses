package com.example.firebaseexample;

public class Pojo {
    String name,number,id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Pojo(){}

    public Pojo(String id, String name, String number) {
        this.name = name;
        this.number = number;
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
