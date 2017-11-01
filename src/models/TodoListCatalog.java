package models;

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
	public void deleteItem(int index,String itemName) {
		arrayTodoItems.remove(index);
	
	}

	@Override
	public void addItem(Task todoList) {
		arrayTodoItems.add(todoList);
		numberOfTodoItems++;

	}


	@Override
	public void editStatus(int index,String status) {
		Task todoItem=(Task) arrayTodoItems.get(index);
		todoItem.setStatus(status);
	}

	@Override
	public List<Task> listAllTodo() {

		return arrayTodoItems;
	}

	@Override
	public void removeDoneItems() {
		
	}

	@Override
	public Task searchSpecificItem(String taskName) {
		return null;
	}

	@Override
	public void checkIfDeadLineExceeded() {
		// TODO Auto-generated method stub
		
	}

	public void editTask(int indexID,String status,int priority) {
		Task task= (Task) arrayTodoItems.get(indexID);
		task.setStatus(status);
		task.setPriority(priority);
		
	}


}
