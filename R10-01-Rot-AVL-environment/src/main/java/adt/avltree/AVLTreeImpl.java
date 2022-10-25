package adt.avltree;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.Util;

/**
 * 
 * Implementacao de uma arvore AVL
 * A CLASSE AVLTree herda de BSTImpl. VOCE PRECISA SOBRESCREVER A IMPLEMENTACAO
 * DE BSTIMPL RECEBIDA COM SUA IMPLEMENTACAO "OU ENTAO" IMPLEMENTAR OS SEGUITNES
 * METODOS QUE SERAO TESTADOS NA CLASSE AVLTREE:
 * - insert
 * - preOrder
 * - postOrder
 * - remove
 * - height
 * - size
 *
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class AVLTreeImpl<T extends Comparable<T>> extends BSTImpl<T> implements
		AVLTree<T> {

	// TODO Do not forget: you must override the methods insert and remove
	// conveniently.

	@Override
	protected void insert(T element, BSTNode<T> currentNode) {
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
			rebalance(currentNode);
		}
	}

	@Override
	protected void remove(T element, BSTNode<T> node) {
		if (!node.isEmpty()) {
			if (node.isLeaf()) {
				node.setData(null);
				rebalanceUp(node);
			} else if (hasOneChild(node)) {
				if (node.getData().equals(root.getData())) {
					if (!node.getLeft().isEmpty()) {
						this.root = (BSTNode<T>) node.getLeft();
					} else {
						this.root = (BSTNode<T>) node.getRight();
					}
				} else {
					if (!node.getLeft().isEmpty()) {
						node.setData(node.getLeft().getData());
						node.setRight(node.getLeft().getRight());
						node.setLeft(node.getLeft().getLeft());
					} else {
						node.setData(node.getRight().getData());
						node.setLeft(node.getRight().getLeft());
						node.setRight(node.getRight().getRight());
					}
				}
				rebalanceUp(node);
			} else {
				BSTNode<T> sucessor = sucessor(element);
				node.setData(sucessor.getData());
				remove(sucessor.getData(), sucessor);
			}
		}
	}

	public boolean isBalanced() {
		return Math.sqrt(calculateBalance(this.root)) <= 1;
	}

	// AUXILIARY
	protected int calculateBalance(BSTNode<T> node) {
		return height((BSTNode<T>) node.getLeft()) - height((BSTNode<T>) node.getRight());
	}

	// AUXILIARY
	protected void rebalance(BSTNode<T> node) {
		int balance = calculateBalance(node);

		if (balance > 1) {
			if (calculateBalance((BSTNode<T>) node.getLeft()) < 0) {
				node.setLeft(Util.leftRotation((BSTNode<T>) node.getLeft()));
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
		} else if (balance < -1) {
			if (calculateBalance((BSTNode<T>) node.getRight()) > 0) {
				node.setRight(Util.rightRotation((BSTNode<T>) node.getRight()));
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
		}
	}

	// AUXILIARY
	protected void rebalanceUp(BSTNode<T> node) {
		rebalance((BSTNode<T>) node);
		if (node.getParent() != null && !node.getParent().isEmpty()) {
			rebalanceUp((BSTNode<T>) node.getParent());
		}
	}
}
