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

    public Student(String name, String username, 
            String password, String email, int semster) {
        super(name, username, password, email);
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
            this.id = Integer.parseInt(result.get(0).get(0));
            this.name = result.get(0).get(1);
            this.username = result.get(0).get(2);
            this.password = result.get(0).get(3);
            this.email = result.get(0).get(4);
            this.semster = Integer.parseInt(result.get(0).get(5));
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
            String query = "select * from student where username = '" 
                    + username + "';";
            psql.connectPSQL();
            result = psql.runPSQLQuery(query);
            if(result.size() == 1) {
                System.out.println("username already exists!");
                return false;
            }
            query = "select * from student where email = '" + email + "';";
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
            query = "insert into student values(" + nextId + ", '" + 
                    name + "', '" + username + "', '" + password +
                    "', '" + email + "', " + semster + ");";
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
