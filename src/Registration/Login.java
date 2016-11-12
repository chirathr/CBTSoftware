/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Registration;

import Dbconnection.PSQLConnect;
import User.Student;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chirath
 */
public class Login {
    
    public String[] login() {
        
        List<List<String>> result = null;
        String[] loginData = null;
        FileReader file = null;
        
        try { 
            
            PSQLConnect psql = new PSQLConnect();
            psql.connectPSQL();
            file = new FileReader("cache.data");
            BufferedReader fileReader = new BufferedReader(file);
            
            try {
                String line = fileReader.readLine();
                String[] cache = line.split(", ");
                
                try {
                    String query = "select id from teacher where username = "
                            + cache[0] + ";";
                    result = psql.runPSQLQuery(query);
                } catch (SQLException ex) {
                    Logger.getLogger(Student.class.getName()).log(Level.SEVERE,
                            null, ex);
                }
                
                if(result.size() == 1) {
                    System.out.println("Login successful");
                    return cache;
                }
            } catch (IOException ex) {
                
            }
            
        } catch (FileNotFoundException ex) {
            
            
           
        } finally {
            try {
                file.close();
            } catch (IOException ex) {
               
            }
        }
        return loginData;
    }
}
