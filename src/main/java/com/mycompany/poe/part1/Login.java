package com.mycompany.poe.part1;
/**
 * Part 3 Registration and Authentication Engine.
 * What it does is handles account creation, validation rule checks and secure login verification.
 * @author Tshireletso
 */
public class Login {
   private String username;
   private String password;
   private String firstName;
   private String lastName;
   private String cellPhone;
     public boolean checkUserName(String user) {
       if (user == null) return false;
         return user.contains("_") && user.length() <=5;
    }    
//    i will be using regular expresssions (Regex) to check the complexity/specifications for the passwords.
    public boolean checkPasswordComplexity(String pass){
        if (pass == null) return false;
       String pattern= "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&+=!]).{8,}$";
          return pass.matches(pattern);
   }
   
   public boolean checkCellPhoneNumber(String number){
       if (number == null) return false;
        return number.matches("^\\+27\\d{9}$");
    }
                   
//   i used the if-statement to make sure that the user's input is correct and meets the conditions/requirements needed. 
   public String registerUser(String user,String pass, String fName, String lName, String phone)
        {
            if(!checkUserName(user))
            {
    return "Username is invalid,please ensure that your username contains an underscore and is not longer than 5 characters in length.";
            }
            if(!checkPasswordComplexity(pass))
            {
    return "Password is invalid,please ensure that the password contains at least 8 characters,a capital letter, a number and a special character.";
            }  
            if(!checkCellPhoneNumber(phone))
            {
    return "Cell phone number is invalid. Please use correct format +27XXXXXXXXX.";
            }
                this.username = user;
                this.password = pass;
                this.firstName = fName;
                this.lastName = lName;
                this.cellPhone = phone;
    return "Username and password successfully captured.";               
}
//   why i created the attempt user & password info was to use it as a security check to check if it matches the original login info(this.username) stored in the memory.
        public boolean loginUser(String attemptUser, String attemptPass){
        return this.username !=null && attemptUser.equals(this.username) && attemptPass.equals(this.password);
    }
        public String returnLoginStatus(boolean 
                        isLoggedIn){
                    if (isLoggedIn){
                return "Welcome" + firstName + ","+ lastName + "it is great to see you again.";
                    }
                    else{
                return"Username or password incorrect,please try again.";
        }
     }
}
