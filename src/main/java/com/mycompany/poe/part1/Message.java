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
    private int disregardedCount = 0;
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
 public String sendMessage (int userSelection, String msgID, String hash,String cell, String text){
   if (text == null || text.length() > 250){
    return "Message exceeds 250 characters; please reduce the size.";   
   }
     
    if (userSelection == 1){
 // filling in the sent parallel arrays
     sentMessages[sentCount] = text;
     messageHashes[sentCount] = hash;
     messageIDs[sentCount] = msgID;
     recipients[sentCount] = cell;
     sentCount++; 
  return "Message successfully sent";
     }
   else if (userSelection == 2){
// filling in the disregarded tracker
    disregardedMessages[disregardedCount] = text;
    disregardedCount++;
       return "Press 0 to delete the message";
   }
   else if (userSelection == 3){
//filling in the stored parallel arrays
storedMessages[storedCount] = text;
messageHashes[storedCount] = hash;
messageIDs[storedCount] = msgID;
recipients[storedCount] = cell;
storedCount++; 
// It registers this stored array to a local text file
saveMessageToJSON();
return "Message successfully stored.";
   }
   return "Invalid option selected.";
 }
 
 public void saveMessageToJSON(){
     StringBuilder json = new StringBuilder();
     json.append("[\n");
 for (int i = 0; i < storedCount; i++){
   json.append(" {\n"); 
json.append("\"messageID\":\"").append(messageIDs[i]).append("\",\n");
json.append("\"messageHash\":\"").append(messageHashes[i]).append("\",\n");
json.append("\"recipient\":\"").append(recipients[i]).append("\",\n");
json.append("\"messageText\":\"").append(storedMessages[i]).append("\"\n");
json.append(" }").append(i < storedCount - 1 ? ",\n" : "\n");
 }
json.append("]");


try (FileWriter fileWriter = new FileWriter("stored_messages.json")){
    fileWriter.write(json.toString());
 System.out.println("[SYSTEM LOG] Local Json tracking matrix updated");
}
catch (IOException e) {
    System.out.println("System execution error writing file tracking logs.");
}
}
         
 public String displayReport(){
     if (sentCount == 0) return "No messages sent yet.";
   StringBuilder report = new StringBuilder();
for (int i = 0; i < sentCount; i++){
 report.append("Hash: ").append(messageHashes[i])
 .append(" | Recipient: ").append(recipients[i])
 .append(" | Message: ").append(sentMessages[i]).append("\n");
}
return report.toString();
 }
 public String displayLongestMessage(){
     String longest = "";
     for(int i = 0; i < sentCount; i++){
     if (sentMessages[i] !=null && sentMessages[i].length() > longest.length()) longest= sentMessages[i];
}
     for (int i= 0; i < storedCount; i++){
     if(storedMessages[i] !=null && storedMessages[i].length() > longest.length()) longest= storedMessages[i];
}
   return longest.isEmpty() ? "No messages found." : longest;  
 }
 public String searchByMessageID(String targetID){
     for(int i = 0; i < sentCount; i++){
         if(targetID.equals(messageIDs[i])) return "It is dinner time!";
}
     for (int i = 0; i < storedCount; i++){
      if (targetID.equals(messageIDs[i])) return "IT is dinner time!";
}
     return "Message ID target mismatch.";
 }
  public int returnTotalMessages(int totalSent){
      return sentCount + storedCount;
  }
  
  public int getSentCount(){ return sentCount;}
  public int getStoredCount() { return storedCount;}
 
 
 
 
   public String printMessages(String allMessagesSummary){
       return allMessagesSummary;
   }
}
