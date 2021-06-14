package com.upf.projetos.controller;

import java.util.List;

import com.upf.projetos.core.Database;
import com.upf.projetos.interfaces.ClienteInterface;
import com.upf.projetos.model.Cliente;

import org.bson.types.ObjectId;

import dev.morphia.Datastore;
import dev.morphia.query.Query;
import dev.morphia.query.UpdateOperations;

/**
 * @author William
*/
public class ClienteController implements ClienteInterface {
    public ClienteController() {}

    @Override
    public void deleteAll() {
        Datastore database = Database.getConexao();
        Query<Cliente> query = database.createQuery(Cliente.class);
        database.delete(query);
    }

    @Override
    public void deletebyId(ObjectId id) {
        Datastore database = Database.getConexao();
        Query<Cliente> query = database.createQuery(Cliente.class).field("id").equal(id);
        database.delete(query);
    }

    @Override
    public void deletebyName(String name) {
        Datastore database = Database.getConexao();
        Query<Cliente> query = database.createQuery(Cliente.class).field("name").equal(name);
        database.delete(query);
    }

    @Override
    public List<Cliente> getAll() {
        Datastore database = Database.getConexao();
        Query<Cliente> query = database.createQuery(Cliente.class);
        List<Cliente> items = query.find().toList();

        if (items != null && !items.isEmpty()) {
            return items;
        }

        return null;
    }

    @Override
    public Cliente getByID(ObjectId id) {
        Datastore database = Database.getConexao();
        Query<Cliente> query = database.createQuery(Cliente.class).field("id").equal(id);

        List<Cliente> itens = query.find().toList();

        if (itens != null && !itens.isEmpty()) {
            return itens.get(0);
        }

        return null;
    }

    @Override
    public Cliente getByName(String name) {
        Datastore database = Database.getConexao();
        Query<Cliente> query = database.createQuery(Cliente.class).field("name").equal(name);

        List<Cliente> itens = query.find().toList();

        if (itens != null && !itens.isEmpty()) {
            return itens.get(0);
        }

        return null;
    }

    @Override
    public void incluir(Cliente c) {
        Datastore database = Database.getConexao();
        database.save(c);
    }

    @Override
    public void update(Query<Cliente> query, UpdateOperations<Cliente> ops) {
        Datastore database = Database.getConexao();
        database.update(query, ops);
    }
}