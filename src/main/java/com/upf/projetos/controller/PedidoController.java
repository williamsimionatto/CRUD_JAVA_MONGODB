package com.upf.projetos.controller;

import java.util.List;

import com.upf.projetos.core.Database;
import com.upf.projetos.interfaces.PedidoInterface;
import com.upf.projetos.model.Cliente;
import com.upf.projetos.model.Pedido;

import org.bson.types.ObjectId;

import dev.morphia.Datastore;
import dev.morphia.query.Query;
import dev.morphia.query.UpdateOperations;

/**
 * @author William
*/
public class PedidoController implements PedidoInterface {
    public PedidoController() {}

    @Override
    public void deleteAll() {
        Datastore database = Database.getConexao();
        Query<Pedido> query = database.createQuery(Pedido.class);
        database.delete(query);
    }

    @Override
    public void deletebyId(ObjectId id) {
        Datastore database = Database.getConexao();
        Query<Pedido> query = database.createQuery(Pedido.class).field("id").equal(id);
        database.delete(query);
    }

    @Override
    public List<Pedido> getAll() {
        Datastore database = Database.getConexao();
        Query<Pedido> query = database.createQuery(Pedido.class);
        List<Pedido> pedidos = query.find().toList();

        if (pedidos != null && !pedidos.isEmpty()) {
            return pedidos;
        }

        return null;
    }

    @Override
    public List<Pedido> getByCliente(Cliente c) {
        Datastore database = Database.getConexao();
        Query<Pedido> query = database.createQuery(Pedido.class).field("cliente.id").equal(c.getId());
        List<Pedido> pedidos = query.find().toList();

        if (pedidos != null && !pedidos.isEmpty()) {
            return pedidos;
        }

        return null;
    }

    @Override
    public Pedido getByID(ObjectId id) {
        Datastore database = Database.getConexao();
        Query<Pedido> query = database.createQuery(Pedido.class).field("id").equal(id);

        List<Pedido> pedidos = query.find().toList();

        if (pedidos != null && !pedidos.isEmpty()) {
            return pedidos.get(0);
        }

        return null;
    }

    @Override
    public void incluir(Pedido p) {
        Datastore database = Database.getConexao();
        database.save(p);
    }

    @Override
    public void update(Query<Pedido> query, UpdateOperations<Pedido> ops) {
       Datastore database = Database.getConexao();
       database.update(query, ops);
    }

    @Override
    public List<Pedido> getPedidosPayamentOptions(String payamentOptions) {
        Datastore database = Database.getConexao();

        Query<Pedido> query = database.createQuery(Pedido.class).field("payamentOptions").equal(payamentOptions);

        List<Pedido> pedidos = query.find().toList();

        return pedidos;
    }
}