package UI;

import java.util.Comparator;

import models.Task;

public class TaskPriorityComparator implements Comparator<Task> {

	@Override
	public int compare(Task o1, Task o2) {
		// TODO Auto-generated method stub
		return o1.getPriority()- o2.getPriority();
	}
}
