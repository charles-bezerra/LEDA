package main;

import sorting.simpleSorting.InsertionSort;

public class Tester {
    public static void main (String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(new Integer[]{4,10,1,9,2,4,5,3,7,8});
    }
}
