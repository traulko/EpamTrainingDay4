package test.traulko.task4_1.service;

import com.traulko.task4_1.entity.CustomArray;
import com.traulko.task4_1.exception.IncorrectValueException;
import com.traulko.task4_1.service.SortService;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SortServiceTest {
    SortService sortService;

    @BeforeMethod
    public void setUp() {
        sortService = new SortService();
    }

    @AfterMethod
    public void tearDown() {
        sortService = null;
    }

    @DataProvider(name = "bubbleSortPositiveData")
    @Test
    public Object[][] bubbleSortPositiveData() {
        return new Object[][]{
                {new CustomArray(new int[]{5, 3, 4, 2}), false,
                        new CustomArray(new int[]{2, 3, 4, 5})},
                {new CustomArray(new int[]{5, 3, 4, 2}), true,
                        new CustomArray(new int[]{5, 4, 3, 2})},
                {new CustomArray(new int[]{1}), false,
                        new CustomArray(new int[]{1})}
        };
    }

    @Test(dataProvider = "bubbleSortPositiveData")
    public void bubbleSortPositiveTest(CustomArray array, boolean isReverse, CustomArray excepted) {
        try {
            sortService.bubbleSort(array, isReverse);
            assertEquals(array, excepted, "bubbleSortPositiveTest failed as...");
        } catch (IncorrectValueException e) {
            fail(e.getMessage());
        }
    }

    @DataProvider(name = "bubbleSortNegativeData")
    @Test
    public Object[][] bubbleSortNegativeData() {
        return new Object[][]{
                {new CustomArray(new int[]{5, 3, 4, 2}), true,
                        new CustomArray(new int[]{2, 3, 4, 5})},
                {new CustomArray(new int[]{5, 3, 4, 2}), false,
                        new CustomArray(new int[]{5, 4, 3, 2})},
                {new CustomArray(new int[]{1}), false,
                        new CustomArray(new int[]{1, 2})}
        };
    }

    @Test(dataProvider = "bubbleSortNegativeData")
    public void bubbleSortNegativeTest(CustomArray array, boolean isReverse, CustomArray excepted) {
        try {
            sortService.bubbleSort(array, isReverse);
            assertNotEquals(array, excepted, "bubbleSortNegativeTest failed as...");
        } catch (IncorrectValueException e) {
            fail(e.getMessage());
        }
    }

    @DataProvider(name = "bubbleSortExceptionData")
    public Object[][] bubbleSortExceptionData() {
        return new Object[][]{
                {null, false},
                {new CustomArray(new int[]{}), false}
        };
    }

    @Test(dataProvider = "bubbleSortExceptionData", expectedExceptions = IncorrectValueException.class)
    public void bubbleSortExceptionTest(CustomArray array, boolean isReverse) throws IncorrectValueException {
        sortService.bubbleSort(array, isReverse);
    }

    @DataProvider(name = "selectionSortPositiveData")
    @Test
    public Object[][] selectionSortPositiveData() {
        return new Object[][]{
                {new CustomArray(new int[]{5, 3, 4, 2}), false,
                        new CustomArray(new int[]{2, 3, 4, 5})},
                {new CustomArray(new int[]{5, 3, 4, 2}), true,
                        new CustomArray(new int[]{5, 4, 3, 2})},
                {new CustomArray(new int[]{1}), false,
                        new CustomArray(new int[]{1})}
        };
    }

    @Test(dataProvider = "selectionSortPositiveData")
    public void selectionSortPositiveTest(CustomArray array, boolean isReverse, CustomArray excepted) {
        try {
            sortService.selectionSort(array, isReverse);
            assertEquals(array, excepted, "selectionSortPositiveTest failed as...");
        } catch (IncorrectValueException e) {
            fail(e.getMessage());
        }
    }

    @DataProvider(name = "selectionSortNegativeData")
    @Test
    public Object[][] selectionSortNegativeData() {
        return new Object[][]{
                {new CustomArray(new int[]{5, 3, 4, 2}), true,
                        new CustomArray(new int[]{2, 3, 4, 5})},
                {new CustomArray(new int[]{5, 3, 4, 2}), false,
                        new CustomArray(new int[]{5, 4, 3, 2})},
                {new CustomArray(new int[]{1}), false,
                        new CustomArray(new int[]{1, 2})}
        };
    }

    @Test(dataProvider = "selectionSortNegativeData")
    public void selectionSortNegativeTest(CustomArray array, boolean isReverse, CustomArray excepted) {
        try {
            sortService.selectionSort(array, isReverse);
            assertNotEquals(array, excepted, "selectionSortNegativeTest failed as...");
        } catch (IncorrectValueException e) {
            fail(e.getMessage());
        }
    }

    @DataProvider(name = "selectionSortExceptionData")
    public Object[][] selectionSortExceptionData() {
        return new Object[][]{
                {null, false},
                {new CustomArray(new int[]{}), false}
        };
    }

    @Test(dataProvider = "selectionSortExceptionData", expectedExceptions = IncorrectValueException.class)
    public void selectionSortExceptionTest(CustomArray array, boolean isReverse) throws IncorrectValueException {
        sortService.selectionSort(array, isReverse);
    }

    @DataProvider(name = "insertionSortPositiveData")
    @Test
    public Object[][] insertionSortPositiveData() {
        return new Object[][]{
                {new CustomArray(new int[]{5, 3, 4, 2}), false,
                        new CustomArray(new int[]{2, 3, 4, 5})},
                {new CustomArray(new int[]{5, 3, 4, 2}), true,
                        new CustomArray(new int[]{5, 4, 3, 2})},
                {new CustomArray(new int[]{1}), false,
                        new CustomArray(new int[]{1})}
        };
    }

    @Test(dataProvider = "insertionSortPositiveData")
    public void insertionSortPositiveTest(CustomArray array, boolean isReverse, CustomArray excepted) {
        try {
            sortService.selectionSort(array, isReverse);
            assertEquals(array, excepted, "insertionSortPositiveTest failed as...");
        } catch (IncorrectValueException e) {
            fail(e.getMessage());
        }
    }

    @DataProvider(name = "insertionSortNegativeData")
    @Test
    public Object[][] insertionSortNegativeData() {
        return new Object[][]{
                {new CustomArray(new int[]{5, 3, 4, 2}), true,
                        new CustomArray(new int[]{2, 3, 4, 5})},
                {new CustomArray(new int[]{5, 3, 4, 2}), false,
                        new CustomArray(new int[]{5, 4, 3, 2})},
                {new CustomArray(new int[]{1}), false,
                        new CustomArray(new int[]{1, 2})}
        };
    }

    @Test(dataProvider = "insertionSortNegativeData")
    public void insertionSortNegativeTest(CustomArray array, boolean isReverse, CustomArray excepted) {
        try {
            sortService.insertionSort(array, isReverse);
            assertNotEquals(array, excepted, "insertionSortNegativeTest failed as...");
        } catch (IncorrectValueException e) {
            fail(e.getMessage());
        }
    }

    @DataProvider(name = "insertionSortExceptionData")
    public Object[][] insertionSortExceptionData() {
        return new Object[][]{
                {null, false},
                {new CustomArray(new int[]{}), false}
        };
    }

    @Test(dataProvider = "insertionSortExceptionData", expectedExceptions = IncorrectValueException.class)
    public void insertionSortExceptionTest(CustomArray array, boolean isReverse) throws IncorrectValueException {
        sortService.insertionSort(array, isReverse);
    }
}