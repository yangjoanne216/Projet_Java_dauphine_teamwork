package test;

import consoCarbone.CE;
import consoCarbone.Logement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class LogementTest {
    private Logement logement0;
    private Logement logement1;
    @BeforeEach
    void setUp() {
        logement0 = new Logement();
        logement1 = new Logement(125, CE.A);

    }

    @AfterEach
    void tearDown() {
        logement0=null;
        logement1=null;
    }

    @ParameterizedTest
    @ValueSource(ints = { 0, 1, 2, 3, 4 })
    void setId(int id) {
        logement0.setId(id);
        assertEquals(id,logement0.getId());
    }

    @ParameterizedTest
    @CsvSource({"A,100,0.5","B,225,2.25","G,345,34.5"})
    void getImpact(CE ce,int superficie,double impactExcepted) {
        logement0.setCe(ce);
        logement0.setSuperficie(superficie);
        assertEquals(impactExcepted,logement0.getImpact());
        logement1.setCe(ce);
        logement1.setSuperficie(superficie);
        assertEquals(impactExcepted,logement1.getImpact());
    }

   @ParameterizedTest
   @CsvSource({"A,100,-1","B,225,1","G,345,1"})
   void compareTo(CE ce, int superfice,int differenceExcepted) {
        logement0.setCe(ce);
        logement0.setSuperficie(superfice);
        assertEquals(differenceExcepted,logement0.compareTo(logement1),0.0001);
    }

    @Test
    void getInfoMoyenne() {
        assertEquals(2.706,Logement.getInfoMoyenne(),0.0001);
    }

    @ParameterizedTest
    @ValueSource(ints = {65, 70, 100, 45, 89})
    void getSuperficie(int superficie) {
        logement0.setSuperficie(superficie);
        assertEquals(superficie,logement0.getSuperficie());
        logement1.setSuperficie(superficie);
        assertEquals(superficie,logement1.getSuperficie());
    }

    @ParameterizedTest
    @ValueSource(ints = {65, 70, 100, 45, 89})
    void setSuperficie(int superficie) {
        logement1.setSuperficie(superficie);
        assertNotEquals(superficie,125);
    }

    @ParameterizedTest
    @EnumSource(CE.class)
     void setAndGetCe(CE ce) {
        logement0.setCe(ce);
        assertEquals(ce,logement0.getCe());
        logement1.setCe(ce);
        assertEquals(ce,logement1.getCe());
    }

    @Test
    void testToString() {
        logement0.setId(0);
        assertEquals("Logement : id =0\n" +
                "La superficie de votre logement : 0 mètres carrés\n" +
                "La class énergique du logement est A\n" +
                "l'impact de votre logement en terme d'émissions de GES :  0.000000 TCO2eq.\n",logement0.toString());
    }
}