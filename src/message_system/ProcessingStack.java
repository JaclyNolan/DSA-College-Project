package message_system;

public class ProcessingStack {
	private Node top;
	private int size;
	/**
	 * 
	 */
	public ProcessingStack() {
		top = null;
		size = 0;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void push(Node node) {
		if (isEmpty()) {
			top = node;
		} else {
			node.next = top;
			top = node;
		}
		size++;
	}

	public void push(String content) {
		Node node = new Node(content);
		if (isEmpty()) {
			top = node;
		} else {
			node.next = top;
			top = node;
		}
		size++;
	}
	
	public Node pop() {
		if (isEmpty()) {
			return null;
		} else {
			Node temp = top;
			top = top.next;
			size--;
			return temp;
		}
	}
	
	public Node peek() {
		if (isEmpty()) {
			return null;
		} else {
			return top;
		}
	}
	
	public boolean search(Node node) {
		Node temp = top;
		while (temp != null) {
			if (node == temp) {
				return true;
			}
			temp = temp.next;
		}
		return false;
	}
	
	public boolean search(String message) {
		Node temp = top;
		while (temp != null) {
			if (temp.message.content.equals(message)) {
				return true;
			}
			temp = temp.next;
		}
		return false;
	}
	
}
