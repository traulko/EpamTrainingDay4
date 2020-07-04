package test.traulko.task4_2.service;

import com.traulko.task4_2.exception.IncorrectDataException;
import com.traulko.task4_2.service.JaggedArrayService;
import com.traulko.task4_2.type.SortType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class JaggedArrayServiceTest {
    JaggedArrayService jaggedArrayService;

    @BeforeMethod
    public void setUp() {
        jaggedArrayService = new JaggedArrayService();
    }

    @AfterMethod
    public void tearDown() {
        jaggedArrayService = null;
    }

    @Test
    public void bubbleSortMaxElementPositiveTest() {
        int[][] matrix = {{7}, {0, 1, 2}, {0}};
        SortType sortType = SortType.MAX_ELEMENT_LINE;
        try {
            jaggedArrayService.bubbleSort(matrix, sortType, false);
            int[][] expected = {{0}, {0, 1, 2}, {7}};
            assertTrue(isArrayEquals(matrix, expected), "bubbleSortMaxElementPositiveTest failed as...");
        } catch (IncorrectDataException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void bubbleSortMaxElementReversedPositiveTest() {
        int[][] matrix = {{7}, {0, 1, 2}, {0}};
        SortType sortType = SortType.MAX_ELEMENT_LINE;
        try {
            jaggedArrayService.bubbleSort(matrix, sortType, true);
            int[][] expected = {{7}, {0, 1, 2}, {0}};
            assertTrue(isArrayEquals(matrix, expected), "bubbleSortMaxElementReversedPositiveTest failed as...");
        } catch (IncorrectDataException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void bubbleSortMaxElementNegativeTest() {
        int[][] matrix = {{7}, {0, 1, 2}, {0}};
        SortType sortType = SortType.MAX_ELEMENT_LINE;
        try {
            jaggedArrayService.bubbleSort(matrix, sortType, false);
            int[][] expected = {{7}, {0, 1, 2}, {0}};
            assertFalse(isArrayEquals(matrix, expected), "bubbleSortMaxElementNegativeTest failed as...");
        } catch (IncorrectDataException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void bubbleSortMinElementReversedNegativeTest() {
        int[][] matrix = {{7}, {0, 1, 2}, {0}};
        SortType sortType = SortType.MIN_ELEMENT_LINE;
        try {
            jaggedArrayService.bubbleSort(matrix, sortType, true);
            int[][] expected = {{0}, {0, 1, 2}, {7}};
            assertFalse(isArrayEquals(matrix, expected), "bubbleSortMinElementReversedNegativeTest failed as...");
        } catch (IncorrectDataException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void bubbleSortMinElementPositiveTest() {
        int[][] matrix = {{7}, {1, 2, 3}, {0}};
        SortType sortType = SortType.MIN_ELEMENT_LINE;
        try {
            jaggedArrayService.bubbleSort(matrix, sortType, false);
            int[][] expected = {{0}, {1, 2, 3}, {7}};
            assertTrue(isArrayEquals(matrix, expected), "bubbleSortMinElementPositiveTest failed as...");
        } catch (IncorrectDataException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void bubbleSortMinElementReversedPositiveTest() {
        int[][] matrix = {{7}, {1, 2, 3}, {0}};
        SortType sortType = SortType.MIN_ELEMENT_LINE;
        try {
            jaggedArrayService.bubbleSort(matrix, sortType, true);
            int[][] expected = {{7}, {1, 2, 3}, {0}};
            assertTrue(isArrayEquals(matrix, expected), "bubbleSortMinElementReversedPositiveTest failed as...");
        } catch (IncorrectDataException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void bubbleSortMinElementNegativeTest() {
        int[][] matrix = {{7}, {1, 2, 3}, {0}};
        SortType sortType = SortType.MIN_ELEMENT_LINE;
        try {
            jaggedArrayService.bubbleSort(matrix, sortType, false);
            int[][] expected = {{7}, {1, 2, 3}, {0}};
            assertFalse(isArrayEquals(matrix, expected), "bubbleSortMinElementNegativeTest failed as...");
        } catch (IncorrectDataException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void bubbleSortMaxElementReversedNegativeTest() {
        int[][] matrix = {{7}, {0, 1, 2}, {0}};
        SortType sortType = SortType.MAX_ELEMENT_LINE;
        try {
            jaggedArrayService.bubbleSort(matrix, sortType, true);
            int[][] expected = {{0}, {0, 1, 2}, {7}};
            assertFalse(isArrayEquals(matrix, expected), "bubbleSortMaxElementReversedNegativeTest failed as...");
        } catch (IncorrectDataException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void bubbleSortSumElementPositiveTest() {
        int[][] matrix = {{7}, {1, 2, 3}, {0}};
        SortType sortType = SortType.SUM_ELEMENT_LINE;
        try {
            jaggedArrayService.bubbleSort(matrix, sortType, false);
            int[][] expected = {{0}, {1, 2, 3}, {7}};
            assertTrue(isArrayEquals(matrix, expected), "bubbleSortSumElementPositiveTest failed as...");
        } catch (IncorrectDataException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void bubbleSortSumElementReversedPositiveTest() {
        int[][] matrix = {{7}, {1, 2, 3}, {0}};
        SortType sortType = SortType.SUM_ELEMENT_LINE;
        try {
            jaggedArrayService.bubbleSort(matrix, sortType, true);
            int[][] expected = {{7}, {1, 2, 3}, {0}};
            assertTrue(isArrayEquals(matrix, expected), "bubbleSortSumElementReversedPositiveTest failed as...");
        } catch (IncorrectDataException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void bubbleSortSumElementNegativeTest() {
        int[][] matrix = {{7}, {1, 2, 3}, {0}};
        SortType sortType = SortType.SUM_ELEMENT_LINE;
        try {
            jaggedArrayService.bubbleSort(matrix, sortType, false);
            int[][] expected = {{7}, {1, 2, 3}, {0}};
            assertFalse(isArrayEquals(matrix, expected), "bubbleSortSumElementNegativeTest failed as...");
        } catch (IncorrectDataException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void bubbleSortSumElementReversedNegativeTest() {
        int[][] matrix = {{7}, {0, 1, 2}, {0}};
        SortType sortType = SortType.SUM_ELEMENT_LINE;
        try {
            jaggedArrayService.bubbleSort(matrix, sortType, true);
            int[][] expected = {{0}, {0, 1, 2}, {7}};
            assertFalse(isArrayEquals(matrix, expected), "bubbleSortSumElementReversedNegativeTest failed as...");
        } catch (IncorrectDataException e) {
            fail(e.getMessage());
        }
    }

    private boolean isArrayEquals(int[][] intArrayActual, int[][] intArrayExpected) {
        boolean isEquals = true;
        if (intArrayActual.length != intArrayExpected.length) {
            isEquals = false;
        } else {
            for (int i = 0; i < intArrayActual.length; i++) {
                if (intArrayActual[i].length != intArrayExpected[i].length) {
                    isEquals = false;
                    break;
                }
            }
        }
        if (isEquals) {
            for (int i = 0; i < intArrayActual.length; i++) {
                for (int j = 0; j < intArrayActual[i].length; j++) {
                    if (intArrayActual[i][j] != intArrayExpected[i][j]) {
                        isEquals = false;
                        break;
                    }
                }
            }
        }
        return isEquals;
    }
}