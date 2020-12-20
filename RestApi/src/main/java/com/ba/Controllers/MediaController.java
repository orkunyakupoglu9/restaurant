package com.ba.Controllers;


import com.ba.DTO.MediaDTO;
import com.ba.Entities.Media;
import com.ba.Repository.MediaRepository;
import com.ba.Service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;


@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
@RequestMapping("/file")
public class MediaController {

    private static final String JPG_EXTENSION=".jpg";
    private static final String PNG_EXTENSION=".png";
    private static final String BMP_EXTENSION=".bmp";
    private static final String BMP_CONTENT="image/bmp";
    private static final String PNG_CONTENT="image/png";


    @Value("${file.upload.directory}")
    private String uploadDir;

    @Autowired
    private MediaRepository repository;

    @Autowired
    private MediaService mediaService;



    @GetMapping("/list")
    public List<MediaDTO> getWholeFiles()
    {


        return mediaService.getAllFiles();

    }

    @PostMapping("/add")
    public String addFile(@RequestParam("file")MultipartFile file, @RequestParam String imageName) throws IOException {



        Files.createDirectories(Paths.get(uploadDir));
        String filePath=generateFullFilePath(file);
        Path targetLocation= FileSystems.getDefault().getPath(filePath);
        Files.copy(file.getInputStream(),targetLocation,StandardCopyOption.REPLACE_EXISTING);

        byte[] bytes=file.getBytes();

        Media media=new Media();
        media.setFile_content(bytes);
        media.setName(imageName);

        repository.save(media);

        return imageName+ " eklendi";

    }

    private String generateUUID()
    {
        return String.valueOf(java.util.UUID.randomUUID());

    }

    private String generateFullFilePath(MultipartFile file){

        String extension=JPG_EXTENSION;

        if(BMP_CONTENT.equals(file.getContentType())){
            extension=BMP_EXTENSION;
        }
        else if(PNG_CONTENT.equals(file.getContentType())){

            extension=PNG_EXTENSION;
        }

        return uploadDir+generateUUID()+extension;



    }




}
