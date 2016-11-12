package cbtsoftware;

import Registration.Registration;

/**
 *
 * @author chirath
 */
public class CBTSoftware {

    public static void main(String[] args) {
        Registration registration = new Registration();
        registration.login();
        char t = registration.teacherOrStudent();
        System.out.println(t);
    }  
}