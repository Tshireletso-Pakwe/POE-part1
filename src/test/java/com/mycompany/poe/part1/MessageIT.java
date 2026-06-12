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
        Message instance = new Message();
        String expResult = "00:11:HELLOWORLD";
        String result = instance.createMessageHash("0012345678", "HELLO WORLD");
        assertEquals(expResult, result);
        }

    /**
     * Test of sendMessage method, of class Message.
     */
    @Test
    public void testSendMessage() {
        System.out.println("sendMessage");
        Message instance = new Message();
        String expResult = "Message successfully sent";
        String result = instance.sendMessage(1, "ID01", "HASH01", "+27831234567", "Testing active message payload transmission.");
        assertEquals(expResult, result);
         }

    /**
     * Test of printMessages method, of class Message.
     */
    @Test
    public void testPrintMessages() {
        System.out.println("printMessages");
        Message instance = new Message();
        String expResult = "Test Summary Data Stream";
        String result = instance.printMessages("Test Summary Data Stream");
        assertEquals(expResult, result);
            }

    /**
     * Test of returnTotalMessages method, of class Message.
     */
    @Test
    public void testReturnTotalMessages() {
        System.out.println("returnTotalMessages");
        Message instance = new Message();
        instance.sendMessage(1, "M1", "H1", "+27831234567", "First data unit.");
        instance.sendMessage(3, "M2", "H2", "+2783124567", "Second data unit saved.");
        int expResult = 2;
        int result = instance.returnTotalMessages();
        assertEquals(expResult, result);
           }

    /**
     * Test of saveMessageToJSON method, of class Message.
     */
    @Test
    public void testSaveMessageToJSON() {
        System.out.println("saveMessageToJSON");
        Message instance = new Message();
        instance.sendMessage(3, "JSONID", "HASHJSON", "+27831234567", "Testing active JSON payload serialization.");
        assertDoesNotThrow(()-> {
            instance.saveMessageToJSON();
  });
 }

    /**
     * Test of displayReport method, of class Message.
     */
    @Test
    public void testDisplayReport() {
        System.out.println("displayReport");
        Message instance = new Message();
        instance.sendMessage(1, "R1", "HR1", "+27831234567", "Report payload.");
        String result = instance.displayReport();
        assertTrue(result.contains("Hash:HR1"));
        assertTrue(result.contains("Recipient: +27831234567"));
        }

    /**
     * Test of displayLongestMessage method, of class Message.
     */
    @Test
    public void testDisplayLongestMessage() {
        System.out.println("displayLongestMessage");
        Message instance = new Message();
        instance.sendMessage(1, "S1", "HS1", "+27831234567", "Short payload");
        instance.sendMessage(1, "S2", "HS2", "+27831234567", "THis is clearly the longest messsage payload stream inside the array tracker.");
        String expResult = "This is clearly the longest message payload stream inside the array tracker.";
        String result = instance.displayLongestMessage();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of searchByMessageID method, of class Message.
     */
    @Test
    public void testSearchByMessageID() {
        System.out.println("searchByMessageID");
        String targetID = "";
        Message instance = new Message();
        instance.sendMessage(1, "FINDME", "HASHSEARCH", "+27831234567", "Target text information block.");
        String expResult = "It is dinner time";
        String result = instance.searchByMessageID("FINDME");
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getSentCount method, of class Message.
     */
    @Test
    public void testGetSentCount() {
        System.out.println("getSentCount");
        Message instance = new Message();
        instance.sendMessage(1, "T1", "H1", "+27831234567", "Sent item");

        assertEquals(1, instance.getSentCount());
            }

    /**
     * Test of getStoredCount method, of class Message.
     */
    @Test
    public void testGetStoredCount() {
        System.out.println("getStoredCount");
        Message instance = new Message();
        instance.sendMessage(3, "T2", "H2", "+27831234567", "Stored item");
        assertEquals(1, instance.getStoredCount());
        
    }
    
}
