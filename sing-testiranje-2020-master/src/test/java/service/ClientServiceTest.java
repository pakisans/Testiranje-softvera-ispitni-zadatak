/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import db.ClientDAO;
import model.Client;
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
public class ClientServiceTest {
    
    public ClientServiceTest() {
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
     * Test of login method, of class ClientService.
     */
    @Test
    public void testLogin1() {
        System.out.println("login1");
        String username = "test";
        String password = "123";
        ClientService instance = new ClientService();
        Client expResult = new Client(1,"Test", "test", "123");
        Client result = instance.login(username, password);
        assertEquals(true, expResult.getUsername().equals(result.getUsername()) && expResult.getPassword().equals(result.getPassword()));
    }
    @Test
    public void testLogin2() {
        System.out.println("login2");
        String username = "";
        String password = "";
        ClientService instance = new ClientService();
        Client expResult = new Client(1,"Test", "test", "123");
        Client result = instance.login(username, password);
        assertEquals(false, expResult.getUsername().equals(result.getUsername()) && expResult.getPassword().equals(result.getPassword()));
    } 
    @Test //bug
    public void testLogin3() {
        System.out.println("login3");
        String username = "";
        String password = "123";
        ClientService instance = new ClientService();
        Client expResult = new Client(1,"Test", "test", "123");
        Client result = instance.login(username, password);
        assertEquals(false, expResult.getUsername().equals(result.getUsername()) && expResult.getPassword().equals(result.getPassword()));
    }
    @Test //bug
    public void testLogin4() {
        System.out.println("login4");
        String username = "test";
        String password = "";
        ClientService instance = new ClientService();
        Client expResult = new Client(1,"Test", "test", "123");
        Client result = instance.login(username, password);
        assertEquals(false, expResult.getUsername().equals(result.getUsername()) && expResult.getPassword().equals(result.getPassword()));
    }
    

    /**
     * Test of register method, of class ClientService.
     */
    @Test
    public void testRegister1() {
        System.out.println("register");
        String name = "Test";
        String username = "test";
        String password = "123";
        ClientService instance = new ClientService();
        ClientDAO cdao = new ClientDAO();
        int expResult = cdao.getAll().size();
        instance.register(name, username, password);
        int result = cdao.getAll().size();
        assertEquals(expResult+1, result);
        
    }

    @Test   
    public void testRegister2() {
        System.out.println("register");
        String name = "Test";
        String username = "test";
        String password = "123";
        ClientService instance = new ClientService();
        instance.register("Test", "test", "123");
        ClientDAO cdao = new ClientDAO();
        int expResult = cdao.getAll().size();
        instance.register("Test", "test", "123");
        int result = cdao.getAll().size();
        assertEquals(expResult, result);
        
    }

       
     
    @Test//bug
    public void testRegister3() {
        System.out.println("register");
        String name = "";
        String username = "testt";
        String password = "123";
        ClientService instance = new ClientService();
        ClientDAO cdao = new ClientDAO();
        int expResult = cdao.getAll().size();
        instance.register(name, username, password);
        int result = cdao.getAll().size();
        assertEquals(expResult, result);
        
    }
//
    @Test//bug
    public void testRegister4() {
        System.out.println("register");
        String name = "Testtt";
        String username = "testtt";
        String password = "";
        ClientService instance = new ClientService();
        ClientDAO cdao = new ClientDAO();
        int expResult = cdao.getAll().size();
        instance.register(name, username, password);
        int result = cdao.getAll().size();
        assertEquals(expResult, result);
        
    }
 
    @Test //bug
    public void testRegister5(){
        System.out.println("register");
        String name = "TEST";
        String username = "";
        String password = "1234";
        ClientService instance = new ClientService();
        ClientDAO cdao = new ClientDAO();
        int expResult = cdao.getAll().size();
        instance.register(name, username, password);
        int result = cdao.getAll().size();
        assertEquals(expResult, result);
        
    }


    @Test
    public void testRegister6(){
        System.out.println("register");
        String name = "";
        String username = "";
        String password = "";
        ClientService instance = new ClientService();
        ClientDAO cdao = new ClientDAO();
        int expResult = cdao.getAll().size();
        instance.register(name, username, password);
        int result = cdao.getAll().size();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of deleteUser method, of class ClientService.
     */
    @Test//bug
    public void testDeleteUser1(){
        System.out.println("deleteUser");
        Client c = new Client(1, "Test", "test", "123");
        ClientService instance = new ClientService();
        instance.register("Test", "test", "123");
        ClientDAO cdao = new ClientDAO();
        int expResult = cdao.getAll().size();
        instance.deleteUser(c);
        int result = cdao.getAll().size();
        assertEquals(expResult-1, result);
        
    }
    @Test
    public void testDeleteUser2(){
        System.out.println("deleteUser");
        Client c = new Client(1, "Test", "test", "123");
        ClientService instance = new ClientService();
        ClientDAO cdao = new ClientDAO();
        int expResult = cdao.getAll().size();
        instance.deleteUser(c);
        int result = cdao.getAll().size();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of updateInfo method, of class ClientService.
     */
   @Test//bug
    public void testUpdateInfoName() {
        System.out.println("updateInfo");
        String name = "Tester";
        String oldPassword = "123";
        String password = "1234";
        ClientService instance = new ClientService();
        ClientDAO cdao = new ClientDAO();
        instance.register("Test", "test", "123");
        instance.updateInfo(cdao.getOne(2), name, oldPassword, password);
        Client i = cdao.getOne(2);
        assertEquals(i.getName().equals(name),true);
   }
    @Test
    public void testUpdateInfoPassword() {
        System.out.println("updateInfo");
        String name = "Test";
        String oldPassword = "123";
        String password = "1234";
        ClientService instance = new ClientService();
        ClientDAO cdao = new ClientDAO();
        instance.register("Test", "test", "123");
        instance.updateInfo(cdao.getOne(2), name, oldPassword, password);
        Client i = cdao.getOne(2);
        assertEquals(i.getPassword().equals(password),true);
    }
}