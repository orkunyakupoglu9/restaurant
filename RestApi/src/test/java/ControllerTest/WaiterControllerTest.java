package ControllerTest;

import com.ba.Builder.WaiterBuilder;
import com.ba.Controllers.WaiterController;
import com.ba.DTO.WaiterDTO;
import com.ba.Entities.Waiter;
import com.ba.Repository.WaiterRepository;
import com.ba.Service.WaiterService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;


@RunWith(MockitoJUnitRunner.class)
public class WaiterControllerTest {

    @InjectMocks
    private WaiterController waiterController;

    @Mock
    private WaiterRepository waiterRepository;

    @Mock
    private WaiterService waiterService;


    private Waiter waiter=new Waiter();


    private WaiterDTO waiterDto=new WaiterDTO();

    private List<Waiter> waiterList=new ArrayList<>();


    private List<WaiterDTO> waiterDTOList=new ArrayList<>();

    @Before
    public void setUp() throws Exception{

        waiter= new WaiterBuilder().waiter_id(1L).name("orkun").build();

        waiterList.add(waiter);

        ModelMapper modelMapper = new ModelMapper();

       waiterDto=modelMapper.map(waiter,WaiterDTO.class);

        waiterDTOList.add(waiterDto);


    }

    @Test
    public void shouldListAllWaiters()
    {
        Mockito.when(waiterService.getAllWaiters()).thenReturn(waiterDTOList);

        List<WaiterDTO> res=waiterController.listAllWaiters();


        assertNotNull(res);
        assertEquals(res.get(0).getWaiter_id(),waiterList.get(0).getWaiter_id());



    }

    @Test
    public void shouldWaiterAdd()
    {
        Mockito.when(waiterRepository.save(any())).thenReturn(waiter);

        ModelMapper modelMapper = new ModelMapper();


        WaiterDTO waiterDto=modelMapper.map(waiter,WaiterDTO.class);

        String result=waiterController.waiterAdd(waiterDto);

        assertNotNull(result);
        assertEquals(result,waiterDto.toString());



    }




}
