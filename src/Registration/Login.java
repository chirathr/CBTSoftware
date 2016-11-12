/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Registration;


import Dbconnection.PSQLConnect;
import java.util.Scanner;
/**
 *
 * @author chirath
 */
public class Login {
    
    private void studentLogin() {
        
    }

    private void teacherLogin() {
        
    }
      
    
    public int login() {
        
        PSQLConnect psql = new PSQLConnect();
        psql.connectPSQL();
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("1 for student");
        System.out.println("2 for teacher");
        System.out.println("3 to go back");
        int type = scanner.nextInt();
        if(type == 1) {
            this.studentLogin();
        }
        else if(type == 2) {
            this.teacherLogin();
        }
        else if(type == 3) 
            return 0;
        else {
            System.out.println("Wrong option, Enter again !");
            this.login();
        }
        return 1;
    }
        
}
