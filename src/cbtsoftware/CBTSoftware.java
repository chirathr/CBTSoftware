package cbtsoftware;

import Questions.AddQuestions;
import Questions.Question;
import Registration.Registration;
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
        registration = new Registration();
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
    
    public void doStudent() {
        System.out.println("----------------Student Menu--------------");
        System.out.println("1 for student");
        System.out.println("2 for teacher");
        System.out.println("3 to go back");
        int choice = scanner.nextInt();
    }
    
    public void doTeacher() {
        System.out.println("----------------Staff Menu--------------");
        System.out.println("1 for student");
        System.out.println("2 to add question");
        System.out.println("3 to go back");
        int ch = scanner.nextInt();
        switch(ch) {
            case 1:
                break;
            case 2:
                AddQuestions aq = new AddQuestions();
                aq.addQuestions();
        }
        int choice = scanner.nextInt();
    }

    public static void main(String[] args) {
        CBTSoftware cbt = new CBTSoftware();
        cbt.logInUser();
        if(cbt.userType == 'S')
            cbt.doStudent();
        else 
            cbt.doTeacher();

        Question q = new Question();
    } 
    
}