package message_system;

public class Node {
	Message message;
	Node next;
	/**
	 * @param message
	 * @param next
	 */
	public Node(Message message, Node next) {
		this.message = message;
		this.next = next;
	}
	/**
	 * @param message
	 */
	public Node(Message message) {
		this.message = message;
		this.next = null;
	}
	
	public Node(String content) {
		this.message = new Message(content);
		this.next = null;
	}
	
	public Node(String content, Node next) {
		this.message = new Message(content);
		this.next = next;
	}
	@Override
	public String toString() {
		return message.toString();
	}
	
	
	
}
