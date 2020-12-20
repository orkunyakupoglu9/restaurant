package ControllerTest;


import com.ba.Builder.MediaBuilder;
import com.ba.Controllers.MediaController;
import com.ba.DTO.MediaDTO;
import com.ba.Entities.Media;
import com.ba.Repository.MediaRepository;
import com.ba.Service.MediaService;
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

@RunWith(MockitoJUnitRunner.class)
public class MediaControllerTest {

    @Mock
    MediaRepository mediaRepository;

    @Mock
    MediaService mediaService;

    @InjectMocks
    MediaController mediaController;

    private Media media=new Media();

    private List<Media> mediaList=new ArrayList<>();

    private MediaDTO mediaDto=new MediaDTO();

    private List<MediaDTO> mediaDTOS=new ArrayList<>();



    @Before
    public void setUp() throws Exception{

        media=new MediaBuilder().name("hamburger").build();

        mediaList.add(media);

        ModelMapper modelMapper = new ModelMapper();

        mediaDto=modelMapper.map(media, MediaDTO.class);

        mediaDTOS.add(mediaDto);


    }

    @Test
    public void shouldGetAllFiles()
    {

        Mockito.when(mediaService.getAllFiles()).thenReturn(mediaDTOS);

        List<MediaDTO> res=mediaController.getWholeFiles();


        assertNotNull(res);
        assertEquals(res.get(0).getName(),mediaDTOS.get(0).getName());


    }








    }
