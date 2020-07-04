package test.traulko.task4_1.reader;

import com.traulko.task4_1.exception.IncorrectValueException;
import com.traulko.task4_1.reader.ConsoleReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.testng.Assert.*;

public class ConsoleReaderTest {
    ConsoleReader consoleReader;

    @BeforeMethod
    public void setUp() {
        consoleReader = new ConsoleReader();
    }

    @AfterMethod
    public void tearDown() {
        consoleReader = null;
    }

    @DataProvider(name = "readArraySizePositiveData")
    public Object[][] readArraySizePositiveData() {
        return new Object[][]{
                {"1", new int[]{0}},
                {"2", new int[]{0, 0}},
                {"3", new int[]{0, 0, 0}}
        };
    }

    @Test(dataProvider = "readArraySizePositiveData")
    public void readArraySizePositiveTest(String data, int[] expected) {
        InputStream actualData = new ByteArrayInputStream(data.getBytes());
        try {
            int[] actual = consoleReader.readArraySize(actualData);
            boolean result = isEqualArrays(actual, expected);
            assertTrue(result, "readArraySizePositiveTest failed as...");
        } catch (IncorrectValueException e) {
            fail(e.getMessage());
        }
    }

    @DataProvider(name = "readArraySizeNegativeData")
    public Object[][] readArraySizeNegativeData() {
        return new Object[][]{
                {"1", new int[]{1}},
                {"2", new int[]{}},
                {"3", new int[]{1, 2, 3}}
        };
    }

    @Test(dataProvider = "readArraySizeNegativeData")
    public void readArraySizeNegativeTest(String data, int[] expected) {
        InputStream actualData = new ByteArrayInputStream(data.getBytes());
        try {
            int[] actual = consoleReader.readArraySize(actualData);
            boolean result = isEqualArrays(actual, expected);
            assertFalse(result, "readArraySizeNegativeTest failed as...");
        } catch (IncorrectValueException e) {
            fail(e.getMessage());
        }
    }

    @DataProvider(name = "readArraySizeExceptionData")
    public Object[][] readArraySizeExceptionData() {
        return new Object[][]{
                {"-1"},
                {"0"}
        };
    }

    @Test(dataProvider = "readArraySizeExceptionData", expectedExceptions = IncorrectValueException.class)
    public void readArraySizeExceptionTest(String data) throws IncorrectValueException {
        InputStream actualData = new ByteArrayInputStream(data.getBytes());
        consoleReader.readArraySize(actualData);
    }

    @DataProvider(name = "readArrayElementPositiveData")
    public Object[][] readArrayElementPositiveData() {
        return new Object[][]{
                {1, "100", 100},
                {2, "-100", -100},
                {3, "1", 1}
        };
    }

    @Test(dataProvider = "readArrayElementPositiveData")
    public void readArrayElementPositiveTest(int index, String data, int expected) {
        InputStream actualData = new ByteArrayInputStream(data.getBytes());
        try {
            int actual = consoleReader.readArrayElement(index, actualData);
            assertEquals(actual, expected);
        } catch (IncorrectValueException e) {
            fail(e.getMessage());
        }
    }

    @DataProvider(name = "readArrayElementNegativeData")
    public Object[][] readArrayElementNegativeData() {
        return new Object[][]{
                {1, "-1", 0},
                {2, "1", -100},
                {3, "5", 1}
        };
    }

    @Test(dataProvider = "readArrayElementNegativeData")
    public void readArrayElementNegativeTest(int index, String data, int expected) {
        InputStream actualData = new ByteArrayInputStream(data.getBytes());
        try {
            int actual = consoleReader.readArrayElement(index, actualData);
            assertNotEquals(actual, expected);
        } catch (IncorrectValueException e) {
            fail(e.getMessage());
        }
    }

    @Test(expectedExceptions = IncorrectValueException.class)
    public void readArrayElementExceptionTest() throws IncorrectValueException {
        String data = "badInput";
        InputStream actualData = new ByteArrayInputStream(data.getBytes());
        int index = 10;
        consoleReader.readArrayElement(index, actualData);
    }

    private boolean isEqualArrays(int[] array1, int[] array2) {
        boolean result = true;
        if (array1.length != array2.length) {
            result = false;
        } else {
            for (int i = 0; i < array1.length; i++) {
                if (array1[i] != array2[i]) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }
}