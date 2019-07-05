package com.rafael.projetox.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rafael.projetox.domain.CategoriaTeve;
import com.rafael.projetox.dto.CategoriaDTO;
import com.rafael.projetox.dto.CategoriaTeveDTO;
import com.rafael.projetox.services.CategoriaTeveService;

@RestController
@RequestMapping(value = "/teve")
public class CategoriaTeveResource {
	
	@Autowired
	private CategoriaTeveService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<CategoriaTeve> find(@PathVariable Integer id) {
		
		CategoriaTeve objs = service.find(id);
		return ResponseEntity.ok().body(objs);		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody CategoriaTeve obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody CategoriaTeve obj, @PathVariable Integer id){
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
			service.delete(id);
			return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CategoriaTeveDTO>> findAll() {		
		List<CategoriaTeve> list = service.findAll();
		List<CategoriaTeveDTO> listTeveDto = list.stream().map(obj -> new CategoriaTeveDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listTeveDto);		
	}

}
