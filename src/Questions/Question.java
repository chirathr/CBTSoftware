/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Questions;

/**
 *
 * @author chirath
 */
public class Question {
    int questionNumber, type, numberOfChoices, mcqAnswer;
    int[] mcqAnswers;
    String question;
    String[] options = new String[5];
    boolean trueOrFalseAnswer;
    String fillInTheBlankAnswer;

    //setters and getters

    public int getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
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

    public int[] getMcqAnswers() {
        return mcqAnswers;
    }

    public void setMcqAnswers(int[] mcqAnswers) {
        this.mcqAnswers = mcqAnswers;
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

    Question(int qno, String q, int nofc, String options[], int mcqAnswer) {
        // mcq(single answer)
        this.type = 1;
        this.questionNumber = qno;
        this.question = q;
        this.numberOfChoices = nofc;
        this.options = options;
        this.mcqAnswer= mcqAnswer;
    }
    Question(int qno, String q, int nofc, String options[], int mcqAnswers[]) {
        //mcq(multiple answers)
        this.type = 2;
        this.questionNumber = qno;
        this.question = q;
        this.numberOfChoices = nofc;
        this.options = options;
        this.mcqAnswers = mcqAnswers;
    }
    Question(int qno, String q, boolean torF) {
        // True or False
        this.type = 3;
        this.questionNumber = qno;
        this.question = q;
        this.trueOrFalseAnswer = torF;
    }
    Question(int qno, String q, String ans) {
        // Fill in the blanks
        this.type = 4;
        this.questionNumber = qno;
        this.question = q;
        this.fillInTheBlankAnswer = ans;
    }


}
