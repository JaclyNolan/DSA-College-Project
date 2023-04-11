package message_system;

import java.time.Instant;

public class Message {
	String content;
	private Instant timestamp;
	/**
	 * @param content
	 * @param timestamp
	 */
	public Message(String content) {
		this.content = content;
		this.timestamp = Instant.now();
	}
	public Instant getTimestamp() {
		return timestamp;
	}
	public void setTimestamp() {
		this.timestamp = Instant.now();
	}
	
	@Override
	public String toString() {
		return "Message [content=" + content + ", timestamp=" + timestamp + "]";
	}
	
	
}
