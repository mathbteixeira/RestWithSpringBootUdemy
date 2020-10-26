package br.com.erudio.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.data.vo.PersonVO;
import br.com.erudio.service.PersonService;

@RestController
@RequestMapping("/api/person/v1")
public class PersonController {
	
	@Autowired
	private PersonService service;
	
	@GetMapping(produces = { "aplication/json", "aplication/xml", "aplication/x-yaml" } )
	public List<PersonVO> findAll() {
		return service.findAll();
	}

	@GetMapping(value = "/{id}", produces = { "aplication/json", "aplication/xml", "aplication/x-yaml" } )
	public PersonVO findById(@PathVariable("id") Long id) {
		return service.findById(id);
	}
	
	@PostMapping(produces = { "aplication/json", "aplication/xml", "aplication/x-yaml" },
			consumes = { "aplication/json", "aplication/xml", "aplication/x-yaml" })
	public PersonVO create(@RequestBody PersonVO person) {
		return service.create(person);
	}
	
	/*
	 * @PostMapping("/v2") public PersonVOV2 createV2(@RequestBody PersonVOV2
	 * person) { return service.createV2(person); }
	 */
	
	@PutMapping(produces = { "aplication/json", "aplication/xml", "aplication/x-yaml" },
			consumes = { "aplication/json", "aplication/xml", "aplication/x-yaml" })
	public PersonVO update(@RequestBody PersonVO person) {
		return service.update(person);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}
}