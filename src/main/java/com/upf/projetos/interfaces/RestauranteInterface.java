package com.upf.projetos.interfaces;

import java.util.List;

import com.upf.projetos.model.Item;
import com.upf.projetos.model.Restaurante;

import org.bson.types.ObjectId;

import dev.morphia.query.Query;
import dev.morphia.query.UpdateOperations;

/**
 * @author William
*/
public interface RestauranteInterface {
    public List<Restaurante> getAll();

    public Restaurante getByID(ObjectId id);

    public Restaurante getByName(String name);

    public void incluir(Restaurante r);

    public void update(Query<Restaurante> query, UpdateOperations<Restaurante> options);

    public void deleteAll();

    public void deletebyId(ObjectId id);

    public void deletebyName(String name);

    public List<Item> getItens();

    public List<Item> getItemRestaurante(String name);
}