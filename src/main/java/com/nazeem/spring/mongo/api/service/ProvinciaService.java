package com.nazeem.spring.mongo.api.service;

import com.nazeem.spring.mongo.api.model.Provincia;
import com.nazeem.spring.mongo.api.repository.ProvinciaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class ProvinciaService {

    @Autowired
    private ProvinciaRepository repository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public String save(Provincia Provincia){
        repository.save(Provincia);
        return Provincia.getId();
    }
    public Optional<Provincia> findById(String id){
        return repository.findById(id);
    }
    public List<Provincia> findByCodigo(String codigo){
       //Query query  = new Query();
       //query.addCriteria(Criteria.where("author").regex(".*"+author+"*.", "i"));

       //List<Provincia> Provincias = mongoTemplate.find(query, Provincia.class);
        //return Provincias;
    	List<Provincia> provincias=repository.findByCodigo(codigo);
    	return provincias;
    }
    public List<Provincia> findAll(){
        return repository.findAll();
    }
    public void deleteById(String id){
        repository.deleteById(id);
    }
}
