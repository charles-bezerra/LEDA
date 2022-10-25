package adt.bst.extended;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StudentBSTTest {

	private FamilyBSTImpl<Integer> tree;

	private void fillTree() {
		Integer[] array = { 5, 3, 10, 2, 4, 6, 11, 1, 7, 12 };
		for (int i : array) {
			tree.insert(i);
		}
	}

	@Before
	public void setUp() {
		tree = new FamilyBSTImpl<>();
	}

	@Test
	public void testPrimosPrimeiroGrau() {
		fillTree();
		assertTrue(tree.primosPrimeiroGrau(new Integer(2), new Integer(6)));
		assertTrue(tree.primosPrimeiroGrau(4, 6));

		assertFalse(tree.primosPrimeiroGrau(2,4));
		assertFalse(tree.primosPrimeiroGrau(6, 11));
		assertFalse(tree.primosPrimeiroGrau(1, 7));
	}

	@Test
	public void testPrimosSegundoGrau() {
		fillTree();
		assertTrue(tree.primosSegundoGrau(1, 7));
		assertTrue(tree.primosSegundoGrau(1, 12));
		assertFalse(tree.primosSegundoGrau(7, 12));
		assertFalse(tree.primosPrimeiroGrau(4, 12));
	}
}
