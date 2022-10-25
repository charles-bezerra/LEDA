import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.lang.annotation.Target;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import orderStatistic.QuickSelect;

public class TestQuickSelect {
    private QuickSelect implementation;
    private Integer[] arrayNulo;
    private Integer[] arrayUm;
    private Integer[] arrayVazio;
    private Integer[] arrayDesordenadoPar;
    private Integer[] arrayDesordenadoImpar;
    private Integer[] arrayOrdenado;

    @Before
    public void setUp() {
        implementation = new QuickSelect<>();
        arrayVazio = new Integer[] {};
        arrayUm = new Integer[] { 10 };
        arrayDesordenadoPar = new Integer[] { 10, 2, 5, 4, 3, 1 };
        arrayDesordenadoImpar = new Integer[] { 9, 2, 1, 4, 5 };
        arrayOrdenado = new Integer[] { 1, 2, 3, 4, 5, 6 };
    }

    @Test
    public void testElementoForaDoTamanho() {
        assertEquals(null, implementation.quickSelect(arrayNulo, 1));
        assertEquals(null, implementation.quickSelect(arrayUm, 2));
        assertEquals(null, implementation.quickSelect(arrayDesordenadoPar, 7));
        assertEquals(null, implementation.quickSelect(arrayDesordenadoImpar, 6));
    }

    @Test
    public void testElementoEncontrado1() {
        assertEquals(new Integer(10), implementation.quickSelect(arrayUm, 1));

        assertEquals(new Integer(5), implementation.quickSelect(arrayDesordenadoPar, 5));
        assertEquals(new Integer(4), implementation.quickSelect(arrayDesordenadoPar, 4));
        assertEquals(new Integer(10), implementation.quickSelect(arrayDesordenadoPar, 6));

        assertEquals(new Integer(1), implementation.quickSelect(arrayDesordenadoImpar, 1));
        assertEquals(new Integer(9), implementation.quickSelect(arrayDesordenadoImpar, 5));
    }

    @Test
    public void testElementoEncontrado2() {
        assertEquals(new Integer(5), implementation.quickSelect(arrayDesordenadoPar, 5));
    }

    @Test
    public void testElementoEncontrado3() {
        assertEquals(new Integer(4), implementation.quickSelect(arrayDesordenadoPar, 4));
    }

    @Test
    public void testElementoEncontrado4() {
        assertEquals(new Integer(10), implementation.quickSelect(arrayDesordenadoPar, 6));
    }

    @Test
    public void testElementoEncontrado5Par() {
        assertEquals(new Integer(1), implementation.quickSelect(arrayOrdenado, 1));
        assertEquals(new Integer(2), implementation.quickSelect(arrayOrdenado, 2));
        assertEquals(new Integer(3), implementation.quickSelect(arrayOrdenado, 3));
        assertEquals(new Integer(4), implementation.quickSelect(arrayOrdenado, 4));
    }
}
