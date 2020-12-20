package com.ba.DTO;

import com.ba.Entities.Media;

public class WaiterDTO {

    private long waiter_id;
    private String name;
    private String surname;

    private Media media;

    private long media_id;


    public long getWaiter_id() {
        return waiter_id;
    }

    public void setWaiter_id(long waiter_id) {
        this.waiter_id = waiter_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public long getMedia_id() {
        return media_id;
    }

    public void setMedia_id(long media_id) {
        this.media_id = media_id;
    }
}
