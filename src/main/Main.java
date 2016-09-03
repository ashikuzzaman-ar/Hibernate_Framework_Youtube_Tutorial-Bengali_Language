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
        if (uap.deleteTest()) {

            List<UserAuthentication> resultList = uap.whereTest();

            for (int i = 0; i < resultList.size(); i++) {

                System.out.println("ID: " + resultList.get(i).getId());
                System.out.println("Username: " + resultList.get(i).getUsername());
                System.out.println("Password: " + resultList.get(i).getPassword());
                System.out.println("\n\n");
            }
        }

        System.exit(0);
    }
}
