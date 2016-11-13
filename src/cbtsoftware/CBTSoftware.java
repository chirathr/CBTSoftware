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
        registration.login();
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
    
    public void addStudents() {
        char ch = 'y';
        while(ch == 'y' || ch =='Y') {
            registration.registerStudent();
            System.out.println("Do you want to enter another student? (y or n)");
            String s = scanner.nextLine();
            ch = scanner.nextLine().charAt(0);
        }
    }
    
    public int doTeacher() {
        System.out.println("----------------Faculty Menu--------------");
        System.out.println("1. Add a student");
        System.out.println("2. Add questions");
        System.out.println("3. Add faculty");
        System.out.println("4. Add Test");
        System.out.println("5. Logout");
        System.out.println("6. Exit");
        int ch = scanner.nextInt();
        switch(ch) {
            case 1:
                this.addStudents();
                break;
            case 2:
                AddQuestions aq = new AddQuestions();
                aq.addQuestions(teacher.getId());
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                registration.logout();
                break;
            case 6:
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