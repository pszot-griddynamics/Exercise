package com.griddynamics.internexercise;

import org.jetbrains.annotations.NotNull;

import java.io.*;

public class Main {
    public static void main(@NotNull String[] args) {
        if (args.length != 1) {
            System.err.println("Invalid arguments. You should specify a file name!");
        }

        String absoluteApplicationPath = new File(".").toPath().toAbsolutePath().getParent().toString();

        String filePath = args[0];
        File file = new File(absoluteApplicationPath, filePath);

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

            int wordCount = bufferedReader.lines().parallel().mapToInt(Main::countWords).sum();

            System.out.println(file.getName() + " " + wordCount);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int countWords(@NotNull String text) {
        //Text has no whitespace at the end, so to be sure that the function include last word of parameterized line
        //I'm adding new line symbol at the end
        text += "\n";

        int words = 0;
        boolean wordFound = false;

        for (char ch : text.toCharArray()) {

            if (Character.isWhitespace(ch)) {
                if (wordFound) {
                    words++;
                    wordFound = false;
                }
            } else wordFound = true;

        }

        return words;
    }

}
