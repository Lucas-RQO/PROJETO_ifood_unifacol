package com.ifood.model;

public class Restaurant {
    private int id;
    private String name;

    public Restaurant(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Override
    public String toString() {
        return "Restaurante: " + name;
    }
}
