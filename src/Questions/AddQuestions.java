/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Questions;

import java.util.Scanner;

/**
 *
 * @author chirath
 */
public class AddQuestions {
    Question question = null;
    Scanner scanner = new Scanner(System.in);
    
    public int getNumberofChoices() {
        System.out.print("Enter number of choices :");
        return scanner.nextInt();
    }
    
    public String getQuestion() {
        System.out.print("Enter Question :");
        return scanner.nextLine();
    }
    
    public String[] getOptions() {
        String[] str = new String[5];
        System.out.print("Enter 5 choices :");
        for(int i = 0; i < 5; ++i) {
            str[i] = scanner.nextLine();
        }
        return str;
    }
    
    public int getMacqAnswer() {
        System.out.print("Enter answer(1-5) :");
        return scanner.nextInt()-1;
    }
    
    public int getMark() {
        System.out.print("Enter mark :");
        return scanner.nextInt();
    }
    
    public void addMCQSingle() {
        question = new Question();
        question.setMCQSingle(
                this.getQuestion(), 
                this.getNumberofChoices(), 
                this.getOptions(),
                this.getMacqAnswer(), 
                this.getMacqAnswer());
        question.save();
    }
    
    public boolean getTrueOrFalseAns() {
        System.out.print("Enter answer(T or F) :");
        char c = scanner.nextLine().charAt(0);
        if(c == 'T' || c == 't')
            return true;
        else if(c == 'F' || c == 'f')
            return false;
        return this.getTrueOrFalseAns();
    }
    
    public void addTrueOrFalse() {
        question = new Question();
        question.setTrueOrFalse(
                this.getQuestion(), 
                this.getTrueOrFalseAns(), 
                this.getMacqAnswer());
        question.save();
    }
    
    public String getFillInTheBlankAns() {
        System.out.print("Enter answer :");
        return scanner.nextLine();
    }
    
    public void addFillInTheBlanks() {
        question = new Question();
        question.setFillInTheBlank(
                this.getQuestion(), 
                this.getFillInTheBlankAns(), 
                this.getMacqAnswer());
        question.save();
    }
}
