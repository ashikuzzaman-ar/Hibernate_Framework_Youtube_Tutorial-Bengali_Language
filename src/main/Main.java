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
        List<String> resultList = uap.selectTest();
        
        for(int i=0; i<resultList.size(); i++){
            
            System.out.println("Username: "+resultList.get(i));
            System.out.println("\n\n");
        }
        
        System.exit(0);
    }
}
