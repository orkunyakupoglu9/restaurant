package com.ba.Entities;


import javax.persistence.*;

@Entity
public class Waiter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long waiter_id;

    private String name;
    private String surname;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "media_id")
    private Media media;




    public Waiter() {
    }

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
}
