package adt.bst;

import java.util.ArrayList;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}


	@Override
	public int height() {
		return height(this.root, -1);
	}

	protected int height (BSTNode<T> node, int count) {
		if (!node.isEmpty()) {
			int countLeft = height((BSTNode<T>) node.getLeft(), count+1);
			int countRight = height((BSTNode<T>) node.getRight(), count+1);

			count = Math.max(countLeft, countRight);
		}

		return count;
	}

	@Override
	public BSTNode<T> search(T element) {
		if (isEmpty()) {
			return new BSTNode<T>();
		}
		else {
			return search(element, this.root);
		}
	}

	protected BSTNode<T> search(T element, BSTNode<T> currentNode) {
		if (!currentNode.isEmpty()) {
			int compared = currentNode.getData().compareTo(element);

			if (compared == 0) {
				return currentNode;
			}
			else if (compared > 0) {
				return search(element, (BSTNode<T>) currentNode.getLeft());
			}
			else {
				return search(element, (BSTNode<T>) currentNode.getRight());
			}
		}
		else {
			return new BSTNode<>();
		}
	}

	@Override
	public void insert(T element) {
		insert(this.root, element);
	}

	protected void insert(BSTNode<T> currentNode, T element) {
		if (currentNode.isEmpty()) {
			currentNode.setData(element);
			currentNode.setLeft(new BSTNode.Builder<T>().parent(currentNode).build());
			currentNode.setRight(new BSTNode.Builder<T>().parent(currentNode).build());
		}
		else {
			int compared = currentNode.getData().compareTo(element);

			if (compared > 0) {
				insert((BSTNode<T>) currentNode.getLeft(), element);
			}
			else {
				insert((BSTNode<T>) currentNode.getRight(), element);
			}
		}
	}

	@Override
	public BSTNode<T> maximum() {
		if (isEmpty()) {
			return null;
		}
		else {
			return maximumImpl(this.root);
		}
	}

	protected BSTNode<T> maximumImpl (BSTNode<T> node) {
		if (node.getRight().isEmpty()) {
			return node;
		}
		else {
			return maximumImpl((BSTNode<T>) node.getRight());
		}
	}

	@Override
	public BSTNode<T> minimum() {
		if (isEmpty()) {
			return null;
		}
		else {
			return minimumImpl(this.root);
		}
	}

	protected BSTNode<T> minimumImpl(BSTNode<T> node) {
		if (node.getLeft().isEmpty()) {
			return node;
		}
		else {
			return minimumImpl((BSTNode<T>) node.getLeft());
		}
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		BSTNode<T> finded = search(element);
		if (!finded.isEmpty()) {
			return minimumImpl((BSTNode<T>) finded.getRight());
		}
		else {
			return null;
		}
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		BSTNode<T> finded = search(element);

		if (!finded.isEmpty()) {
			return maximumImpl((BSTNode<T>) finded.getLeft());
		}
		else {
			return null;
		}
	}

	protected boolean hasOnlyLeftChild (BSTNode<T> node) {
		return !node.getLeft().isEmpty() && node.getRight().isEmpty();
	}

	protected boolean hasOnlyRightChild (BSTNode<T> node) {
		return node.getLeft().isEmpty() && !node.getRight().isEmpty();
	}

	@Override
	public void remove(T element) {
		BSTNode<T> node = search(element);

		if (!node.isEmpty()) {
			if (node.isLeaf()) {
				if (node.getData().equals(this.root.getData())) {
					this.root = new BSTNode<>();
				}
				else {
					if (node.getData().compareTo(node.getParent().getData()) < 0) {
						node.getParent().setLeft(new BSTNode<>());
					}
					else {
						node.getParent().setRight(new BSTNode<>());
					}
				}
			}

			else if (hasOnlyLeftChild(node)) {
				if (this.root.equals(node)) {
					this.root.setData(node.getLeft().getData());
					this.root.setParent(new BSTNode<>());
				}
				else {
					node.getParent().setLeft(node.getParent());
					if (node.getData().compareTo(node.getParent().getData()) < 0)
						node.getParent().setLeft(node.getLeft());
					else
						node.getParent().setRight(node.getLeft());
				}
			}

			else if (hasOnlyRightChild(node)) {
				if (this.root.equals(node)) {
					this.root.setData(node.getRight().getData());
					this.root.setParent(new BSTNode<>());
				}
				else {
					node.getRight().setParent(node.getParent());
					if (node.getData().compareTo(node.getParent().getData()) < 0) {
						node.getLeft().setParent(node.getRight());
					}
					else {
						node.getRight().setParent(node.getRight());
					}
				}
			}
			else {
				BSTNode<T> suc = sucessor(element);
				node.setData(suc.getData());
				remove(suc.getData());
			}

		}
	}

	@Override
	public T[] preOrder() {
		ArrayList<T> list = new ArrayList<>();
		preOrderGenerate(list, this.root);
		return (T[]) list.toArray(new Comparable[0]);
	}

	protected void preOrderGenerate(ArrayList<T> list, BSTNode<T> node) {
		if (!node.isEmpty()) {
			list.add(node.getData());
			orderGenerate(list, (BSTNode<T>) node.getLeft());
			orderGenerate(list, (BSTNode<T>) node.getRight());
		}
	}

	@Override
	public T[] order() {
		ArrayList<T> list = new ArrayList<>();
		orderGenerate(list, this.root);
		return (T[]) list.toArray(new Comparable[0]);
	}

	protected void orderGenerate(ArrayList<T> list, BSTNode<T> node) {
		if (!node.isEmpty()) {
			orderGenerate(list, (BSTNode<T>) node.getLeft());
			list.add(node.getData());
			orderGenerate(list, (BSTNode<T>) node.getRight());
		}
	}

	@Override
	public T[] postOrder() {
		ArrayList<T> list = new ArrayList<>();
		postOrderGenerate(list, this.root);
		return (T[]) list.toArray(new Comparable[0]);
	}

	protected void postOrderGenerate(ArrayList<T> list, BSTNode<T> node) {
		if (!node.isEmpty()) {
			orderGenerate(list, (BSTNode<T>) node.getLeft());
			orderGenerate(list, (BSTNode<T>) node.getRight());
			list.add(node.getData());
		}
	}

	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}

}
