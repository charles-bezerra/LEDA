package adt.queue;

import adt.stack.Stack;
import adt.stack.StackImpl;
import adt.stack.StackOverflowException;
import adt.stack.StackUnderflowException;

public class QueueUsingStack<T> implements Queue<T> {

	private Stack<T> stack1;
	private Stack<T> stack2;

	public QueueUsingStack(int size) {
		stack1 = new StackImpl<T>(size);
		stack2 = new StackImpl<T>(size);
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (isFull()) {
			throw new QueueOverflowException();
		}
		if (element != null) {
			try {
				stack1.push(element);
			} catch (StackOverflowException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty()) {
			throw new QueueUnderflowException();
		} else {
			T obj = null;

			try {
				while (!stack1.isEmpty()) {
					stack2.push(stack1.pop());
				}

				obj = stack2.pop();

				while (!stack2.isEmpty()) {
					stack1.push(stack2.pop());
				}

				return obj;
			} catch (StackOverflowException | StackUnderflowException e) {
				e.printStackTrace();
			}

			return null;
		}
	}

	@Override
	public T head() {
		T obj = null;

		try {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}

			obj = stack2.top();

			while (!stack2.isEmpty()) {
				stack1.push(stack2.pop());
			}
		} catch (StackUnderflowException | StackOverflowException e) {
			e.printStackTrace();
		}

		return obj;
	}

	@Override
	public boolean isEmpty() {
		return stack1.isEmpty();
	}

	@Override
	public boolean isFull() {
		return stack1.isFull();
	}
}
