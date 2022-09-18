package com.nazeem.spring.mongo.api.controller;

import java.util.List;
import java.util.Optional;

import com.nazeem.spring.mongo.api.service.ProvinciaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.nazeem.spring.mongo.api.model.Provincia;

@RestController
@RequestMapping("/provincia")
public class ProvinciaController {

	@Autowired
	private ProvinciaService service;

	@PostMapping("/add")
	public String saveProvincia(@RequestBody Provincia Provincia) {
		String id  = service.save(Provincia);
		return "Added Provincia with id : " + id;
	}

	@GetMapping("/findAll")
	public List<Provincia> getProvincias() {
		return service.findAll();
	}

	@GetMapping("/findByCodigo/{codigo}")
	public List<Provincia> findByAuthor( @PathVariable("codigo") String codigo) {
		return service.findByCodigo(codigo);
	}

	@GetMapping("/findAll/{id}")
	public Optional<Provincia> getProvincia(@PathVariable String id) {
		return service.findById(id);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteProvincia(@PathVariable String id) {
		service.deleteById(id);
		return "Provincia deleted with id : " + id;
	}

}
