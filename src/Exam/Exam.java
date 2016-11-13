/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exam;

import Dbconnection.PSQLConnect;
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
        String query = "insert into examination values(" + id + ", " + teacherId + ");";
        psql.connectPSQL();
        psql.insertQuery(query);
    }
    
    public void addQuestion() {
        try {
            List<List<String>> result;
            PSQLConnect psql = new PSQLConnect();
            String query = "select max(id) from question;";
            psql.connectPSQL();
            result = psql.runPSQLQuery(query);
            int startId = Integer.parseInt(result.get(0).get(0) + 1);
            
            question.getQuestion();
            
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
    
    public void showQuestions() {
        try {
            question = new Question();
            
            List<List<String>> result;
            PSQLConnect psql = new PSQLConnect();
            String query = "select max(id) from question;";
            psql.connectPSQL();
            result = psql.runPSQLQuery(query);
            int endId = Integer.parseInt(result.get(0).get(0));
            
            System.out.println("--------------------All question-------------------");
            
            for(int i = 1; i <= endId; ++i) {
                question.load(i);
                question.print(i);
            }
            
            System.out.println("Enter number of question");
            int n = scanner.nextInt();
            System.out.println("Enter question number for exam in order");
            for(int i = 0; i < n; ++i) {
                int number = scanner.nextInt();
                saveExamination(number);
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Exam.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void selectQuestions() {
        String temp = scanner.nextLine();
        Question question = new Question();
        System.out.print("\n----------Select Questions------------");
        System.out.print("\n1. Add new questions");
        System.out.print("\n2. Select from existing questions");
        int choice = scanner.nextInt();
        
        if(choice == 1) {
            this.addQuestion();
        }
        else if(choice == 2) {
            this.showQuestions();
        }
        else {
            System.out.print("\nWrong choice, enter again");
            this.selectQuestions();
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
        this.selectQuestions();
        String temp = scanner.nextLine();
        System.out.print("Do you want to add another exam?(y or n)");
        char ch = scanner.nextLine().charAt(0);
        if(ch=='y'||ch=='Y')
            this.addExam(tId);
    }
}
