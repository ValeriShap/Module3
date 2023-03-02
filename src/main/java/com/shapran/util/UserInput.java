package com.shapran.util;

import com.shapran.action.Actions;
import lombok.SneakyThrows;

import org.apache.commons.lang3.StringUtils;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInput {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    public void start() {
        final Actions[] values = Actions.values();
        final String[] names = actionToName(values);
        while (true) {
            final int userChoice = UserInput.getMenu(names);
            values[userChoice].execute();
        }
    }

    private static int getMenu(final String[] names) {
        int userChoice = -1;
        do {
            System.out.println("Please choise what you want to do:");
            for (int i = 0; i < names.length; i++) {
                System.out.println(i + " " + names[i]);
            }
            final String line;
            try {
                line = READER.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (!StringUtils.isNumeric(line)) {
                continue;
            }
            userChoice = Integer.parseInt(line);
        } while (userChoice < 0 || userChoice >= names.length);
        return userChoice;
    }

    private static String[] actionToName(final Actions[] values) {
        String[] names = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            names[i] = values[i].getName();
        }
        return names;
    }

    @SneakyThrows
    public static String getString() {
        String userInput = READER.readLine();
        return userInput;
    }

    public static double getDouble() {
        double number;
        do {
            number = Double.parseDouble(getString());
            if (number < 0 || number >= 100) {
                System.out.println("Wrong choice.");
            } else {
                break;
            }
        } while (true);
        return number;
    }

}
