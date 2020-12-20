package ControllerTest;

import com.ba.Builder.TableCategoryBuilder;
import com.ba.Controllers.TableCategoryController;
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

@RunWith(MockitoJUnitRunner.class)
public class TableCategoryControllerTest {

    @InjectMocks
    private TableCategoryController tableCategoryController;

    @Mock
    private TableCategoryRepository tableCategoryRepository;

    @Mock
    private TableCategoryService tableCategoryService;

    private TableCategory tableCategory = new TableCategory();
    private TableCategoryDTO tableCategoryDto = new TableCategoryDTO();

    private List<TableCategory> tableCategoryList = new ArrayList<>();

    private List<TableCategoryDTO> tableCategoryDTOList = new ArrayList<>();


    @Before
    public void setUp() throws Exception {

        tableCategory = new TableCategoryBuilder().name("terrace").build();


        tableCategoryList.add(tableCategory);

        ModelMapper modelMapper = new ModelMapper();

        tableCategoryDto = modelMapper.map(tableCategory, TableCategoryDTO.class);

        tableCategoryDTOList.add(tableCategoryDto);


    }


    @Test
    public void shouldListAllTableCategories() {
        Mockito.when(tableCategoryService.getAllTableCategory()).thenReturn(tableCategoryDTOList);

        List<TableCategoryDTO> res = tableCategoryController.listAllTableCategories();

        assertNotNull(res);
        assertEquals(res.get(0).getName(), tableCategoryDTOList.get(0).getName());


    }


    @Test
    public void shouldTableCategoryAdd() {

        Mockito.when(tableCategoryRepository.save(any())).thenReturn(tableCategory);

        ModelMapper modelMapper = new ModelMapper();


        TableCategoryDTO tableCategoryDto = modelMapper.map(tableCategory, TableCategoryDTO.class);

        String result = tableCategoryController.TableCategoryAdd(tableCategoryDto);

        assertNotNull(result);
        assertEquals(result, tableCategoryDto.toString());


    }

}
