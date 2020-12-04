package ControllerTest;

import com.ba.Controllers.OrderController;
import com.ba.Repository.OrderRepository;
import com.ba.Service.OrderService;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {

    @InjectMocks
    private OrderController orderController;

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private OrderService orderService;



}
