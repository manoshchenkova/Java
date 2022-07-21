public interface Chat {

	void appendUser(User user);

	void banUser(User user);

	void sendMessage(Message msg, User me);
}
