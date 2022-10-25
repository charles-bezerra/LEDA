package adt.bst.extended;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

/**
 * Note que esta classe estende sua implementacao de BST (BSTImpl).
 * Dependendo do design que voce use, sua BSTImpl precisa ter apenas funcionando
 * corretamente o metodo insert para que voce consiga testar esta classe.
 */
public class FloorCeilBSTImpl extends BSTImpl<Integer> implements FloorCeilBST {

	private BSTImpl<Integer> fillArray(Integer[] array) {
		BSTImpl<Integer> bst = new BSTImpl<Integer>();
		for (int i : array) {
			bst.insert(i);
		}
		return bst;
	}

	@Override
	public Integer floor(Integer[] array, double numero) {
		BSTImpl<Integer> tree = fillArray(array);
		Integer x = floor(tree.getRoot(), numero);
		if (x != null) {
			return x;
		}
		return null;
	}

	private Integer floor(BSTNode<Integer> node, double key) {
		if (node.getData() == null) {
			return null;
		}
		if (key == node.getData()) {
			return node.getData();
		}
		if (key < node.getData()) {
			return floor((BSTNode<Integer>) node.getLeft(), key);
		}

		Integer t = floor((BSTNode<Integer>) node.getRight(), key);
		if (t != null) {
			return t;
		} else {
			return node.getData();
		}
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		BSTImpl<Integer> tree = fillArray(array);
		Integer x = ceil(tree.getRoot(), numero);
		if (x != null) {
			return x;
		}
		return null;
	}

	private Integer ceil(BSTNode<Integer> node, double key) {
		if (node.getData() == null) {
			return null;
		}
		if (key == node.getData()) {
			return node.getData();
		}
		if (key > node.getData()) {
			return ceil((BSTNode<Integer>) node.getRight(), key);
		}

		Integer t = ceil((BSTNode<Integer>) node.getLeft(), key);
		if (t != null) {
			return t;
		} else {
			return node.getData();
		}
	}

}
