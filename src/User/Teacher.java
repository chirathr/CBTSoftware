/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

/**
 *
 * @author chirath
 */

public class Teacher extends Person {
    String department; 

    public Teacher(String name, String username, String password, String email, String dep) {
        super(name, username, password, email);
        this.department = dep;
    }

    public Teacher() {
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    
    
    
}
