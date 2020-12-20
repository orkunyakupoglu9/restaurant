package com.ba.Builder;


import com.ba.Entities.Media;

public class MediaBuilder {

    private Long id;

    private String name;

    private byte[] fileContent;

    public MediaBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public MediaBuilder name(String name) {
        this.name = name;
        return this;
    }

    public MediaBuilder fileContent(byte[] fileContent) {
        this.fileContent = fileContent;
        return this;
    }

    public Media build(){

        Media media=new Media();
        media.setMedia_id(this.id);
        media.setFile_content(this.fileContent);
        media.setName(this.name);
        return media;

    }




}
