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
		return countSize(this.head);
	}

	private int countSize(SingleLinkedListNode<T> currentNode) {
		int resp = 0;
		if (!currentNode.isNIL()) {
			resp = 1 + countSize(currentNode.next);
		}
		return resp;
	}

	@Override
	public T search(T element) {
		return search(this.head, element);
	}

	private T search(SingleLinkedListNode<T> currentNode, T element) {
		T resp = null;
		if (!currentNode.isNIL()) {
			if (currentNode.data.equals(element)) {
				resp = currentNode.data;
			} else {
				resp = search(currentNode.next, element);
			}
		}
		return resp;
	}

	@Override
	public void insert(T element) {
		insert(element, this.head);
	}

	private void insert(T element, SingleLinkedListNode<T> currentNode) {
		if (currentNode.isNIL()) {
			currentNode.setData(element);
			currentNode.setNext(new SingleLinkedListNode<T>());
		} else {
			insert(element, currentNode.next);
		}
	}

	@Override
	public void remove(T element) {
		if (!isEmpty()) {
			remove(element, this.head);
		}
	}

	private void remove(T element, SingleLinkedListNode<T> currentNode) {
		if (!currentNode.isNIL()) {
			if (currentNode.data.equals(element)) {
				currentNode.setData(currentNode.next.data);
				currentNode.setNext(currentNode.next.next);
			} else {
				remove(element, currentNode.next);
			}
		}
	}

	@Override
	public T[] toArray() {
		T[] array = (T[]) new Object[size()];
		fillArray(array, this.head);
		return array;
	}

	private  void fillArray (T[] array, SingleLinkedListNode<T> current) {
		fillArray(array, current, 0);
	}

	private void fillArray (T[] array, SingleLinkedListNode<T> currentNode, int index) {
		if (!currentNode.isNIL()) {
			array[index] = currentNode.data;
			fillArray(array, currentNode.next, index+1);
		}
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
