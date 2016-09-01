package main;

import db.models.UserAuthentication;
import db.provider.UserAuthenticationProvider;
import java.util.List;

/**
 *
 * @author ashik
 */
public class Main {

    public static void main(String[] args) {

        UserAuthenticationProvider uap = new UserAuthenticationProvider();
        List<UserAuthentication> resultList = uap.fromTest();
        
        for(int i=0; i<5; i++){
            
            System.out.println("Username: "+resultList.get(i).getUsername());
            System.out.println("Password: "+resultList.get(i).getPassword());
            System.out.println("\n\n");
        }
        
        System.exit(0);
    }
}
