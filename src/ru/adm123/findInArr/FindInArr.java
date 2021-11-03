package ru.adm123.findInArr;

import java.util.Arrays;

/**
 * @author Dmitry Ushakov at 03.11.2021
 */
public class FindInArr {

    private static final int[] testArr = {1,2,3,-6,3,-3,-4,-5,-6,-7};

    public static void main(String[] args) {
        printZeroSumParts(testArr);
    }

    public static int arraySum(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException();
        }
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }

    public static int[] getSubArray(int[] arr, int firstIndex, int lastIndex) {
        if (arr == null || lastIndex < firstIndex || firstIndex < 0) {
            throw new IllegalArgumentException();
        }
        int[] destArr = new int[lastIndex - firstIndex];
        System.arraycopy(arr, firstIndex, destArr, 0, lastIndex - firstIndex);
        return destArr;
    }

    public static void printZeroSumParts(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException();
        }
        if (arr.length == 1) {
            if (arr[0] == 0) {
                System.out.println(Arrays.toString(arr));
            }
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                int[] candidate = getSubArray(arr, i, j);
                if (arraySum(candidate) == 0) {
                    System.out.println(Arrays.toString(candidate));
                }
            }
        }
    }

}
