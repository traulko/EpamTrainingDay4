package test.traulko.task4_1.validator;

import com.traulko.task4_1.validator.NumberValidator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class NumberValidatorTest {
    NumberValidator numberValidator;

    @BeforeMethod
    public void setUp() {
        numberValidator = new NumberValidator();
    }

    @AfterMethod
    public void tearDown() {
        numberValidator = null;
    }

    @DataProvider(name = "isThreeDigitNumberPositiveData")
    @Test
    public Object[][] isThreeDigitNumberPositiveData() {
        return new Object[][]{
                {105},
                {524},
                {-521}
        };
    }

    @Test(dataProvider = "isThreeDigitNumberPositiveData")
    public void isThreeDigitNumberPositiveTest(int number) {
        boolean actual = numberValidator.isThreeDigitNumber(number);
        assertTrue(actual, "isThreeDigitNumberPositiveTest failed as...");
    }

    @DataProvider(name = "isThreeDigitNumberNegativeData")
    @Test
    public Object[][] isThreeDigitNumberNegativeData() {
        return new Object[][]{
                {10},
                {5241},
                {-1},
                {0}
        };
    }

    @Test(dataProvider = "isThreeDigitNumberNegativeData")
    public void isThreeDigitNumberNegativeTest(int number) {
        boolean actual = numberValidator.isThreeDigitNumber(number);
        assertFalse(actual, "isThreeDigitNumberNegativeTest failed as...");
    }
}