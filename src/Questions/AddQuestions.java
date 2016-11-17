package Questions;

import java.util.Scanner;


public class AddQuestions {
    Question question = null;
    Scanner scanner = new Scanner(System.in);
    int nOfC;
    
    public int getNumberofChoices() {
        System.out.print("Enter number of choices :");
        nOfC = scanner.nextInt();
        return nOfC;
    }
    
    public String getQuestion() {
        System.out.print("Enter Question :");
        return scanner.nextLine();
    }
    
    public String[] getOptions() {
        String[] str = new String[5];
        System.out.print("Enter " + nOfC + " choices :");
        str[0] = scanner.nextLine();
        for(int i = 0; i < nOfC; ++i) {
            str[i] = scanner.nextLine();
        }
        return str;
    }
    
    public String getMcqAnswer() {
        System.out.print("Enter answer :");
        return scanner.nextLine();
    }
    
    public int getMark() {
        System.out.print("Enter mark :");
        return scanner.nextInt();
    }
    
    public void addMCQSingle(int tId) {
        System.out.println("----------------MCQ single--------------");
        System.out.println("Number of question?");
        int n = scanner.nextInt();
        for(int i = 0; i < n; ++i) {
            System.out.println("Enter question " + i+1);
            String temp = scanner.nextLine();
            question = new Question();
            question.setMCQSingle(
                    this.getQuestion(), 
                    this.getNumberofChoices(), 
                    this.getOptions(),
                    this.getMcqAnswer(), 
                    this.getMark(),
                    tId
            );
            question.save();
        }  
    }
    
    public String getMcqAnswers() {
        System.out.print("Enter answers seperated by comma(,) :");
        return scanner.nextLine();
    }
    
    public void addMCQMultiple(int tId) {
        System.out.println("----------------MCQ single--------------");
        System.out.println("Number of question?");
        int n = scanner.nextInt();
        for(int i = 0; i < n; ++i) {
            System.out.println("Enter question " + i+1);
            String temp = scanner.nextLine();
            question = new Question();
            question.setMCQMultiple(
                    this.getQuestion(), 
                    this.getNumberofChoices(), 
                    this.getOptions(),
                    this.getMcqAnswers(), 
                    this.getMark(),
                    tId
            );
            question.save();
        }  
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
    
    public void addTrueOrFalse(int tId) {
        System.out.println("----------------True or False--------------");
        System.out.println("Number of question?");
        int n = scanner.nextInt();
        for(int i = 0; i < n; ++i) {
            System.out.println("Enter question " + i+1);
            String temp = scanner.nextLine();
            question = new Question();
            question.setTrueOrFalse(
                    this.getQuestion(), 
                    this.getTrueOrFalseAns(), 
                    this.getMark(),
                    tId
            );
            question.save();
        }        
    }
    
    public String getFillInTheBlankAns() {
        System.out.print("Enter answer :");
        return scanner.nextLine();
    }
    
    public void addFillInTheBlanks(int tId) {
        System.out.println("----------------Fill in the blanks--------------");
        System.out.println("Number of question?");
        int n = scanner.nextInt();
        for(int i = 0; i < n; ++i) {
            System.out.println("Enter question " + i+1);
            String temp = scanner.nextLine();
            question = new Question();
            question.setFillInTheBlank(
                    this.getQuestion(), 
                    this.getFillInTheBlankAns(), 
                    this.getMark(),
                    tId
            );
            question.save();
        }
    }
    
    public void addQuestions(int tId) {
        System.out.println("----------------Add Questions--------------");
        System.out.println("1 for MCQ single answer");
        System.out.println("2 for MCQ multiple answer");
        System.out.println("3 for true or false");
        System.out.println("4 for fill in the blanks");
        System.out.println("5 to exit");
        int ch = scanner.nextInt();
        switch(ch) {
            case 1: addMCQSingle(tId);
            return;
            case 2: addMCQMultiple(tId);
            break;
            case 3: addTrueOrFalse(tId);
            break;
            case 4: addFillInTheBlanks(tId);
            break;
            case 5:
            break;
            default:
                System.out.println("Wrong choice");
        }
    }
}
