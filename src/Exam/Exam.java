/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exam;

import Dbconnection.PSQLConnect;
import Questions.AddQuestions;
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
public class Exam {
    Question question = null;
    Scanner scanner = null;
    int id, teacherId;
    int time;
    String examName, dateOfExam;
    float totalMark;
    
    
    public void save() {
        try {
            List<List<String>> result;
            PSQLConnect psql = new PSQLConnect();
            String query = "select max(id) from exam;";
            psql.connectPSQL();
            result = psql.runPSQLQuery(query);
            id = Integer.parseInt(result.get(0).get(0)) + 1;
            query = "insert into exam values(" + id + ", '" + examName + 
                    "', '" + dateOfExam + "'," + teacherId + ", " + 
                    time + ", " + totalMark + ");";
            psql.connectPSQL();
            psql.insertQuery(query);
        } catch (SQLException ex) {
            System.out.println("PSQL Server error");
        }
    }
    
    public void saveExamination(int qId) {
        List<List<String>> result;
        PSQLConnect psql = new PSQLConnect();
        String query = "insert into examination values(" + qId + ", " + teacherId + ");";
        psql.connectPSQL();
        psql.insertQuery(query);
    }
    
    public void addQuestion(int tId) {
        try {
            List<List<String>> result;
            PSQLConnect psql = new PSQLConnect();
            String query = "select max(id) from question;";
            psql.connectPSQL();
            result = psql.runPSQLQuery(query);
            int startId = Integer.parseInt(result.get(0).get(0) + 1);
            String s = scanner.nextLine();
            System.out.println("How many Questions?");
            int n = scanner.nextInt();
            AddQuestions addQ = new AddQuestions();
            for(int i=0; i < n; ++i)
                addQ.addQuestions(tId);
            query = "select max(id) from question;";
            psql.connectPSQL();
            result = psql.runPSQLQuery(query);
            int endId = Integer.parseInt(result.get(0).get(0));
            
            for(int i = startId; i <= endId; ++i) {
                this.saveExamination(i);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Exam.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void showQuestions(int tId) {
        try {
            question = new Question();
            
            List<List<String>> result;
            PSQLConnect psql = new PSQLConnect();
            String query = "select * from question where teacherId = " + tId + ";";
            psql.connectPSQL();
            result = psql.runPSQLQuery(query);
            int endId = Integer.parseInt(result.get(0).get(0));
            
            System.out.println("--------------------All question-------------------");
            
            for(int i = 0; i < result.size(); ++i) {
                question.load(Integer.parseInt(result.get(i).get(0)));
                question.print(i+1);
            }
            
            System.out.println("Enter number of question");
            int n = scanner.nextInt();
            System.out.println("Enter question number for exam in order");
            for(int i = 0; i < n; ++i) {
                int number = scanner.nextInt();
                this.saveExamination(number);
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Exam.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void selectQuestions(int tId) {
        String temp = scanner.nextLine();
        Question question = new Question();
        System.out.print("\n----------Select Questions------------");
        System.out.print("\n1. Add new questions");
        System.out.print("\n2. Select from existing questions");
        int choice = scanner.nextInt();
        
        if(choice == 1) {
            this.addQuestion(tId);
        }
        else if(choice == 2) {
            this.showQuestions(tId);
        }
        else {
            System.out.print("\nWrong choice, enter again");
            this.selectQuestions(tId);
        }
    }
    
    public void addExam(int tId) {
        scanner = new Scanner(System.in);
        question = new Question();
        
        teacherId = tId;
        System.out.print("Enter exam name : ");
        examName = scanner.nextLine();
        System.out.print("Enter date of exam : ");
        dateOfExam = scanner.nextLine();
        System.out.print("Enter duration : ");
        time = scanner.nextInt();
        this.save();
        this.selectQuestions(tId);
        String temp = scanner.nextLine();
        System.out.print("Do you want to add another exam?(y or n)");
        char ch = scanner.nextLine().charAt(0);
        if(ch=='y'||ch=='Y')
            this.addExam(tId);
    }
}
