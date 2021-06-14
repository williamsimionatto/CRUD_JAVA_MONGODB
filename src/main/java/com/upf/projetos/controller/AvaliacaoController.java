package com.upf.projetos.controller;

import java.util.List;

import com.upf.projetos.core.Database;
import com.upf.projetos.interfaces.AvaliacaoInterface;
import com.upf.projetos.model.Avaliacao;

import org.bson.types.ObjectId;

import dev.morphia.Datastore;
import dev.morphia.query.Query;
import dev.morphia.query.UpdateOperations;

/**
 * @author William
*/
public class AvaliacaoController implements AvaliacaoInterface {
    public AvaliacaoController() {}

    @Override
    public void deleteAll() {
        Datastore database = Database.getConexao();
        Query<Avaliacao> query = database.createQuery(Avaliacao.class);
        database.delete(query);
    }

    @Override
    public void deletebyId(ObjectId id) {
        Datastore database = Database.getConexao();
        Query<Avaliacao> query = database.createQuery(Avaliacao.class).field("id").equal(id);
        database.delete(query);
    }

    @Override
    public List<Avaliacao> getAll() {
        Datastore database = Database.getConexao();
        Query<Avaliacao> query = database.createQuery(Avaliacao.class);
        List<Avaliacao> avaliacoes = query.find().toList();

        if (avaliacoes != null && !avaliacoes.isEmpty()) {
            return avaliacoes;
        }

        return null;
    }

    @Override
    public Avaliacao getByID(ObjectId id) {
        Datastore database = Database.getConexao();
        Query<Avaliacao> query = database.createQuery(Avaliacao.class).field("id").equal(id);

        List<Avaliacao> avaliacoes = query.find().toList();

        if (avaliacoes != null && !avaliacoes.isEmpty()) {
            return avaliacoes.get(0);
        }

        return null;
    }

    @Override
    public void incluir(Avaliacao a) {
        Datastore database = Database.getConexao();
        database.save(a);
    }

    @Override
    public void update(Query<Avaliacao> query, UpdateOperations<Avaliacao> ops) {
        Datastore database = Database.getConexao();
        database.update(query, ops);
    }
}