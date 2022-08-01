import java.time.LocalDate;
import java.util.List;

public class TaskManager {
	
	private TaskStorage taskStorage;

	public TaskManager(TaskStorage taskStorage) {

		this.taskStorage = taskStorage;
	}

	public void saveTask(Task task) {
		 taskStorage.saveTask(task);
	}
	
	public List<Task> findTasks(LocalDate date) {
		List<Task> tasks = taskStorage.getTasks(date);
		return tasks;
	}
	
}

