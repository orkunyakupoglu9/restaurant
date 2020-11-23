package com.ba.Service;


import com.ba.Entities.Order;
import com.ba.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public void addOrder(@RequestBody Order order)
    {

        orderRepository.save(order);


    }



}
