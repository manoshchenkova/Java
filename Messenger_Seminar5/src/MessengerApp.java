public class MessengerApp {

	public static void main(String[] args) {

		ICQ icq = new ICQ();
		User user1 = new User("Maria",  icq);
		User user2 = new User("Pavel",  icq);
		icq.appendUser(user1);
		icq.appendUser(user2);
		
		user1.sendMsg(new TextMessage("Hi!"));
		user2.sendMsg(new TextMessage("Good afternoon!"));
		
		User user3 = new User("Ivan", icq);
		icq.appendUser(user3);
		
		user3.sendMsg(new TextMessage("Hi everyone!"));
		
		user1.sendMsg(new EmojiMessage(Emoji.GRINNING_FACE));
	}


}
