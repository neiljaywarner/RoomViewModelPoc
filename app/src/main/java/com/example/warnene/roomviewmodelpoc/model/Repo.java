package com.example.warnene.roomviewmodelpoc.model;

public class Repo {
    public int id;
    public String name;
    public License license;

    public static class License {
        public String key;
        public String name;
    }

    public String description;

}
