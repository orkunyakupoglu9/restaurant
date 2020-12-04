package ServiceTest;

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
public class ProductServiceTest {

    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

   private Product product=new Product();

    private List<Product> productList=new ArrayList<>();

    private List<ProductDTO> productDTOList=new ArrayList<>();

    @Before
    public void setUp() throws Exception{

        product.setName("Hamburger");
        product.setPrice(35);
        productList.add(product);



    }


   @Test
    public void shouldAddProduct()
   {

       Mockito.when(productRepository.save(any())).thenReturn(product);
       ModelMapper modelMapper = new ModelMapper();
       ProductDTO productDto=modelMapper.map(product,ProductDTO.class);

       String result=productService.addProduct(productDto);

       assertNotNull(result);
       assertEquals(result,productDto.toString());


   }

   /*@Test
    public void shouldGetAllProduct()
   {
       Mockito.when(productRepository.findAll()).thenReturn(productList);
       //categoryRepository.save(category);
       List<Product> result=productService.getAllProducts();


       assertNotNull(result);
       assertEquals(result,productList);


   }*/
   @Test
   public void shouldGetAllProduct()
   {
       Mockito.when(productRepository.findAll()).thenReturn(productList);


       List<ProductDTO> res=productService.getAllProducts();

       assertNotNull(res);
       assertEquals(res,productList);


   }



   @Test
    public void shouldDeleteProductById()
   {
       Long id=222L;
       String res=productService.deleteProduct(id);

       assertEquals(res,"ID "+id+" is deleted");
       verify(productRepository).deleteById(id);


   }






}
