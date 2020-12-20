package ServiceTest;

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
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {

    @InjectMocks
    private OrderService orderService;

    @Mock
    private OrderRepository orderRepository;

    private Order order=new Order();

    private List<Order> orderList=new ArrayList<>();

    private List<OrderDTO> orderDTOList=new ArrayList<>();



    @Before
    public void setUp() throws Exception{

        order.setOrders_name("hamburger");
        order.setPayment_type("cash");
        orderList.add(order);


    }
    @Test
    public void shouldGetOrders()
    {

        Mockito.when(orderRepository.findAll()).thenReturn(orderList);
        Mockito.when(orderRepository.count()).thenReturn(1L);
        Mockito.when(orderRepository.findById(any())).thenReturn(Optional.of(order));


        List<OrderDTO> res=orderService.getOrders();

        assertNotNull(res);
        assertEquals(res.get(0).getOrder_id(),orderList.get(0).getOrder_id());


    }



    @Test
    public void shouldAddOrder()
    {

        Mockito.when(orderRepository.save(any())).thenReturn(order);
        ModelMapper modelMapper = new ModelMapper();
        OrderDTO orderDto=modelMapper.map(order,OrderDTO.class);

        String result=orderService.addOrder(orderDto);

        assertNotNull(result);
        assertEquals(result,orderDto.toString());


    }




}
