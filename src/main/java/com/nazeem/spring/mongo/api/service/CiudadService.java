package com.nazeem.spring.mongo.api.service;

import com.nazeem.spring.mongo.api.model.Ciudad;
import com.nazeem.spring.mongo.api.repository.CiudadRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CiudadService {

    @Autowired
    private CiudadRepository repository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public String save(Ciudad Ciudad){
        repository.save(Ciudad);
        return Ciudad.getId();
    }
    public Optional<Ciudad> findById(String id){
        return repository.findById(id);
    }
    public List<Ciudad> findByNombre(String nombre){
       //Query query  = new Query();
       //query.addCriteria(Criteria.where("author").regex(".*"+author+"*.", "i"));

       //List<Ciudad> Ciudads = mongoTemplate.find(query, Ciudad.class);
        //return Ciudads;
    	List<Ciudad> Ciudads=repository.findByNombre(nombre);
    	return Ciudads;
    }
    public List<Ciudad> findAll(){
        return repository.findAll();
    }
    public void deleteById(String id){
        repository.deleteById(id);
    }
}
