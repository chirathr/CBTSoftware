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


public class Student extends Person {
    int semster;

    public Student(int id, String name, String username, 
            String password, String email, int semster) {
        super(id, name, username, password, email);
        this.semster = semster;
    }


    public Student() {
        super();
    }

    public int getSemster() {
        return semster;
    }

    public void setSemster(int semster) {
        this.semster = semster;
    }
    
    
    
    public boolean login(String username, String password) {
        List<List<String>> result = null;
        PSQLConnect psql = new PSQLConnect();
        psql.connectPSQL();
        try {
            String query = "select * from student where username = '" 
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
        psql.connectPSQL();
        try {
            String query = "select * from student where username = '" 
                    + username + "';";
            result = psql.runPSQLQuery(query);
            if(result.size() == 1) {
                System.out.println("username already exists!");
                return false;
            }
            query = "select * from student where email = '" + email + "';";
            result = psql.runPSQLQuery(query);
            if(result.size() == 1) {
                System.out.println("email already exists!");
                return false;
            }
            query = "select max(id) from student;";
            result = psql.runPSQLQuery(query);
            int nextId = Integer.parseInt(result.get(0).get(0)) + 1;
            query = "insert into student values(" + nextId + ", '" + 
                    name + "', '" + username + "', '" + password +
                    "', '" + email + "', " + semster + ");";
            System.out.println("User created successfully!");
        } catch (SQLException ex) {
            Logger.getLogger(
                    Student.class.getName()).log(Level.SEVERE, 
                            null, ex);
        }
        return true;
    }
    
}
