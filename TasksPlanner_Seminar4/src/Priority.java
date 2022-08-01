public enum Priority {
	VERY_URGENT,
	HIGH,
	NORMAL,
	LOW;

	public static Priority fromString(String fromUser) {
		switch (fromUser) {
			case "VERY_URGENT": return Priority.VERY_URGENT;
			case "HIGH": return Priority.HIGH;
			case "NORMAL": return Priority.NORMAL;
			case "LOW": return Priority.LOW;
			default: throw new IllegalArgumentException("Пожалуйста, введите корректный приоритет задачи");
		}
	}

}
