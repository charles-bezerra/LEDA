package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}

	@Override
	public boolean isEmpty() {
		return this.data == null;
	}

	private int size(RecursiveSingleLinkedListImpl<T> currentNode) {
		if (currentNode.isEmpty()) {
			return 0;
		} else {
			return 1 + size(currentNode.getNext());
		}
	}

	@Override
	public int size() {
		return this.size(this);
	}

	private T search(RecursiveSingleLinkedListImpl<T> currentNode, T element) {
		T result = null;

		if (!currentNode.isEmpty()) {
			if (currentNode.data.equals(element)) {
				result = currentNode.data;
			} else {
				result = search(currentNode.getNext(), element);
			}
		}

		return result;
	}

	@Override
	public T search(T element) {
		return search(this, element);
	}

	private void insert(RecursiveSingleLinkedListImpl<T> currentNode, T element) {
		if (currentNode.isEmpty()) {
			currentNode.setData(element);
			currentNode.setNext(new RecursiveSingleLinkedListImpl<>());
		} else {
			insert(currentNode.getNext(), element);
		}
	}

	@Override
	public void insert(T element) {
		insert(this, element);
	}

	private void remove(RecursiveSingleLinkedListImpl<T> currentNode, T element) {
		if (!currentNode.isEmpty()) {
			if (currentNode.data.equals(element)) {
				currentNode.setData(currentNode.getNext().getData());
				currentNode.setNext(currentNode.getNext().getNext());
			} else {
				remove(currentNode.getNext(), element);
			}
		}
	}

	@Override
	public void remove(T element) {
		remove(this, element);
	}

	private void fillArray(T[] array, RecursiveSingleLinkedListImpl<T> currentNode, int i) {
		if (!currentNode.isEmpty()) {
			array[i] = currentNode.getData();
			fillArray(array, currentNode.getNext(), ++i);
		}
	}

	@Override
	public T[] toArray() {
		T[] array = (T[]) new Object[size()];
		fillArray(array, this, 0);
		return array;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}
