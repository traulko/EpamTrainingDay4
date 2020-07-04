package test.traulko.task4_1.parser;

import com.traulko.task4_1.exception.IncorrectValueException;
import com.traulko.task4_1.parser.ElementsParser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ElementsParserTest {
    ElementsParser elementsParser;

    @BeforeMethod
    public void setUp() {
        elementsParser = new ElementsParser();
    }

    @AfterMethod
    public void tearDown() {
        elementsParser = null;
    }

    @DataProvider(name = "parseToIntArrayPositiveData")
    @Test
    public Object[][] parseToIntArrayPositiveData() {
        return new Object[][]{
                {new String[]{"1", "2", "3"}, new int[]{1, 2, 3}},
                {new String[]{"0"}, new int[]{0}},
                {new String[]{}, new int[]{}}
        };
    }

    @Test(dataProvider = "parseToIntArrayPositiveData")
    public void parseToIntArrayPositiveTest(String[] arrayStringFormat, int[] expected) {
        try {
            int[] actual = elementsParser.parseToIntArray(arrayStringFormat);
            assertEquals(actual, expected, "parseToIntArrayPositiveTest failed as...");
        } catch (IncorrectValueException e) {
            fail(e.getMessage());
        }
    }

    @DataProvider(name = "parseToIntArrayNegativeData")
    @Test
    public Object[][] parseToIntArrayNegativeData() {
        return new Object[][]{
                {new String[]{"1", "2", "3"}, new int[]{3, 2, 1}},
                {new String[]{"-1"}, new int[]{}},
                {new String[]{"12345"}, new int[]{0}}
        };
    }

    @Test(dataProvider = "parseToIntArrayNegativeData")
    public void parseToIntArrayNegativeTest(String[] arrayStringFormat, int[] expected) {
        try {
            int[] actual = elementsParser.parseToIntArray(arrayStringFormat);
            assertNotEquals(actual, expected, "parseToIntArrayNegativeTest failed as...");
        } catch (IncorrectValueException e) {
            fail(e.getMessage());
        }
    }

    @DataProvider(name = "parseToIntArrayExceptionData")
    @Test
    public Object[][] parseToIntArrayExceptionData() {
        return new Object[][]{
                {new String[]{"1g", "2", "3"}},
                {new String[]{"-1-"}},
                {new String[]{"12/345"}}
        };
    }

    @Test(dataProvider = "parseToIntArrayExceptionData", expectedExceptions = IncorrectValueException.class)
    public void parseToIntArrayExceptionTest(String[] arrayStringFormat) throws IncorrectValueException {
        elementsParser.parseToIntArray(arrayStringFormat);
    }
}