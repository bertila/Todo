package UI;

import java.util.Comparator;
import models.Task;

public class TaskDeadlineDateComparator implements Comparator<Task> {

	@Override
	public int compare(Task o1, Task o2) {
		
				
		return o1.getLocalDateDeadline().compareTo(o2.getLocalDateDeadline());
		
		
//		int result=0;
//		
//		result = o1.getLocaldDeadline().compareTo(o2.getLocaldDeadline());
//		System.out.println(o1.getLocaldDeadline() + " " + o2.getLocaldDeadline() + " "+ result);
//		
//		return result;
	}
}

