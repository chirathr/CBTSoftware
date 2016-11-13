/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Registration;

import java.util.*;
import java.io.*;
import User.Student;
import User.Teacher;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author chirath
 */
public class Registration {
    Scanner scanner = null;
    Student student = null;
    Teacher teacher = null;
    
    public void studentRegister() {
        /*get student data : String name, String username, 
        String password, String email, int semster */
        
        Scanner s = new Scanner(System.in);
	String name="";
	String uname="";
        String username;
	String password="";
	String email="";
	int semester;
        int flag=0;
        
        System.out.println("------------Student registration------------");
        
        System.out.print("Enter Your Name : ");
        name = s.nextLine();
        
        System.out.print("Enter your username:-");
        username = s.nextLine();
        
        System.out.print("Enter a password : ");
        password = s.nextLine();
        
        System.out.print("Enter your email address : ");
        flag=0;
        while(flag == 0) {
            email = s.nextLine();
            Pattern pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
            Matcher mat = pattern.matcher(email);
            if(mat.matches())
                flag=1;
            else
                System.out.println("Not a valid email address, Enter again");
        }
                
        System.out.print("Enter your semester : ");
        semester = s.nextInt();
        
        student = new Student();
        if(!student.save(name, username, password, email, semester)) {
            System.out.println();
            System.out.println("Enter again !!");
            this.studentRegister();
        }
    }
    
    public void teacherRegister() {
        Scanner s = new Scanner(System.in);
	String name="";
	String uname="";
        String username;
	String password="";
	String email="";
        String department="";
        
        int flag=0;
        
        System.out.println("-------------Teacher registration---------------");
        
        System.out.print("Enter Your Name : ");
        name = s.nextLine();
        
        System.out.print("Enter your username : ");
        username = s.nextLine();
        
        System.out.print("Enter a password : ");
        password = s.nextLine();
        
        System.out.print("Enter your email address : ");
        flag=0;
        while(flag == 0) {
            email = s.nextLine();
            Pattern pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
            Matcher mat = pattern.matcher(email);
            if(mat.matches())
                flag=1;
            else
                System.out.println("Not a valid email address, Enter again");
        }
                
        System.out.print("Enter your department : ");
        department = s.nextLine();
        
        teacher = new Teacher();
        if(!teacher.save(name, username, password, email, department)) {
            System.out.println();
            System.out.println("Enter again !!");
            this.teacherRegister();
        }
    }
    
    public int register() {
        scanner = new Scanner(System.in);
        System.out.println("----------------Register--------------");
        System.out.println("1 for student");
        System.out.println("2 for teacher");
        System.out.println("3 to go back");
        int type = scanner.nextInt();
        if(type == 1) {
            this.studentRegister();
        }
        else if(type == 2) {
            this.teacherRegister();
        }
        else if(type == 3) 
            return 0;
        else {
            System.out.println("Wrong option, Enter again !");
            this.register();
        }
        return 1;
    }
    
    public int studentLogin() {
        String username = scanner.nextLine();
        System.out.println("---------Enter details--------");
        System.out.print("Username : ");
        username = scanner.nextLine();
        System.out.print("Password : ");
        String password = scanner.nextLine();
        student = new Student();
        if(student.login(username, password))
            return 1;
        student = null;
        return 0;
    } 
    public int teacherLogin() {
        String username = scanner.nextLine();
        System.out.println("---------Enter details--------");
        System.out.print("Username : ");
        username = scanner.nextLine();
        System.out.print("Password : ");
        String password = scanner.nextLine();
        teacher = new Teacher();
        if(teacher.login(username, password))
            return 1;
        teacher = null;
        return 0;
    } 
    
    public int login() {
        scanner = new Scanner(System.in);
        System.out.println("----------------Login--------------");
        System.out.println("1 for student");
        System.out.println("2 for teacher");
        System.out.println("3 to go back");
        int type = scanner.nextInt();
        if(type == 1) {
            if(this.studentLogin() == 0) {
                System.out.println("Wrong username or password! Enter to continue");
                this.studentLogin();
            }
            return 1;
        }
        else if(type == 2) {
            if(this.teacherLogin() == 0) {
                System.out.println("Wrong username or password! Enter to continue");
                this.teacherLogin();
            }
            return 1;
        }
        else if(type == 3) 
            return 0;
        else {
            System.out.println("Wrong option, Enter again !");
            this.register();
        }
        return 1;
    }
    
    public Student getStudent() {
        return student;
    }
    public Teacher getTeacher() {
        return teacher;
    }
    
    public char teacherOrStudent() {
        if(teacher == null && student == null)
            return 'N';
        if(teacher == null)
            return 'S';
        return 'T';
    }
    
    public void logout() {
        teacher = null;
        student = null;
    }
    
    public boolean loggedIn() {
        if(teacher != null || student != null)
            return true;
        return false;
    }
    
    public void loginUser() {
        System.out.println("----------------Login or Register--------------");
        System.out.println("1 to login");
        System.out.println("2 signUp");
        System.out.println("3 to exit");
        scanner = new Scanner(System.in);
        int type = scanner.nextInt();
        if(type == 1) {
            type = this.login();
        }
        else if(type == 2) {
            type = this.register();
        }
        else if(type == 3) 
            System.exit(0);
        else {
            System.out.println("Wrong option, Enter again !");
            this.register();
        }
    }
}
