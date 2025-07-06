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

@Entity
public class Restaurant {

    private int id;
    private String nom;
    private String adresse;
    private String telephone;
    private Boolean aEmporter;
    private Boolean surPlace;
    private Integer prix;
    private Boolean accesPMR;
    private String latitude;
    private String longitude;
    private String website;
    private Collection<TypeRestau> typerestaus = new ArrayList<>();
    private Collection<Preference> preference = new ArrayList<>();
	
    public Restaurant() {
		super();
	}

    public Restaurant(String nom, String adresse, String telephone, Boolean aEmporter, Boolean surPlace, int prix,
			Boolean accesPMR, String latitude, String longitude, String website, Collection<TypeRestau> typerestaus) {
		super();
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

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_restau")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@Column(nullable = false)
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	@Column(nullable = false)
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	@Column(nullable = true)
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	@Column(nullable = true)
	public Boolean isaEmporter() {
		return aEmporter;
	}
	public void setaEmporter(Boolean aEmporter) {
		this.aEmporter = aEmporter;
	}
	@Column(nullable = true)
	public Boolean isSurPlace() {
		return surPlace;
	}
	public void setSurPlace(Boolean surPlace) {
		this.surPlace = surPlace;
	}
	@Column(nullable = true)
	public Integer getPrix() {
		return prix;
	}
	public void setPrix(Integer prix) {
		this.prix = prix;
	}
	@Column(nullable = true)
	public Boolean isAccesPMR() {
		return accesPMR;
	}
	public void setAccesPMR(Boolean accesPMR) {
		this.accesPMR = accesPMR;
	}
	@Column(nullable = false)
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	@Column(nullable = false)
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	@Column(nullable = true)
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}

    @ManyToMany
    @JoinTable(name="type_restau",
	joinColumns = @JoinColumn(name = "id_restau"/*classe en cours*/,referencedColumnName = "id_restau" /*classe reliée*/) ,
	inverseJoinColumns =  @JoinColumn(name = "id_type",referencedColumnName = "id_type"))
	public Collection<TypeRestau> getTyperestaus() {
		return typerestaus;
	}
    public void setTyperestaus(Collection<TypeRestau> typerestaus) {
		this.typerestaus = typerestaus;
	}

    @OneToMany(mappedBy = "preferencePK.restau", cascade = CascadeType.REMOVE)
	@JsonIgnore
	public Collection<Preference> getPreference() {
		return preference;
	}


	public void setPreference(Collection<Preference> preference) {
		this.preference = preference;
	}



}
