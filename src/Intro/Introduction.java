package Intro;
import java.util.Scanner;


public class Introduction {
    public void displayInfo() {
        //Display intro, call this function in CBTSofware
        System.out.println("\n \n \n \n \n \n \n ");
        System.out.println("*********************************************************************************************************");
        System.out.println("                                     Computer Based Testing Software");
        System.out.println("*********************************************************************************************************");
        System.out.println(" \n \n \n \n \n \n \n \t\t\t\t\tYour Test Will Begin Shortly\n \n \n \n \nThis sofware has been developed using Atom text-editor.\nDeveloped by Chirath and Vishnu.\nNo part of this code may be reproduced or copied without the express permissions of the administrators");
        System.out.println("Hit return to continue");
        String s=new Scanner(System.in).nextLine();
    }
    public void displayRules() {
        //Display rules, call this function in CBTSoftware
        System.out.println("\n \n \n \n \n \n \n ");
        System.out.println("*********************************************************************************************************");
        System.out.println("                                           Rules And Regulations");
        System.out.println("*********************************************************************************************************");
        System.out.println("\n\n\n1.All Questions must be answered");
        System.out.println("2.ID card and admit card is a must,entry to the exam hall can be denied");
        System.out.println("3.Mobile Phones are banned, any trace WILL be treated as malpractice");
        System.out.println("4.Copying, either from the internet or from any other student will be treated as malpractice");
        System.out.println("5.Time limit for each question is specified. No extra time will be given");
        System.out.println("6.No Negative marking system.");
        System.out.println("7.Marks for each question are specified");
        System.out.println("\n \n \n \n \n \n \n ");
        System.out.println("*********************************************************************************************************");
        System.out.println("\n\n\nBEST OF LUCK");
        System.out.println("Hit return to begin your test");
        String s=new Scanner(System.in).nextLine();
    }
}
