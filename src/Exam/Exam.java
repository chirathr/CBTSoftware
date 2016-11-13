/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exam;

import Questions.Question;
import java.util.Scanner;

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
    
    public void selectQuestions() {
        Question question = new Question();
        System.out.print("\n----------Questions------------");
        System.out.print("\n1. Add new questions");
        System.out.print("\n2. Select from existing questions");
        int choice = scanner.nextInt();
        if(choice == 1) {
            question.getQuestion();
        }
        else if(choice == 2) {
            
        }
        else {
            System.out.print("\nWrong choice, enter again");
            this.selectQuestions();
        }
    }
    
    public void addExam(int tId) {
        teacherId = tId;
        System.out.print("\nEnter exam name : ");
        examName = scanner.nextLine();
        System.out.print("\nEnter date of exam : ");
        dateOfExam = scanner.nextLine();
        System.out.print("\nEnter duration : ");
        time = scanner.nextInt();
        this.selectQuestions();
    }
}
