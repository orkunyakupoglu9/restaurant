package ControllerTest;

import com.ba.Builder.UsersBuilder;
import com.ba.Controllers.UsersController;
import com.ba.DTO.CategoryDTO;
import com.ba.DTO.RoleDTO;
import com.ba.DTO.UsersDTO;
import com.ba.Entities.Role;
import com.ba.Entities.Users;
import com.ba.Repository.RoleRepository;
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
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class UsersControllerTest {

    @InjectMocks
    private UsersController usersController;

    @Mock
    private UsersService usersService;

    @Mock
    private UsersRepository usersRepository;

    @Mock
    private RoleRepository roleRepository;

    private Users user=new Users();
    private Role role=new Role();

    private UsersDTO userDto=new UsersDTO();
    private RoleDTO roleDto=new RoleDTO();

    private List<Users> usersList=new ArrayList<>();
    private List<Role> rolesList=new ArrayList<>();

    private List<UsersDTO> usersDTOS=new ArrayList<>();
    private List<RoleDTO> roleDTOS=new ArrayList<>();

    @Before
    public void setUp() throws Exception{


        user=new UsersBuilder().username("Orkun").build();
        role.setName("ROLE_ADMIN");


        usersList.add(user);
        rolesList.add(role);

        ModelMapper modelMapper = new ModelMapper();
        ModelMapper modelMapper2 = new ModelMapper();

        roleDto=modelMapper.map(role,RoleDTO.class);
        userDto=modelMapper2.map(user,UsersDTO.class);


        roleDTOS.add(roleDto);
        usersDTOS.add(userDto);

    }

    @Test
    public void shouldListAllRoles()
    {
        Mockito.when(usersService.getAllRoles()).thenReturn(roleDTOS);

        List<RoleDTO> res=usersController.listAllRoles();


        assertNotNull(res);
        assertEquals(res.get(0).getName(),roleDTOS.get(0).getName());


    }

    @Test
    public void shouldListAllUsers()
    {
        Mockito.when(usersService.getAllUsers()).thenReturn(usersDTOS);

        List<UsersDTO> res=usersController.listAllUsers();


        assertNotNull(res);
        assertEquals(res.get(0).getUsername(),usersDTOS.get(0).getUsername());


    }



    @Test
    public void shouldAddUser()
    {

        Mockito.when(usersRepository.save(any())).thenReturn(user);

        ModelMapper modelMapper = new ModelMapper();


        UsersDTO userDto=modelMapper.map(user,UsersDTO.class);

        String result=usersController.UserAdd(userDto);

        assertNotNull(result);
        assertEquals(result,"user "+userDto.toString()+" added");

    }









}
