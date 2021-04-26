package adt.queue;

public class CircularQueue<T> implements Queue<T> {

	private T[] array;
	private int tail;
	private int head;
	private int elements;

	public CircularQueue(int size) {
		array = (T[]) new Object[size];
		head = -1;
		tail = -1;
		elements = 0;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (isFull()) {
			throw new QueueOverflowException();
		}

		if (element != null) {
			if (head == -1)
				head++;
			if (tail == array.length-1) {
				tail=-1;
			}

			array[++tail] = element;
			++elements;
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty()) {
			throw new QueueUnderflowException();
		}
		else {
			T aux = array[head];
			array[head] = null;
			--elements;

			if (head == array.length-1) {
				head=0;
			}
			else {
				head++;
			}

			return aux;
		}
	}

	@Override
	public T head() {
		if (isEmpty()) {
			return null;
		}
		else {
			return array[head];
		}
	}

	@Override
	public boolean isEmpty() {
		return elements == 0;
	}

	@Override
	public boolean isFull() {
		return elements == array.length;
	}

}
