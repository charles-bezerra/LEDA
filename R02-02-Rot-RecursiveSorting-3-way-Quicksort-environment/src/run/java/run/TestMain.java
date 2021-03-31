package run;

import sorting.divideAndConquer.MergeSort;

import java.util.Arrays;

public class TestMain {

    public static void main(String[]args){
        Integer[] array = new Integer[] {10,13,4,5,2,5,6,1,2};
        MergeSort<Integer> ms = new MergeSort<Integer>();
        ms.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
