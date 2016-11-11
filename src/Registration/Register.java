/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Registration;

import java.util.*;
import java.io.*;
import User.Student;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author chirath
 */
public class Register {
    Scanner scanner = null;
    
    public void studentRegister() {
        /*get student data : String name, String username, 
        String password, String email, int semster */
        
        //Student student = new Student(); pass all value here in order as parameter
            
        //if(!student.save()) 
        //call studentRegister() again
        
        // make same function for 
        Scanner s = new Scanner(System.in);
	String name="";
	String uname="";
        String username;
	String password="";
	String email="";
	int semester;
        int flag=0;
        
        System.out.println("Enter Your Name : ");
        name = s.nextLine();
        
        System.out.println("Enter your username:-");
        username = s.nextLine();
        
        System.out.println("Enter a password : ");
        
        System.out.println("Enter your email address");
        flag=0;
        while(flag == 0) {
            email = s.nextLine();
            Pattern pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
            Matcher mat = pattern.matcher(email);
            if(mat.matches()){
                System.out.println("Valid email address");
                flag=1;
            }
            else
                System.out.println("Not a valid email address, Enter again");
        }
                
        System.out.println("Enter your semester");
        semester = s.nextInt();
        
        Student student = new Student();
        if(!student.save(name, username, password, email, semester)) {
            System.out.println("Enter again");
            this.studentRegister();
        }
    }
    
    public void register() {
        scanner = new Scanner(System.in);
        
        System.out.println("1 for student");
        int type = scanner.nextInt();
        if(type == 1) {
            this.studentRegister();
        }
        else {
            //get teacher data
        }
    }
}
