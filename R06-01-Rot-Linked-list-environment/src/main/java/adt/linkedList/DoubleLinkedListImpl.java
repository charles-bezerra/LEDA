package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements DoubleLinkedList<T> {
	protected DoubleLinkedListNode<T> last;

	@Override
	public void insertFirst(T element) {
		if (isEmpty()) {
			this.setLast(new DoubleLinkedListNode<>(element, new DoubleLinkedListNode<>(), new DoubleLinkedListNode<>()));
			this.setHead(this.last);
		} else {
			DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<>();
			newNode.setData(this.head.getData());
			newNode.setNext(this.head.getNext());

			DoubleLinkedListNode<T> newHead = new DoubleLinkedListNode<>();
			newHead.setData(element);
			newHead.setNext(newNode);
			newHead.setPrevious(new DoubleLinkedListNode<T>());

			newNode.setPrevious(newHead);

			this.setHead(newHead);
		}
	}

	@Override
	public void removeFirst() {
		this.setHead(this.getHead().getNext());
		if (this.getHead().getNext().isNIL()) {
			this.setLast((DoubleLinkedListNode<T>) this.head);
		}
	}

	@Override
	public void removeLast() {
		removeLast(this.getHead());
	}


	private void removeLast(SingleLinkedListNode<T> currentNode) {
		if (currentNode.getNext().isNIL()) {
			currentNode.setData(null);
			currentNode.setNext(new SingleLinkedListNode<>());
		}
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
