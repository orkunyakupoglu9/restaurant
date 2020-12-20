package ServiceTest;


import com.ba.Builder.WaiterBuilder;
import com.ba.DTO.CategoryDTO;
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

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class WaiterServiceTest {

    @InjectMocks
    private WaiterService waiterService;

    @Mock
    private WaiterRepository waiterRepository;

    private Waiter waiter=new Waiter();

    private WaiterDTO waiterDto=new WaiterDTO();

    private List<Waiter> waiterList=new ArrayList<>();


    private List<WaiterDTO> waiterDTOList=new ArrayList<>();

    @Before
    public void setUp() throws Exception{

       waiter= new WaiterBuilder().waiter_id(1L).name("orkun").build();

       waiterList.add(waiter);


    }


    @Test
    public void shouldGetAllWaiters()
    {

        Mockito.when(waiterRepository.findAll()).thenReturn(waiterList);
        Mockito.when(waiterRepository.count()).thenReturn(1L);
        Mockito.when(waiterRepository.findById(any())).thenReturn(Optional.of(waiter));



        List<WaiterDTO> res=waiterService.getAllWaiters();


        assertNotNull(res);
        assertEquals(res.get(0).getName(),waiterList.get(0).getName());


    }

    @Test
    public void shouldAddWaiter()
    {

        Mockito.when(waiterRepository.save(any())).thenReturn(waiter);

        ModelMapper modelMapper = new ModelMapper();


        WaiterDTO waiterDto=modelMapper.map(waiter,WaiterDTO.class);

        String result=waiterService.addWaiter(waiterDto);

        assertNotNull(result);
        assertEquals(result,waiterDto.toString());



    }

    @Test
    public void shouldDeleteWaiter()
    {

        Long id=222L;
        String res=waiterService.deleteWaiter(id);

        assertEquals(res,"ID:"+id+"removed");
        verify(waiterRepository).deleteById(id);




    }

    @Test
    public void shouldUpdateWaiter()
    {
        Mockito.when(waiterRepository.findById(any())).thenReturn(Optional.of(waiter));



        String result=waiterService.updateWaiter(waiterDto,1L);

        assertNotNull(result);
        assertEquals(result,waiter.toString());


    }






}


