package cbtsoftware;

import Exam.Exam;
import Questions.AddQuestions;
import Questions.Question;
import Registration.Registration;
import Result.Result;
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
        System.out.println("2. View results");
        System.out.println("3. Logout");
        System.out.println("4. Exit");
        int ch = scanner.nextInt();
        switch(ch) {
            case 1:   
                
                TakeTest t = new TakeTest();
                t.setTest(1, 8, 10);
                t.StartTest(student.getId());
                break;
            case 2:
                System.out.println("----------------Results Menu--------------");
                Result r = new Result();
                r.displayAll(student.getId());
                String s = scanner.nextLine();
                break;
            case 3:
                registration.logout();
                break;
            case 4:
                System.exit(0);
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
                registration.teacherRegister();
                break;
            case 4:
                Exam e = new Exam();
                e.addExam(teacher.getId());
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