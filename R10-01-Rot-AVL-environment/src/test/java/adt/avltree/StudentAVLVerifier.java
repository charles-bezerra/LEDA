package adt.avltree;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import adt.bst.BSTNode;

public class StudentAVLVerifier {
  private AVLTree<Integer> avl;
	private BSTNode<Integer> NIL = new BSTNode<Integer>();
  private AVLTreeVerifier<Integer> avlV;

	@Before
	public void setUp() {
		avl = new AVLTreeImpl<>();
	}

  @Test
  public void testValidsAVL() {
    avl.insert(20);
    avl.insert(5);
    avl.insert(21);

    avlV = new AVLTreeVerifierImpl<Integer>(avl);
    assertTrue(avlV.isAVLTree());
  }
}
