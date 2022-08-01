import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TaskStorageImpl implements TaskStorage {

	private final String fileName;

	public TaskStorageImpl() {

		this.fileName = "todo.list";
	}

	@Override
	public List<Task> getTasks(LocalDate date) {

		File file = new File(fileName);
		if (!file.exists()) {
			return new ArrayList<>();
		}
		List<String> lines;
		try {
			lines = Files.readAllLines(file.toPath());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		List<Task> tasks = new ArrayList<>();
		for (String row : lines) {
			if (row.isBlank()) {
				continue;
			}
			String[] parts = row.split(",");
			Task task = new Task();
			task.setContent(parts[1]);
			task.setPriority(Priority.fromString(parts[2]));
			task.setTaskAdded(LocalDateTime.parse(parts[4]));
			task.setTaskDeadline(LocalDate.parse(parts[5]));
			tasks.add(task);
		}
		
		List<Task> tasksForDay = new ArrayList();
		for (Task task : tasks) {
			if (task.getTaskDeadline().isAfter(date)) {
				tasksForDay.add(task);
			}
		}

		return tasksForDay;
	}

	@Override
	public void saveTask(Task task) {

		try {
			try (FileWriter fileWriter = new FileWriter(fileName)) {
				fileWriter.append(convertToString(task));
				fileWriter.append("\n");
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private String convertToString(Task task) {

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(task.getId());
		stringBuilder.append(",");
		stringBuilder.append(task.getContent());
		stringBuilder.append(",");
		stringBuilder.append(task.getPriority());
		stringBuilder.append(",");
		stringBuilder.append(task.getOwner());
		stringBuilder.append(",");
		stringBuilder.append(task.getTaskAdded());
		stringBuilder.append(",");
		stringBuilder.append(task.getTaskDeadline());

		return stringBuilder.toString();
	}
}
