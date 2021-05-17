package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return head.isNIL();
	}

	@Override
	public int size() {
		int count = 0;
		SingleLinkedListNode<T> auxNode = head;

		if (!isEmpty()) {
			count++;

			while (auxNode.getNext().getData() != null) {
				count++;
				auxNode = auxNode.getNext();
			}
		}

		return count;
	}

	@Override
	public T search(T element) {
		T searched = null;
		SingleLinkedListNode<T> auxNode = head;

		while (!auxNode.isNIL() && !auxNode.getData().equals(element) ) {
			auxNode = auxNode.getNext();
		}

		if (!auxNode.isNIL()) {
			searched = auxNode.getData();
		}

		return searched;
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			SingleLinkedListNode<T> auxNode = head;

			if (isEmpty()) {
				head = new SingleLinkedListNode<>(element, new SingleLinkedListNode<>(null, null));
			}
			else {
				while (!auxNode.getNext().isNIL()) {
					auxNode = auxNode.getNext();
				}

				auxNode.setNext(new SingleLinkedListNode<>(element, new SingleLinkedListNode<>(null, null)));
			}
		}
	}

	@Override
	public void remove(T element) {
		T finded = search(element);

		if (finded != null) {
			SingleLinkedListNode<T> auxNode = head;

			if (head.getData().equals(element)) {

			}

			while (!auxNode.getNext().isNIL() && !auxNode.getNext().getData().equals(element)) {
				auxNode = auxNode.getNext();
			}

			auxNode.getData();
		}
	}

	@Override
	public T[] toArray() {
		T[] array = (T[]) new Object[size()];

		if (!isEmpty()) {
			SingleLinkedListNode<T> auxNode = head;
			int i = 0;

			array[i++] = head.getData();

			while (!auxNode.getNext().isNIL()) {
				array[i++] = auxNode.getData();
				auxNode = auxNode.getNext();
			}
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
