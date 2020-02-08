/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import db.ShopItemDAO;
import db.TransactionDAO;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import model.ShopItem;
import model.Transaction;
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
public class ShopItemServiceTest {
    
    public ShopItemServiceTest() {
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
     * Test of postItem method, of class ShopItemService.
     */
    @Test
    public void testPostItem1() {
        System.out.println("postItem");
        String name = "Name";
        float price = 100.0F;
        int amount = 1;
        ShopItemService instance = new ShopItemService();
        boolean expResult = true;
        boolean result = instance.postItem(name, price, amount);
        assertEquals(expResult, result);
       
    }
    @Test
    public void testPostItem2() {
        System.out.println("postItem");
        String name = "Name2";
        float price = 200.0F;
        int amount = 2;
        ShopItemService instance = new ShopItemService();
        ShopItemDAO sdao = new ShopItemDAO();
        int expResult = sdao.getAll().size();
        instance.postItem(name, price, amount);
        int result = sdao.getAll().size();
        assertEquals(expResult+1, result);
        
    }
    @Test
    public void testPostItem3() {
        System.out.println("postItem");
        String name = "Name3";
        float price = -300.0F;
        int amount = 3;
        ShopItemService instance = new ShopItemService();
        ShopItemDAO sdao = new ShopItemDAO();
        int expResult = sdao.getAll().size();
        instance.postItem(name, price, amount);
        int result = sdao.getAll().size();
        assertEquals(expResult, result);
        
    }
    @Test
    public void testPostItem4() {
        System.out.println("postItem");
        String name = "Name4";
        float price = -300.0F;
        int amount = 16;
        ShopItemService instance = new ShopItemService();
        ShopItemDAO sdao = new ShopItemDAO();
        int expResult = sdao.getAll().size();
        instance.postItem(name, price, amount);
        int result = sdao.getAll().size();
        assertEquals(expResult, result);
        
    }
    @Test
    public void testPostItem5() {
        System.out.println("postItem");
        String name = "Name";
        float price = -100.0F;
        int amount = 1;
        ShopItemService instance = new ShopItemService();
        boolean expResult = false;
        boolean result = instance.postItem(name, price, amount);
        assertEquals(expResult, result);
        
    }
    public void testPostItem6() {
        System.out.println("postItem");
        String name = "Name4";
        float price = 300.0F;
        int amount = -16;
        ShopItemService instance = new ShopItemService();
        ShopItemDAO sdao = new ShopItemDAO();
        int expResult = sdao.getAll().size();
        instance.postItem(name, price, amount);
        int result = sdao.getAll().size();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of removeItem method, of class ShopItemService.
     */
    @Test
    public void testRemoveItem1() {
        System.out.println("removeItem");
        ShopItem s = new ShopItem(1, "New", 100.0F, 1);
        ShopItemService instance = new ShopItemService();
        instance.postItem("New", 100.0F, 1);
        boolean expResult = true;
        boolean result = instance.removeItem(s);
        assertEquals(expResult, result);
        
    }
    @Test
    public void testRemoveItem2() {
        System.out.println("removeItem");
        ShopItem s = new ShopItem(1, "New", 100.0F, 1);
        ShopItemService instance = new ShopItemService();
        instance.postItem("New", 100.0F, 1);
        ShopItemDAO sdao = new ShopItemDAO();
        int expResult = sdao.getAll().size();
        instance.removeItem(s);
        int result = sdao.getAll().size();
        assertEquals(expResult-1, result);
        
    }

    /**
     * Test of buy method, of class ShopItemService.
     */
    @Test //bug
    public void testBuy1() {
        System.out.println("buy");      
        ShopItem s = new ShopItem(1, "New", 100.0F, 6);       
        int amount = 10;   
        ShopItemService instance = new ShopItemService();
        instance.postItem(s.getName(), s.getPrice(), s.getAmount());
        instance.buy(s, amount);
        
        ShopItemDAO sdao = new ShopItemDAO();
        ShopItem s2 = sdao.getOne(1);
        
        assertEquals(s2.getAmount(), s.getAmount());
    }
     @Test
    public void testBuy2() {
        System.out.println("buy");        
        ShopItem s = new ShopItem(1, "New", 100.0F, 6);
        
        int amount = -10;   
        ShopItemService instance = new ShopItemService();
        instance.postItem(s.getName(), s.getPrice(), s.getAmount());
        instance.buy(s, amount);
        
        ShopItemDAO sdao = new ShopItemDAO();
        ShopItem s2 = sdao.getOne(1);
        
        assertEquals(s2.getAmount(), s.getAmount());
    }

    /**
     * Test of stockUp method, of class ShopItemService.
     */
    @Test
    public void testStockUp1() {
        System.out.println("stockUp");        
        ShopItem s = new ShopItem(1, "New", 100.0F, 6);
        int amount = 5;
        int result = amount + s.getAmount();
        
        ShopItemService instance = new ShopItemService();
        instance.postItem(s.getName(), s.getPrice(), s.getAmount());
        
        ShopItemDAO sdao = new ShopItemDAO();
        instance.stockUp(s, amount);
        ShopItem s1 = sdao.getOne(1);
        assertEquals(result, s1.getAmount());
    }
    @Test
    public void testStockUp2() {
        System.out.println("stockUp");
        ShopItem s = new ShopItem(1, "New", 100.0F, 6);
        int amount = -5;
        int result = amount + s.getAmount();
        ShopItemService instance = new ShopItemService();
        instance.postItem(s.getName(), s.getPrice(), s.getAmount());
        ShopItemDAO sdao = new ShopItemDAO();
        instance.stockUp(s, amount);
        ShopItem s1 = sdao.getOne(1);
        assertEquals(result, s1.getAmount());
    }

    /**
     * Test of checkIfPopular method, of class ShopItemService.
     */
    @Test//bug
    public void testCheckIfPopular() {
        System.out.println("checkIfPopular");
        ShopItem s = new ShopItem(1, "New2", 1000.0F, 100);
        ShopItemService instance = new ShopItemService();
        TransactionDAO tdao = new TransactionDAO();
        Date d=java.sql.Date.valueOf(LocalDate.now().minusDays(30));
        Transaction t1 = new Transaction(1, 1000, 100, new Date(), 1, 1, 1, 10);
        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(t1);
        int amount = 0;
        for(Transaction t : transactions){
            if (t.getShopItemId()==s.getId() && t.getDate().after(d)){
                amount+=t.getAmount();
            }
        }
              
        boolean expResult = s.getPrice()>300.0f && amount>(0.6*s.getAmount());
        boolean result = instance.checkIfPopular(s);
        assertEquals(expResult, result);
    }
    @Test
    public void testCheckIfPopular2() {
        System.out.println("checkIfPopular");
        ShopItem s = new ShopItem(1, "New2", 1000.0F, 100);
        ShopItemService instance = new ShopItemService();
        TransactionDAO tdao = new TransactionDAO();
        Date d=java.sql.Date.valueOf(LocalDate.now().minusDays(30));
        Transaction t1 = new Transaction(1, 100, 100, new Date(), 1, 1, 1, 10);
        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(t1);
        int amount = 0;
        for(Transaction t : transactions){
            if (t.getShopItemId()==s.getId() && t.getDate().after(d)){
                amount+=t.getAmount();
            }
        }
              
        boolean expResult = s.getPrice()<300.0f && amount>(0.8*s.getAmount());
        boolean result = instance.checkIfPopular(s);
        assertEquals(expResult, result);
    
    }
    
    @Test
    public void testCheckIfPopular3() {
        System.out.println("checkIfPopular");
        ShopItem s = new ShopItem(1, "New2", 1000.0F, 100);
        ShopItemService instance = new ShopItemService();
        TransactionDAO tdao = new TransactionDAO();
        Date d=java.sql.Date.valueOf(LocalDate.now().minusDays(30));
        Transaction t1 = new Transaction(1, 1000, 1, new Date(), 1, 1, 1, 10);
        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(t1);
        int amount = 0;
        for(Transaction t : transactions){
            if (t.getShopItemId()==s.getId() && t.getDate().after(d)){
                amount+=t.getAmount();
            }
        }
              
        boolean expResult = s.getPrice()>300.0f && amount>(0.6*s.getAmount());
        boolean result = instance.checkIfPopular(s);
        assertEquals(expResult, result);
    
    }
    
    @Test
    public void testCheckIfPopular4() {
        System.out.println("checkIfPopular");
        ShopItem s = new ShopItem(1, "New2", 1000.0F, 100);
        ShopItemService instance = new ShopItemService();
        TransactionDAO tdao = new TransactionDAO();
        Date d=java.sql.Date.valueOf(LocalDate.now().minusDays(30));
        Transaction t1 = new Transaction(1, 100, 1, new Date(), 1, 1, 1, 10);
        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(t1);
        int amount = 0;
        for(Transaction t : transactions){
            if (t.getShopItemId()==s.getId() && t.getDate().after(d)){
                amount+=t.getAmount();
            }
        }
              
        boolean expResult = s.getPrice()<300.0f && amount>(0.8*s.getAmount());
        boolean result = instance.checkIfPopular(s);
        assertEquals(expResult, result);
    
    }
    
    @Test
    public void testCheckIfPopular5() {
        System.out.println("checkIfPopular");
        ShopItem s = new ShopItem(1, "New2", 1000.0F, 100);
        ShopItemService instance = new ShopItemService();
        TransactionDAO tdao = new TransactionDAO();
        Date d=java.sql.Date.valueOf(LocalDate.now().minusDays(30));
        Transaction t1 = new Transaction(1, 1, 100, new Date(), 1, 1, 1, 10);
        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(t1);
        int amount = 0;
        for(Transaction t : transactions){
            if (t.getShopItemId()==s.getId() && t.getDate().after(d)){
                amount+=t.getAmount();
            }
        }
              
        boolean expResult = s.getPrice()>300.0f && amount>(0.6*s.getAmount());
        boolean result = instance.checkIfPopular(s);
        assertEquals(expResult, result);
    
    }
    
    @Test
    public void testCheckIfPopular6() {
        System.out.println("checkIfPopular");
        ShopItem s = new ShopItem(1, "New2", 1000.0F, 100);
        ShopItemService instance = new ShopItemService();
        TransactionDAO tdao = new TransactionDAO();
        Date d=java.sql.Date.valueOf(LocalDate.now().minusDays(30));
        System.out.println(d);
        Transaction t1 = new Transaction(1, 1000, 100, new Date(), 1, 1, 1, 10);
        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(t1);
        int amount = 0;
        for(Transaction t : transactions){
            if (t.getShopItemId()==s.getId() && t.getDate().after(d)){
                amount+=t.getAmount();
            }
        }
              
        boolean expResult = s.getPrice()<300.0f && amount>(0.8*s.getAmount());
        boolean result = instance.checkIfPopular(s);
        assertEquals(expResult, result);
    
    }
    
    @Test
    public void testCheckIfPopular7() {
        System.out.println("checkIfPopular");
        ShopItem s = new ShopItem(1, "New2", 1000.0F, 100);
        ShopItemService instance = new ShopItemService();
        TransactionDAO tdao = new TransactionDAO();
        Date d=java.sql.Date.valueOf(LocalDate.now().minusDays(30));
        Transaction t1 = new Transaction(1, 1, 1, new Date(), 1, 1, 1, 10);
        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(t1);
        int amount = 0;
        for(Transaction t : transactions){
            if (t.getShopItemId()==s.getId() && t.getDate().after(d)){
                amount+=t.getAmount();
            }
        }
              
        boolean expResult = s.getPrice()>300.0f && amount>(0.6*s.getAmount());
        boolean result = instance.checkIfPopular(s);
        assertEquals(expResult, result);
    
    }
    
    @Test
    public void testCheckIfPopular8() {
        System.out.println("checkIfPopular");
        ShopItem s = new ShopItem(1, "New2", 1000.0F, 100);
        ShopItemService instance = new ShopItemService();
        TransactionDAO tdao = new TransactionDAO();
        Date d=java.sql.Date.valueOf(LocalDate.now().minusDays(30));
        Transaction t1 = new Transaction(1, 1000, 1, new Date(), 1, 1, 1, 10);
        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(t1);
        int amount = 0;
        for(Transaction t : transactions){
            if (t.getShopItemId()==s.getId() && t.getDate().after(d)){
                amount+=t.getAmount();
            }
        }
              
        boolean expResult = s.getPrice()<300.0f && amount>(0.8*s.getAmount());
        boolean result = instance.checkIfPopular(s);
        assertEquals(expResult, result);
    
    }

    /**
     * Test of getTrendingIndex method, of class ShopItemService.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testGetTrendingIndex1() {
        ShopItem s = new ShopItem(1, "New2", 1000.0F, 100);
        ShopItemService instance = new ShopItemService();
        float result = instance.getTrendingIndex(s);
    }
    
    @Test
    public void testGetTrendingIndex2() {
        int profit = 0;
        ArrayList<Transaction> transactions = new ArrayList<>();
        ShopItem s = new ShopItem(1, "New2", 1000.0F, 100);       
        Transaction t2 = new Transaction(1, 1000, 1, java.sql.Date.valueOf(LocalDate.now().minusDays(60)), 1, 1, 1, 10);
        transactions.add(t2);
        ShopItemService instance = new ShopItemService();
        
        for(Transaction t : transactions){
            if (t.getShopItemId()==s.getId()){
                profit+=t.getTotalPrice();
            }
        }
        float expResult = profit/60;
        float result = instance.getTrendingIndex(s);
        assertEquals(expResult, result, 0.0);
    }
    
}
    

