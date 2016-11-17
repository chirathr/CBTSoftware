package Questions;

public class ReadFromFile {
    Question q = null;
    
    public void readFromFile() {
        q = new Question();
        
        int type, numberOfChoices, mcqAnswer, mark;
        String question;
        String[] options = new String[5];
        boolean trueOrFalseAnswer = true;
        String fillInTheBlankAnswer;
        //open a file
        
        /* 
            type | numerofchoices | choice1  | choice2  | choice3  | choice4  | choice5  |         question          | mcqanswer | trueorfalse | fillintheblankanswer | mark 

            example of a line in file :
            2, 5, 'option 1', 'option 2', 'option 3', 'option 4', 'option 5', 'Question text?', 1, -1, 'answer', 2
            
            read the file line by line
            split 12 items of the question
            
            save into all the variables
        
            call.  
            q.setAll(); // pass all the variable as parameters
            q.save();
        
        */
    }
}
