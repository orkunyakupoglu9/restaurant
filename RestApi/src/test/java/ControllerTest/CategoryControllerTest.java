package ControllerTest;

import com.ba.Builder.CategoryBuilder;
import com.ba.Builder.ProductBuilder;
import com.ba.Controllers.CategoryController;
import com.ba.DTO.CategoryDTO;
import com.ba.Entities.Category;
import com.ba.Entities.Product;
import com.ba.Repository.CategoryRepository;
import com.ba.Service.CategoryService;
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
public class CategoryControllerTest {

    @InjectMocks
    private CategoryController categoryController;

    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private CategoryService categoryService;


    private Category category=new Category();
    private Product product=new Product();

    private CategoryDTO categoryDto=new CategoryDTO();

    private List<Category> categoryList=new ArrayList<>();

    private Set<Product> products=new HashSet<>();

    private List<CategoryDTO> categoryDTOList=new ArrayList<>();



    @Before
    public void setUp() throws Exception{


        product=new ProductBuilder().name("hamburger").build();

        products.add(product);

        category= new CategoryBuilder().name("food").description("sdsdsds").products(products).build();


        categoryList.add(category);

        ModelMapper modelMapper = new ModelMapper();

        categoryDto=modelMapper.map(category,CategoryDTO.class);

        categoryDTOList.add(categoryDto);


    }

    @Test
    public void shouldListAllCategories()
    {



        Mockito.when(categoryService.getAllCategory()).thenReturn(categoryDTOList);

        List<CategoryDTO> res=categoryController.listAllCategories();


        assertNotNull(res);
        assertEquals(res.get(0).getCategory_id(),categoryList.get(0).getCategory_id());




    }

    @Test
    public void shouldCategoryAdd()
    {

        Mockito.when(categoryRepository.save(any())).thenReturn(category);

        ModelMapper modelMapper = new ModelMapper();


        CategoryDTO categoryDto=modelMapper.map(category,CategoryDTO.class);

        String result=categoryController.categoryAdd(categoryDto);

        assertNotNull(result);
        assertEquals(result,categoryDto.toString());


    }

    @Test
    public void shouldDeleteCategoryById()
    {
        Long id=222L;
        String res=categoryController.deleteCategory(id);

        assertEquals(res,"ID:"+id+" and products removed");
        //verify(categoryController).deleteCategory(id);


    }

    @Test
    public void shouldGetProductsById()
    {

       Mockito.when(categoryRepository.findById(any())).thenReturn(Optional.of(category));


        //verify(categoryRepository).findById(1L);

        Set<Product> p=categoryController.getProductsById(1L);

        assertEquals(category.getProducts(),p);


    }











}
