package test;

import consoCarbone.Alimentation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class AlimentationTest {
    private Alimentation alimentation0;
    private Alimentation alimentation1;
    @BeforeEach
    void setUp() {
        alimentation0 = new Alimentation();
        alimentation1 = new Alimentation(0.3,0.4);
    }
    @AfterEach
    void tearDown() {
        alimentation0 = null;
        alimentation1 = null;
    }
    @ParameterizedTest
    @CsvSource({"0.1,0.5,1.89","0.3,0.4,3.24","0.9,0.05,7.325"})
    void getImpact(double txBoeuf,double txVege,double resultatExpected) {
        alimentation0.setTxBoeuf(txBoeuf);
        alimentation0.setTxVege(txVege);
        assertEquals(resultatExpected,alimentation0.getImpact(),0.0001);
        assertEquals(3.24,alimentation1.getImpact(),0.0001);
    }

    @Test
    void getInfoMoyenne() {
        assertEquals(2.353,Alimentation.getInfoMoyenne(),0.0001);
    }

    @ParameterizedTest
    @CsvSource({"0.1,0.5,-0.463","0.3,0.4,0.887","0.9,0.05,4.972"})
    void comparerAvecMoyen(double txBoeuf,double txVege,double resultatExpected) {
        alimentation0.setTxBoeuf(txBoeuf);
        alimentation0.setTxVege(txVege);
        assertEquals(resultatExpected,alimentation0.comparerAvecMoyen(),0.0001);
        alimentation1.setTxBoeuf(txBoeuf);
        alimentation1.setTxVege(txVege);
        assertEquals(resultatExpected,alimentation1.comparerAvecMoyen(),0.0001);
    }

    @ParameterizedTest
    @ValueSource(doubles = { 0.1, 0.2, 0.42, 0, 0.6 })
    void setTxBoeuf(double txBoeuf) {
        alimentation1.setTxBoeuf(txBoeuf);
        assertNotEquals(0.3,alimentation1.getTxBoeuf());
        alimentation0.setTxBoeuf(txBoeuf);
        assertEquals(txBoeuf,alimentation0.getTxBoeuf());
    }
    @ParameterizedTest
    @ValueSource(doubles = { 0.1, 0.2, 0.42, 0, 0.6 })
    void getTxBoeuf(double txBoeuf) {
        alimentation0.setTxBoeuf(txBoeuf);
        assertEquals(txBoeuf,alimentation0.getTxBoeuf());
        assertEquals(0.3,alimentation1.getTxBoeuf());
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.32,0.6,0.8,0.34})
    void setTxVege(double txVege) {
        alimentation1.setTxVege(txVege);
        assertNotEquals(0.4,alimentation1.getTxVege());
    }

    @ParameterizedTest
    @ValueSource(doubles = { 0.6, 0.7, 0.72, 0, 0.86 })
    void getTxVege(double txVege) {
        alimentation0.setTxVege(txVege);
        assertEquals(txVege,alimentation0.getTxVege());
        assertEquals(0.4,alimentation1.getTxVege());
    }

    @Test
    void testToString() {
        alimentation0.setId(0);
        assertEquals("Alimentation : id =0\nLe pourcentage de bœuf dans votre alimentation : 0.5\nLe pourcentage de légumes dans votre alimentation : 0.5\nl'impact de votre alimentation en terme d'émissions de GES : 4.450000 TCO2eq.\n",
                alimentation0.toString());
    }
    @org.junit.Test(expected = Exception.class)
    public void setTauxThrowException()
    {
        setTxBoeuf(-1);
        setTxVege(0);
    }
}