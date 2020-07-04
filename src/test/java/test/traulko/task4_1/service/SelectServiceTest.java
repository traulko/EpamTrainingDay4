package test.traulko.task4_1.service;

import com.traulko.task4_1.entity.CustomArray;
import com.traulko.task4_1.exception.IncorrectValueException;
import com.traulko.task4_1.service.SelectService;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SelectServiceTest {
    SelectService selectService;

    @BeforeMethod
    public void setUp() {
        selectService = new SelectService();
    }

    @AfterMethod
    public void tearDown() {
        selectService = null;
    }

    @DataProvider(name = "selectPrimeNumbersPositiveData")
    @Test
    public Object[][] selectPrimeNumbersPositiveData() {
        return new Object[][]{
                {new CustomArray(new int[]{1, 2, 3, 5, 7}),
                        new CustomArray(new int[]{1, 2, 3, 5, 7})},
                {new CustomArray(new int[]{1, 2, 3, 4, 5}),
                        new CustomArray(new int[]{1, 2, 3, 5})},
                {new CustomArray(new int[]{1}),
                        new CustomArray(new int[]{1})}
        };
    }

    @Test(dataProvider = "selectPrimeNumbersPositiveData")
    public void selectPrimeNumbersPositiveTest(CustomArray array, CustomArray expected) {
        try {
            CustomArray actual = selectService.selectPrimeNumbers(array);
            assertEquals(actual, expected, "selectPrimeNumbersPositiveTest failed as...");
        } catch (IncorrectValueException e) {
            fail(e.getMessage());
        }
    }

    @DataProvider(name = "selectPrimeNumbersNegativeData")
    @Test
    public Object[][] selectPrimeNumbersNegativeData() {
        return new Object[][]{
                {new CustomArray(new int[]{1, 2, 3, 5, 7}),
                        new CustomArray(new int[]{1, 7})},
                {new CustomArray(new int[]{1, 2, 3, 4}),
                        new CustomArray(new int[]{1, 2, 3, 5})},
                {new CustomArray(new int[]{1}),
                        new CustomArray(new int[]{})}
        };
    }

    @Test(dataProvider = "selectPrimeNumbersNegativeData")
    public void selectPrimeNumbersNegativeTest(CustomArray array, CustomArray expected) {
        try {
            CustomArray actual = selectService.selectPrimeNumbers(array);
            assertNotEquals(actual, expected, "selectPrimeNumbersNegativeTest failed as...");
        } catch (IncorrectValueException e) {
            fail(e.getMessage());
        }
    }

    @DataProvider(name = "selectPrimeNumbersExceptionData")
    public Object[][] selectPrimeNumbersExceptionData() {
        return new Object[][]{
                {new CustomArray(new int[]{})},
                {null}
        };
    }

    @Test(dataProvider = "selectPrimeNumbersExceptionData", expectedExceptions = IncorrectValueException.class)
    public void selectPrimeNumbersExceptionTest(CustomArray array) throws IncorrectValueException {
        selectService.selectPrimeNumbers(array);
    }

    @DataProvider(name = "selectFibonacciNumbersPositiveData")
    public Object[][] selectFibonacciNumbersPositiveData() {
        return new Object[][]{
                {new CustomArray(new int[]{1, 2, 3, 4, 5, 6, 7}),
                        new CustomArray(new int[]{1, 2, 3, 5})},
                {new CustomArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8}),
                        new CustomArray(new int[]{1, 2, 3, 5, 8})}
        };
    }

    @Test(dataProvider = "selectFibonacciNumbersPositiveData")
    public void selectFibonacciNumbersPositiveTest(CustomArray array, CustomArray expectedArray) {
        try {
            CustomArray actual = selectService.selectFibonacciNumbers(array);
            assertEquals(actual, expectedArray, "selectFibonacciNumbersPositiveTest failed as...");
        } catch (IncorrectValueException e) {
            fail(e.getMessage());
        }
    }

    @DataProvider(name = "selectFibonacciNumbersNegativeData")
    public Object[][] selectFibonacciNumbersNegativeData() {
        return new Object[][]{
                {new CustomArray(new int[]{1}),
                        new CustomArray(new int[]{1, 2, 3, 5})},
                {new CustomArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8}),
                        new CustomArray(new int[]{1, 2, 3, 5})}
        };
    }

    @Test(dataProvider = "selectFibonacciNumbersNegativeData")
    public void selectFibonacciNumbersNegativeTest(CustomArray array, CustomArray expectedArray) {
        try {
            CustomArray actual = selectService.selectFibonacciNumbers(array);
            assertNotEquals(actual, expectedArray, "selectFibonacciNumbersNegativeTest failed as...");
        } catch (IncorrectValueException e) {
            fail(e.getMessage());
        }
    }

    @DataProvider(name = "selectFibonacciNumbersExceptionData")
    public Object[][] selectFibonacciNumbersExceptionData() {
        return new Object[][]{
                {null},
                {new CustomArray(new int[]{})}
        };
    }

    @Test(dataProvider = "selectFibonacciNumbersExceptionData", expectedExceptions = IncorrectValueException.class)
    public void selectFibonacciNumbersExceptionTest(CustomArray array) throws IncorrectValueException {
        selectService.selectFibonacciNumbers(array);
    }

    @DataProvider(name = "selectNumbersWithThreeUniqueDigitsPositiveData")
    public Object[][] selectNumbersWithThreeUniqueDigitsPositiveData() {
        return new Object[][]{
                {new CustomArray(new int[]{154, 222, 345, 4, 7}),
                        new CustomArray(new int[]{154, 345})},
                {new CustomArray(new int[]{1, 2, 3, 4, 5}),
                        new CustomArray(new int[]{})}
        };
    }

    @Test(dataProvider = "selectNumbersWithThreeUniqueDigitsPositiveData")
    public void selectNumbersWithThreeUniqueDigitsPositiveTest(CustomArray array, CustomArray expectedArray) {
        try {
            CustomArray actual = selectService.selectNumbersWithThreeUniqueDigits(array);
            assertEquals(actual, expectedArray, "selectNumbersWithThreeUniqueDigitsPositiveTest failed as...");
        } catch (IncorrectValueException e) {
            fail(e.getMessage());
        }
    }

    @DataProvider(name = "selectNumbersWithThreeUniqueDigitsNegativeData")
    public Object[][] selectNumbersWithThreeUniqueDigitsNegativeData() {
        return new Object[][]{
                {new CustomArray(new int[]{154, 222, 345, 4, 7}),
                        new CustomArray(new int[]{154, 222, 345})},
                {new CustomArray(new int[]{1, 2, 3, 4, 5}),
                        new CustomArray(new int[]{1, 2, 3, 4, 5})},
                {new CustomArray(new int[]{1, 2, 3, 4, 5}),
                        new CustomArray(new int[]{-1})}
        };
    }

    @Test(dataProvider = "selectNumbersWithThreeUniqueDigitsNegativeData")
    public void selectNumbersWithThreeUniqueDigitsNegativeTest(CustomArray array, CustomArray expectedArray) {
        try {
            CustomArray actual = selectService.selectNumbersWithThreeUniqueDigits(array);
            assertNotEquals(actual, expectedArray, "selectNumbersWithThreeUniqueDigitsNegativeTest failed as...");
        } catch (IncorrectValueException e) {
            fail(e.getMessage());
        }
    }

    @DataProvider(name = "selectNumbersWithThreeUniqueDigitsExceptionData")
    public Object[][] selectNumbersWithThreeUniqueDigitsExceptionData() {
        return new Object[][]{
                {null},
                {new CustomArray(new int[]{})}
        };
    }

    @Test(dataProvider = "selectNumbersWithThreeUniqueDigitsExceptionData", expectedExceptions = IncorrectValueException.class)
    public void selectNumbersWithThreeUniqueDigitsExceptionTest(CustomArray array) throws IncorrectValueException {
        selectService.selectFibonacciNumbers(array);
    }
}