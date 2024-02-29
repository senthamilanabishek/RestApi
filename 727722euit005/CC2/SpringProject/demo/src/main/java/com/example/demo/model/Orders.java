package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;


@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int orderId;
    String orderdetails;
    String useraddress;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ord_id")
    List<Book> books=new ArrayList<>();
    public int getOrderId() {
        return orderId;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    public String getOrderdetails() {
        return orderdetails;
    }
    public void setOrderdetails(String orderdetails) {
        this.orderdetails = orderdetails;
    }
    public String getUseraddress() {
        return useraddress;
    }
    public void setUseraddress(String useraddress) {
        this.useraddress = useraddress;
    }
    public List<Book> getBooks() {
        return books;
    }
    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
