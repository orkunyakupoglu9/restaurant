package com.ba.Controllers;


import com.ba.Entities.Order;
import com.ba.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @PostMapping("/add")
    public Order orderAdd(@RequestBody Order order)
    {

        orderService.addOrder(order);

        return order;

    }








}
