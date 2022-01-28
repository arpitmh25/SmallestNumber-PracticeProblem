package com.bridgelabz.practiceproblem;

import java.util.ArrayList;

public class SmallestNumberOrder2 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        ArrayList result = getSmallestNumberFromArray(array);
        System.out.println(result);
    }

    public static ArrayList<Integer> finalArray = new ArrayList<>();

    private static ArrayList getSmallestNumberFromArray(int[] array) {
        int smallestInArray = getSmallest(array);
        int index = findArrayIndex(array, smallestInArray);
        finalArray.add(smallestInArray);

        for (int i = index + 1; i < array.length; i++) {
            int[] tempArray = new int[array.length - index - 1];
            for (int j = 0; j < tempArray.length; j++) {
                if (i + j != array.length)
                    tempArray[j] = array[i + j];
            }
            getSmallestNumberFromArray(tempArray);
            break;
        }
        return finalArray;
    }

    private static int findArrayIndex(int[] array, int elementInArray) {
        int len = array.length;
        int i = 0;

        while (i < len) {
            if (array[i] == elementInArray)
                return i;
            else
                i = i + 1;
        }
        return -1;
    }

    private static int getSmallest(int[] array) {
        Integer minimumNumber = Integer.MAX_VALUE;
        for (Integer i : array) {
            if (i < minimumNumber)
                minimumNumber = i;
        }
        return minimumNumber;
    }
}
