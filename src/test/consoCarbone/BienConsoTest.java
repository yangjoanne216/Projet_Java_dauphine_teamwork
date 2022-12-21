//package test.consoCarbone;
//
//import consoCarbone.BienConso;
//import org.junit.Test;
//import org.junit.Before;
//import org.junit.After;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
///**
//* BienConso Tester.
//*
//* @author <Yang YANG, NinXing YE>
//* @since <pre>12月18, 2022</pre>
//* @version 1.0
//*/
//public class BienConsoTest {
//    private static BienConso bienConso0;
//    private static BienConso bienConso1;
//
//
//@Before
//public void setUpTests() throws Exception {
//    bienConso0=new BienConso();
//    bienConso1=new BienConso(100);
//}
//
//@After
//public void afterEach() throws Exception {
//    bienConso0=null;
//    bienConso1=null;
//}
//
///**
//*
//* Method: getMontant()
//*
//*/
//@Test
//public void testGetMontant() throws Exception {
//    //bienConso0=new BienConso();
//    //bienConso1=new BienConso(100);
//    assertEquals(0,bienConso0.getMontant());
//    assertEquals(100,bienConso1.getMontant());
//}
//
///**
//*
//* Method: setMontant(double montant)
//*
//*/
//@Test
//public void testSetMontant() throws Exception {
////TODO: Test goes here...
//    bienConso1.setMontant(300);
//    assertEquals(300,bienConso1.getMontant());
//    bienConso0.setMontant(50);
//    assertEquals(50,bienConso0.getMontant());
//}
//@Test
//public void testGetImpact() throws Exception{
//    assertEquals(0.05714285,bienConso1.getImpact(),0.00000001);
//    assertEquals(0,bienConso0.getImpact());
//}
//
///**
//*
//* Method: toString()
//*
//*/
//@Test
//public void testToString() throws Exception {
////TODO: Test goes here...
//}
//
//
//}
