package Result;

import Dbconnection.PSQLConnect;
import java.util.List;
import java.util.Scanner;

public class Result {
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
    
    public void displayAll() {
        String query = "select * from result;";
        psql = new PSQLConnect();
        psql.connectPSQL();
        List<List<String>> result;
        result = psql.runPSQLQuery(query);
        for(int i =0 ; i < result.size(); ++i) {
            query = "select * from student where id = " + result.get(i).get(0) + ";";
            psql = new PSQLConnect();
            psql.connectPSQL();
            List<List<String>> rs;
            rs = psql.runPSQLQuery(query);
            System.out.println(rs.get(0).get(1) + "\t" + result.get(i).get(1) + "\t" + result.get(i).get(3) + "/" + result.get(i).get(4));
        }
        String s = new Scanner(System.in).nextLine();
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
        result = psql.runPSQLQuery(query);
        for(int i =0 ; i < result.size(); ++i) {
            System.out.println(result.get(i).get(1) + "\t" + result.get(i).get(3) + "/" + result.get(i).get(4));
        }
        String s = new Scanner(System.in).nextLine();
    }
}
