/*
 type
        1 = mcq(single answer)
        2 = mcq(multiple answer)
        3 = true or false
        4 = fill in the blanks
*/

class Question {
    int questionNumber, type, numberOfChoices, mcqAnswer[5], mcqAnswer;
    String question;
    String[] options = new String[5];
    boolean trueOrFalseAnswer;
    String fillInTheBlankAnswer;

    //setters

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    public void setNumberOfChoices(int numberOfChoices) {
        this.numberOfChoices = numberOfChoices;
    }

    public void setMcqAnswer(int[] mcqAnswer) {
        this.mcqAnswer = mcqAnswer;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public void setTrueOrFalseAnswer(boolean trueOrFalseAnswer) {
        this.trueOrFalseAnswer = trueOrFalseAnswer;
    }

    public void setFillInTheBlankAnswer(String fillInTheBlankAnswer) {
        this.fillInTheBlankAnswer = fillInTheBlankAnswer;
    }

    public void setType(int type) {
        this.type = type;
    }

    // Getters

    public boolean isTrueOrFalseAnswer() {
        return trueOrFalseAnswer;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public int getType() {
        return type;
    }

    public int getNumberOfChoices() {
        return numberOfChoices;
    }

    public int[] getMcqAnswers() {
       return mcqAnswers;
    }

    public int getMcqAnswer() {
        return mcqAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public String getFillInTheBlankAnswer() {
        return fillInTheBlankAnswer;
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