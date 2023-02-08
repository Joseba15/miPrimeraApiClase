package com.jacaranda.miPrimeraApiClase.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jacaranda.miPrimeraApiClase.model.Users;

public interface UserRepository extends JpaRepository<Users, String> {

}
