package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Orders;

@Repository
public interface OrdersRepo extends JpaRepository<Orders,Integer>{
    @Query(value = "select * from orders o JOIN books b on b.ord_id=o.order_id",nativeQuery = true)
    List<Orders> getalldetails();
}
