package adt.bst;

/**
 * 
 * Performs consistency validations within a BST instance
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class BSTVerifierImpl<T extends Comparable<T>> implements BSTVerifier<T> {
	
	private BSTImpl<T> bst;

	public BSTVerifierImpl(BST<T> bst) {
		this.bst = (BSTImpl<T>) bst;
	}
	
	private BSTImpl<T> getBSt() {
		return bst;
	}

	@Override
	public boolean isBST() {
		BSTNode<T> node = this.bst.root;
		return isBST(node);
	}

	private boolean isBST(BSTNode<T> node) {
		if (!node.getLeft().isEmpty() || !node.getRight().isEmpty()) {
			if (!node.getLeft().isEmpty() && node.getData().compareTo(node.getLeft().getData()) < 0) {
				return false;
			}
			if (!node.getRight().isEmpty() && node.getData().compareTo(node.getRight().getData()) > 0) {
				return false;
			}

			return isBST((BSTNode<T>) node.getLeft()) && isBST((BSTNode<T>) node.getRight());
		}
		else {
			return true;
		}
	}
}
