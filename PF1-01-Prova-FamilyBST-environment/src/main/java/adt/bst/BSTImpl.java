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
		return height(this.root);
	}

	private int height(BSTNode<T> currentNode) {
		int result = -1;
		if (!currentNode.isEmpty()) {
			int left = 1 + height((BSTNode<T>) currentNode.getLeft());
			int right = 1 + height((BSTNode<T>) currentNode.getRight());

			result = Math.max(left, right);
		}
		return result;
	}

	
	@Override
	public BSTNode<T> search(T element) {
		return search(element, this.root);
	}

	private BSTNode<T> search(T element, BSTNode<T> currentNode) {
		BSTNode<T> resp = (BSTNode<T>) new BSTNode.Builder<T>().build();
		if (!currentNode.isEmpty()) {
			if (currentNode.getData().equals(element)) {
				resp = currentNode;
			} else if (currentNode.getData().compareTo(element) < 0) {
				resp = search(element, (BSTNode<T>) currentNode.getRight());
			} else {
				resp = search(element, (BSTNode<T>) currentNode.getLeft());
			}
		}
		return resp;
	}

	@Override
	public void insert(T element) {
		insert(element, this.root);
	}

	private void insert(T element, BSTNode<T> currentNode) {
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
		}
	}


	@Override
	public BSTNode<T> maximum() {
		BSTNode<T> result = null;
		if (!isEmpty()) {
			result = maximum(this.root);
		}
		return result;
	}

	private BSTNode<T> maximum(BSTNode<T> currentNode) {
		BSTNode<T> result;
		if (currentNode.getRight().isEmpty()) {
			result = currentNode;
		} else {
			result = maximum((BSTNode<T>) currentNode.getRight());
		}
		return result;
	}

	@Override
	public BSTNode<T> minimum() {
		BSTNode<T> result = null;
		if (!this.root.isEmpty()) {
			result = minimum(this.root);
		}
		return result;
	}

	private BSTNode<T> minimum(BSTNode<T> currentNode) {
		BSTNode<T> result;
		if (currentNode.getLeft().isEmpty()) {
			result = currentNode;
		} else {
			result = minimum((BSTNode<T>) currentNode.getLeft());
		}
		return result;
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		BSTNode<T> result = null;
		BSTNode<T> node = search(element);
		if (!node.isEmpty()) {
			result = sucessor(node, element);
		}
		return result;
	}

	private BSTNode<T> sucessor(BSTNode<T> currentNode, T element) {
		if (!currentNode.getRight().isEmpty()) {
			return minimum((BSTNode<T>) currentNode.getRight());
		} else {
			BSTNode<T> parent = (BSTNode<T>) currentNode.getParent();

			if (!parent.isEmpty() && parent.getRight().equals(currentNode)) {
				return sucessor(parent, element);
			} else {
				return parent;
			}
		}
	}	

	@Override
	public BSTNode<T> predecessor(T element) {
		BSTNode<T> result = null;
		BSTNode<T> node = search(element);

		if (!node.isEmpty()) {
			result = predecessor(node, element);
		}
		
		return result;
	}

	private BSTNode<T> predecessor(BSTNode<T> currentNode, T element) {
		if (!currentNode.getLeft().isEmpty()) {
			return maximum((BSTNode<T>) currentNode.getLeft());
		} else {
			return auxPredecessor(currentNode, element);
		}
	}

	private BSTNode<T> auxPredecessor(BSTNode<T> currentNode, T element) {
		BSTNode<T> parent = (BSTNode<T>) currentNode.getParent();
		if (parent != null && !parent.isEmpty() && parent.getLeft().equals(currentNode)) {
			return auxPredecessor(parent, element);
		} else {
			return parent;
		}
	}

	@Override
	public void remove(T element) {
		if (!this.root.isEmpty()) {
			BSTNode<T> node = search(element);
			remove(element, node);
		}
	}

	private void remove(T element, BSTNode<T> node) {
		if (!node.isEmpty()) {
			if (node.isLeaf()) {
				node.setData(null);
			} 
			else if (hasOneChild(node)) {
					if (node.equals(this.root.getData())) {
						if (!node.getLeft().isEmpty()) {
							this.root = (BSTNode<T>) node.getLeft();
						} else {
							this.root = (BSTNode<T>) node.getRight();
						}
					}
					else {
						if (!node.getLeft().isEmpty()) {
							node.setData(node.getLeft().getData());
							node.setRight(node.getLeft().getRight());
							node.setLeft(node.getLeft().getLeft());
						}	
						else {
							node.setData(node.getRight().getData());
							node.setLeft(node.getRight().getLeft());
							node.setRight(node.getRight().getRight());
						}
					}
			}
			else {
				BSTNode<T> sucessor = sucessor(element);
				node.setData(sucessor.getData());
				remove(sucessor.getData(), sucessor);
			}
		}
	}

	private boolean hasOneChild(BSTNode<T> node) {
		boolean result = true;
		if (!node.getLeft().isEmpty() && !node.getRight().isEmpty()) {
			result = false;
		} else if (node.getLeft().isEmpty() && node.getRight().isEmpty()) {
			result = false;
		}
		return result;
	}

	@Override
	public T[] preOrder() {
		ArrayList<T> result = new ArrayList<>();
		preOrder(this.root, result);
		return (T[]) result.toArray(new Comparable[0]);
	}

	private void preOrder(BSTNode<T> currentNode, ArrayList<T> arraylist) {
		if (!currentNode.isEmpty()) {
			arraylist.add(currentNode.getData());
			preOrder((BSTNode<T>) currentNode.getLeft(), arraylist);
			preOrder((BSTNode<T>) currentNode.getRight(), arraylist);
		}
	}

	@Override
	public T[] order() {
		ArrayList<T> result = new ArrayList<>();
		order(this.root, result);
		return (T[]) result.toArray(new Comparable[0]);
	}

	private void order(BSTNode<T> currentNode, ArrayList<T> arraylist) {
		if (!currentNode.isEmpty()) {
			order((BSTNode<T>) currentNode.getLeft(), arraylist);
			arraylist.add(currentNode.getData());
			order((BSTNode<T>) currentNode.getRight(), arraylist);
		}
	}

	@Override
	public T[] postOrder() {
		ArrayList<T> result = new ArrayList<>();
		postOrder(this.root, result);
		return (T[]) result.toArray(new Comparable[0]);
	}

	private void postOrder(BSTNode<T> currentNode, ArrayList<T> arraylist) {
		if (!currentNode.isEmpty()) {
			postOrder((BSTNode<T>) currentNode.getLeft(), arraylist);
			postOrder((BSTNode<T>) currentNode.getRight(), arraylist);
			arraylist.add(currentNode.getData());
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
