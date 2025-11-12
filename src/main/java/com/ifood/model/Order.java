package com.ifood.model;

public class Order {
    private int id;
    private String customerName;
    private String item;
    private String status; // "Pendente", "Concluído"

    public Order() {}

    public Order(int id, String customerName, String item, String status) {
        this.id = id;
        this.customerName = customerName;
        this.item = item;
        this.status = status;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getItem() { return item; }
    public void setItem(String item) { this.item = item; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public void displayInfo() {
        System.out.println("Pedido [ID=" + id + ", Cliente=" + customerName +
                           ", Item=" + item + ", Status=" + status + "]");
    }
}
