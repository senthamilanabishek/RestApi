package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Orders;
import com.example.demo.repository.OrdersRepo;

@Service
public class OrdersService {
    @Autowired
    OrdersRepo orderrepo;

    public Orders orderposting(Orders od)
    {
        return orderrepo.save(od);
    }

    public List<Orders> getorderposted()
    {
        return orderrepo.findAll();
    }

    public List<Orders> getall()
    {
        return orderrepo.getalldetails();
    }
}
