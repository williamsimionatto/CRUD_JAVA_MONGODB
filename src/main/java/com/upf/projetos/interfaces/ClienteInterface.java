package com.upf.projetos.interfaces;

import java.util.List;

import com.upf.projetos.model.Cliente;

import org.bson.types.ObjectId;

import dev.morphia.query.Query;
import dev.morphia.query.UpdateOperations;

/**
 * @author William
*/
public interface ClienteInterface {
    public List<Cliente> getAll();

    public Cliente getByID(ObjectId id);

    public Cliente getByName(String name);

    public void incluir(Cliente i);

    public void update(Query<Cliente> query, UpdateOperations<Cliente> ops);

    public void deleteAll();

    public void deletebyId(ObjectId id);

    public void deletebyName(String name);
}