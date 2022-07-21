public class User {

	String name;
	Chat chatroom;

	public User(String name, Chat chatroom) {

		this.name = name;
		this.chatroom = chatroom;
	}

	void printMessage(Message msg) {

		System.out.printf("Чат %s: %s\n", name, msg.toChatMessage());
	}

	void sendMsg(Message message) {

		chatroom.sendMessage(message, this);

	}
}
