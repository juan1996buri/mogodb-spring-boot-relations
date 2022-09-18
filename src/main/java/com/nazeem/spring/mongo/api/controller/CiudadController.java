package com.nazeem.spring.mongo.api.controller;

import java.util.List;
import java.util.Optional;

import com.nazeem.spring.mongo.api.service.CiudadService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.nazeem.spring.mongo.api.model.Ciudad;

@RestController
@RequestMapping("/ciudad")
public class CiudadController {

	@Autowired
	private CiudadService service;

	@PostMapping("/add")
	public String saveCiudad(@RequestBody Ciudad ciudad) {
		String id  = service.save(ciudad);
		return "Added Ciudad with id : " + id;
	}

	@GetMapping("/findAll")
	public List<Ciudad> getCiudads() {
		return service.findAll();
	}

	@GetMapping("/findByNombre/{nombre}")
	public List<Ciudad> findByAuthor( @PathVariable("codigo") String nombre) {
		return service.findByNombre(nombre);
	}

	@GetMapping("/findAll/{id}")
	public Optional<Ciudad> getCiudad(@PathVariable String id) {
		return service.findById(id);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteCiudad(@PathVariable String id) {
		service.deleteById(id);
		return "Ciudad deleted with id : " + id;
	}

}
