public interface Chat {

	void appendUser(User user);

	void sendMessage(String msg, User me);
}
