package com.jacaranda.miPrimeraApiClase.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jacaranda.miPrimeraApiClase.model.Element;

public interface ElementRepository extends JpaRepository<Element, Integer>{

}
