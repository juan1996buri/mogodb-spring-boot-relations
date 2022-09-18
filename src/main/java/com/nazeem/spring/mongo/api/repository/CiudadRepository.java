package com.nazeem.spring.mongo.api.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nazeem.spring.mongo.api.model.Ciudad;

public interface CiudadRepository extends MongoRepository<Ciudad, String> {
	List<Ciudad> findByNombre(String nombre);
}
