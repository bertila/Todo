package UI;

import java.util.Comparator;

import models.Task;

public class TaskDueDateComparator implements Comparator<Task> {

	@Override
	public int compare(Task o1, Task o2) {
		// TODO Auto-generated method stub
		return o1.getDateDeadline().compareTo(o2.getDateDeadline());
		// return 0;
		// return o1.getTaskName().compareTo(o2.getTaskName());
	}


	
	
	

}
