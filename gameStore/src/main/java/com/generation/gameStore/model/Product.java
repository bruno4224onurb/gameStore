package com.generation.gameStore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Id;

@Entity
@Table(name = "tb_products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "The attribute name is mandatory.")
	@Size(min = 2, max = 50, message = "The attribute name must contain at least 2 characters and a max of 50!")
	public String name;
	
	@NotBlank(message = "The attribute description is mandatory.")
	@Size(min = 10, max = 100, message = "The attribute description must contain at least 10 characters and a max of 100!")
	public String description;
	
	@ManyToOne
	@JsonIgnoreProperties("products")
	private Category category;

	public Long getId() {
		return id;
	}

	public void setId(Long n) {
		id = n;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
