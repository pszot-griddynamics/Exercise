package com.griddynamics.internexercise;

import org.junit.Assert;
import org.junit.Test;

public class StringWordCountTest {

    @Test
    public void emptyStringShouldBeZeroTest() {
        Assert.assertEquals(0, Main.countWords(""));
    }

    @Test
    public void onlyWhitespacesStringShouldBeZeroTest() {
        Assert.assertEquals(0, Main.countWords("  \t\n \t "));
    }

    @Test
    public void singleWhitespacesStringShouldBeFiveTest() {
        Assert.assertEquals(5, Main.countWords(" some text\twith some\nwhitespaces"));
    }

    @Test
    public void multipleWhitespacesStringShouldBeFiveTest() {
        Assert.assertEquals(5, Main.countWords("    some     text \t\twith   some\n\n\nwhitespaces  \n"));
    }

}
