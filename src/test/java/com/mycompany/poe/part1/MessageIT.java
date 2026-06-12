package com.mycompany.poe.part1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Tshireletso
 */
public class MessageIT {
    
    public MessageIT() {
    }
    
    

    /**
     * Test of checkMessageID method, of class Message.
     */
    @Test
    public void testCheckMessageID() {
        System.out.println("checkMessageID");
        Message instance = new Message();
        //test to check if the ID is valid and is under 10 characters
        assertTrue(instance.checkMessageID("MSG123"));
        //test to check if the ID is valid and is over 10 characters
        assertFalse(instance.checkMessageID("THISISAYTOOLONGFORSYSTEM"));
}

    /**
     * Test of checkRecipientCell method, of class Message.
     */
    @Test
    public void testCheckRecipientCell() {
        System.out.println("checkRecipientCell");
        Message instance = new Message();
        //test to check if this is a valid and is the SA international phone sequence
        assertTrue(instance.checkRecipientCell("+27831234567"));
        //test invalid due to missing code 
        assertFalse(instance.checkRecipientCell("0831234567"));
        
        
        
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

    /**
     * Test of saveMessageToJSON method, of class Message.
     */
    @Test
    public void testSaveMessageToJSON() {
        System.out.println("saveMessageToJSON");
        Message instance = new Message();
        instance.saveMessageToJSON();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayReport method, of class Message.
     */
    @Test
    public void testDisplayReport() {
        System.out.println("displayReport");
        Message instance = new Message();
        String expResult = "";
        String result = instance.displayReport();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayLongestMessage method, of class Message.
     */
    @Test
    public void testDisplayLongestMessage() {
        System.out.println("displayLongestMessage");
        Message instance = new Message();
        String expResult = "";
        String result = instance.displayLongestMessage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchByMessageID method, of class Message.
     */
    @Test
    public void testSearchByMessageID() {
        System.out.println("searchByMessageID");
        String targetID = "";
        Message instance = new Message();
        String expResult = "";
        String result = instance.searchByMessageID(targetID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSentCount method, of class Message.
     */
    @Test
    public void testGetSentCount() {
        System.out.println("getSentCount");
        Message instance = new Message();
        int expResult = 0;
        int result = instance.getSentCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStoredCount method, of class Message.
     */
    @Test
    public void testGetStoredCount() {
        System.out.println("getStoredCount");
        Message instance = new Message();
        int expResult = 0;
        int result = instance.getStoredCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
