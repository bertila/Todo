package models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TodoListCatalog implements Methods {
	private static ArrayList arrayTodoItems;
	private static int numberOfTodoItems=0;
	
	public static int getNumberOfTodoItems() {
		return numberOfTodoItems;
	}

	public TodoListCatalog() {
		arrayTodoItems = new ArrayList<Task>();
	}
	
	@Override
	public void deleteItem(int index) {
		arrayTodoItems.remove(index);
	
	}

	@Override
	public void addItem(Task todoList) {
		arrayTodoItems.add(todoList);
		numberOfTodoItems++;

	}

	

	@Override
	public List<Task> listAllTodo() {

		return arrayTodoItems;
	}

	@Override
	public void removeDoneItems() {
		
		List<Task> arrayList = listAllTodo();
		for(Task task:arrayList) {
			if (task.getStatus()==Status.DONE) {
				arrayTodoItems.remove(task.getId());
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

	@Override
	public void editStatus(int index, models.Status status){
		Task todoItem=(Task) arrayTodoItems.get(index);
		if(todoItem!=null) {
		todoItem.setStatus(status); 
		}else {
			System.out.println("The item was not found");
		}
	}

}
