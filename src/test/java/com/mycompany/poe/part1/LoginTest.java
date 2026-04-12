
package com.mycompany.poe.part1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


/**
 *
 * @author Tshireletso
 */
public class LoginTest {
    
    public LoginTest() {
    }

    /**
     * Test of checkUserName method, of class Login.
     */
    @org.junit.jupiter.api.Test
    public void testCheckUserName() {
        System.out.println("checkUserName-Valid Case");
        String user = "kyl_1";
//  It has an underscore and is <=5 characters.
        Login instance = new Login();
        boolean expResult = true;
        boolean result = instance.checkUserName(user);
        assertEquals(expResult, result);
    }

    /**
     * Test of checkPasswordComplexity method, of class Login.
     */
    @org.junit.jupiter.api.Test
    public void testCheckPasswordComplexity() {
        System.out.println("checkPasswordComplexity");
        String pass = "Ch@llenge2026";
        Login instance = new Login();
        boolean expResult = true;
        boolean result = instance.checkPasswordComplexity(pass);
        assertEquals(expResult, result);
    }

    /**
     * Test of registerUser method, of class Login.
     */
    
    @org.junit.jupiter.api.Test
    public void testRegisterUser() {
        System.out.println("registerUser");
        String user = "kyl_1";
        String pass = "Ch@llenge2026";
        String fName = "Kyle";
        String lName = "Smith";
        Login instance = new Login();
        String expResult = "";
        String result = instance.registerUser("kyl_1", "Ch@llenge2026", "Kyle", "Smith");
        assertEquals("Username and password successfully captured.", result);
    }
      
    

    /**
     * Test of loginUser method, of class Login.
     */

    @org.junit.jupiter.api.Test
    public void testLoginUser() {
        Login instance= new Login();
//  First time a user is registering.
    instance.registerUser("kyl_1", "Ch@llenge2026","Kyle", "Smith");
      
        boolean result = instance.loginUser("kyl_1","Ch@llenge2026");
        assertTrue(result);
        
    }

    /**
     * Test of returnLoginStatus method, of class Login.
     */
    
    @org.junit.jupiter.api.Test
    public void testReturnLoginStatus() {
        System.out.println("returnLoginStatus");
        Login instance = new Login();
        instance.registerUser("kyl_1", "Ch@llenge2026", "Kyle", "Smith");
      boolean isLoggedIn = instance.loginUser("kyl_1", "Ch@llenge2026");
        String result = instance.returnLoginStatus(isLoggedIn);
        assertEquals("Welcome Kyle,Smith it is great to see you again.", result);
       
    }
   
}
