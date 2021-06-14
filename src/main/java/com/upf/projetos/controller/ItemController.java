package com.upf.projetos.controller;

import java.util.List;

import com.upf.projetos.core.Database;
import com.upf.projetos.interfaces.ItemInterface;
import com.upf.projetos.model.Item;

import dev.morphia.Datastore;
import dev.morphia.query.Query;
import dev.morphia.query.UpdateOperations;

/**
 * @author William
*/
public class ItemController implements ItemInterface {
    public ItemController() {}

    @Override
    public void deleteAll() {
        Datastore database = Database.getConexao();
        Query<Item> query = database.createQuery(Item.class);
        database.delete(query);
    }

    @Override
    public void deletebyId(Integer id) {
        Datastore database = Database.getConexao();
        Query<Item> query = database.createQuery(Item.class).field("id").equal(id);
        database.delete(query);
    }

    @Override
    public void deletebyName(String name) {
        Datastore database = Database.getConexao();
        Query<Item> query = database.createQuery(Item.class).field("name").equal(name);
        database.delete(query);
    }

    @Override
    public List<Item> getAll() {
        Datastore database = Database.getConexao();
        Query<Item> query = database.createQuery(Item.class);
        List<Item> items = query.find().toList();

        if (items != null && !items.isEmpty()) {
            return items;
        }

        return null;
    }

    @Override
    public Item getByID(Integer id) {
        Datastore database = Database.getConexao();
        Query<Item> query = database.createQuery(Item.class).field("id").equal(id);

        List<Item> itens = query.find().toList();

        if (itens != null && !itens.isEmpty()) {
            return itens.get(0);
        }

        return null;
    }

    @Override
    public Item getByName(String name) {
        Datastore database = Database.getConexao();
        Query<Item> query = database.createQuery(Item.class).field("name").equal(name);

        List<Item> itens = query.find().toList();

        if (itens != null && !itens.isEmpty()) {
            return itens.get(0);
        }

        return null;
    }

    @Override
    public void incluir(Item i) {
        Datastore database = Database.getConexao();
        database.save(i);
    }

    @Override
    public void update(Query<Item> query, UpdateOperations<Item> ops) {
        Datastore database = Database.getConexao();
        database.update(query, ops);
    }

    @Override
    public List<Item> getItensMaisCaros(Double price) {
        Datastore database = Database.getConexao();
        Query<Item> query = database.createQuery(Item.class).field("price").greaterThan(price);

        List<Item> itens = query.find().toList();

        if (itens != null && !itens.isEmpty()) {
            return itens;
        }

        return null;
    }

    @Override
    public List<Item> getItensSemPedido(List<String> name) {
        Datastore database = Database.getConexao();
        Query<Item> query = database.createQuery(Item.class).field("name").not().hasAnyOf(name);

        List<Item> itens = query.find().toList();

        if (itens != null && !itens.isEmpty()) {
            return itens;
        }

        return null;
    }
}