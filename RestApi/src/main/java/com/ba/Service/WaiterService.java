package com.ba.Service;

import com.ba.DTO.WaiterDTO;
import com.ba.Entities.Waiter;
import com.ba.Repository.WaiterRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WaiterService
{
    @Autowired
    private WaiterRepository waiterRepository;


    public List<WaiterDTO> getAllWaiters()
    {
        ModelMapper modelMapper = new ModelMapper();

        List<WaiterDTO> waiterDTOS=new ArrayList<>();


        List<Waiter> waiterList= waiterRepository.findAll();

        waiterList.forEach(waiter -> {
           WaiterDTO waiterDto = modelMapper.map(waiter, WaiterDTO.class);
            waiterDTOS.add(waiterDto);
        });



        return waiterDTOS;


    }

    public String addWaiter(WaiterDTO waiterDto)
    {
        ModelMapper modelMapper = new ModelMapper();


        Waiter waiter=modelMapper.map(waiterDto,Waiter.class);

        waiterRepository.save(waiter);


        return waiterDto.toString();


    }


    public String deleteWaiter(Long id)
    {

        waiterRepository.deleteById(id);

        return "ID:"+id+"removed";

    }

    public String updateWaiter(WaiterDTO waiterDto,Long id)
    {

        Optional<Waiter> waiter=waiterRepository.findById(id);

        ModelMapper modelMapper = new ModelMapper();

        waiter.get().setName(waiterDto.getName());
        waiter.get().setSurname(waiterDto.getSurname());


        return waiter.toString();

    }







}
