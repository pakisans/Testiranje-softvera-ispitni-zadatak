/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import db.DeliveryServiceDAO;
import model.DeliveryService;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pakisa
 */
public class DeliveryServiceServiceTest {
    
    public DeliveryServiceServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of register method, of class DeliveryServiceService.
     */
    @Test
    public void testDeliveryRegister1() {
        System.out.println("register");
        String name = "Name";
        float pricePerKilometer = 100.0F;
        float startingPrice = 1.0F;
        DeliveryServiceService instance = new DeliveryServiceService();
        boolean expResult = true;
        boolean result = instance.register(name, pricePerKilometer, startingPrice);
        assertEquals(expResult, result);
    }
    @Test
    public void testDeliveryRegister2() {
        System.out.println("register");
        String name = "Name2";
        float pricePerKilometer = 200.0F;
        float startingPrice = 2.0F;
        DeliveryServiceService instance = new DeliveryServiceService();
        DeliveryServiceDAO ddao = new DeliveryServiceDAO();
        int expResult = ddao.getAll().size();
        instance.register(name, pricePerKilometer, startingPrice);
        int result = ddao.getAll().size();
        assertEquals(expResult+1, result);
        
    }
    @Test
    public void testDeliveryRegister3() {
        System.out.println("register");
        String name = "Name3";
        float pricePerKilometer = -300.0F;
        float startingPrice = 2.0F;
        DeliveryServiceService instance = new DeliveryServiceService();
        DeliveryServiceDAO ddao = new DeliveryServiceDAO();
        int expResult = ddao.getAll().size();
        instance.register(name, pricePerKilometer, startingPrice);
        int result = ddao.getAll().size();
        assertEquals(expResult, result);
        
    }
    @Test
    public void testDeliveryRegister5() {
        System.out.println("register");
        String name = "Name4";
        float pricePerKilometer = 400.0F;
        float startingPrice = -4.0F;
        DeliveryServiceService instance = new DeliveryServiceService();
        DeliveryServiceDAO ddao = new DeliveryServiceDAO();
        int expResult = ddao.getAll().size();
        instance.register(name, pricePerKilometer, startingPrice);
        int result = ddao.getAll().size();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of deleteDeliveryService method, of class DeliveryServiceService.
     */
    
    @Test
    public void testDeleteDeliveryService2() {
        DeliveryServiceDAO ddao = new DeliveryServiceDAO();
        System.out.println("deleteDeliveryService");
        DeliveryService d = new DeliveryService(2, "Name", 100.0f, 1.0F);
        DeliveryServiceService instance = new DeliveryServiceService();
        instance.register("Name", 100.0f, 1.0F);
        int expResult = ddao.getAll().size();
        instance.deleteDeliveryService(d);
        int result = ddao.getAll().size();
        assertEquals(expResult-1, result);
     
    }
    @Test //bug
    public void testDeleteDeliveryService3() {
        System.out.println("deleteDeliveryService");
        DeliveryService ds = new DeliveryService(2, "Name", 100.0f, 1.0F);
        DeliveryServiceService instance = new DeliveryServiceService();
        boolean expResult = false;
        boolean result = instance.deleteDeliveryService(ds);
        assertEquals(expResult, result);
     
    }

    /**
     * Test of updateInfo method, of class DeliveryServiceService.
     */
    @Test
    public void testUpdateInfo() {
        System.out.println("updateInfo");
        DeliveryService d = new DeliveryService(1, "Name", 100.0f, 1.0F);
        String name = "Test";
        float startingPrice = 200.0F;
        float pricePerKilometer = 15.0F;
        DeliveryServiceService instance = new DeliveryServiceService();
        instance.register("Name", 100.0f, 1.0F);
        boolean expResult = true;
        boolean result = instance.updateInfo(d, name, startingPrice, pricePerKilometer);
        assertEquals(expResult, result);
    }
    @Test
    public void testUpdateInfo2() {
        System.out.println("updateInfo");
        DeliveryService d = new DeliveryService(1, "Name", 100.0f, 1.0F);
        String name = "Test";
        float startingPrice = 200.0F;
        float pricePerKilometer = 15.0F;
        DeliveryServiceService instance = new DeliveryServiceService();
        instance.register("Name", 100.0f, 1.0F);
        DeliveryServiceDAO ddao = new DeliveryServiceDAO();
        instance.updateInfo(d, name, startingPrice, pricePerKilometer);
        DeliveryService d1 = ddao.getOne(1);
        assertEquals(d1.getName().equals(name) && d1.getStartingPrice() == startingPrice && d1.getPricePerKilometer() == pricePerKilometer, true);
    }
    
}
