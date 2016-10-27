/*
 type
        1 = mcq(single answer)
        2 = mcq(multiple answer)
        3 = true or false
        4 = fill in the blanks
*/

class Question {
    int questionNumber, type, numberOfChoices, mcqAnswer[5], mcqAns;
    String question;
    String[] options = new String[5];
    boolean trueOrFalseAnswer;
    String fillInTheBlankAnswer;

    Question(int qno, String q, int nofc, String options[], int mcqAns) {
        // mcq(single answer)
        this.type = 1;
        this.questionNumber = qno;
        this.question = q;
        this.numberOfChoices = nofc;
        this.options = options;
        this.mcqAns = mcqAns;
    }
    Question(int qno, String q, int nofc, String options[], int mcqAns[]) {
        //mcq(multiple answers)
        this.type = 2;
        this.questionNumber = qno;
        this.question = q;
        this.numberOfChoices = nofc;
        this.options = options;
        this.mcqAnswer = mcqAns;
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