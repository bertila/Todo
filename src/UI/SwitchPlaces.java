package UI;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import models.Task;
import models.TodoListCatalog;

public class SwitchPlaces {
	public SwitchPlaces() {
		
	}
	
	public List<Task> sortCollection() {
		TodoListCatalog cat = new TodoListCatalog(); 
		ArrayList<Task> list = cat.getArrayTodoItems();
		
		LocalDate d1, d2;
		for (int i=0; i<list.size()-1;i++) {
			for (int j=i;j<list.size();j++) {
				d1 = list.get(i).getLocalDateDeadline();
				d2 = list.get(j).getLocalDateDeadline();
				
				if (d1.isAfter(d2)) {
					Collections.swap(list,i,j);
				}
								
			}
		}
		return list;
	}
}