import java.time.LocalDate;
import java.time.LocalDateTime;

public class Task {
	int id;
	String Content;
	Priority priority;
	String owner;
	LocalDateTime taskAdded;
	LocalDate taskDeadline;

	public int getId() {

		return id;
	}

	public void setId(int id) {

		this.id = id;
	}

	public String getContent() {

		return Content;
	}

	public void setContent(String content) {

		Content = content;
	}

	public Priority getPriority() {

		return priority;
	}

	public void setPriority(Priority priority) {

		this.priority = priority;
	}

	public String getOwner() {

		return owner;
	}

	public void setOwner(String owner) {

		this.owner = owner;
	}

	public LocalDateTime getTaskAdded() {

		return taskAdded;
	}

	public void setTaskAdded(LocalDateTime taskAdded) {

		this.taskAdded = taskAdded;
	}

	public LocalDate getTaskDeadline() {

		return taskDeadline;
	}

	public void setTaskDeadline(LocalDate taskDeadline) {

		this.taskDeadline = taskDeadline;
	}

	public Task() {
		taskAdded = LocalDateTime.now();
		owner = "UNKNOWN";
	}
}
