package com.jacaranda.miPrimeraApiClase.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacaranda.miPrimeraApiClase.model.Element;
import com.jacaranda.miPrimeraApiClase.repository.ElementRepository;

@Service
public class ElementsService {

	@Autowired
	ElementRepository repository;
	
	public List<Element> getElements(){
		return repository.findAll();
	}
	
	public Element getElement(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public Element save(Element e) {
		return repository.save(e);
	}

	public void delete(Element e) {
		repository.delete(e);
	}
}

