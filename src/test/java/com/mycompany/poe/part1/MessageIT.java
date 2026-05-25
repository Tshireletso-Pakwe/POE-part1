/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.poe.part1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Tshireletso
 */
public class MessageIT {
    
    public MessageIT() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of checkMessageID method, of class Message.
     */
    @Test
    public void testCheckMessageID() {
        System.out.println("checkMessageID");
        String messageID = "";
        Message instance = new Message();
        boolean expResult = true;
        boolean result = instance.checkMessageID(1234567890);
        assertTrue(result);

    }

    /**
     * Test of checkRecipientCell method, of class Message.
     */
    @Test
    public void testCheckRecipientCell() {
        System.out.println("checkRecipientCell");
        String cellNumber = "";
        Message instance = new Message();
        String expResult = "Cell number successfully captured.";
        String result = instance.checkRecipientCell("+27831234567");
        assertEquals(expResult, result);
        
    }

    /**
     * Test of createMessageHash method, of class Message.
     */
    @Test
    public void testCreateMessageHash() {
        System.out.println("createMessageHash");
        String messageID = "";
        int numSentMessages = 0;
        String messageText = "";
        Message instance = new Message();
        String expResult = "00:1:HELLOWORLD";
        String result = instance.createMessageHash("0012345678", 1, "HELLO WORLD");
        assertEquals(expResult, result);
        
    }

    /**
     * Test of sendMessage method, of class Message.
     */
    @Test
    public void testSendMessage() {
        System.out.println("sendMessage");
        int userSelection = 0;
        Message instance = new Message();
        String expResult = "Message successfully sent";
        String result = instance.sendMessage(1);
        assertEquals(expResult, result);
           }

    /**
     * Test of printMessages method, of class Message.
     */
    @Test
    public void testPrintMessages() {
        System.out.println("printMessages");
        String allMessagesSummary = "";
        Message instance = new Message();
        String expResult = "Test Summary";
        String result = instance.printMessages("Test Summary");
        assertEquals(expResult, result);
            }

    /**
     * Test of returnTotalMessages method, of class Message.
     */
    @Test
    public void testReturnTotalMessages() {
        System.out.println("returnTotalMessages");
        int totalSent = 0;
        Message instance = new Message();
        int expResult = 5;
        int result = instance.returnTotalMessages(5);
        assertEquals(expResult, result);
           }
    
}
