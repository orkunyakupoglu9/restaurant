package ControllerTest;

import com.ba.Builder.OrderBuilder;
import com.ba.Controllers.OrderController;
import com.ba.DTO.OrderDTO;
import com.ba.Entities.Order;
import com.ba.Repository.OrderRepository;
import com.ba.Service.OrderService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {

    @InjectMocks
    private OrderController orderController;

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private OrderService orderService;


    private Order order=new Order();
    private OrderDTO orderDto=new OrderDTO();

    private List<Order> orderList=new ArrayList<>();

    private List<OrderDTO> orderDTOList=new ArrayList<>();

    @Before
    public void setUp() throws Exception{


        order=new OrderBuilder().orders_name("hamburgerorder").build();

        orderList.add(order);

        ModelMapper modelMapper = new ModelMapper();

         orderDto=modelMapper.map(order,OrderDTO.class);

        orderDTOList.add(orderDto);

    }

    @Test
    public void shouldListAllOrders()
    {



        Mockito.when(orderService.getOrders()).thenReturn(orderDTOList);

        List<OrderDTO> res=orderController.listAllOrders();


        assertNotNull(res);
        assertEquals(res.get(0).getOrders_name(),orderDTOList.get(0).getOrders_name());




    }

    @Test
    public void shouldorderAdd()
    {

        Mockito.when(orderRepository.save(any())).thenReturn(order);

        ModelMapper modelMapper = new ModelMapper();

        OrderDTO orderDto=modelMapper.map(order,OrderDTO.class);

        String result=orderController.orderAdd(orderDto);

        assertNotNull(result);
        assertEquals(result,orderDto.toString());





    }













}
