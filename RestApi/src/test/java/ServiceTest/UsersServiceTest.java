package ServiceTest;

import com.ba.Entities.Users;
import com.ba.Repository.UsersRepository;
import com.ba.Service.UsersService;
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
public class UsersServiceTest {

    @InjectMocks
    private UsersService usersService;

    @Mock
    private UsersRepository usersRepository;


    private Users user=new Users();

    private List<Users> usersList=new ArrayList<>();


    @Before
    public void setUp() throws Exception{

       user.setUsername("Orkun");

        usersList.add(user);

    }

    @Test
    public void shouldGetAllUsers()
    {
        Mockito.when(usersRepository.findAll()).thenReturn(usersList);


        List<Users> res=usersService.getAllUsers();

        assertNotNull(res);
        assertEquals(res,usersList);

    }

    @Test
    public void shouldAddUsers()
    {
        Mockito.when(usersRepository.save(any())).thenReturn(user);


        String result=usersService.addUser(user);

        assertNotNull(result);
        assertEquals(result,user.toString());


    }

    @Test
    public void shouldDeleteUser()
    {
        Long id=222L;

        String res=usersService.deleteUser(id);

        assertEquals(res,id+ " is deleted");

        verify(usersRepository).deleteById(id);


    }











}
