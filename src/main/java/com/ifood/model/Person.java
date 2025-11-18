package com.ifood.model;

public abstract class Person {
    private int id;
    private String name;
    private String phone;

    // Construtor para carregar do BD
    public Person(int id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    // Construtor para criar novo (sem id, com phone)
    public Person(String name, String phone) {
        this.id = 0; // ID será gerado pelo banco
        this.name = name;
        this.phone = phone;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getPhone() { return phone; }
    
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setPhone(String phone) { this.phone = phone; }

    public abstract void displayInfo();
}