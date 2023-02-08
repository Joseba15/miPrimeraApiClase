package com.jacaranda.miPrimeraApiClase.model;

import java.util.Objects;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="element")
public class Element {

	
		@Id 
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Integer id;
		private String name;
		private String description;
		private double price;
		private int stock;
		private int category;
		
		public Element() {
			
		}
		
		public Element(int id, String name, String description, double price, int stock, int category) {
			super();
			this.id = id;
			this.name = name;
			this.description = description;
			this.price = price;
			this.stock = stock;
			this.category = category;
		}
		

		
		

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public int getStock() {
			return stock;
		}

		public void setStock(int stock) {
			this.stock = stock;
		}

		public int getCategory() {
			return category;
		}

		public void setCategory(int category) {
			this.category = category;
		}

		@Override
		public int hashCode() {
			return Objects.hash(id);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Element other = (Element) obj;
			return Objects.equals(id, other.id);
		}

		
	

		
	}

	

