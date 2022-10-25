package adt.avltree;

import adt.bst.BSTNode;
import adt.bt.Util;

public class AVLCountAndFillImpl<T extends Comparable<T>> extends
		AVLTreeImpl<T> implements AVLCountAndFill<T> {

	private int LLcounter;
	private int LRcounter;
	private int RRcounter;
	private int RLcounter;

	public AVLCountAndFillImpl() {

	}

	@Override
	public int LLcount() {
		return LLcounter;
	}

	@Override
	public int LRcount() {
		return LRcounter;
	}

	@Override
	public int RRcount() {
		return RRcounter;
	}

	@Override
	public int RLcount() {
		return RLcounter;
	}

	@Override
	protected void rebalance(BSTNode<T> node) {
		int balance = calculateBalance(node);
		boolean isDouble = false;

		if (balance > 1) {
			if (calculateBalance((BSTNode<T>) node.getLeft()) < 0) {
				node.setLeft(Util.leftRotation((BSTNode<T>) node.getLeft()));
				isDouble = true;
			}
			BSTNode<T> pivot = Util.rightRotation(node);
			if (node.equals(root)) {
				root = pivot;
			} else {
				if (node.getParent().getData().compareTo(node.getData()) > 0) {
					node.getParent().setLeft(pivot);
				} else {
					node.getParent().setRight(pivot);
				}
			}

			if (isDouble)
				LRcounter++;
			else
				LLcounter++;
		} else if (balance < -1) {
			if (calculateBalance((BSTNode<T>) node.getRight()) > 0) {
				node.setRight(Util.rightRotation((BSTNode<T>) node.getRight()));
				isDouble = true;
			}
			BSTNode<T> pivot = Util.leftRotation(node);
			if (node.equals(root)) {
				root = pivot;
			} else {
				if (node.getParent().getData().compareTo(node.getData()) > 0) {
					node.getParent().setLeft(pivot);
				} else {
					node.getParent().setRight(pivot);
				}
			}

			if (isDouble)
				RLcounter++;
			else
				RRcounter++;
		}
	}

	public void insertWithoutBalance(T element) {
		insertWithoutBalance(element, root);
	}

	protected void insertWithoutBalance(T element, BSTNode<T> currentNode) {
		if (currentNode.isEmpty()) {
			currentNode.setData(element);
			currentNode.setLeft(new BSTNode.Builder<T>().parent(currentNode).build());
			currentNode.setRight(new BSTNode.Builder<T>().parent(currentNode).build());
		} else {
			if (currentNode.getData().compareTo(element) > 0) {
				insert(element, (BSTNode<T>) currentNode.getLeft());
			} else {
				insert(element, (BSTNode<T>) currentNode.getRight());
			}
			counterCase(currentNode);
		}
	}

	protected void counterCase(BSTNode<T> node) {
		int balance = calculateBalance(node);

		if (balance > 1) {
			if (calculateBalance((BSTNode<T>) node.getLeft()) < 0) {
				++LRcounter;
			} else {
				++LLcounter;
			}
		} else if (balance < -1) {
			if (calculateBalance((BSTNode<T>) node.getRight()) > 0) {
				++RLcounter;
			} else {
				++RRcounter;
			}
		}
	}

	@Override
	public void fillWithoutRebalance(T[] array) {
		for (T t : array) {
			insertWithoutBalance(t);
		}
	}
}
