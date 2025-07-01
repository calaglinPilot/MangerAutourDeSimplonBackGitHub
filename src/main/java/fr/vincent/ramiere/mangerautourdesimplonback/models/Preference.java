package fr.vincent.ramiere.mangerautourdesimplonback.models;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entité représentant les préférences d'un utilisateur (Personne) pour un restaurant (Restaurant).
 * Utilise une clé primaire composite {@link PreferencePK}.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Preference {

    // Clé primaire composite, intégrée directement dans cette entité.
    @EmbeddedId
    private PreferencePK preferencePK;

    // Note attribuée par l'utilisateur au restaurant. Peut être nulle.
    // Le type Integer est utilisé pour permettre la nullité (non noté).
	@Column // Par défaut, nullable = true pour Integer
	private Integer note;

    // Indique si le restaurant est marqué comme favori par l'utilisateur.
    // boolean primitif, donc non nullable par défaut en base (false si non spécifié).
	@Column
	private boolean favoris;

    /**
     * Constructeur partiel pour initialiser avec la clé primaire.
     * Ce constructeur est conservé car @AllArgsConstructor ne couvre pas ce cas spécifique
     * si vous souhaitez initialiser uniquement avec la clé.
     * Si @AllArgsConstructor suffit, vous pouvez supprimer celui-ci.
     */
    public Preference(PreferencePK preferencePK){
        this.preferencePK = preferencePK;
    }
}