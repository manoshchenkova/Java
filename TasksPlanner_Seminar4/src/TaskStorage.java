import java.time.LocalDate;
import java.util.List;

/**
 * Компонента для хранения данных
 */

public interface TaskStorage {
	
	void saveTask(Task task);
	List<Task> getTasks(LocalDate date);
	
}
