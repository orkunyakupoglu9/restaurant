package ServiceTest;

import com.ba.DTO.CategoryDTO;
import com.ba.Entities.Category;
import com.ba.Repository.CategoryRepository;
import com.ba.Repository.ProductRepository;
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
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class CategoryServiceTest {

    @InjectMocks
    private CategoryService categoryService;

    @Mock
    private CategoryRepository categoryRepository;

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
    public void shouldGetAllCategory()
    {

        Mockito.when(categoryRepository.findAll()).thenReturn(categoryList);
        Mockito.when(categoryRepository.count()).thenReturn(1L);
        Mockito.when(categoryRepository.findById(any())).thenReturn(Optional.of(category));



        List<CategoryDTO> res=categoryService.getAllCategory();


        assertNotNull(res);
        assertEquals(res.get(0).getCategory_id(),categoryList.get(0).getCategory_id());


    }
    @Test
    public void shouldAddCategory()
    {
        Mockito.when(categoryRepository.save(any())).thenReturn(category);

        ModelMapper modelMapper = new ModelMapper();
        // user here is a prepopulated User instance

        CategoryDTO categoryDto=modelMapper.map(category,CategoryDTO.class);

        String result=categoryService.addCategory(categoryDto);

        assertNotNull(result);
        assertEquals(result,categoryDto.toString());


    }




}
