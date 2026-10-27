package org.example;

import org.mindrot.jbcrypt.BCrypt;

public class Main {
    static void main() {
        String password = "123456";

        String hash = BCrypt.hashpw(password, BCrypt.gensalt());

        System.out.println("Password: " + password);
        System.out.println("Hash: " + hash);

        boolean valid = BCrypt.checkpw(password, hash);

        System.out.println("Valid password: " + valid);
    }
}
