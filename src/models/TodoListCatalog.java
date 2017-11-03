package models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import UI.TaskIdComparator;

public class TodoListCatalog implements Methods {
	private static ArrayList arrayTodoItems;
	private static int numberOfTodoItems=0;

	public static int getNumberOfTodoItems() {
		return numberOfTodoItems;
	}
	
	public List returnCatalog() {
		return arrayTodoItems;
	}

	public TodoListCatalog() {
		arrayTodoItems = new ArrayList<Task>();
	}

	@Override
	public void deleteItem(int index) {
		try {
			arrayTodoItems.remove(index);
		}
		catch (Exception e){
			System.out.println("Kunde inte hitta id="+index);
		}
	}

	@Override
	public void addItem(Task todoList) {
		arrayTodoItems.add(numberOfTodoItems, todoList);
		numberOfTodoItems++;

	}

	@Override
	public List<Task> listAllTodo() {

		return arrayTodoItems;
	}

	@Override
	public void removeDoneItems() {
		List<Task> arrayList = listAllTodo();
		Iterator<Task> it = arrayList.iterator();
		
		while (it.hasNext()) {
			Task t = it.next();
			if (t.getStatus().equals(Status.DONE)){
				it.remove();
			}
		}
	}

	@Override
	public Task searchSpecificItem(String taskName) {
		return null;
	}

	@Override
	public void checkIfDeadLineExceeded() {
		// check if due date passed

		List<Task> arrayList = listAllTodo();
		LocalDate now= LocalDate.now();

		for(Task task:arrayList) {
			LocalDate taskDeadLineDate=task.getDateDeadline();
			if (taskDeadLineDate.compareTo(now)<0)  {
				System.out.println( "Task with name "  + task.getTaskName() + "/"+task.getDateDeadline() + " has passed deadline date");
			}
		}

	}

	//	public void editTask(int indexID,String status,int priority) {
	//		Task task= (Task) arrayTodoItems.get(indexID);
	//		task.setStatus(indexID,status);
	//		task.setPriority(priority);
	//		
	//	}

	public Task findTaskByID(int search) {
		List<Task> arrayList = listAllTodo();
		for (Task nextTask : arrayList) {
			if (nextTask.getId() == search) {
				return nextTask;
			}
		}
		return null;
	}

	public Task findTaskByID(String search) {
		List<Task> arrayList = listAllTodo();
		for (Task nextTask : arrayList) {
			if (nextTask.getTaskName().indexOf(search)>0) {
				return nextTask;
			}
		}
		return null;
	}

	@Override
	public void editStatus(int id, models.Status status){
		Task tFound = findTaskByID(id);

		if (tFound == null) {
			return; 
		}
		else if (tFound.getId()==id) {
			// Task todoItem=(Task) arrayTodoItems.get(id);
			if(tFound!=null) {
				tFound.setStatus(status); 
			}else {
				System.out.println("The item was not found");
			}
		}
		return;
	}

}
