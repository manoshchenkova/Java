public class EmojiMessage extends Message {

	private Emoji emoji;

	public EmojiMessage(Emoji emoji) {

		this.emoji = emoji;
	}

	@Override
	public String toChatMessage() {

		return emoji.getCode();
	}
}
