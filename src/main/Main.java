package main;

import db.provider.UserAuthenticationProvider;
import java.util.List;

/**
 *
 * @author ashik
 */
public class Main {
    
    public static void main(String[] args) {
        
        UserAuthenticationProvider uap = new UserAuthenticationProvider();
        
        List resultList = uap.aggrTest();
        
        System.out.println("Average value of ID: " + resultList.get(0));
        
        System.exit(0);
    }
}
