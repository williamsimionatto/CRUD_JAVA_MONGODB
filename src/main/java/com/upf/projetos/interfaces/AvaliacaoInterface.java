package com.upf.projetos.interfaces;

import java.util.List;

import com.upf.projetos.model.Avaliacao;

import org.bson.types.ObjectId;

import dev.morphia.query.Query;
import dev.morphia.query.UpdateOperations;

/**
 * @author William
*/
public interface AvaliacaoInterface {
    public List<Avaliacao> getAll();

    public Avaliacao getByID(ObjectId id);

    public void incluir(Avaliacao a);

    public void update(Query<Avaliacao> query, UpdateOperations<Avaliacao> ops);

    public void deleteAll();

    public void deletebyId(ObjectId id);
}