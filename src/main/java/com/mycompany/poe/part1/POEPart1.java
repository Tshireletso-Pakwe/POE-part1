package com.mycompany.poe.part1;

import java.util.Scanner;
public class POEPart1 {

    public static void main(String[] args) {
      Scanner sc= new Scanner(System.in);
      
      Login loginLogic = new Login();
      
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
        
   String
           registrationMessage =
           loginLogic.registerUser(username, password,firstName, lastName,phone);
   
   System.out.println("\nStatus:"+ registrationMessage);
        if
                (registrationMessage.equals("User registered successfully"))
        {
            System.out.print("Enter Username: ");
            String loginUser =
                    sc.nextLine();
            System.out.print("Enter Password: ");
            String loginPass =
                    sc.nextLine();
            
    boolean loginSuccess
            =loginLogic.loginUser(loginUser, loginPass);
    System.out.println(loginLogic.returnLoginStatus(loginSuccess));
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
