/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloWorld;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Miguel Simões
 */
public class sendLiveRequestIT {
    
    public sendLiveRequestIT() {
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
     * Test of sendLiveRequest method, of class sendLiveRequest.
     */
    @Test
    public void testSendLiveRequest() {
        System.out.println("sendLiveRequest");
        String from = "";
        String to = "";
        String value = "";
        String expResult = "";
        String result = sendLiveRequest.sendLiveRequest(from, to, value);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class sendLiveRequest.
     */
    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        sendLiveRequest.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
