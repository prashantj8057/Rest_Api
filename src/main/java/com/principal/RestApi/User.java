package com.principal.RestApi;

public class User {
    private int userid;
    private String name;
    private int age;
    private String country;

    public User(int userid, String name, int age, String country) {
        this.userid = userid;
        this.name = name;
        this.age = age;
        this.country = country;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
