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
		arrayTodoItems = new ArrayList<TodoList>();
	}
	
	@Override
	public void deleteItem(int index,String itemName) {
		arrayTodoItems.remove(index);
	
	}

	@Override
	public void addItem(TodoList todoList) {
		arrayTodoItems.add(todoList);
		numberOfTodoItems++;

	}


	@Override
	public void editStatus(int index,String status) {
		TodoList todoItem=(TodoList) arrayTodoItems.get(index);
		todoItem.setStatus(status);
	}

	@Override
	public List<TodoList> listAllTodo() {
		return arrayTodoItems;
	}

	@Override
	public void removeDoneItems() {
		
	}

	@Override
	public TodoList searchSpecificItem(String taskName) {
		return null;
	}

	@Override
	public void checkIfDeadLineExceeded() {
		// TODO Auto-generated method stub
		
	}

	

}
