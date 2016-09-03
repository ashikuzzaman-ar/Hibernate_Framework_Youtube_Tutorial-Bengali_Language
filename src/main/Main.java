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

        List resultList = uap.whereTest();

        System.out.println("Projections: "+resultList.get(0));
//        for (UserAuthentication UA : resultList) {
//
//            System.out.println("Username: " + UA.getUsername());
//            System.out.println("Password: " + UA.getPassword());
//            System.out.println("\n\n");
//        }

        System.exit(0);
    }
}
