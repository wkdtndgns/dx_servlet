package com.example.servlet.data;

public class ServletList {
    int id;
    String name;

    public ServletList(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ServletList{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
