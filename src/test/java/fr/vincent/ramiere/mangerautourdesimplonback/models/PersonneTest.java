package fr.vincent.ramiere.mangerautourdesimplonback.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PersonneTest {
    @Test
    void testBuilder() {
        Personne p = Personne.builder().nom("Test").prenom("Test").email("t@t.fr").password("1234").build();
        assertEquals("Test", p.getNom());
    }
}
