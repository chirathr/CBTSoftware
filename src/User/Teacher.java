/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import Dbconnection.PSQLConnect;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    public boolean login(String username, String password) {
        List<List<String>> result = null;
        PSQLConnect psql = new PSQLConnect();
        psql.connectPSQL();
        try {
            String query = "select * from teacher where username = '" 
                    + username + "' and password = '" + password + "';";
            result = psql.runPSQLQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, 
                    null, ex);
        }
        if(result.size() == 1) {
            System.out.println("Login successful");
            return true;
        }
        return false;
    }
    public boolean save(
            String name, 
            String username, 
            String password, 
            String email, 
            int semster
        ) {
        
        List<List<String>> result = null;
        PSQLConnect psql = new PSQLConnect();
        try {
            String query = "select * from teacher where username = '" 
                    + username + "';";
            psql.connectPSQL();
            result = psql.runPSQLQuery(query);
            if(result.size() == 1) {
                System.out.println("username already exists!");
                return false;
            }
            query = "select * from teacher where email = '" + email + "';";
            psql.connectPSQL();
            result = psql.runPSQLQuery(query);
            if(result.size() == 1) {
                System.out.println("email already exists!");
                return false;
            }
            query = "select max(id) from student;";
            psql.connectPSQL();
            result = psql.runPSQLQuery(query);
            int nextId = Integer.parseInt(result.get(0).get(0)) + 1;
            query = "insert into teacher values(" + nextId + ", '" + 
                    name + "', '" + username + "', '" + password +
                    "', '" + email + "', " + department + ");";
            psql.connectPSQL();
            psql.insertQuery(query);
            System.out.println("User created successfully!");
        } catch (SQLException ex) {
            Logger.getLogger(
                    Student.class.getName()).log(Level.SEVERE, 
                            null, ex);
        }
        return true;
    }
    
}
