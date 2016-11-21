package Test;

import Dbconnection.PSQLConnect;
import Exam.Exam;
import Questions.Question;
import Result.Result;
import java.util.List;
import java.util.Scanner;

public class TakeTest {
    Question question = null;
    Exam exam = null;
    PSQLConnect psql = null;
    List<List<String>> results = null;
    Scanner scanner = new Scanner(System.in); 
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
    
    
    public int selectExam() {
        exam = new Exam();
        psql = new PSQLConnect();
        int selectedId = 0;
        System.out.print("-----------------------Online Exam----------------------");
        String query = "select * from exam;";
        psql.connectPSQL();
        results = psql.runPSQLQuery(query);
        for(int i = 0; i < results.size(); ++i) {
            System.out.print("\n" + results.get(i).get(0) + ". " +
                    results.get(i).get(1) + "\t" + results.get(i).get(2) +
                    "\t" + results.get(i).get(4));
        }
        System.out.print("\n\nEnter your choice : ");
        selectedId = scanner.nextInt();
        
        query = "select * from exam where id = " + selectedId + ";";
        psql.connectPSQL();
        results = psql.runPSQLQuery(query);
        time = Integer.parseInt(results.get(0).get(4));
        return selectedId;
        
        
    }

    public void StartTest(int sId) {
        question = new Question();
        float marks = 0, total = 0;
        int examId = this.selectExam();
        System.out.println("----------------------Examination----------------------");
        long startTime = (System.nanoTime() / 1000000000)/60;
        String query = "select * from examination where examid = " + examId + ";";
        psql.connectPSQL();
        results = psql.runPSQLQuery(query);
        question = new Question();
        System.out.println(results.size());
        for(int i = 0, j =1; i < results.size(); ++i, j++) {
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
            
            question.load(Integer.parseInt(results.get(i).get(1)));
            question.print(j);
            System.out.print("   ->");
            String ans = new Scanner(System.in).nextLine();
            total += question.getMark();
            marks += question.checkAnswer(ans);
            System.out.println("------------------------------------------------------------");
        }
        Result result = new Result();
        query = "select * from exam where id = " + examId + ";";
        psql.connectPSQL();
        results = psql.runPSQLQuery(query);
        int nextId = 0;
        result.setResult(sId, examId, results.get(0).get(1), marks, total);
        result.save();
        System.out.println("-----------------------Test complete-----------------------");
        System.out.print("\nResult : ");
        System.out.print(marks);
        System.out.print(" / ");
        System.out.print(total);
        System.out.println("\n\n-----------------------------------------------------------\n");
    }
}
