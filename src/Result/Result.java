/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Result;

import Dbconnection.PSQLConnect;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author chirath
 */
public class Result {
    /*studentId numeric(10) references student,
    examName varchar(100),
    examId numeric(10),
    marks float,
    total float */
    PSQLConnect psql = null;
    
    int studentId, examId;
    String examName;
    float marks, total;
    
    public void setResult(int sId, int eId, String examName, float marks, float total) {
        this.studentId = sId;
        this.examId = eId;
        this.examName = examName;
        this.marks = marks;
        this.total = total;
    }
    
    public void save() {
        PSQLConnect psql = new PSQLConnect();
        String query = "insert into result values(" + studentId + ", '" + 
                examName + "', " + examId + ", " + marks + ", " + total + ");";
        psql.connectPSQL();
        psql.insertQuery(query);
    }
     
    public void displayAll(int studentId) {
        String query = "select * from result where studentid = "+ studentId +";";
        psql = new PSQLConnect();
        psql.connectPSQL();
        List<List<String>> result;
        try {
            result = psql.runPSQLQuery(query);
            for(int i =0 ; i < result.size(); ++i) {
                System.out.println(result.get(i).get(1) + "\t" + result.get(i).get(3) + "/" + result.get(i).get(4));
            }
        } catch (SQLException ex) {
            System.out.println("Question not found in DB");
        }
        String s = new Scanner(System.in).nextLine();
    }
}
