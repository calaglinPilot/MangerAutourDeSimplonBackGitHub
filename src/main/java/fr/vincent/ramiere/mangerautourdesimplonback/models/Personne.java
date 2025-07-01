package fr.vincent.ramiere.mangerautourdesimplonback.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Personne {
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private Collection<Preference> preference = new ArrayList<>();
    private List<EnumRole> roleList;

    public Personne() {
        super();
    }

    public Personne(String nom, String prenom, String email, String password, List<EnumRole> roleList) {
        super();
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.roleList = roleList;
    }

    public Personne(String email, String password, List<EnumRole> roleList) {
		super();
		this.email = email;
		this.password = password;
		this.roleList = roleList;
	}

    
	public Personne(String nom, String prenom, String email, String password) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
	}

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_personne")
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
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Column(nullable = false)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Column(nullable = false)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

	@OneToMany(mappedBy = "preferencePK.personne", cascade = CascadeType.REMOVE)
	//@JsonIgnore
	public Collection<Preference> getPreference() {
		return preference;
	}


	public void setPreference(Collection<Preference> preference) {
		this.preference = preference;
	}


	@ElementCollection(fetch = FetchType.EAGER)
	@Enumerated(EnumType.STRING)
	public List<EnumRole> getRoleList() {
		return roleList;
	}


	public void setRoleList(List<EnumRole> roleList) {
		this.roleList = roleList;
	}

}
