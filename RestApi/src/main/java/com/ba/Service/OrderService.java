package com.ba.Service;


import com.ba.DTO.OrderDTO;
import com.ba.Entities.Order;
import com.ba.Repository.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;




    public List<OrderDTO> getOrders()
    {
        ModelMapper modelMapper = new ModelMapper();
        // user here is a prepopulated User instance
        List<OrderDTO> orderDTOList=new ArrayList<>();

        for(long i=1L;i<=orderRepository.count();i++) {

            OrderDTO orderDto=modelMapper.map(orderRepository.findById(i).get(),OrderDTO.class);
            orderDTOList.add(orderDto);


        }

        return orderDTOList;


    }




    public String addOrder(OrderDTO orderDto)
    {
        ModelMapper modelMapper = new ModelMapper();

        Order order=modelMapper.map(orderDto,Order.class);

        orderRepository.save(order);



        return orderDto.toString();


    }



}
