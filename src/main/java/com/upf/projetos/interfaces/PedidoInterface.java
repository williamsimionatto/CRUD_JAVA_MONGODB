package com.upf.projetos.interfaces;

import java.util.List;

import com.upf.projetos.model.Cliente;
import com.upf.projetos.model.Pedido;

import org.bson.types.ObjectId;

import dev.morphia.query.Query;
import dev.morphia.query.UpdateOperations;

/**
 * @author William
*/
public interface PedidoInterface {
    public List<Pedido> getAll();

    public Pedido getByID(ObjectId id);

    public List<Pedido> getByCliente(Cliente c);

    public void incluir(Pedido r);

    public void update(Query<Pedido> query, UpdateOperations<Pedido> options);

    public void deleteAll();

    public void deletebyId(ObjectId id);

    public List<Pedido> getPedidosPayamentOptions(String payamentOptions);
}