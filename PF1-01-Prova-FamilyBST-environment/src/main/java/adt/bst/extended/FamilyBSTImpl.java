package adt.bst.extended;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

public class FamilyBSTImpl<T extends Comparable<T>> extends BSTImpl<T> implements FamilyBST<T>{	
	public BSTNode<T> getGrandParent(BSTNode<T> node) {
		BSTNode<T> result = null;

		if (!node.getParent().isEmpty() && !node.getParent().getParent().isEmpty()) {
			result = (BSTNode<T>) node.getParent().getParent();
		}

		return result;
	}


	@Override
	public boolean primosPrimeiroGrau(T elem1, T elem2) {
		boolean result = false;
		BSTNode<T> node1 = search(elem1);
		BSTNode<T> node2 = search(elem2);

		BSTNode<T> grandParent1 = getGrandParent(node1);
		BSTNode<T> grandParent2 = getGrandParent(node2);

		BSTNode<T> parent1 = (BSTNode<T>) node1.getParent();
		BSTNode<T> parent2 = (BSTNode<T>) node2.getParent();

		if (grandParent1 != null && grandParent2 != null) {
			return !parent1.getData().equals(parent2.getData()) && grandParent1.getData().equals(grandParent2.getData());
		}

		return result;
	}


	@Override
	public boolean primosSegundoGrau(T elem1, T elem2) {
		boolean result = false;
		BSTNode<T> node1 = search(elem1);
		BSTNode<T> node2 = search(elem2);

		BSTNode<T> parent1 = (BSTNode<T>) node1.getParent();
		BSTNode<T> parent2 = (BSTNode<T>) node2.getParent();

		if (!parent1.isEmpty() && !parent2.isEmpty()) {
			result = primosPrimeiroGrau(parent1.getData(), parent2.getData());
		}

		return result;
	}
	
	
	/**
	 * NAO ALTERAR OS METODOS ABAIXO PORQUE SERAO UTULIZADOS PELOS TESTES
	 */
	@Override
	public void insert(T element) {
		insert(root, element);
	}

	protected void insert(BSTNode<T> node, T element) {
		if (node.isEmpty()) {
			node.setData(element);
			node.setLeft(new BSTNode<T>());
			node.getLeft().setParent(node);
			node.setRight(new BSTNode<T>());
			node.getRight().setParent(node);
		} else {
			if (element.compareTo(node.getData()) < 0) {
				insert((BSTNode<T>)node.getLeft(), element);
			} else if (element.compareTo(node.getData()) > 0) {
				insert((BSTNode<T>)node.getRight(), element);
			}
		}
	}
	
	@Override
	public BSTNode<T> search(T element) {
		return search(root, element);
	}

	protected BSTNode<T> search(BSTNode<T> node, T element) {
		BSTNode<T> result = node;
		if (element != null) {
			if (!node.isEmpty()) {
				if (element.compareTo(node.getData()) == 0) {
					result = node;
				} else if (element.compareTo(node.getData()) < 0) {
					result = search((BSTNode<T>)node.getLeft(), element);
				} else {
					result = search((BSTNode<T>)node.getRight(), element);
				}
			}
		}

		return result;
	}
}
