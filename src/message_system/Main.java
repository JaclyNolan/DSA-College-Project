package message_system;

import java.util.Scanner;

public class Main {
	
	static Scanner sc = new Scanner(System.in);
	final static int exitInput = 6; 
	static BufferQueue queue = new BufferQueue();
	static ProcessingStack stack = new ProcessingStack();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int option;
		
		do {
			option = printMenu();
			
			switch(option) {
				case 1: {
					inputMessage();
					break;
				}
				case 2: {
					showAllStoredMessage();
					break;
				}
				case 3: {
					deleteAllStoredMessage();
					break;
				}
				case 4: {
					sendAllStoredMessage();
					break;
				}
				case 5: {
					showAllSentMessage();
					break;
				}
				case exitInput: {
					closingMenu();
					break;
				}
				default: {
					invalidMenu();
					break;
				}
			}
		} while (option != exitInput);
	}

	static void divideMenu() {
		System.out.println("--------------------------------------------");
	}
	
	static int printMenu() {
		System.out.println("Welcome to a shitty message system");
		System.out.println("1. Input message");
		System.out.println("2. Show stored message");
		System.out.println("3. Delete all stored message");
		System.out.println("4. Send all messages");
		System.out.println("5. View sent messages");
		System.out.println("6. Exit");
		divideMenu();
		try {
			int option = sc.nextInt();
			sc.nextLine();
			return option;
		} catch (Exception ex) {
			sc.nextLine();
			invalidMenu();
			return printMenu();
		}
		
	}
	
	static void closingMenu() {
		System.out.println("Closing!");
		divideMenu();
	}
	
	static void invalidMenu() {
		System.out.println("Invalid input");
		divideMenu();
	}
	
	static void invalidMenu(Exception ex) {
		System.out.println("Error: " + ex);
		divideMenu();
	}
	
	static void inputMessage() {
		//Input content of message
		try {
			boolean isExit = false;
			do {
				System.out.println("New Message (smaller than 250 words): ");
				String content = sc.nextLine();
				if (isValid(content)) {
					storeToQueue(content);
				}
				
				System.out.println("Countinue to input new message? (Y/N)");
				isExit = !confirmNext();
			} while (!isExit);
			
		} catch(Exception ex) {
			invalidMenu(ex);
		}
		closingMenu();
	}
	
	static boolean storeToQueue(String content) {
		try {
			queue.enqueue(content);
			System.out.println("Stored successful");
			return true;
		} catch (Exception ex) {
			System.out.println("Stored unsuccessful");
			System.out.println("Error: " + ex);
			return false;
		}
	}
	
	static boolean isValid(String content) {
		if (content.equalsIgnoreCase("")) {
			System.out.println("Message is blank");
			return false;
		} else if (content.length() > 250) {
			System.out.println("Message is too large (smaller than 250 words)");
			return false;
		} else {
			return true;
		}
	}
	
	static boolean confirmNext() {
		do {
			String input = sc.nextLine();
			
			if (input.equalsIgnoreCase("y")) {
				return true;
			} else if (input.equalsIgnoreCase("n")) {
				return false;
			} else {
				System.out.println("Invalid input");
			}
		} while (true);
	}

	static void showAllStoredMessage() {
		Node front = queue.peek();
		if (front != null) {
			int n = 0;
			while (front != null) {
				System.out.println(front.toString());
				front = front.next;
				n++;
			}
			System.out.println("Successfully displayed " + n + " stored message(s)");
		} else {
			System.out.println("There are no stored message");
			divideMenu();
		}
		closingMenu();
	}
	
	static void deleteAllStoredMessage() {
		int n = 0;
		while (!queue.isEmpty()) {
			queue.dequeue();
			n++;
		}
		System.out.println("Successfully deleted " + n + " message(s)");
		closingMenu();
	}

	static void sendAllStoredMessage() {
		int n = 0;
		while (!queue.isEmpty()) {
			Node temp = queue.dequeue();
			temp.next = null;
			stack.push(temp);
			n++;
		}
		System.out.println("Successfully sent " + n + " message(s)");
		closingMenu();
	}
	
	static void showAllSentMessage() {
		Node front = stack.peek();
		if (front != null) {
			int n = 0;
			while (front != null) {
				System.out.println(front.toString());
				front = front.next;
				n++;
			}
			System.out.println("Successfully displayed " + n + " sent message(s)");
		} else {
			System.out.println("There are no sent message");
			divideMenu();
		}
		closingMenu();
	}
}
