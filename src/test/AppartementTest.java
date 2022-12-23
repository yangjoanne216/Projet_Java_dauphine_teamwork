package test;

import consoCarbone.CE;
import consoCarbone.Appartement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class AppartementTest {
    private Appartement appartement0;
    private Appartement appartement1;
    @BeforeEach
    void setUp() {
        appartement0 = new Appartement();
        appartement1 = new Appartement(125, CE.A);

    }

    @AfterEach
    void tearDown() {
        appartement0 =null;
        appartement1 =null;
    }

    @ParameterizedTest
    @ValueSource(ints = { 0, 1, 2, 3, 4 })
    void setId(int id) {
        appartement0.setId(id);
        assertEquals(id, appartement0.getId());
    }

    @ParameterizedTest
    @CsvSource({"A,100,0.5","B,225,2.25","G,345,34.5"})
    void getImpact(CE ce,int superficie,double impactExcepted) {
        appartement0.setCe(ce);
        appartement0.setSuperficie(superficie);
        assertEquals(impactExcepted, appartement0.getImpact());
        appartement1.setCe(ce);
        appartement1.setSuperficie(superficie);
        assertEquals(impactExcepted, appartement1.getImpact());
    }

   @ParameterizedTest
   @CsvSource({"A,100,-1","B,225,1","G,345,1"})
   void compareTo(CE ce, int superfice,int differenceExcepted) {
        appartement0.setCe(ce);
        appartement0.setSuperficie(superfice);
        assertEquals(differenceExcepted, appartement0.compareTo(appartement1),0.0001);
    }


    @ParameterizedTest
    @ValueSource(ints = {65, 70, 100, 45, 89})
    void getSuperficie(int superficie) {
        appartement0.setSuperficie(superficie);
        assertEquals(superficie, appartement0.getSuperficie());
        appartement1.setSuperficie(superficie);
        assertEquals(superficie, appartement1.getSuperficie());
    }

    @ParameterizedTest
    @ValueSource(ints = {65, 70, 100, 45, 89})
    void setSuperficie(int superficie) {
        appartement1.setSuperficie(superficie);
        assertNotEquals(superficie,125);
    }

    @ParameterizedTest
    @EnumSource(CE.class)
     void setAndGetCe(CE ce) {
        appartement0.setCe(ce);
        assertEquals(ce, appartement0.getCe());
        appartement1.setCe(ce);
        assertEquals(ce, appartement1.getCe());
    }

    @Test
    void testToString() {
        appartement0.setId(0);
        assertEquals("Logement : id =0\n" +
                "La superficie de votre logement : 0 mètres carrés\n" +
                "La class énergique du logement est A\n" +
                "l'impact de votre logement en terme d'émissions de GES :  0.000000 TCO2eq.\n", appartement0.toString());
    }
}