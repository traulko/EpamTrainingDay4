package com.traulko.task4_1.entity;

public class CustomArray {
    private static final int [] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    private static final int DEFAULT_CAPACITY = 10;

    private int [] array;

    public CustomArray (int [] array) {
        this.array = array;
    }

    public CustomArray() {
        this.array = new int[DEFAULT_CAPACITY];
    }

    public CustomArray(int capacity) {
        if (capacity == 0) {
            this.array = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
        }
        else if (capacity > 0) {
            this.array = new int[capacity];
        }
        else {
            this.array = new int[DEFAULT_CAPACITY];
        }
    }

    public int get(int index) {
        int result = -1;
        if (isCorrect(index)) {
            result = array[index];
        }
        return result;
    }

    public boolean isCorrect(int index) {
        boolean isCorrectIndex = index >= 0;
        boolean isBelongsArray = index < array.length;
        return isCorrectIndex && isBelongsArray;
    }

    public int length() {
        return array.length;
    }

    public boolean set(int element, int index) {
        boolean result = false;
        if (isCorrect(index)) {
            array[index] = element;
            result = true;
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CustomArray array1 = (CustomArray) o;
        if (this.array == null || array1.array == null) {
            return false;
        }
        if (array1.length() != this.length()) {
            return false;
        }
        for (int i = 0; i < this.length(); i++)
            if (this.array[i] != array1.array[i]) {
                return false;
            }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        for (int element : array) {
            result = prime * result + element;
        }
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Array{");
        sb.append("elements = ");
        for (int i = 0; i < array.length; i++) {
            sb.append(String.valueOf(array[i]));
            if (i != array.length - 1) {
                sb.append(", ");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
