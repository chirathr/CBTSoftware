/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cbtsoftware;
import java.util.*;
import java.io.*;
import Dbconnection.PSQLConnect;
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
        PSQLConnect psql = new PSQLConnect();
        psql.connectPSQL();
        try {
            psql.runPSQLQuery("Select * from users;");
        } catch (SQLException ex) {
            Logger.getLogger(CBTSoftware.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
