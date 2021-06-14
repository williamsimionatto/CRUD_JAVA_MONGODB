package com.upf.projetos.model;

import java.util.List;

import org.bson.types.ObjectId;

import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;
import dev.morphia.annotations.Indexed;
import dev.morphia.annotations.Reference;

/**
 * @author William
*/
@Entity(value = "cliente", noClassnameStored = true)
public class Cliente {
    @Id
    private ObjectId id;
    
    @Indexed
    private String name;
    private String email;
    private String adress;
    private Integer number;
    private String complement;

    @Reference
    private List<Pedido> pedidos;

    public Cliente() {}

    public Cliente(ObjectId id, String name, String email, String adress, Integer number, String complement) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.adress = adress;
        this.number = number;
        this.complement = complement;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }
}