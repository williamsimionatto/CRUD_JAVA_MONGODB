package com.upf.projetos.model;

import org.bson.types.ObjectId;

import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;
import dev.morphia.annotations.Indexed;

/**
 * @author William
*/
@Entity(value = "restaurante", noClassnameStored = true)
public class Restaurante {
    @Id
    private ObjectId id;

    @Indexed
    private String name;
    private String category;
    private String deliveryStime;
    private Double rating;
    private String about;
    private String hours;

    public Restaurante() {}

    public Restaurante(ObjectId id, String name, String category, String deliveryStime, Double rating, String about, String hours) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.deliveryStime = deliveryStime;
        this.rating = rating;
        this.about = about;
        this.hours = hours;
    }

    public Restaurante(ObjectId id, String name, String category, String deliveryStime, String about, String hours) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.deliveryStime = deliveryStime;
        this.about = about;
        this.hours = hours;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDeliveryStime() {
        return deliveryStime;
    }

    public void setDeliveryStime(String deliveryStime) {
        this.deliveryStime = deliveryStime;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}