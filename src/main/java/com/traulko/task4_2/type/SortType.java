package com.traulko.task4_2.type;

import com.traulko.task4_2.exception.IncorrectDataException;

public enum SortType {
    SUM_ELEMENT_LINE {
        public int sortMethod(int[] lines) throws IncorrectDataException {
            if (lines == null) {
                throw new IncorrectDataException("Line is null");
            }
            int sumElementLine = 0;
            for (int line : lines) {
                sumElementLine += line;
            }
            return sumElementLine;
        }
    },
    MIN_ELEMENT_LINE {
        public int sortMethod(int[] lines) throws IncorrectDataException {
            if (lines == null) {
                throw new IncorrectDataException("Line is null");
            }
            int minElementLine = lines[0];
            for (int line : lines) {
                if (line < minElementLine) {
                    minElementLine = line;
                }
            }
            return minElementLine;
        }
    },
    MAX_ELEMENT_LINE {
        public int sortMethod(int[] lines) throws IncorrectDataException {
            if (lines == null) {
                throw new IncorrectDataException("Line is null");
            }
            int maxElementLine = lines[0];
            for (int i = 0; i < lines.length; i++) {
                if (lines[i] > maxElementLine) {
                    maxElementLine = lines[i];
                }
            }
            return maxElementLine;
        }
    };

    public abstract int sortMethod(int[] lines) throws IncorrectDataException;
}
