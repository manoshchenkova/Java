public enum Emoji {
	
	GRINNING_FACE("\uD83D\uDE00");

	private String code;

	Emoji(String code) {

		this.code = code;
	}

	public String getCode() {

		return code;
	}
}
