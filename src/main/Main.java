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

        List<UserAuthentication> resultList = uap.limitTest();

        for (UserAuthentication UA : resultList) {

            System.out.println("Username: " + UA.getUsername());
            System.out.println("Password: " + UA.getPassword());
            System.out.println("\n\n");
        }

        System.exit(0);
    }
}
