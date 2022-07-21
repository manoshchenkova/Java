public interface Chat {

	void appendUser(User user);

	void sendMessage(Message msg, User me);
}
