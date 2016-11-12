package cbtsoftware;

import Registration.Registration;
import User.Student;
import User.Teacher;

/**
 *
 * @author chirath
 */
public class CBTSoftware {
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

    public static void main(String[] args) {
        CBTSoftware cbt = new CBTSoftware();
        cbt.logInUser();
    }  
}