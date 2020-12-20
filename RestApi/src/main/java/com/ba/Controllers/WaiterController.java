package com.ba.Controllers;


import com.ba.DTO.WaiterDTO;
import com.ba.Entities.Waiter;
import com.ba.Repository.WaiterRepository;
import com.ba.Service.WaiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/waiter")
public class WaiterController {

    @Autowired
    private WaiterRepository waiterRepository;

    @Autowired
    private WaiterService waiterService;

    @GetMapping("/list")
    public List<WaiterDTO> listAllWaiters()
    {

        return waiterService.getAllWaiters();

    }
    @PostMapping("/add")
    public String waiterAdd(@RequestBody WaiterDTO waiterDto)
    {

        waiterService.addWaiter(waiterDto);

        return waiterDto.toString();

    }

    @PutMapping("/update/{id}")
    public String updateWaiter(@RequestBody WaiterDTO waiterDto,@PathVariable Long id)
    {
        waiterService.updateWaiter(waiterDto,id);

        return waiterDto.toString();


    }

    @DeleteMapping("/delete/{id}")
    public String deleteWaiter(@PathVariable Long id)
    {
        waiterService.deleteWaiter(id);

        return "ID "+id+" is deleted";


    }







}
