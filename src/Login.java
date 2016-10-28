//First page
// options to select student or teacher.
//Login as student or teacher.

import java.io.*;
import java.util.*;

class Login {
    Scanner scanner = new Scanner(System.in);
    int ch;

    // constructor

    Main(int choice){
        ch=choice;
    }

    void selectUser() {
        System.out.println("1. Student\n2. Teacher");
        this.ch = scanner.nextInt();
    }

    int loginUser() {
        if(ch == 1) {
            System.out.println("Login Student :");
            System.out.print("Username : ");

            System.out.print("Password : ");

            if() // table verify
                return id; //return users id
        }
    }

}
