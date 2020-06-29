package test.traulko.task4_1.entity;

import com.traulko.task4_1.entity.CustomArray;
import com.traulko.task4_1.exception.IncorrectValueException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CustomArrayTest {
    @DataProvider(name = "getPositiveData")
    public Object[][] getPositiveData() throws IncorrectValueException {
        return new Object[][]{
                {new CustomArray(new int[]{1, 2}), 0, 1},
                {new CustomArray(new int[]{-1, 6 - 65}), 3, -1},
                {new CustomArray(new int[]{3, 4, 5, 6}), 3, 6},
        };
    }

    @Test(dataProvider = "getPositiveData")
    public void getPositiveTest(CustomArray array, int index, int expected) {
        int actual = array.get(index);
        assertEquals(actual, expected, "getPositiveTest failed as...");
    }

    @DataProvider(name = "getNegativeData")
    public Object[][] getNegativeData() throws IncorrectValueException {
        return new Object[][]{
                {new CustomArray(new int[]{1, 2, 3, 4}), 0, 2},
                {new CustomArray(new int[]{-1}), 2, 2},
                {new CustomArray(new int[]{3, 4, 5}), 2, -1},
        };
    }

    @Test(dataProvider = "getNegativeData")
    public void getNegativeTest(CustomArray array, int index, int expected) {
        int actual = array.get(index);
        assertNotEquals(actual, expected, "getNegativeTest failed as...");
    }

    @DataProvider(name = "setPositiveData")
    public Object[][] setPositiveData() {
        return new Object[][]{
                {new CustomArray(new int[]{1, 2, 3}), 1, 1, new CustomArray(new int[]{1, 1, 3})},
                {new CustomArray(new int[]{3, 2, 1, 0}), 0, 2, new CustomArray(new int[]{2, 2, 1, 0})},
                {new CustomArray(new int[]{2, 3, 4}), 2, 10, new CustomArray(new int[]{2, 3, 10})},
        };
    }

    @Test(dataProvider = "setPositiveData")
    public void setPositiveTest(CustomArray actual, int index, int value, CustomArray expected) {
            actual.set(value, index);
            assertEquals(actual, expected);
    }

    @DataProvider(name = "setNegativeData")
    public Object[][] setNegativeData() {
        return new Object[][]{
                {new CustomArray(new int[]{1, 2, 3}), 0, 0, new CustomArray(new int[]{1, 1, 3})},
                {new CustomArray(new int[]{3, 2, 1, 0}), -1, 0, new CustomArray(new int[]{2, 2, 1, 0})},
                {new CustomArray(new int[]{2, 3, 4}), 56, 24, new CustomArray(new int[]{2, 3, 10})},
        };
    }

    @Test(dataProvider = "setNegativeData")
    public void setNegativeTest(CustomArray actual, int index, int value, CustomArray expected) {
        actual.set(value, index);
        assertNotEquals(actual, expected);
    }

    @DataProvider(name = "equalsPositiveData")
    public Object[][] equalsPositiveData() {
        return new Object[][]{
                {new CustomArray(new int[]{1, 2, 3, 4, 5}),
                        new CustomArray(new int[]{1, 2, 3, 4, 5})},
                {new CustomArray(new int[]{1}),
                        new CustomArray(new int[]{1})},
                {new CustomArray(new int[]{}),
                        new CustomArray(new int[]{})},
        };
    }

    @Test(dataProvider = "equalsPositiveData")
    public void equalsPositiveTest(CustomArray array, CustomArray array1) {
        boolean actual = array.equals(array1);
        assertTrue(actual);
    }

    @DataProvider(name = "equalsNegativeData")
    public Object[][] equalsNegativeData() {
        return new Object[][]{
                {new CustomArray(new int[]{1, 2, 3, 4, 5}),
                        new CustomArray(new int[]{1})},
                {new CustomArray(new int[]{1}),
                        new CustomArray(new int[]{1, 2})},
                {new CustomArray(new int[]{}),
                        new CustomArray(new int[]{0})},
        };
    }

    @Test(dataProvider = "equalsNegativeData")
    public void equalsNegativeTest(CustomArray array, CustomArray array1) {
        boolean actual = array.equals(array1);
        assertFalse(actual);
    }
}