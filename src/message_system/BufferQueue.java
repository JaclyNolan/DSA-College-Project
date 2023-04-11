package message_system;

public class BufferQueue {
	private Node front, back;
	private int size;
	/**
	 * 
	 */
	public BufferQueue() {
		front = null;
		back = null;
		size = 0;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void enqueue(Node node) {
		if (isEmpty()) {
			front = back = node;
		} {
			back.next = node;
			back = node;
		}
		size++;
	}
	
	public void enqueue(String content) {
		Node node = new Node(content, null);
		if (isEmpty()) {
			front = node;
			back = node;
		} else {
			back.next = node;
			back = node;
		}
		size++;
	}
	
	public Node dequeue() {
		if (isEmpty()) {
			return null;
		} else if (size == 1) {
			Node temp = front;
			front = null;
			back = null;
			size--;
			return temp;
		} else {
			Node temp = front;
			front = front.next;
			size--;
			return temp;
		}
	}
	
	public Node peek() {
		if (isEmpty()) {
			return null;
		} else {
			return front;
		}
	}
}
