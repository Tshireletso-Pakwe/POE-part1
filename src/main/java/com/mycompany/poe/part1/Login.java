package com.mycompany.poe.part1;

public class Login {
   private String username;
   private String password;
   private String firstName;
   private String lastName;
   private String CellPhone;
     public boolean
    checkUserName(String user) {
        return user.contains("_")
         && user.length() <=5;
    }    
//    i will be using regular expresssions (Regex) to check the complexity/specifications for the passwords.
    public boolean
   checkPasswordComplexity(String pass){
       String pattern= "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!]).{8,}$";
          return pass.matches(pattern);
   }
   
   public boolean 
           checkCellPhoneNumber(String number)
    {
        return number.matches("^\\=27\\d{9}$");
    }
                   
//   i used the if-statement to make sure that the user's input is correct and meets the conditions/requirements needed. 
   public String 
        registerUser(String user,String pass, String fName, String lName, String phone)
        {
            if(!checkUserName(user))
            {
    return "Username is invalid,please ensure that your username contains an underscore and is not longer than 5 characters in length.";
            }
            if(!checkPasswordComplexity(pass))
            {
    return "Password is invalid,please ensure that the passwor contains at least 8 characters,a capital letter, a number and a special character.";
            }  
            if(!checkCellPhoneNumber(phone))
            {
    return "Cell phone number is invalid. Please use correct format +27XXXXXXXXX.";
            }
                this.username = user;
                this.password = pass;
                this.firstName = fName;
                this.lastName = lName;
                this.CellPhone = phone;
    return "Username and password successfully captured.";               
}
//   why i created the attempt user & password info was to use it as a security check to check if it matches the original login info(this.username) stored in the memory.
        public boolean
    loginUser(String attemptUser, String attemptPass)  
    {
        return this.username !=null &&
                attemptUser.equals(this.username)
                    &&
                attemptPass.equals(this.password);
    }
        public String
                returnLoginStatus(boolean 
                        isLoggedIn){
                    if (isLoggedIn){
                return "Welcome" + firstName+ ","+ lastName+ "it is great to see you again.";
                    }
                    else{
                return"Username or password incorrect,please try again.";
                    }
                }
}