package com.example.warnene.roomviewmodelpoc.model;

public class Repo {
    public int id;
    public String name;
    public Owner owner;

    static class Owner {
        String login;
        String type;
    }

    public String description;

}
