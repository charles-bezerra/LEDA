package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return this.head.isNIL();
	}

	@Override
	public int size() {
		int count = 0;
		SingleLinkedListNode<T> currentNode = this.head;

		while (!currentNode.isNIL()) {
			count++;
			currentNode = currentNode.getNext();
		}

		return count;
	}

	@Override
	public T search(T element) {
		T result = null;
		SingleLinkedListNode<T> currentNode = this.head;

		while (!currentNode.isNIL()) {
			if (currentNode.getData().equals(element)) {
				result = currentNode.getData();
				break;
			}

			currentNode = currentNode.getNext();
		}

		return result;
	}

	@Override
	public void insert(T element) {
		SingleLinkedListNode<T> currentNode = this.head;

		while (!currentNode.isNIL()) {
			currentNode = currentNode.getNext();
		}

		currentNode.setData(element);
		currentNode.setNext(new SingleLinkedListNode<T>());
	}

	@Override
	public void remove(T element) {
		SingleLinkedListNode<T> currentNode = this.head;

		while (!currentNode.isNIL()) {
			if (currentNode.getData().equals(element)) {
				currentNode.setData(currentNode.getNext().getData());
				currentNode.setNext(currentNode.getNext().getNext());
				break;
			}

			currentNode = currentNode.getNext();
		}
	}

	@Override
	public T[] toArray() {
		T[] array = (T[]) new Object[size()];
		SingleLinkedListNode<T> currentNode = this.head;
		int i = 0;

		while (!currentNode.isNIL()) {
			array[i++] = currentNode.getData();
			currentNode = currentNode.getNext();
		}

		return array;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
