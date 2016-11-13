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
    int id, type, numberOfChoices, mcqAnswer, mark;
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

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
    
    // Constructors

    public void setMCQSingle(String q, int nofc, String options[], int mcqAnswer, int mark) {
        // mcq(single answer)
        this.type = 1;
        this.question = q;
        this.numberOfChoices = nofc;
        this.options = options;
        this.mcqAnswer= mcqAnswer;
        this.mark = mark;
    }
    
    public void setMCQMultiple(String q, int nofc, String options[],int mcqAnswer, int mark) {
        //mcq(multiple answers)
        this.type = 2;
        this.question = q;
        this.numberOfChoices = nofc;
        this.options = options;
        this.mark = mark;
        this.mcqAnswer = mcqAnswer;
    }
    public void setTrueOrFalse(String q, boolean torF, int mark) {
        // True or False
        this.type = 3;
        this.question = q;
        this.trueOrFalseAnswer = torF;
        this.mark = mark;
    }
    public void setFillInTheBlank(String q, String ans, int mark) {
        // Fill in the blanks
        this.type = 4;
        this.question = q;
        this.fillInTheBlankAnswer = ans;
        this.mark = mark;
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
                fillInTheBlankAnswer +"', " + mark +");";
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
        String query = "select * from question where id = "+ id +";";
        psql = new PSQLConnect();
        psql.connectPSQL();
        try {
            result = psql.runPSQLQuery(query);
            type = Integer.parseInt(result.get(0).get(1));
            numberOfChoices = Integer.parseInt(result.get(0).get(2));
            options[0] = result.get(0).get(3);
            options[1] = result.get(0).get(4);
            options[2] = result.get(0).get(5);
            options[3] = result.get(0).get(6);
            options[4] = result.get(0).get(7);
            question = result.get(0).get(8);
            mcqAnswer = Integer.parseInt(result.get(0).get(9));
            if(Integer.parseInt(result.get(0).get(10)) == 1)
                trueOrFalseAnswer = true;
            else
                trueOrFalseAnswer = false;
            fillInTheBlankAnswer = result.get(0).get(11);
            mark = Integer.parseInt(result.get(0).get(12));

        } catch (SQLException ex) {
            System.out.println("Question not found in DB");
        }
    }
    
    public void setAll() {
        //Create a function similar to above that takes all the fields except id and assign it to variables.
        // no need to use db
        //just inizialize all viables with parameters from read file
    }
    
    public void print(int number) {
        System.out.print(number + ". ");
        System.out.print(question + "    " + Integer.toString(mark) + " marks");
        if(type == 1 || type == 2) {
            for(int i = 0; i < numberOfChoices; ++i) {
                System.out.println();
                System.out.print("  ");
                System.out.print(i+1);
                System.out.print(". " + options[i]);
            }
            if(type == 1) {
                System.out.println("\n  Enter single answer(1 - " + 
                    Integer.toString(numberOfChoices) + ")");
            }
            else {
                System.out.println("\n  Enter multiple answers(1 - " + 
                    Integer.toString(numberOfChoices) + ")");
            }
        }
        else if(type == 3) {
            System.out.println("\n  T. True");
            System.out.println("  F. False");
            System.out.println("  Enter (T or F)?");
        }
        else {
            System.out.println("\n  Fill in the blanks");
        }
    }
    
    public float checkAnswer(String ans) {
        if(type == 1) {
            int answer = Integer.parseInt(ans);
            if(answer == mcqAnswer)
                return (float)mark;
            return 0;
        }
        else if(type == 2) {
            
        }
        else if( type == 3) {
            char answer = 'F';
            if(trueOrFalseAnswer) {
                answer = 'T';
            }
            if(ans.charAt(0) == answer)
                return (float)mark;
            return 0;
        }
        else {
            if(ans.equals(fillInTheBlankAnswer))
                return (float)mark;
            return 0;
        }
        return 0;
    }
}
