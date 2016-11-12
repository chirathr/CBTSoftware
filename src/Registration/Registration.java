/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Registration;

/**
 *
 * @author chirath
 */
public class Registration {
    public void loginOrRegister() {
        int choice = 0;
        
        System.out.println("----------------Login or Register--------------");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
        
        if(choice == 1) {
            Login login = new Login();
            
        }
        else if(choice == 2) {
            Register register = new Register();
            register.register();
            System.out.println("Registration sucessful, you are logged in");
        }
        else if(choice == 3)
            return;
        else {
            System.out.println("Wrong choice, Enter again...");
            this.loginOrRegister();
        }
    }
}
