/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Questions;

import Dbconnection.PSQLConnect;
import User.Student;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chirath
 */
public class Question {
    List<List<String>> result = null;
    PSQLConnect psql = null;
    int id, type, numberOfChoices, mcqAnswer;
    String question;
    String[] options = new String[5];
    boolean trueOrFalseAnswer = true;
    String fillInTheBlankAnswer;

    //setters and getters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getNumberOfChoices() {
        return numberOfChoices;
    }

    public void setNumberOfChoices(int numberOfChoices) {
        this.numberOfChoices = numberOfChoices;
    }

    public int getMcqAnswer() {
        return mcqAnswer;
    }

    public void setMcqAnswer(int mcqAnswer) {
        this.mcqAnswer = mcqAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public boolean isTrueOrFalseAnswer() {
        return trueOrFalseAnswer;
    }

    public void setTrueOrFalseAnswer(boolean trueOrFalseAnswer) {
        this.trueOrFalseAnswer = trueOrFalseAnswer;
    }

    public String getFillInTheBlankAnswer() {
        return fillInTheBlankAnswer;
    }

    public void setFillInTheBlankAnswer(String fillInTheBlankAnswer) {
        this.fillInTheBlankAnswer = fillInTheBlankAnswer;
    }
    
    // Constructors

    public void setMCQSingle(String q, int nofc, String options[], int mcqAnswer) {
        // mcq(single answer)
        this.type = 1;
        this.question = q;
        this.numberOfChoices = nofc;
        this.options = options;
        this.mcqAnswer= mcqAnswer;
    }
    
    public void setMCQMultiple(String q, int nofc, String options[]) {
        //mcq(multiple answers)
        this.type = 2;
        this.question = q;
        this.numberOfChoices = nofc;
        this.options = options;
    }
    public void setTrueOrFalse(String q, boolean torF) {
        // True or False
        this.type = 3;
        this.question = q;
        this.trueOrFalseAnswer = torF;
    }
    public void setFillInTheBlank(String q, String ans) {
        // Fill in the blanks
        this.type = 4;
        this.question = q;
        this.fillInTheBlankAnswer = ans;
    }
    
    String getInsertQuestionQuery(int type, int numberOfChoices) throws SQLException {
        String query = "select max(id) from question;";
        psql.connectPSQL();
        result = psql.runPSQLQuery(query);
        int nextId = 0; 
        nextId = Integer.parseInt(result.get(0).get(0)) + 1;
        int tOrF;
        if(trueOrFalseAnswer)
            tOrF = 1;
        else
            tOrF = 0;
            
        return "insert into question values (" + nextId +", " + type + ", " + 
                numberOfChoices +", '" + options[0] + "', '" + options[1] +
                "', '" + options[2] + "', '" + options[3] + "', '" + 
                options[4] + "', '" + question + "', " + mcqAnswer + ", " + tOrF +", '" + 
                fillInTheBlankAnswer +"');";
    }
    
    public boolean save() {
        
        psql = new PSQLConnect();
        
        String query;
        try {
            query = getInsertQuestionQuery(type, numberOfChoices);
        } catch (SQLException ex) {
            return false;
        }
            
        psql.connectPSQL();
        psql.insertQuery(query);
        System.out.println("Question save sucessfull!");
        return true;
    }
    
    public void load(int id) {
        String query = "select max(id) from question where id = "+ id +";";
        psql.connectPSQL();
        try {
            result = psql.runPSQLQuery(query);
            type = Integer.parseInt(result.get(0).get(1));
            numberOfChoices = Integer.parseInt(result.get(0).get(2));
            
        } catch (SQLException ex) {
            System.out.println("Question not found in DB");
        }
    }
}
