package com.example.myapp.Controller.Helpers;
import java.util.Random;
import java.security.SecureRandom;
public  class Generator {

        private String random;
        private static final String PASSWORD_PATTERN = "((?=.*[a-z])(?=.*\\d)(?=.*[A-Z]))";
        public Generator(){
            this.random=generateRandom(8);
        }

        private static final String characters = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        public static String generateRandom(int length) {
            Random random = new SecureRandom();
            if (length <= 0) {
                throw new IllegalArgumentException("String length must be a positive integer");
            }

            StringBuilder sb = new StringBuilder(length);
            for (int i = 0; i < length; i++) {
                sb.append(characters.charAt(random.nextInt(characters.length())));
            }

            return sb.toString();
        }
    }



