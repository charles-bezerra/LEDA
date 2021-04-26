package adt.queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class StudentQueueTest {

	public Queue<Integer> queue1;
	public Queue<Integer> queue2;
	public Queue<Integer> queue3;

	@Before
	public void setUp() throws QueueOverflowException {

		getImplementations();

		// Fila com 3 elementos cheia.
		queue1.enqueue(1);
		queue1.enqueue(2);
		queue1.enqueue(3);

		// Fila com 2 elementos de tamanho 2. Fila cheia.
		queue2.enqueue(1);
		queue2.enqueue(2);
		queue2.enqueue(3);
		queue2.enqueue(4);
		queue2.enqueue(5);

		queue3.enqueue(1);
		queue3.enqueue(2);
		queue3.enqueue(3);
	}

	private void getImplementations() {
		// TODO O aluno deve ajustar aqui para instanciar sua implementação
		queue1 = new QueueImpl<>(3);
		queue2 = new CircularQueue<>(5);
		queue3 = new QueueUsingStack<>(3);
	}

	// MÉTODOS DE TESTE
	@Test
	public void testHead() {
		assertEquals(new Integer(1), queue1.head());
		assertEquals(new Integer(1), queue2.head());
		assertEquals(new Integer(1), queue3.head());

	}

	@Test
	public void testEnqueueDequeue () throws QueueUnderflowException, QueueOverflowException {
		queue2.dequeue();
		queue2.dequeue();

		queue2.enqueue(new Integer(6));
		queue2.enqueue(new Integer(7));

		assertEquals(new Integer(3), queue2.dequeue());
		assertEquals(new Integer(4), queue2.dequeue());
		assertEquals(new Integer(5), queue2.dequeue());
		assertEquals(new Integer(6), queue2.dequeue());

		queue2.enqueue(new Integer(8));

		assertEquals(new Integer(7), queue2.dequeue());
		assertEquals(new Integer(8), queue2.dequeue());
	}

	@Test
	public void testIsEmpty() {
		assertFalse(queue1.isEmpty());
		assertFalse(queue2.isEmpty());
		assertFalse(queue3.isEmpty());
	}

	@Test
	public void testIsFull() throws QueueUnderflowException {
		queue1.dequeue();
		queue2.dequeue();

		assertFalse(queue1.isFull());
		assertFalse(queue2.isFull());
	}

	@Test
	public void testEnqueue() {
		try {
			queue1.enqueue(new Integer(5));
		} catch (QueueOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected = QueueOverflowException.class)
	public void testEnqueueComErro() throws QueueOverflowException {
		queue1.enqueue(new Integer(5)); // vai depender do tamanho que a fila
										// foi iniciada!!!
	}

	@Test
	public void testDequeue() {
		try {
			assertEquals(new Integer(1), queue1.dequeue());
		} catch (QueueUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected = QueueUnderflowException.class)
	public void testDequeueComErro() throws QueueUnderflowException {
		queue1.dequeue();
		queue1.dequeue();
		queue1.dequeue();

		assertEquals(new Integer(1), queue1.dequeue()); // vai depender do
														// tamanho que a fial
														// foi iniciada!!!

		queue2.dequeue();
		queue2.dequeue();
		queue2.dequeue();
		queue2.dequeue();
		queue2.dequeue();
		queue2.dequeue();
		assertEquals(new Integer(1), queue2.dequeue());
	}
}