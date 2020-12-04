package ControllerTest;

import com.ba.Controllers.TableCategoryController;
import com.ba.Repository.TableCategoryRepository;
import com.ba.Service.TableCategoryService;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TableCategoryControllerTest {

    @InjectMocks
    private TableCategoryController tableCategoryController;

    @Mock
    private TableCategoryRepository tableCategoryRepository;

    @Mock
    private TableCategoryService tableCategoryService;



}
