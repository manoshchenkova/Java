public class Admin extends User {

	public Admin(String name, Chat chatroom) {

		super(name, chatroom);
	}

	public void banUser(User user) {
		
		this.chatroom.banUser(user);
	}

	@Override
	public String getChatName() {

		return super.getChatName() + " [Admin]";
	}
}
