package ControllerTest;

import com.ba.Controllers.ProductController;
import com.ba.Entities.Product;
import com.ba.Repository.ProductRepository;
import com.ba.Service.ProductService;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ProductControllerTest {

    @InjectMocks
    private ProductController productController;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductService productService;


}
