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
		return isBST(bst.getRoot());
	}
	
	protected boolean isBST(BSTNode<T> node) {
		boolean result = true;
		if (!node.isEmpty()) {
			boolean left = true;
			boolean right = true;
			if (!node.getLeft().isEmpty()) {
				if (node.getData().compareTo(node.getLeft().getData()) > 0) {
					left = isBST((BSTNode<T>) node.getLeft());
				} else {
					left = false;
				}
			} 
			if (!node.getRight().isEmpty()) {
				if (node.getData().compareTo(node.getRight().getData()) < 0) {
					right = isBST((BSTNode<T>) node.getRight());
				} else {
					right = false;
				}
			}

			result = left && right;
		}
		return result;
	}
}
