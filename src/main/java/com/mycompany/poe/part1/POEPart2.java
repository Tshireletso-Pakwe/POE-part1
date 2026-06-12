package com.mycompany.poe.part1;

import java.util.Scanner;
import com.mycompany.poe.part1.Login;
public class POEPart1 {

 /**
  * Part 3 Main applications center
  * It will manage the interactive console workflows, data captures and analytical menu reporting
  * @author Tshireletso
  */   
    
    public static void main(String[] args) {
      Scanner sc= new Scanner(System.in);
      Login loginLogic = new Login();
//      Part 1: REGISTRATION
      
    System.out.println("--User Registration--");
        System.out.print("Enter First Name: ");
            String firstName =
                    sc.nextLine();
        System.out.print("Enter Last Name: ");
            String lastName =
                    sc.nextLine();
        System.out.print("Enter Username:");
            String username = 
                    sc.nextLine();
        System.out.print("Enter Password: ");
            String password =
                    sc.nextLine();
        System.out.print("Enter Cellphone Number: ");
            String phone =
                    sc.nextLine();
        
   String registrationMessage = loginLogic.registerUser(username, password,firstName, lastName,phone);
   System.out.println("\nStatus:"+ registrationMessage);
        if (registrationMessage.equals("Username and password successfully captured.")){
            System.out.println("\n-- User Login --");
            System.out.print("Enter Username: ");
            String loginUser = sc.nextLine();
            System.out.print("Enter Password: ");
            String loginPass = sc.nextLine();
            
    boolean loginSuccess = loginLogic.loginUser(loginUser, loginPass);
    System.out.println(loginLogic.returnLoginStatus(loginSuccess));
//   PART 2 & 3: Message Engine Execution
if (loginSuccess){
    Message messageManager = new Message();
    System.out.println("\nWelcome to QuickChat.");
    boolean keepRunning = true;
    
    while (keepRunning) {
        System.out.println("\nSelect a feature from the numeric menu:");
        System.out.println("1)Send / Process Message");
        System.out.println("2)Display Full Sent Messages Report");
        System.out.println("3)View Longest Message Captured");
        System.out.println("4)Search for Message by ID");
        System.out.println("5)Quit");
        System.out.print("Enter choice:");
    int mainChoice = sc.nextInt();
    sc.nextLine();
// Scanner for the buffer bug
if (mainChoice == 1){
        System.out.print("How many messages do you wish to enter?");
    int totalMessagesToEnter = sc.nextInt();
    sc.nextLine();
// Another buffering bug
    int messagesProcessedSoFar = 0;
 while (messagesProcessedSoFar < totalMessagesToEnter){
        System.out.println("\n--- Composing Message" + (messagesProcessedSoFar + 1) + "---");
        //prompt for message ID
        System.out.print("Enter Message ID (Max 10 characters); ");
        String msgID = sc.nextLine();
        if (!messageManager.checkMessageID(msgID)){
            System.out.println("Invalid Message ID length. Let's retry this entry.");
            continue;
        }
//  Checking Recipient Cell
        System.out.print("Enter recipient cell number: ");
    String recipient = sc.nextLine();
    String cellValidationMessage = messageManager.checkRecipientCell(recipient);
        System.out.println(cellValidationMessage);
if (cellValidationMessage.contains("incorrectly formatted")){
        System.out.println("Cell phone number is incorrectly formatted.Let's retry this entry.");
 continue;
            }
//Validation of the length of the message
        System.out.print("Enter Message text(Max 250 characters): ");
    String textPayload = sc.nextLine();
if (textPayload.length() > 250){
        System.out.println("Message exceeds 250 characters; please reduce the size.");
continue;
            }
else {
        System.out.println("Message ready to send.");
     }
//Action menu options
        System.out.println("\nChoose action option (1 - Send, 2-Disregard, 3-Store): ");
    int actionChoice =  sc.nextInt();
    sc.nextLine();
    String actionResultMessage = messageManager.sendMessage(actionChoice);
        System.out.println(actionResultMessage);
if (actionChoice == 1){
    totalSuccessfullySent++;
      }
// Generating tracking code
    String autoGenID = "00000000";
    String calculatedHash = messageManager.createMessageHash(autoGenID, totalSuccessfullySent, textPayload);
systemReportSummary += "\nMessage ID generated: <" + autoGenID + ">\n" + "Message Hash:" + calculatedHash + "\n" + "Recipient: " + recipient + "\n" + "Delivery Status: " + actionResultMessage + "\n" + "------------------------------";
messagesProcessedSoFar++;
    }
// Display all cumulative summary outputs
        System.out.println("\n======BATCH SUMMARY REPORT ======");
        System.out.println(messageManager.printMessages(systemReportSummary));
        System.out.println("Total successfully sent: " + messageManager.returnTotalMessages(totalSuccessfullySent));
        }
else if (mainChoice == 2) {
        System.out.println("Coming Soon.");
                          }
else if (mainChoice == 3) {
        System.out.println("Exiting Application. Goodbye!");
keepRunning = false;
                          }
else {
        System.out.println("Invalid numeric choice configuration.");
     }
    }
        }
else {
        System.out.println("Access Denied: Invalid Credentials apttern matching failed.");
}     
        }
        else 
        {
    System.out.println("Please restart and ensure your formatting is correct.");
    {
        sc.close();
    }
        }
    }
}

   
