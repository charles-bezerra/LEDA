package adt.bst;

import adt.bt.BTNode;

/**
 * - Esta eh a unica classe que pode ser modificada
 * 
 * @author adalbertocajueiro
 *
 * @param <T>
 */
public class SimpleBSTManipulationImpl<T extends Comparable<T>> implements SimpleBSTManipulation<T> {

	private boolean equals(BTNode<T> btNode1, BTNode<T> btNode2) {
		boolean result = true;

		if (btNode1.isEmpty() && btNode2.isEmpty()) {
			result = true;
		} else if (!btNode1.isEmpty() && !btNode2.isEmpty()) {
			if (btNode1.equals(btNode2)) {
				result = equals(btNode1.getLeft(), btNode2.getLeft()) && equals(btNode2.getRight(), btNode2.getRight());
			} else {
				result = false;
			}
		} else {
			result = false;
		}

		return result;
	}

	@Override
	public boolean equals(BST<T> tree1, BST<T> tree2) {
		return equals(tree1.getRoot(), tree2.getRoot());
	}

	private boolean isSimilar(BTNode<T> btNode, BTNode<T> btNode2) {
		if (btNode.isEmpty() && btNode2.isEmpty()) {
			return true;
		} else if (!btNode.isEmpty() && !btNode2.isEmpty()) {
			return isSimilar(btNode.getLeft(), btNode2.getLeft()) && isSimilar(btNode2.getRight(), btNode2.getRight());
		} else {
			return false;
		}
	}

	@Override
	public boolean isSimilar(BST<T> tree1, BST<T> tree2) {
		boolean result = true;

		if (tree1.height() != tree2.height()) {
			result = false;
		} else {
			result = isSimilar(tree1.getRoot(), tree2.getRoot());
		}

		return result;
	}

	@Override
	public T orderStatistic(BST<T> tree, int k) {
		T result = null;
		if (k <= tree.size()) {
			if (k == 1) {
				result = tree.maximum().getData();
			} else if (k == tree.size()) {
				result = tree.maximum().getData();
			} else {
				result = tree.order()[k - 1];
			}
		}

		return result;
	}
}
