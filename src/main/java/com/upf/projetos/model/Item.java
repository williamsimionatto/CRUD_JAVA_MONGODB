package com.upf.projetos.model;

import dev.morphia.annotations.Embedded;
import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;
import dev.morphia.annotations.Indexed;

/**
 * @author William
*/
@Entity(value = "item", noClassnameStored = true)
public class Item {
    @Id
    private Integer id;

    @Indexed
    private String name;
    private String description;
    private Double price;

    @Embedded
    private Restaurante restaurante;

    public Item() {}

    public Item(Integer id, String name, String description, Double price, Restaurante restaurante) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.restaurante = restaurante;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }
}