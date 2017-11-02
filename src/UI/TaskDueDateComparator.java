package UI;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Date;

import models.Task;

public class TaskDueDateComparator implements Comparator<Task> {

	@Override
	public int compare(Task o1, Task o2) {
		
		// return o1.getDateDeadline().compareTo(o2.getDateDeadline());
		return o1.getDateDeadline().compareTo(o2.getDateDeadline());
	}

	//		// TODO Auto-generated method stub
	//		if (o1.getDateDeadline().isBefore(o2.getDateDeadline())) {
	//			return -1;
	//		}
	//		else if (o1.getDateDeadline().isAfter(o2.getDateDeadline())) {
	//			return 1;}
	//
	//		else {
	//			return 0;
	//		}
	//	}

	// return o2.getDateDeadline().compareTo(o1.getDateDeadline());
	// o1.getDateDeadline().isAfter(o2.getDateDeadline()); 
	// return Comparator.comparing(Task::getDateDeadline).compare(o1, o2);
	// return o1.getDateDeadline().compareTo(o2.getDateDeadline());
	// return 0;
	// return o1.getTaskName().compareTo(o2.getTaskName());
}

