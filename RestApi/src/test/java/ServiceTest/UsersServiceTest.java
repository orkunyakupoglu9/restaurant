package ServiceTest;

import com.ba.Builder.UsersBuilder;
import com.ba.DTO.RoleDTO;
import com.ba.DTO.UsersDTO;
import com.ba.Entities.Role;
import com.ba.Entities.Users;
import com.ba.Repository.RoleRepository;
import com.ba.Repository.UsersRepository;
import com.ba.Service.UsersService;
import org.h2.engine.UserBuilder;
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

    @Mock
    private RoleRepository roleRepository;


    private Users user=new Users();
    private Role role=new Role();

    private UsersDTO userDto=new UsersDTO();

    private List<Users> usersList=new ArrayList<>();
    private List<Role> rolesList=new ArrayList<>();

    private List<UsersDTO> usersDTOS=new ArrayList<>();



    @Before
    public void setUp() throws Exception{


        user=new UsersBuilder().username("Orkun").build();
        role.setName("ROLE_ADMIN");


        usersList.add(user);
        rolesList.add(role);

    }

    @Test
    public void shouldGetAllRoles()
    {
        Mockito.when(roleRepository.findAll()).thenReturn(rolesList);

        Mockito.when(roleRepository.findById(any())).thenReturn(Optional.of(role));



        List<RoleDTO> res=usersService.getAllRoles();


        assertNotNull(res);
        assertEquals(res.get(0).getName(),rolesList.get(0).getName());



    }


    @Test
    public void shouldGetAllUsers()
    {
        Mockito.when(usersRepository.findAll()).thenReturn(usersList);
        Mockito.when(usersRepository.count()).thenReturn(1L);
        Mockito.when(usersRepository.findById(any())).thenReturn(Optional.of(user));



        List<UsersDTO> res=usersService.getAllUsers();


        assertNotNull(res);
        assertEquals(res.get(0).getUsername(),usersList.get(0).getUsername());

    }

    /*@Test
    public void shouldAddUsers()
    {
        Mockito.when(usersRepository.save(any())).thenReturn(user);


        String result=usersService.addUser(user);

        assertNotNull(result);
        assertEquals(result,user.toString());


    }*/

    @Test
    public void shouldDeleteUser()
    {
        Long id=222L;

        String res=usersService.deleteUser(id);

        assertEquals(res,id+ " is deleted");

        verify(usersRepository).deleteById(id);


    }











}
