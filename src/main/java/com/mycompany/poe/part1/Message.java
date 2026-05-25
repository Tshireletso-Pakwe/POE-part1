
package com.mycompany.poe.part1;
import java.util.regex.Pattern;
/**
 *
 * @author Tshireletso
 */
public class Message{
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
           return "Cellnumber is incorecctly formatted or does not contain an international code.Please correct the numvber and try again.";
 }
 }
//   Combining the first 2 characters from the ID and a colon and the message number and first/last words in caps.
   public String createMessageHash(String messageID,int numSentMessages,String messageText) {
//       Extracting the first 2 characters of the Message ID
String idPrefix = messageID.substring(0,2);
String[] words = messageText.trim().split("\\s+");
String firstWord = words[0].toUpperCase();
String lastWord = words[words.length - 1].toUpperCase();
lastWord = lastWord.replaceAll("[?!.]","");
return idPrefix + ":" + numSentMessages + ":" + firstWord + lastWord;
   }
 public String sendMessage (int userSelection){
   if (userSelection == 1){
       return "Message successfully sent";
     }
   else if (userSelection == 2){
       return "Press 0 to delete the message";
   }
   else if (userSelection == 3){
       return "Invalid selection.";
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
