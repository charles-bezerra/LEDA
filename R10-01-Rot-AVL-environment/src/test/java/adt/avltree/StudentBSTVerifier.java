package adt.avltree;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import adt.bst.BST;
import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bst.BSTVerifier;
import adt.bst.BSTVerifierImpl;

public class StudentBSTVerifier {
  private BST<Integer> bst;
	private BSTNode<Integer> NIL = new BSTNode<Integer>();
  private BSTVerifier<Integer> bstV;

	@Before
	public void setUp() {
		bst = new BSTImpl<>();
	}

  @Test
  public void testValidsBST() {
    bst.insert(20);
    bst.insert(5);
    bst.insert(21);

    bstV = new BSTVerifierImpl<Integer>(bst);
    assertTrue(bstV.isBST());
  }
}
