package com.traulko.task4_1;

import com.traulko.task4_1.creator.CustomCreator;
import com.traulko.task4_1.entity.CustomArray;
import com.traulko.task4_1.exception.IncorrectValueException;
import com.traulko.task4_1.service.SearchService;
import com.traulko.task4_1.service.SelectService;

public class Main {
    public static void main(String[] args) throws IncorrectValueException {
        CustomCreator customCreator = new CustomCreator();
        CustomArray customArray = customCreator.createArrayRandom(10);
        System.out.println(customArray);
        SearchService searchService = new SearchService();
        System.out.println(searchService.searchMinimalElement(customArray));
        System.out.println(searchService.searchMaximalElement(customArray));
        SelectService selectService = new SelectService();
        CustomArray customArray1 = selectService.selectPrimeNumbers(customArray);
        System.out.println(customArray1);
        CustomArray a = new CustomArray(null);
        CustomArray b = new CustomArray(null);
        boolean c = a.equals(b);
        System.out.println(a.equals(b));
        System.out.println(selectService.selectNumbersWithThreeUniqueDigits(customArray));
        System.out.printf("%d", (int) 'g');
    }
}
