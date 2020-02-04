package com.griddynamics.internexercise;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class FileWordsCountTest {
    private final ClassLoader loader = getClass().getClassLoader();

    //Empty
    private final File EMPTY_FILE = new File(loader.getResource("empty.txt").getFile());
    private final File ONLY_WHITESPACES = new File(loader.getResource("only_whitespaces.txt").getFile());

    //One line
    private final File ONE_LINE_WITH_SINGLE_WHITESPACES = new File(loader.getResource("one_line_single_whitespaces.txt").getFile());
    private final File ONE_LINE_WITH_MULTIPLE_WHITESPACES = new File(loader.getResource("one_line_multiple_whitespaces.txt").getFile());

    //Multiple lines
    private final File MULTIPLE_LINES_WITH_MULTIPLE_WHITESPACES = new File(loader.getResource("multiple_with_multiple_whitespaces.txt").getFile());

    @Test
    public void emptyFileShouldBeZeroTest() {
        Assert.assertEquals(0, Main.countWords(EMPTY_FILE));
    }

    @Test
    public void onlyWhitespacesShouldBeZeroTest() {
        Assert.assertEquals(0, Main.countWords(ONLY_WHITESPACES));
    }

    @Test
    public void singleLineSingleWhitespacesShouldBeThreeTest() {
        Assert.assertEquals(3, Main.countWords(ONE_LINE_WITH_SINGLE_WHITESPACES));
    }

    @Test
    public void singleLineMultipleWhitespacesShouldBeThreeTest() {
        Assert.assertEquals(3, Main.countWords(ONE_LINE_WITH_MULTIPLE_WHITESPACES));
    }

    @Test
    public void multipleLinesMultipleWhitespacesShouldBeNineTest() {
        Assert.assertEquals(9, Main.countWords(MULTIPLE_LINES_WITH_MULTIPLE_WHITESPACES));
    }
}
