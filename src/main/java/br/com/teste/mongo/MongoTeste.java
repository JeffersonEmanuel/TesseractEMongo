/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.teste.mongo;

import br.com.teste.tesseract.TesseractTeste;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import java.io.File;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jefferson
 */
public class MongoTeste {

    public DB connect() {
        DB db = null;
        try {
            MongoClient mongoClient = new MongoClient("localhost", 27017);
            db = mongoClient.getDB("testeTesseract");
            
            
        } catch (UnknownHostException ex) {
            Logger.getLogger(MongoTeste.class.getName()).log(Level.SEVERE, null, ex);
        }
        return db;
    }

    
    public void salvar (String termo, String nomeDoArquivo, String enderecoDoArquivo) {
        DB db = connect();
        DBCollection collection = db.getCollection(termo);
        BasicDBObject object = new BasicDBObject();
        object.append(nomeDoArquivo, enderecoDoArquivo);
        collection.insert(object);
    }
    
    
    public void salvarPorTermo (String enderecoDoArquivo) {
        TesseractTeste tesseract = new TesseractTeste();
        File file = new File(enderecoDoArquivo);
       
        List<String> list = tesseract.separarPalavra(enderecoDoArquivo);
        for (String col : list) {
            salvar(col, file.getName(), enderecoDoArquivo);
        }
    }
    
    
    public void buscar (String termo) {
        DB db = connect();
        DBCollection collection = db.getCollection(termo);
        DBCursor cursor = collection.find();
        while (cursor.hasNext()){
            System.out.println(cursor.next());
        }
    }
    
    
    
}
