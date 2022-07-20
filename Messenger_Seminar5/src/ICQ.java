import java.util.ArrayList;

public class ICQ implements Chat {

	ArrayList<User> users = new ArrayList<>();

	public ICQ() {

	}

	@Override
	public void appendUser(User user) {

		System.out.println("\n >>>> " + user.name + " joined this chat");
		users.add(user);
	}

	@Override
	public void sendMessage(String text, User me) {

		for (User user : users) {
			if (!user.name.equals(me.name)) {
				user.printMessage(text);
			}

		}
	}

}
