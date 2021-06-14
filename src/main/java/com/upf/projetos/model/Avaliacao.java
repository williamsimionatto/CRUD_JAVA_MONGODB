package com.upf.projetos.model;

import java.util.Date;

import org.bson.types.ObjectId;

import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;
import dev.morphia.annotations.Reference;

/**
 * @author William
*/
@Entity(value = "avaliacao", noClassnameStored = true)
public class Avaliacao {
    @Id
    private ObjectId id;

    @Reference
    private Cliente cliente;

    @Reference
    private Restaurante restaurante;

    private Date date;
    private Double rating;
    private String comment;

    public Avaliacao() {}

    public Avaliacao(ObjectId id, Cliente cliente, Restaurante restaurante, Date date, Double rating, String comment) {
        this.id = id;
        this.cliente = cliente;
        this.restaurante = restaurante;
        this.date = date;
        this.rating = rating;
        this.comment = comment;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }
}