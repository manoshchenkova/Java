import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class PlannerApp {

	public static void main(String[] args) {

		TaskManager taskManager = new TaskManager(new TaskStorageImpl());
		
		LocalDate today = LocalDate.now();
		printTasksForDate(taskManager, today);

		addNewTask(taskManager);

		printTasksForDate(taskManager, today);

		// ========
		//Пометить задачу как выполненную
		
		
	}

	private static void addNewTask(TaskManager taskManager) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Введите новую задачу: ");

		System.out.println("Введите задачу: ");
		String content = scanner.next();

		System.out.println("Введите приоритет (VERY_URGENT, HIGH, NORMAL, LOW): ");
		String priority = scanner.next();
		Priority taskPriority = Priority.fromString(priority);

		System.out.println("Введите срок для задачи dd/MM/yyyy: ");
		String dateString = scanner.next();
		LocalDate deadline = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd/M/yyyy"));

		Task newTask = new Task();
		newTask.setContent(content);
		newTask.setPriority(taskPriority);
		newTask.setTaskDeadline(deadline);
		newTask.taskAdded = LocalDateTime.now();

		taskManager.saveTask(newTask);
	}

	private static void printTasksForDate(TaskManager taskManager, LocalDate today) {

		List<Task> listForToday =  taskManager.findTasks(today);

		for (Task task: listForToday) {
			System.out.println(task.Content + " " + task.priority + " " + "due " + task.taskDeadline);
		}
	}
}
