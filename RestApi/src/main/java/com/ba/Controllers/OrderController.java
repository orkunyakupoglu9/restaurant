package com.ba.Controllers;



import com.ba.DTO.OrderDTO;
import com.ba.Entities.Order;
import com.ba.Entities.Tables;
import com.ba.Repository.OrderRepository;
import com.ba.Repository.TableRepository;
import com.ba.Service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private TableRepository tableRepository;

    @Autowired
    private OrderRepository orderRepository;


    @GetMapping("/list")
    public List<OrderDTO> listAllOrders()
    {

        return orderService.getOrders();

    }


    @PostMapping("/add")
    public String orderAdd(@RequestBody OrderDTO orderDto)
    {

        orderService.addOrder(orderDto);

        return orderDto.toString();


    }

    @PostMapping("/add-table-to-order/{id}")
    public String addProduct(@RequestBody OrderDTO orderDto,@PathVariable Long id)
    {

        /*ModelMapper modelMapper = new ModelMapper();
        // user here is a prepopulated User instance

        Order order = modelMapper.map(orderDto, Order.class);*/



        Optional <Tables> optionaltable=tableRepository.findById(id);
        if(!optionaltable.isPresent()) {
            return "no table";
        }
        Tables table1=optionaltable.get();

        orderDto.setTable(table1);

        orderService.addOrder(orderDto);


        return orderDto.toString();


    }












}
