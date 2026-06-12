package com.mycompany.poe.part1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Pattern;
/**
 *Part 3
 * @author Tshireletso
 */
public class Message{
    
 //Parallel tracking Arrays
     private String[] sentMessages = new String[100];
     private String[] disregardedMessages = new String[100];
     private String[] storedMessages = new String[100];
     private String[] messageHashes = new String[100];
     private String[] messageIDs = new String[100];
     private String[] recipients = new String[100];
    
    //Array storage counters
    private int sentCount = 0;
    private int disregarededCount = 0;
    private int storedCount = 0;
    
    
    
//   message checking for ID length
   public boolean checkMessageID(String messageID) {
    if(messageID !=null && messageID.length() <=10){
    return true;
 }
    return false;
 }
//    Checking if the recipient cell number is correct allow with the characters including the +
   public String checkRecipientCell(String cellNumber) {
       String regex = "^\\+27\\d{9}$";
      if (Pattern.matches(regex,cellNumber)){
           return "Cellnumber successfully captured.";
 }
       else { 
           return "Cellnumber is incorecctly formatted or does not contain an international code.Please correct the number and try again.";
 }
 }
//   Combining the first 2 characters from the ID and a colon and the message number and first/last words in caps.
   public String createMessageHash(String messageID,String messageText) {
//       Extracting the first 2 characters of the Message ID
if (messageID == null || messageID.length() < 2){
    return "Invalid Message ID";
}
if (messageText == null || messageText.trim().isEmpty()){
    return "Invalid message text";
}
String idPrefix = messageID.substring(0,2);

//using this function to calculate the length of the message
int messageLength = messageText.length();
String[] words = messageText.trim().split("\\s+");
String firstWord = words[0].toUpperCase();
String lastWord = words[words.length - 1].toUpperCase();
lastWord = lastWord.replaceAll("[?!.]","");
return idPrefix + ":" + messageLength + ":" + firstWord + lastWord;
   }
 public String sendMessage (int userSelection){
   if (userSelection == 1){
       return "Message successfully sent";
     }
   else if (userSelection == 2){
       return "Press 0 to delete the message";
   }
   else if (userSelection == 3){
       return "Message successfully stored.";
   }
   return "Invalid option selected.";
 }
   public String printMessages(String allMessagesSummary){
       return allMessagesSummary;
   }
public int returnTotalMessages(int totalSent){
    return totalSent;
}
}
