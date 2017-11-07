package UI;

import java.util.Comparator;
import models.Task;

public class TaskPriorityComparator implements Comparator<Task> {

	public int compare(Task o1, Task o2) {
		return Comparator.comparing(Task::getPriority)
				.thenComparing(Task::getTaskName)
				.compare(o1, o2);
	}
}
