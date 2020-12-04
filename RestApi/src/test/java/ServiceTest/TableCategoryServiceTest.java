package ServiceTest;

import com.ba.DTO.TableCategoryDTO;
import com.ba.Entities.TableCategory;
import com.ba.Repository.TableCategoryRepository;
import com.ba.Service.TableCategoryService;
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
public class TableCategoryServiceTest {

    @InjectMocks
    private TableCategoryService tableCategoryService;

    @Mock
    private TableCategoryRepository tableCategoryRepository;


    private TableCategory tableCategory=new TableCategory();

    private List<TableCategory> tableCategories=new ArrayList<>();

    private List<TableCategoryDTO> tableCategoryDTOS=new ArrayList<>();


    @Before
    public void setUp() throws Exception{

        tableCategory.setName("food");

        tableCategories.add(tableCategory);

    }

    @Test
    public void shouldGetAllTableCategories()
    {
        Mockito.when(tableCategoryRepository.findAll()).thenReturn(tableCategories);


        List<TableCategoryDTO> res=tableCategoryService.getAllTableCategory();

        assertNotNull(res);
        assertEquals(res,tableCategories);


    }


    @Test
    public void shouldAddTableCategory()
    {

        Mockito.when(tableCategoryRepository.save(any())).thenReturn(tableCategory);
        ModelMapper modelMapper = new ModelMapper();
        TableCategoryDTO tableCategoryDto=modelMapper.map(tableCategory,TableCategoryDTO.class);


        String result=tableCategoryService.addTableCategory(tableCategoryDto);

        assertNotNull(result);
        assertEquals(result,tableCategoryDto.toString());


    }






}
