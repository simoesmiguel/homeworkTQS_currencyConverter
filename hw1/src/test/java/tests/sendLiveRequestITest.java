/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import helloWorld.sendLiveRequest;
import org.easymock.EasyMock;
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
public class sendLiveRequestITest {
    
    public sendLiveRequestITest() {
    }
    
    private  sendLiveRequest slrMock;
    
 
    
    @Before
    public void setUp() {
        slrMock = EasyMock.createMock(sendLiveRequest.class);
    }
   
    /**
     * Test of sendLiveRequest method, of class sendLiveRequest.
     */
    @Test
    public void testSendLiveRequest() {
        //setup my mock object 
        System.out.println("sendLiveRequest");
        EasyMock.expect(slrMock.sendLiveRequest("USD","EUR","1")).andReturn("1 USD in EUR : 0.824304");
        EasyMock.replay(slrMock);
        
        String from = "USD";
        String to = "EUR";
        String value = "1";
        String expResult = "1 USD in EUR : 0.824304";
        String result = sendLiveRequest.sendLiveRequest(from, to, value);
        System.out.println("expResult : "+expResult+" result "+result );
        System.out.println(expResult.equals(result));
        assertTrue(expResult.equals(result));
        
        EasyMock.verify(slrMock);
        // TODO review the generated test code and remove the default call to fail.
        //fail("Failed in testSendLiveRequest");
    }

    @Test
    public void testSendLiveRequest2() {
        System.out.println("sendLiveRequest2");
        String from = "EUR";
        String to = "PLN";
        String value = "5"; 
        String expResult = "5 EUR in PLN : 21.038985616956847";
        String result = sendLiveRequest.sendLiveRequest(from, to, value);
        assertEquals(expResult,result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("Failed in testSendLiveRequest2");
    }
    
    @Test(expected=NumberFormatException.class)
    public void testSendLiveRequest3() {
        System.out.println("sendLiveRequest3");
        String from = "EUR";
        String to = "PLN";
        String value = "value";
        String result = sendLiveRequest.sendLiveRequest(from, to, value);
        // TODO review the generated test code and remove the default call to fail.
        //fail("Failed in testSendLiveRequest3");
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
        //fail("The test case is a prototype.");
    }
    
    public static void main(String[] args) {
      sendLiveRequestITest slr = new sendLiveRequestITest();
      slr.testSendLiveRequest();
      slr.testSendLiveRequest2();
      slr.testSendLiveRequest3();
    }
}
