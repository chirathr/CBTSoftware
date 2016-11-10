/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cbtsoftware;
import java.util.*;
import java.io.*;
import User.Student;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chirath
 */
public class CBTSoftware {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Student s = new Student();
        s.login("chirath", "1234");
    }  
}

/*
PSQL connection example
PSQLConnect psql = new PSQLConnect();
        List<List<String>> result = null;
        psql.connectPSQL();
        try {
            result = psql.runPSQLQuery("Select * from users;");
        } catch (SQLException ex) {
            Logger.getLogger(CBTSoftware.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(result);
*/
