package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	@Override
	public void insertFirst(T element) {
		DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<>();

		newNode.setData(element);
		newNode.setNext(this.head);
		newNode.setPrevious(new DoubleLinkedListNode<>());

		if (this.isEmpty()) {
			this.last = newNode;
		}

		this.head = newNode;
	}

	@Override
	public void removeFirst() {
		if (!this.getHead().isNIL()) {
			if (this.getHead().equals(this.getLast())) {
				this.head = new DoubleLinkedListNode<>();
				this.last = new DoubleLinkedListNode<>();
			} else {
				this.head = this.getHead().getNext();
			}
		}
	}

	private void removeLast(SingleLinkedListNode<T> currentNode) {
		if (!currentNode.isNIL()) {
			if (currentNode.getNext().isNIL()) {
				currentNode.setData(null);
				currentNode.setNext(new SingleLinkedListNode<>());
			} else {
				removeLast(currentNode.getNext());
			}
		}
	}

	@Override
	public void removeLast() {
		if (this.getHead().getNext().isNIL()) {
			this.head = new DoubleLinkedListNode<>();
			this.last = new DoubleLinkedListNode<>();
		} else {
			removeLast(this.head);
		}
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
