package User;

public interface User {
    
    public boolean isIsLoggedIn();
    
    public int getId();
    
    public boolean login(String username, String password);
}
