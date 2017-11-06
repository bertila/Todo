package UI;

import java.util.Comparator;
import models.Task;

public class TaskNameComparator implements Comparator<Task>{
	@Override
	public int compare(Task o1, Task o2) {
		
		return o1.getTaskName().compareTo(o2.getTaskName());
	}
}
