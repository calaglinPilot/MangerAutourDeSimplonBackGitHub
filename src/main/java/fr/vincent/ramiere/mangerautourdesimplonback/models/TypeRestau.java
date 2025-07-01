package fr.vincent.ramiere.mangerautourdesimplonback.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="type")
public class TypeRestau {
    
    private int id;
	private String libelle;
	private List<Restaurant> restaurants;
	
	public TypeRestau() {
		super();
	}

	public TypeRestau(int id, String libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
	}

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_type")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
    @Column(nullable = false)
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
    
    @ManyToMany(mappedBy="typerestaus")
	@JsonBackReference("restaurants")
	public List<Restaurant> getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(List<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}

}
