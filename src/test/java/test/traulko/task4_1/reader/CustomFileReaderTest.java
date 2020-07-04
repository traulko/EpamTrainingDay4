package test.traulko.task4_1.reader;

import com.traulko.task4_1.exception.IncorrectValueException;
import com.traulko.task4_1.reader.CustomFileReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CustomFileReaderTest {
    CustomFileReader customFileReader;

    @BeforeMethod
    public void setUp() {
        customFileReader = new CustomFileReader();
    }

    @AfterMethod
    public void tearDown() {
        customFileReader = null;
    }

    @Test
    public void readFromFilePositiveTest() {
        String fileName = "data\\task4_1.txt";
        try {
            String[] actual = customFileReader.readFromFile(fileName);
            String[] expected = new String[]{"104", "256", "6749", "1", "-523", "43"};
            assertEquals(actual, expected, "readFromFilePositiveTest failed as...");
        } catch (IncorrectValueException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void readFromFileNegativeTest() {
        String fileName = "data\\task4_1.txt";
        try {
            String[] actual = customFileReader.readFromFile(fileName);
            String[] expected = new String[]{"1", "2", "3", "4", "5", "6"};
            assertNotEquals(actual, expected, "readFromFilePositiveTest failed as...");
        } catch (IncorrectValueException e) {
            fail(e.getMessage());
        }
    }

    @Test(expectedExceptions = IncorrectValueException.class)
    public void readFromFileExceptionTest() throws IncorrectValueException {
        String fileName = "data\\invalidFile.txt";
        customFileReader.readFromFile(fileName);
    }
}