package runner;

import orderStatistic.KLargestOrderStatisticsImpl;
import problems.FloorBinarySearchImpl;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        Integer[] array = new Integer[]{25,38,15,96,4,30,84};
        FloorBinarySearchImpl fb = new FloorBinarySearchImpl();
        System.out.println(fb.floor(array, 2));

        KLargestOrderStatisticsImpl<Integer> kl = new KLargestOrderStatisticsImpl<>();
        System.out.println(kl.getKLargest(array, 5));
    }
}
