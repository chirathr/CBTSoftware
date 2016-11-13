package cbtsoftware;

import Questions.AddQuestions;
import Questions.Question;
import Registration.Registration;
import Test.TakeTest;
import User.Student;
import User.Teacher;
import java.util.Scanner;

/**
 *
 * @author chirath
 */
public class CBTSoftware {
    Scanner scanner = null;
    Student student = null;
    Teacher teacher = null;
    Registration registration = null;
    char userType;
    
    public void logInUser() {
        registration.loginUser();
        userType = registration.teacherOrStudent();
        if(userType == 'T')
            teacher = registration.getTeacher();
        else if(userType == 'S')
            student = registration.getStudent();
        else 
            this.logInUser();
    }
    
    CBTSoftware() {
        scanner = new Scanner(System.in);
    }
    
    public int doStudent() {
        System.out.println("----------------Student Menu--------------");
        System.out.println("1. Attent examination");
        System.out.println("2. Logout");
        System.out.println("3. Exit");
        int ch = scanner.nextInt();
        switch(ch) {
            case 1:   
                
                TakeTest t = new TakeTest();
                t.setTest(1, 8, 1);
                float marks = t.StartTest();
                System.out.println(marks);
                break;
            case 2:
                registration.logout();
                break;
            case 3:
                return 0;
            default: 
                System.out.println("Wrong Choice, try again.");
                this.doStudent();
        }
        return 1;
    }
    
    public int doTeacher() {
        System.out.println("----------------Faculty Menu--------------");
        System.out.println("1. Add a student");
        System.out.println("2. Add questions");
        System.out.println("3. Logout");
        System.out.println("4. Exit");
        int ch = scanner.nextInt();
        switch(ch) {
            case 1:
                break;
            case 2:
                AddQuestions aq = new AddQuestions();
                aq.addQuestions();
                break;
            case 3:
                registration.logout();
                break;
            case 4:
                return 0;
            default: 
                System.out.println("Wrong Choice, try again.");
                this.doTeacher();
        }
        return 1;    
    }

    public static void main(String[] args) {
        CBTSoftware cbt = new CBTSoftware();
        cbt.registration = new Registration();
        
        int run = 1;
        while(run == 1) {
            if(!cbt.registration.loggedIn()) {
                cbt.logInUser();
            }
            if(cbt.userType == 'S')
                run = cbt.doStudent();
            else 
                run = cbt.doTeacher();
        }
    } 
    
}