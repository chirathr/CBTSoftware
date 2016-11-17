package User;
import Dbconnection.PSQLConnect;

public class Person implements User{
    int id;
    String name, username, password, email;
    boolean isLoggedIn;

    public Person(String name, String username, String password, String email) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
    }
    
    public Person() {
        
    }

    //getter and setters
    
    public boolean isIsLoggedIn() {
        return isLoggedIn;
    }

    public boolean login(String username, String password) {
        return true;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    } 
    
}
