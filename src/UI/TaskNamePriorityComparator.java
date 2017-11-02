package UI;

import models.Task;
import java.util.Comparator;

public class TaskNamePriorityComparator implements Comparator<Task>{

	@Override
	public int compare(Task o1, Task o2) {
		// TODO Auto-generated method stub
		return Comparator.comparing(Task::getPriority).compare(o1, o2);
		
//				.thenComparing(Task::getDateDeadline)
//	              .thenComparing(Task::getTaskName)
//	              .compare(o1, o2);
	}
	

}
