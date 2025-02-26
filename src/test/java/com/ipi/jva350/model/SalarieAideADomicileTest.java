package com.ipi.jva350.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SalarieAideADomicileTest {

    @Test
    void testALegalementDroitADesCongesPayesParDefaut() {
        // Given
        SalarieAideADomicile s = new SalarieAideADomicile();
        // When
        boolean res = s.aLegalementDroitADesCongesPayes();
        // Then
        Assertions.assertEquals(false, res); // TODO vérifie que Sonar demande amélioration
    }

    /*
    @Test
    void testALegalementDroitADesCongesPayes100() {
        // Given
        SalarieAideADomicile s = new SalarieAideADomicile();
        s.setJoursTravaillesAnneeNMoins1(100);
        // When
        boolean res = s.aLegalementDroitADesCongesPayes();
        // Then
        Assertions.assertTrue(res); // TODO vérifie que Sonar demande amélioration
    }
    @Test
    void testALegalementDroitADesCongesPayes101() {
        // Given
        SalarieAideADomicile s = new SalarieAideADomicile();
        s.setJoursTravaillesAnneeNMoins1(101);
        // When
        boolean res = s.aLegalementDroitADesCongesPayes();
        // Then
        Assertions.assertTrue(res); // TODO vérifie que Sonar demande amélioration
    }
    */

    /**
     * Test représentatif du cas "n'a légalement pas droit des congés"
     */
    @Test
    void testALegalementDroitADesCongesPayesFalseTypique() {
        // Given
        SalarieAideADomicile s = new SalarieAideADomicile();
        // When
        boolean res = s.aLegalementDroitADesCongesPayes();
        s.setJoursTravaillesAnneeNMoins1(1);
        // Then
        // avec 1j de travaillé, il est très peu probable d'avoir un jour de congés !
        Assertions.assertFalse(res);
    }

    /**
     * Test représentatif du cas "a légalement pas droit des congés"
     */
    @Test
    void testALegalementDroitADesCongesPayesTrueTypique() {
        // Given
        SalarieAideADomicile s = new SalarieAideADomicile();
        s.setJoursTravaillesAnneeNMoins1(100);
        // When
        boolean res = s.aLegalementDroitADesCongesPayes();
        // Then
        // avec 100j de travaillé, il est très probable d'avoir un jour de congés !
        Assertions.assertTrue(res);
    }

    @Test
    void testALegalementDroitADesCongesPayesFalseAuxLimites() {
        // Given
        SalarieAideADomicile s = new SalarieAideADomicile();
        s.setJoursTravaillesAnneeNMoins1(9);
        // When
        boolean res = s.aLegalementDroitADesCongesPayes();
        // Then
        Assertions.assertFalse(res);
    }

    @Test
    void testALegalementDroitADesCongesPayesTrueAuxLimites() {
        // Given
        SalarieAideADomicile s = new SalarieAideADomicile();
        s.setJoursTravaillesAnneeNMoins1(10);
        // When
        boolean res = s.aLegalementDroitADesCongesPayes();
        // Then
        Assertions.assertTrue(res);
    }

}