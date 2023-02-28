package com.shapran.util;

import java.util.Random;

public class RandomGenerator {
    private static final Random random = new Random();

    public static String randomString(){
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int index = random.nextInt(alphabet.length());
            sb.append(alphabet.charAt(random.nextInt(alphabet.length() - 1)));
        }
        return sb.toString();
    }

    public static int randomAge(){
        return random.nextInt(18,50);
    }


}
