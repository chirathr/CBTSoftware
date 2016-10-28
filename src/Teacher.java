/* Teacher details
username
email
password
*/
import java.util.*;
import java.io.*;

class Teacher {
	String username, email, password;
	int id;

	//Getters and setters


    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    Teacher(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}
	
	boolen setData(String username, String email, String password) {
		dbQuery = true; //check if user exists in teacher table
		if(dbQuery) // if user does exist
			return false;
		else {
			// int maxIdInDB = query();  // Query for max id in table
			//this.id = maxIdInDB+1;
			this.username = username;
			this.email = email;
			this.password = password;
		}
	}
	
	/*
	void query(String username) { // load the teacher from db into the class
		
	}
	*/
}