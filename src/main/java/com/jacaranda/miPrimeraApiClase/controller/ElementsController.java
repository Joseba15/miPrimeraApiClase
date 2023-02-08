package com.jacaranda.miPrimeraApiClase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jacaranda.miPrimeraApiClase.error.ApiError;
import com.jacaranda.miPrimeraApiClase.error.ElementNotFoundException;
import com.jacaranda.miPrimeraApiClase.model.Element;
import com.jacaranda.miPrimeraApiClase.service.ElementsService;

@RestController
public class ElementsController {

	@Autowired
	private ElementsService servicio;
	
	
	@GetMapping("/element")
	public List<Element> getElements(){
		return servicio.getElements();
	}
	
	
	
	@GetMapping("/element/{id}")
	public ResponseEntity<?> getElement(@PathVariable Integer id) {
		
		Element result = servicio.getElement(id);
		
		if (result == null ) {
			throw new ElementNotFoundException(id);
		}else {
		return ResponseEntity.ok(result);
		}
	}
	
	
	
	@PutMapping("/element/{id}")
	public Element edit(@RequestBody Element elemento, @PathVariable Integer id) {
		if (servicio.getElement(id)!= null) {
			elemento.setId(id);
		return servicio.save(elemento);
		}else {
		return null;
		}
	}
	
	
	@PostMapping("/element/")
	public ResponseEntity<?> add(@RequestBody Element elemento) {
		if(servicio.getElement(elemento.getId())==null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Identificador ya existente");
		}
		try {
			servicio.save(elemento);
			return ResponseEntity.ok(elemento);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		
	}
	
	
	
	
	@DeleteMapping("/element/{id}")
	public ResponseEntity<String> del(@PathVariable int id) {
		if(servicio.getElement(id)!=null) {
			Element e = servicio.getElement(id);
			servicio.delete(e);
			return ResponseEntity.ok("Element deleted");
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	
	
	@ExceptionHandler(ElementNotFoundException.class)
	public ResponseEntity<ApiError> handleElementNotFoundException(ElementNotFoundException e){
		ApiError apiError = new ApiError(HttpStatus.NOT_FOUND,e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
	}
	
	
}
