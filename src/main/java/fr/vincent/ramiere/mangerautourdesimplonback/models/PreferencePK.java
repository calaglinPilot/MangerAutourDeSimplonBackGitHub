package fr.vincent.ramiere.mangerautourdesimplonback.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Classe représentant la clé primaire composite pour l'entité {@link Preference}.
 * Elle est composée d'une référence à une {@link Personne} et à un {@link Restaurant}.
 * Cette classe doit implémenter {@link Serializable} et redéfinir {@code equals()} et {@code hashCode()}.
 */
@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class PreferencePK implements Serializable {
    private static final long serialVersionUID = 1L;

    // Clé étrangère vers l'entité Personne
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "personne_id", referencedColumnName = "id_personne")
    @JsonBackReference("personne-preferencepk")
    private transient Personne personne;

    // Clé étrangère vers l'entité Restaurant
    @ManyToOne
	@PrimaryKeyJoinColumn(name="id_restau",referencedColumnName ="id_restau" )
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	private transient Restaurant restau;
}
