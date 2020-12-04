package ControllerTest;

import com.ba.Controllers.CategoryController;
import com.ba.DTO.CategoryDTO;
import com.ba.Entities.Category;
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

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CategoryControllerTest {

    @InjectMocks
    private CategoryController categoryController;

    @Mock
    private CategoryRepository categoryRepository;

    private CategoryService categoryService;


    private Category category=new Category();

    private List<Category> categoryList=new ArrayList<>();

    private List<CategoryDTO> categoryDTOList=new ArrayList<>();



    @Before
    public void setUp() throws Exception{

        category.setName("food");
        category.setDescription("sddssd");

        categoryList.add(category);

        ModelMapper modelMapper = new ModelMapper();

        CategoryDTO categoryDto=modelMapper.map(category,CategoryDTO.class);

        categoryDTOList.add(categoryDto);


    }

    @Test
    public void shouldListAllCategories()
    {

       // verify(categoryRepository).findAll();


        Mockito.when(categoryService.getAllCategory()).thenReturn(categoryDTOList);

        List<CategoryDTO> res=categoryController.listAllCategories();


        assertNotNull(res);
        assertEquals(res,categoryDTOList);


    }






}
