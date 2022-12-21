package test.consoCarbone;

import consoCarbone.AutreBien;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
* BienConso Tester.
*
* @author <Yang YANG, NinXing YE>
* @since <pre>12月18, 2022</pre>
* @version 1.0
*/
public class AutreBienTest {
    private static AutreBien autreBien0;
    private static AutreBien autreBien1;


@Before
public void setUpTests() throws Exception {
    autreBien0 =new AutreBien();
    autreBien1 =new AutreBien(100);
}

@After
public void afterEach() throws Exception {
    autreBien0 =null;
    autreBien1 =null;
}

/**
*
* Method: getMontant()
*
*/
@Test
public void testGetMontant() throws Exception {
    //bienConso0=new BienConso();
    //bienConso1=new BienConso(100);
    assertEquals(0, autreBien0.getMontant());
    assertEquals(100, autreBien1.getMontant());
}

/**
*
* Method: setMontant(double montant)
*
*/
@Test
public void testSetMontant() throws Exception {
//TODO: Test goes here...
    autreBien1.setMontant(300);
    assertEquals(300, autreBien1.getMontant());
    autreBien0.setMontant(50);
    assertEquals(50, autreBien0.getMontant());
}
@Test
public void testGetImpact() throws Exception{
    assertEquals(0.05714285, autreBien1.getImpact(),0.00000001);
    assertEquals(0, autreBien0.getImpact());
}

/**
*
* Method: toString()
*
*/
@Test
public void testToString() throws Exception {
//TODO: Test goes here...
}


}
