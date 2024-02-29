package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Orders;
import com.example.demo.service.OrdersService;

@RestController
public class OrdersController {
    @Autowired
    OrdersService ordersService;

    @PostMapping("/order/post")
    public Orders orderposted(@RequestBody Orders od)
    {
        return ordersService.orderposting(od);
    }

    @GetMapping("/order/get")
    public List<Orders> getpostedorder()
    {
        return ordersService.getorderposted();
    }

    @GetMapping("/order/getall")
    public List<Orders> getpostedorderall()
    {
        return ordersService.getall();
    }
}
