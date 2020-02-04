package com.griddynamics.internexercise;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public final class Main {
    /**
     * Absolute path to application directory.
     */
    private static final String ABSOLUTE_APPLICATION_PATH = new File(".")
            .toPath()
            .toAbsolutePath()
            .getParent()
            .toString();

    private Main() {
    }

    /**
     * Display number of words inside the file provided as an first and only argument.
     *
     * @param args Starting parameters
     * @throws IllegalArgumentException If number of arguments is not equal to 1
     */
    public static void main(@NotNull final String[] args) {

        if (args.length != 1) {
            throw new IllegalArgumentException("Invalid arguments. You should specify a file name!");
        }

        String filePath = args[0];

        File file = findFile(filePath);

        System.out.println(file.getName() + " " + countWords(file));

    }

    /**
     * Find file according to provided path.
     *
     * @param filePath Path to the file that you're looking for.
     * @return Non null File object created by using {@code ABSOLUTE_APPLICATION_PATH} and parameterized file path.
     */
    @NotNull
    public static File findFile(@NotNull final String filePath) {
        return new File(ABSOLUTE_APPLICATION_PATH, filePath);
    }

    /**
     * Count words inside of provided file.
     *
     * @param file Non null File object inside which the words will be counted
     * @return number of words inside parameterized file
     */
    public static int countWords(@NotNull final File file) {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

            return bufferedReader.lines().parallel().mapToInt(Main::countWords).sum();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return 0;
    }

    /**
     * Count word inside the String.
     *
     * @param text Text for counting
     * @return Number of words inside the text
     */
    public static int countWords(@NotNull final String text) {
        //Transforming all whitespaces to a single space
        String trimText = text.replaceAll("\\s+", " ").trim();

        return (trimText.isBlank() || trimText.isEmpty()) ? 0 : trimText.split(" ").length;
    }

}
