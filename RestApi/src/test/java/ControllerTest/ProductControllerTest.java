package ControllerTest;

import com.ba.Builder.ProductBuilder;
import com.ba.Controllers.ProductController;
import com.ba.DTO.ProductDTO;
import com.ba.Entities.Product;
import com.ba.Repository.ProductRepository;
import com.ba.Service.ProductService;
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
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ProductControllerTest {

    @InjectMocks
    private ProductController productController;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductService productService;

    private Product product=new Product();
    private ProductDTO productDto=new ProductDTO();

    private List<Product> productList=new ArrayList<>();

    private List<ProductDTO> productDTOList=new ArrayList<>();





    @Before
    public void setUp() throws Exception{

        product=new ProductBuilder().name("hamburger").description("dssdds").build();



        productList.add(product);

        ModelMapper modelMapper = new ModelMapper();

        productDto=modelMapper.map(product,ProductDTO.class);

        productDTOList.add(productDto);


    }

    @Test
    public void shouldListAllProducts()
    {
        Mockito.when(productService.getAllProducts()).thenReturn(productDTOList);

        List<ProductDTO> res=productController.listAllProducts();


        assertNotNull(res);
        assertEquals(res.get(0).getName(),productDTOList.get(0).getName());




    }

    @Test
    public void shouldProductAdd()
    {

        Mockito.when(productRepository.save(any())).thenReturn(product);

        ModelMapper modelMapper = new ModelMapper();
        // user here is a prepopulated User instance

        ProductDTO productDto=modelMapper.map(product,ProductDTO.class);

        String result=productController.addProduct(productDto);

        assertNotNull(result);
        assertEquals(result,productDto.toString());


    }

    @Test
    public void shouldDeleteProductById()
    {
        Long id=222L;
        String res=productController.deleteProduct(id);

        assertEquals(res,"ID:"+id+"removed");
        //verify(categoryController).deleteCategory(id);


    }











}
