package cbtsoftware;
import java.util.*;
import java.io.*;
import Registration.Register;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chirath
 */
public class CBTSoftware {

    public static void main(String[] args) {
        Register r = new Register();
        r.register();
    }  
}