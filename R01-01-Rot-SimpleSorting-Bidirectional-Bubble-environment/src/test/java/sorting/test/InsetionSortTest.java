package sorting.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sorting.AbstractSorting;
import sorting.simpleSorting.InsertionSort;

public class InsetionSortTest {  private Integer[] vetorDesordenado1;
    private Integer[] vetorDesordenado2;
    private Integer[] vetorDesordenado3;
    private Integer[] vetorOrdenado;
    private Integer[] vetorVazio = {};

    public AbstractSorting<Integer> implementation;

    @Before
    public void setUp() {
        implementation = new InsertionSort<>();
        vetorDesordenado1 = new Integer[]{2, 11, 3, 1, 1, 3, 40, 4, 2, 100, 20};
        vetorDesordenado2 = new Integer[]{200, 11, 3, 1, 1, 3, 40, 4, 2, 100, 0};
        vetorDesordenado3 = new Integer[]{2, 1, 3, 0, 5, 3, 40, 4, 2, 100, 20, 2};
        vetorOrdenado = new Integer[]{1,2,3,4,5};
    }

//    @Test
//    public void TesteComValoresDesordenados1 () {
//        implementation.sort(vetorDesordenado1);
//        Assert.assertArrayEquals(new Integer[]{1,1,2,2,3,3,4,11,20,40,100}, vetorDesordenado1);
//    }
//
//    @Test
//    public void TesteComValoresDesordenados2 () {
//        implementation.sort(vetorDesordenado2);
//        Assert.assertArrayEquals(new Integer[]{0,1,1,2,3,3,4,11,40,100,200}, vetorDesordenado2);
//    }
//
//    @Test
//    public void TesteComValoresDesordenados3 () {
//        implementation.sort(vetorDesordenado3);
//        Assert.assertArrayEquals(new Integer[]{0,1,2,2,2,3,3,4,5,20,40,100}, vetorDesordenado3);
//    }

    @Test
    public void TestComValoresOrdenados () {
        implementation.sort(vetorOrdenado);
        Assert.assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, vetorOrdenado);
    }
}
