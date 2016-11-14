/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Dbconnection.PSQLConnect;
import Exam.Exam;
import Questions.Question;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chirath
 */
public class TakeTest {
    Question question = null;
    Exam exam = null;
    PSQLConnect psql = null;
    List<List<String>> result = null;
    Scanner scanner = new Scanner(System.in); 
    int startId, endId;
    float time;

    public int getStartId() {
        return startId;
    }

    public void setStartId(int startId) {
        this.startId = startId;
    }

    public int getEndId() {
        return endId;
    }

    public void setEndId(int endId) {
        this.endId = endId;
    }

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
    }
    
    public void setTest(int startId, int endId, int time) {
        this.startId = startId;
        this.endId = endId;
        this.time = time;
    }
    
    
    public int selectExam() {
        exam = new Exam();
        psql = new PSQLConnect();
        int selectedId = 0;
        System.out.print("-----------------------Online Exam----------------------");
        try {
            String query = "select * from exam;";
            psql.connectPSQL();
            result = psql.runPSQLQuery(query);
            for(int i = 0; i < result.size(); ++i) {
                System.out.print(result.get(i).get(0) + ". " + 
                        result.get(i).get(1) + "\t" + result.get(i).get(2) + 
                        "\t" + result.get(i).get(4));
            }
            System.out.print("Enter your choice : ");
            selectedId = scanner.nextInt();
            
        } catch (SQLException ex) {
           System.out.println("Error in Db connect");
        }
        return selectedId;
    }

    public float StartTest() {
        question = new Question();
        float marks = 0;
        int examId = this.selectExam();
        System.out.println("----------------------Examination----------------------");
        long startTime = (System.nanoTime() / 1000000000)/60;
        try {
            String query = "select * from examination where exam id = " + examId + ";";
            psql.connectPSQL();
            result = psql.runPSQLQuery(query);
            for(int i = 0, j =1; i < result.size(); ++i, j++) {
                long currentTime = (System.nanoTime() / 1000000000)/60;
            System.out.print("\t\t\t\t    ");
            System.out.print((int)(time - (currentTime - startTime))/60);
            System.out.print(" hrs, ");
            System.out.print((int)(time - (currentTime - startTime))%60);
            
            System.out.print(" mins remaining\n");
            if((time - (currentTime - startTime)) < 1) {
                System.out.println("\n-----------------------------Time up---------------------------");
                break;
            }
            question.load(i);
            question.print(j);
            System.out.print("   ->");
            String ans = new Scanner(System.in).nextLine();
            marks += question.checkAnswer(ans);
            System.out.println("------------------------------------------------------------");
            }
        } catch (SQLException ex) {
           System.out.println("Error in Db connect");
        }
        return marks;
    }
}
