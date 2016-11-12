/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Registration;

import java.util.Scanner;

/**
 *
 * @author chirath
 */
public class Registration {
    public int loginOrRegister() {
        
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        
        System.out.println("----------------Login or Register--------------");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
        
        choice = scanner.nextInt();
        if(choice == 1) {
            Login login = new Login();
            return 1;
        }
        else if(choice == 2) {
            Register register = new Register();
            choice = register.register();
            System.out.println("Registration sucessful, you are logged in");
            if(choice == 0)
                return loginOrRegister();
            return 1;
        }
        else if(choice == 3)
            return 0;
        else {
            System.out.println("Wrong choice, Enter again...");
            this.loginOrRegister();
        }
        return 1;
    }
}
