package com.upf.projetos.controller;

import java.util.List;

import com.upf.projetos.core.Database;
import com.upf.projetos.interfaces.RestauranteInterface;
import com.upf.projetos.model.Item;
import com.upf.projetos.model.Restaurante;

import org.bson.types.ObjectId;

import dev.morphia.Datastore;
import dev.morphia.query.Query;
import dev.morphia.query.UpdateOperations;

/**
 * @author William
*/
public class RestauranteController implements RestauranteInterface {
    public RestauranteController() {}

    @Override
    public void deleteAll() {
        Datastore database = Database.getConexao();
        Query<Restaurante> query = database.createQuery(Restaurante.class);
        database.delete(query);
    }

    @Override
    public void deletebyName(String name) {
        Datastore database = Database.getConexao();
        Query<Restaurante> query = database.createQuery(Restaurante.class).field("name").equal(name);
        database.delete(query);
    }

    @Override
    public void deletebyId(ObjectId id) {
        Datastore database = Database.getConexao();
        Query<Restaurante> query = database.createQuery(Restaurante.class).field("id").equal(id);
        database.delete(query);
    }

    @Override
    public List<Restaurante> getAll() {
        Datastore database = Database.getConexao();
        Query<Restaurante> query = database.createQuery(Restaurante.class);
        List<Restaurante> restaurantes = query.find().toList();

        if (restaurantes != null && !restaurantes.isEmpty()) {
            return restaurantes;
        }

        return null;
    }

    @Override
    public Restaurante getByID(ObjectId id) {
        Datastore database = Database.getConexao();
        Query<Restaurante> query = database.createQuery(Restaurante.class).field("id").equal(id);

        List<Restaurante> restaurantes = query.find().toList();

        if (restaurantes != null && !restaurantes.isEmpty()) {
            return restaurantes.get(0);
        }

        return null;
    }

    @Override
    public Restaurante getByName(String name) {
        Datastore database = Database.getConexao();
        Query<Restaurante> query = database.createQuery(Restaurante.class).field("name").equal(name);

        List<Restaurante> restaurantes = query.find().toList();

        if (restaurantes != null && !restaurantes.isEmpty()) {
            return restaurantes.get(0);
        }

        return null;
    }

    @Override
    public List<Item> getItens() {
        return null;
    }

    @Override
    public void incluir(Restaurante r) {
        Datastore database = Database.getConexao();
        database.save(r);
    }

    @Override
    public void update(Query<Restaurante> query, UpdateOperations<Restaurante> ops) {
        Datastore database = Database.getConexao();
        database.update(query, ops);
    }

    @Override
    public List<Item> getItemRestaurante(String name) {
        Datastore database = Database.getConexao();

        Query<Item> query = database.createQuery(Item.class).field("restaurante.name").equal(name);

        List<Item> items = query.find().toList();

        return items;
    }
}