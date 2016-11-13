/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Questions.Question;
import java.util.Scanner;

/**
 *
 * @author chirath
 */
public class TakeTest {
    Question question = null;
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

    public float StartTest() {
        question = new Question();
        float marks = 0;
        System.out.println("------------------------------------------------------------");
        long startTime = (System.nanoTime() / 1000000000)/60;
        for(int i = startId, j = 1; i <= endId; ++i, j++) {
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
        return marks;
    }
}
