package com.upf.projetos.core;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import dev.morphia.Datastore;
import dev.morphia.Morphia;

/**
 * @author William
 */
public class Database {
    // private static final String IP = "177.67.253.61";
    private static final String DATABASE = "178344";
    // private static final int PORT = 27017;

    private static MongoClientURI uri = new MongoClientURI("mongodb://178344:178344@177.67.253.61/?authSource=178344&ssl=false");
    private static MongoClient mongoClient = new MongoClient(uri);
    private static Morphia morphia = new Morphia();
    private static Datastore datastore = morphia.createDatastore(mongoClient, DATABASE);

    public static Datastore getConexao() {
       return datastore;
    }
}