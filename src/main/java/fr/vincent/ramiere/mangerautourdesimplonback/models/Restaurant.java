package fr.vincent.ramiere.mangerautourdesimplonback.models;

import java.util.ArrayList;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_restau")
    private int id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String adresse;

    @Column(nullable = true)
    private String telephone;

    @Column(nullable = true)
    private Boolean aEmporter;

    @Column(nullable = true)
    private Boolean surPlace;

    @Column(nullable = true)
    private Integer prix;

    @Column(nullable = true)
    private Boolean accesPMR;

    @Column(nullable = false)
    private String latitude;

    @Column(nullable = false)
    private String longitude;

    @Column(nullable = true)
    private String website;

    @ManyToMany
    @JoinTable(name="type_restau",
    joinColumns = @JoinColumn(name = "id_restau"/*classe en cours*/,referencedColumnName = "id_restau" /*classe reliée*/) ,
    inverseJoinColumns =  @JoinColumn(name = "id_type",referencedColumnName = "id_type"))
    private Collection<TypeRestau> typerestaus = new ArrayList<>();

    @OneToMany(mappedBy = "preferencePK.restau", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private Collection<Preference> preference = new ArrayList<>();

    public Restaurant(String nom, String adresse, String telephone, Boolean aEmporter, Boolean surPlace, int prix,
			Boolean accesPMR, String latitude, String longitude, String website, Collection<TypeRestau> typerestaus) {
		this.nom = nom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.aEmporter = aEmporter;
		this.surPlace = surPlace;
		this.prix = prix;
		this.accesPMR = accesPMR;
		this.latitude = latitude;
		this.longitude = longitude;
		this.website = website;
		this.typerestaus = typerestaus;
	}
}
