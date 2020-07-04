package test.traulko.task4_1.service;

import com.traulko.task4_1.entity.CustomArray;
import com.traulko.task4_1.exception.IncorrectValueException;
import com.traulko.task4_1.service.SearchService;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SearchServiceTest {
    SearchService searchService;

    @BeforeMethod
    public void setUp() {
        searchService = new SearchService();
    }

    @AfterMethod
    public void tearDown() {
        searchService = null;
    }

    @DataProvider(name = "binarySearchPositiveData")
    @Test
    public Object[][] binarySearchPositiveData() {
        return new Object[][]{
                {new CustomArray(new int[]{1, 2, 3, 4}),
                        3, 2},
                {new CustomArray(new int[]{1, 2, 3}),
                        1, 0},
                {new CustomArray(new int[]{1, 2, 3, 4, 5}),
                        4, 3}
        };
    }

    @Test(dataProvider = "binarySearchPositiveData")
    public void binarySearchPositiveTest(CustomArray array, int number, int expectedIndex) {
        try {
            int actual = searchService.binarySearch(array, number);
            assertEquals(actual, expectedIndex, "binarySearchPositiveTest failed as...");
        } catch (IncorrectValueException e) {
            fail(e.getMessage());
        }
    }

    @DataProvider(name = "binarySearchNegativeData")
    @Test
    public Object[][] binarySearchNegativeData() {
        return new Object[][]{
                {new CustomArray(new int[]{1, 2, 3, 4}),
                        3, -1},
                {new CustomArray(new int[]{1, 2, 3}),
                        1, 4},
                {new CustomArray(new int[]{1, 2, 3, 4, 5}),
                        4, 0}
        };
    }

    @Test(dataProvider = "binarySearchNegativeData")
    public void binarySearchNegativeTest(CustomArray array, int number, int expectedIndex) {
        try {
            int actual = searchService.binarySearch(array, number);
            assertNotEquals(actual, expectedIndex, "binarySearchNegativeTest failed as...");
        } catch (IncorrectValueException e) {
            fail(e.getMessage());
        }
    }

    @DataProvider(name = "binarySearchExceptionData")
    @Test
    public Object[][] binarySearchExceptionData() {
        return new Object[][]{
                {new CustomArray(new int[]{}), 5},
                {null, 5}
        };
    }

    @Test(dataProvider = "binarySearchExceptionData", expectedExceptions = IncorrectValueException.class)
    public void binarySearchExceptionTest(CustomArray array, int number) throws IncorrectValueException {
        searchService.binarySearch(array, number);
    }

    @DataProvider(name = "searchMinimalElementPositiveData")
    @Test
    public Object[][] searchMinimalElementPositiveData() {
        return new Object[][]{
                {new CustomArray(new int[]{1, 2, 3, -5}), -5},
                {new CustomArray(new int[]{0, -6, 10}), -6},
                {new CustomArray(new int[]{65}), 65}
        };
    }

    @Test(dataProvider = "searchMinimalElementPositiveData")
    public void searchMinimalElementPositiveTest(CustomArray array, int expectedMinElement) {
        try {
            int actual = searchService.searchMinimalElement(array);
            assertEquals(actual, expectedMinElement, "searchMinimalElementPositiveTest failed as...");
        } catch (IncorrectValueException e) {
            fail(e.getMessage());
        }
    }

    @DataProvider(name = "searchMinimalElementNegativeData")
    @Test
    public Object[][] searchMinimalElementNegativeData() {
        return new Object[][]{
                {new CustomArray(new int[]{1, 2, 3, -5}), 5},
                {new CustomArray(new int[]{0, -6, 10}), 0},
                {new CustomArray(new int[]{65}), 0}
        };
    }

    @Test(dataProvider = "searchMinimalElementNegativeData")
    public void searchMinimalElementNegativeTest(CustomArray array, int expectedMinElement) {
        try {
            int actual = searchService.searchMinimalElement(array);
            assertNotEquals(actual, expectedMinElement, "searchMinimalElementNegativeTest failed as...");
        } catch (IncorrectValueException e) {
            fail(e.getMessage());
        }
    }

    @DataProvider(name = "searchMinimalElementExceptionData")
    @Test
    public Object[][] searchMinimalElementExceptionData() {
        return new Object[][]{
                {new CustomArray(new int[]{})},
                {null}
        };
    }

    @Test(dataProvider = "searchMinimalElementExceptionData", expectedExceptions = IncorrectValueException.class)
    public void searchMinimalElementExceptionTest(CustomArray array) throws IncorrectValueException {
        searchService.searchMinimalElement(array);
    }

    @DataProvider(name = "searchMaximalElementPositiveData")
    @Test
    public Object[][] searchMaximalElementPositiveData() {
        return new Object[][]{
                {new CustomArray(new int[]{1, 2, 3, -5}), 3},
                {new CustomArray(new int[]{0, -6, 10}), 10},
                {new CustomArray(new int[]{65}), 65}
        };
    }

    @Test(dataProvider = "searchMaximalElementPositiveData")
    public void searchMaximalElementPositiveTest(CustomArray array, int expectedMaxElement) {
        try {
            int actual = searchService.searchMaximalElement(array);
            assertEquals(actual, expectedMaxElement, "searchMaximalElementPositiveTest failed as...");
        } catch (IncorrectValueException e) {
            fail(e.getMessage());
        }
    }

    @DataProvider(name = "searchMaximalElementNegativeData")
    @Test
    public Object[][] searchMaximalElementNegativeData() {
        return new Object[][]{
                {new CustomArray(new int[]{1, 2, 3, -5}), 1},
                {new CustomArray(new int[]{0, -6, 10}), -6},
                {new CustomArray(new int[]{65}), 0}
        };
    }

    @Test(dataProvider = "searchMaximalElementNegativeData")
    public void searchMaximalElementNegativeTest(CustomArray array, int expectedMaxElement) {
        try {
            int actual = searchService.searchMaximalElement(array);
            assertNotEquals(actual, expectedMaxElement, "searchMaximalElementNegativeTest failed as...");
        } catch (IncorrectValueException e) {
            fail(e.getMessage());
        }
    }

    @DataProvider(name = "searchMaximalElementExceptionData")
    @Test
    public Object[][] searchMaximalElementExceptionData() {
        return new Object[][]{
                {new CustomArray(new int[]{})},
                {null}
        };
    }

    @Test(dataProvider = "searchMaximalElementExceptionData", expectedExceptions = IncorrectValueException.class)
    public void searchMaximalElementExceptionTest(CustomArray array) throws IncorrectValueException {
        searchService.searchMaximalElement(array);
    }
}