/*
 type
        1 = mcq(single answer)
        2 = mcq(multiple answer)
        3 = true or false
        4 = fill in the blanks
*/


class Question {
    int questionNumber, type, numberOfChoices, mcqAnswer[5];
    String question;
    String[] options = new String[5];
    String trueOrFalseAnswer;
    String fillInTheBlankAnswer;


}