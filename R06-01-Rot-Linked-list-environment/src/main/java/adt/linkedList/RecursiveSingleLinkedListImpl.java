package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {
	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {}

	@Override
	public boolean isEmpty() {
		return this.data == null;
	}

	@Override
	public int size() {
		int resp = 0;
		if (!isEmpty()) {
			return 1 + count(next);
		}
		return resp;
	}

	private int count(RecursiveSingleLinkedListImpl<T> currentNode) {
		int resp = 0;
		if (!currentNode.isEmpty()) {
			resp = 1 + count(currentNode.getNext());
		}
		return resp;
	}

	@Override
	public T search(T element) {
		T resp = null;

		if (!isEmpty()) {
			if (data.equals(element)) {
				resp = data;
			} else {
				resp = search(element, next);
			}
		}
		return resp;
	}

	private T search(T element, RecursiveSingleLinkedListImpl<T> currentNode) {
		T resp = null;
		if (!currentNode.isEmpty()) {
			if (currentNode.getData().equals(element)) {
				resp = currentNode.getData();
			} else {
				resp = search(element, currentNode.getNext());
			}
		}
		return resp;
	}

	@Override
	public void insert(T element) {
		if (!isEmpty()) {
			this.insert(element, this.next);
		} else {
			this.setData(element);
		}
	}

	private void insert(T element, RecursiveSingleLinkedListImpl<T> currentNode) {
		if (currentNode.isEmpty()) {
			currentNode.setData(element);
			currentNode.setNext(new RecursiveSingleLinkedListImpl<T>());
		} else {
			insert(element, currentNode.getNext());
		}
	}

	@Override
	public void remove(T element) {
		if (!isEmpty()) {
			if (this.data.equals(element)) {
				setData(null);
				setNext(null);
			} else {
				remove(element, this.next);
			}
		}
	}

	private void remove(T elemente, RecursiveSingleLinkedListImpl<T> currentNode) {
		if (!currentNode.isEmpty()) {
			if (currentNode.getData().equals(elemente)) {
				currentNode.setData(currentNode.getNext().getData());
				currentNode.setNext(currentNode.getNext().getNext());
			} else {
				remove(elemente, currentNode.getNext());
			}
		}
	}

	@Override
	public T[] toArray() {
		T[] resp = (T[]) new Object[size()];
		if (!isEmpty()) {
			resp[0] = data;
			fillArray(resp, this.next, 1);
		}
		return resp;
	}

	private void fillArray(T[] array, RecursiveSingleLinkedListImpl<T> currentNode, int index) {
		if (!currentNode.isEmpty()) {
			array[index] = currentNode.getData();
			fillArray(array, currentNode.getNext(), index+1);
		}
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
