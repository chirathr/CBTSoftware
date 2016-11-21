package User;

import Dbconnection.PSQLConnect;
import java.util.List;

public class Teacher extends Person {
    String department; 

    public Teacher(String name, String username, String password, String email, String dep) {
        super(name, username, password, email);
        this.department = dep;
    }

    public Teacher() {
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    
    public boolean login(String username, String password) {
        List<List<String>> result = null;
        PSQLConnect psql = new PSQLConnect();
        psql.connectPSQL();
        String query = "select * from teacher where username = '"
                + username + "' and password = '" + password + "';";
        result = psql.runPSQLQuery(query);
        if(result.size() == 1) {
            System.out.println("Login successful");
            this.id = Integer.parseInt(result.get(0).get(0));
            this.name = result.get(0).get(1);
            this.username = result.get(0).get(2);
            this.password = result.get(0).get(3);
            this.email = result.get(0).get(4);
            this.department = result.get(0).get(5);
            return true;
        }
        return false;
    }
    public boolean save(
            String name, 
            String username, 
            String password, 
            String email, 
            String department
        ) {
        
        List<List<String>> result = null;
        PSQLConnect psql = new PSQLConnect();
        String query = "select * from teacher where username = '"
                + username + "';";
        psql.connectPSQL();
        result = psql.runPSQLQuery(query);
        if(result.size() == 1) {
            System.out.println("username already exists!");
            return false;
        }
        query = "select * from teacher where email = '" + email + "';";
        psql.connectPSQL();
        result = psql.runPSQLQuery(query);
        if(result.size() == 1) {
            System.out.println("email already exists!");
            return false;
        }
        query = "select max(id) from student;";
        psql.connectPSQL();
        result = psql.runPSQLQuery(query);
        int nextId = Integer.parseInt(result.get(0).get(0)) + 1;
        query = "insert into teacher values(" + nextId + ", '" +
                name + "', '" + username + "', '" + password +
                "', '" + email + "', '" + department + "');";
        psql.connectPSQL();
        psql.insertQuery(query);
        System.out.println("User created successfully!");
        this.login(username, password);
        return true;
    }
    
}
