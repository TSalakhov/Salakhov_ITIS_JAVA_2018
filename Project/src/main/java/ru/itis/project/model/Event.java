package ru.itis.project.model;

import java.util.ArrayList;
import java.util.List;

public class Event {
    private  String name;
    private  String description;
    private  Long date;
    private  Long address;
    private  String image;
    private  String tags;
    private  String status;
    private List<Tag> eventTags;

    public Event() {
    }

    public Event(String name, String description, Long date, Long address, String image, String tags, String status, List<Tag> eventTags) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.address = address;
        this.image = image;
        this.tags = tags;
        this.status = status;
        this.eventTags = eventTags;
    }

    public List<Tag> getEventTags() {
        return eventTags;
    }

    public void setEventTags(List<Tag> eventTags) {
        this.eventTags = eventTags;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public Long getAddress() {
        return address;
    }

    public void setAddress(Long address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
