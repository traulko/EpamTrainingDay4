package test.traulko.task4_1.creator;

import com.traulko.task4_1.creator.CustomCreator;
import com.traulko.task4_1.entity.CustomArray;
import com.traulko.task4_1.exception.IncorrectValueException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CustomCreatorTest {
    CustomCreator customCreator;

    @BeforeMethod
    public void setUp() {
        customCreator = new CustomCreator();
    }

    @AfterMethod
    public void tearDown() {
        customCreator = null;
    }

    @Test
    public void createArrayRandomPositiveTest() {
        try {
            int actual = 5;
            CustomArray customArray = customCreator.createArrayRandom(actual);
            int expected = customArray.length();
            assertEquals(actual, expected, "createArrayRandomPositiveTest failed as...");
        } catch (IncorrectValueException e) {
            fail(e.getMessage());
        }
    }

    @Test(expectedExceptions = IncorrectValueException.class)
    public void createArrayRandomNegativeTest() throws IncorrectValueException {
        int actual = 0;
        customCreator.createArrayRandom(actual);
    }

    @Test
    public void createArrayConsolePositiveTest() {
        try {
            CustomArray expected = new CustomArray(new int[]{1, 2, 3, 4, 5});
            CustomArray actual = customCreator.createArrayConsole();
            assertEquals(actual, expected, "createAndFillArrayConsolePositiveTest failed as...");
        } catch (IncorrectValueException e) {
            fail(e.getMessage());
        }
    }

    @DataProvider(name = "createArrayFilePositiveData")
    public Object[][] createArrayFilePositiveData() {
        return new Object[][]{
                {"data/task4_1.txt", new CustomArray(new int[]{104, 256, 6749, 1, -523, 43})},
                {null, new CustomArray(new int[]{1, 2, 3, 4, 5})},
                {"input/qwerty.txt", new CustomArray(new int[]{1, 2, 3, 4, 5})},
        };
    }

    @Test(dataProvider = "createArrayFilePositiveData")
    public void createArrayFilePositiveTest(String file, CustomArray expected) {
        try {
            CustomArray actual = customCreator.createArrayFile(file);
            assertEquals(actual, expected, "createArrayFilePositiveTest failed as...");
        } catch (IncorrectValueException e) {
            fail(e.getMessage());
        }
    }

    @DataProvider(name = "createArrayFileNegativeData")
    public Object[][] createArrayFileNegativeData() {
        return new Object[][]{
                {"input/validData.txt", new CustomArray(new int[]{1, 2})},
                {null, new CustomArray(new int[]{3, 2})},
                {"input/qwerty.txt", new CustomArray(new int[]{1, 4, 5})},
        };
    }

    @Test(dataProvider = "createArrayFileNegativeData")
    public void createArrayFileNegativeTest(String file, CustomArray expected) {
        try {
            CustomArray actual = customCreator.createArrayFile(file);
            assertNotEquals(actual, expected, "createArrayFilePositiveTest failed as...");
        } catch (IncorrectValueException e) {
            fail(e.getMessage());
        }
    }

    @DataProvider(name = "createArrayFileExceptionData")
    public Object[][] createCreateAndFillArrayFileExceptionData() {
        return new Object[][]{
                {"data\\invalidFile.txt"}
        };
    }

    @Test(dataProvider = "createArrayFileExceptionData", expectedExceptions = IncorrectValueException.class)
    public void createAndFillArrayFileExceptionTest(String file) throws IncorrectValueException {
        customCreator.createArrayFile(file);
    }
}