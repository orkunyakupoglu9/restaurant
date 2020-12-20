package com.ba.Service;


import com.ba.DTO.MediaDTO;
import com.ba.Entities.Media;
import com.ba.Repository.MediaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class MediaService {

    private static final String JPG_EXTENSION=".jpg";
    private static final String PNG_EXTENSION=".png";
    private static final String BMP_EXTENSION=".bmp";
    private static final String BMP_CONTENT="image/bmp";
    private static final String PNG_CONTENT="image/png";


    @Value("${file.upload.directory}")
    private String uploadDir;



    @Autowired
    MediaRepository mediaRepository;

    public List<MediaDTO> getAllFiles()
    {
        ModelMapper modelMapper = new ModelMapper();
        // user here is a prepopulated User instance
        List<MediaDTO> mediaDTOList=new ArrayList<>();

        List<Media> mediaList= mediaRepository.findAll();

        mediaList.forEach(media -> {
            MediaDTO mediaDto = modelMapper.map(media, MediaDTO.class);
            mediaDTOList.add(mediaDto);
        });


       /* for(long i=1L;i<=mediaRepository.count();i++) {

            MediaDTO mediaDto=modelMapper.map(mediaRepository.findById(i).get(),MediaDTO.class);
            mediaDTOList.add(mediaDto);


        }*/


        return mediaDTOList;


    }













}
