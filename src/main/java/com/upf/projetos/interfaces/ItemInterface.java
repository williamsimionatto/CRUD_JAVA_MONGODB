package com.upf.projetos.interfaces;

import java.util.List;

import com.upf.projetos.model.Item;

import dev.morphia.query.Query;
import dev.morphia.query.UpdateOperations;

/**
 * @author William
*/
public interface ItemInterface {
    public List<Item> getAll();

    public Item getByID(Integer id);

    public Item getByName(String name);

    public void incluir(Item i);

    public void update(Query<Item> query, UpdateOperations<Item> ops);

    public void deleteAll();

    public void deletebyId(Integer id);

    public void deletebyName(String name);

    public List<Item> getItensMaisCaros(Double price);

    public List<Item> getItensSemPedido(List<String> name);
}