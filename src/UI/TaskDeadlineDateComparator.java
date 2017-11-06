package UI;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Date;

import models.Task;

public class TaskDeadlineDateComparator implements Comparator<Task> {

	@Override
	public int compare(Task o1, Task o2) {
		int result=0;
		
		result = o1.getLocaldDeadline().compareTo(o2.getLocaldDeadline());
		System.out.println(o1.getLocaldDeadline() + " " + o2.getLocaldDeadline() + " "+ result);
		
		return result;
		
//		int compare;
//		
//		LocalDate d1 = o1.getDateDeadline();
//		LocalDate d2 = o2.getDateDeadline();
//		
//		compare = d1.getYear() - d2.getYear();
//		if (compare <0)
//			return 1;
//		else if (compare >0)
//			return -1;
//		else if (compare ==0)
//			return 0;
//		
//		return 0;
		
//		compare = d1.getMonthValue() - d2.getMonthValue();
//		if (compare <0)
//			return -1;
//		else if (compare >0)
//			return 1;
//		
//		compare = d1.getDayOfMonth() - d2.getDayOfMonth();
//		if (compare <0)
//			return -1;
//		else if (compare >0)
//			return 1;
//		else if (compare ==0)
//			return 0;
//		
//		return 0;
		// return compare;
		
		
		// return o1.getDateDeadline().compareTo(o2.getDateDeadline());
		// return o1.getDateDeadline().compareTo(o2.getDateDeadline());
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

