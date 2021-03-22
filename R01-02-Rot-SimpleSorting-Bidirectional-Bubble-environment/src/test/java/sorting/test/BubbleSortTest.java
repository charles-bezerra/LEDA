package sorting.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sorting.simpleSorting.BubbleSort;

import java.util.Arrays;

public class BubbleSortTest {
    BubbleSort<Integer> bubbleSort;
    Integer[] arrayTrivial;

    Integer[] array1Desordenade;
    Integer[] array1Ordenade;

    Integer[] array2DesordenadeR;
    Integer[] array2OrdenadeR;


    @Before
    public void initObjects (){
        bubbleSort = new BubbleSort<>();
        arrayTrivial = new Integer[] {1};

        array1Desordenade = new Integer[] {2,0,1,4,5,6,8,10,9};
        array1Ordenade = new Integer[] {0,1,2,4,5,6,8,9,10};

        array2DesordenadeR = new Integer[] {1,0,0,10,2,3,9,8,3};
        array2OrdenadeR = new Integer[] {0,0,1,2,3,3,8,9,10};
    }

    @Test
    public void TrivialTest () {
        try {
            bubbleSort.sort(arrayTrivial);
        }
        catch (Exception e) {
            throw new IllegalArgumentException("Array deveria ser o mesmo!");
        }
    }

    @Test
    public void sort1Test () {
        bubbleSort.sort(array1Desordenade);
        Assert.assertArrayEquals(array1Ordenade, array1Desordenade);
    }

    @Test
    public void sort2Test () {
        bubbleSort.sort(array2DesordenadeR);
        Assert.assertArrayEquals(array2DesordenadeR, array2OrdenadeR);
    }
}
