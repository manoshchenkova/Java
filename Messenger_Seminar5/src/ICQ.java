import java.util.ArrayList;

public class ICQ implements Chat {

	ArrayList<User> users = new ArrayList<>();

	public ICQ() {

	}

	@Override
	public void appendUser(User user) {

		System.out.println("\n >>>> " + user.getChatName() + " joined this chat");
		users.add(user);
	}

	@Override
	public void banUser(User user) {

		System.out.println("\n >>>> " + user.getChatName() + " removed from this chat");
		users.remove(user);
	}

	@Override
	public void sendMessage(Message message, User me) {

		if (!users.contains(me)) {
			System.out.println("\n >>>> " + me.getChatName() + " can't send message due to ban");
			return;
		}
		for (User user : users) {
			if (!user.name.equals(me.name)) {
				user.printMessage(message);
			}

		}
	}

}
