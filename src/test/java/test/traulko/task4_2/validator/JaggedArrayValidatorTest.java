package test.traulko.task4_2.validator;

import com.traulko.task4_2.validator.JaggedArrayValidator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class JaggedArrayValidatorTest {
    JaggedArrayValidator jaggedArrayValidator;

    @BeforeMethod
    public void setUp() {
        jaggedArrayValidator = new JaggedArrayValidator();
    }

    @AfterMethod
    public void tearDown() {
        jaggedArrayValidator = null;
    }

    @Test
    public void isCorrectPositiveTest() {
        boolean actual = jaggedArrayValidator.isCorrect(10, 11);
        assertTrue(actual, "isCorrectPositiveTest failed as...");
    }

    @Test
    public void isCorrectNegativeTest() {
        boolean actual = jaggedArrayValidator.isCorrect(-1, 20);
        assertFalse(actual, "isCorrectNegativeTest failed as...");
    }
}