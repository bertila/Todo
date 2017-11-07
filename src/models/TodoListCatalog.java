package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TodoListCatalog implements Methods {
	private static ArrayList<Task> arrayTodoItems = new ArrayList<Task>();
	private static int numberOfTodoItems=0;
	
	public TodoListCatalog() {
	}
	
	public static int getNumberOfTodoItems() {
		return numberOfTodoItems;
	}
	
	public List<Task> returnCatalog() {
		return arrayTodoItems;
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
			LocalDate taskDeadLineDate=task.getLocalDateDeadline();
			if (taskDeadLineDate.compareTo(now)<0)  {
				System.out.println( "Task with name "  + task.getTaskName() + "/"+task.getLocalDateDeadline() + " has passed deadline date");
			}
		}
	}

	public Task findTaskByID(int search) {
		for (Task nextTask : listAllTodo()) {
			if (nextTask.getId() == search) {
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
			}
		}
		return;
	}
	
	public ArrayList<Task> getArrayTodoItems() {
		return arrayTodoItems;
	}

	public void setArrayTodoItems(ArrayList<Task> arrayTodoItems) {
		this.arrayTodoItems = arrayTodoItems;
	}
	public void editProperties(int indexID,Status status) {
		editStatus(indexID, status);
	}
	
	public void removeDoneTodo() {
		removeDoneItems();
	}
	
	public void checkDeadline() {
		checkIfDeadLineExceeded();
	}
	
	
}
