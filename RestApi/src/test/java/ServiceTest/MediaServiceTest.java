package ServiceTest;

import com.ba.Builder.MediaBuilder;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;

@RunWith(MockitoJUnitRunner.class)
public class MediaServiceTest {

    @InjectMocks
    private MediaService mediaService;

    @Mock
    private MediaRepository mediaRepository;

    private Media media=new Media();


    private List<Media> mediaList=new ArrayList<>();

    private List<MediaDTO> mediaDTOList=new ArrayList<>();

    @Before
    public void setUp() throws Exception{

        media= new MediaBuilder().id(1L).name("hamburger-image").fileContent(null).build();
        mediaList.add(media);

    }

    @Test
    public void shouldGetOrders()
    {

        Mockito.when(mediaRepository.findAll()).thenReturn(mediaList);
        Mockito.when(mediaRepository.count()).thenReturn(1L);
        Mockito.when(mediaRepository.findById(any())).thenReturn(Optional.of(media));


        List<MediaDTO> res=mediaService.getAllFiles();
        assertNotNull(res);
        assertEquals(res.get(0).getMedia_id(),mediaList.get(0).getMedia_id());


    }




}

