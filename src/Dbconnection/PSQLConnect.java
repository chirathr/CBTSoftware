/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dbconnection;

import java.sql.Array;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chirath
 */
public class PSQLConnect {
    Connection connection = null;
    public void connectPSQL() {
        try {

            Class.forName("org.postgresql.Driver");

	} catch (ClassNotFoundException e) {

            System.out.println("PostgreSQL JDBC Driver not found!!");
            e.printStackTrace();
            return;
	}
        
        

	try {
            connection = DriverManager.
                    getConnection(
                            "jdbc:postgresql://127.0.0.1:5432/postgres",
                            "postgres",
                            "postgres"
                    );

	} catch (SQLException e) {

            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;

	}

	if (connection != null) {
            System.out.println("Connection sucessful!");
	} else {
            System.out.println("Failed to make connection to Database!");
	}
    }
    
    public  List<List<String>> runPSQLQuery(String query) throws SQLException {
        Statement st = connection.createStatement();
        ResultSet rs = null;
        try {
            rs = st.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(PSQLConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<List<String>> result = new ArrayList<>();  // List of list, one per row
        int numcols = rs.getMetaData().getColumnCount();
        while (rs.next()) {
            List<String> row = new ArrayList<>(numcols); // new list per row
            int i = 1;
            while (i <= numcols) {  // don't skip the last column, use <=
                row.add(rs.getString(i++));
            }
            result.add(row); // add it to the result
        }
        
        rs.close();
        st.close();
        return result;
    }
    
}
