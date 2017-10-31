package models;

import java.util.ArrayList;
import java.util.List;

public class TodoListMethods implements Methods {
	private static ArrayList arrayTodoItems;
	private static int numberOfTodoItems=0;
	
	public static int getNumberOfTodoItems() {
		return numberOfTodoItems;
	}

	public TodoListMethods() {
		arrayTodoItems = new ArrayList<TodoList>();
	}
	
	@Override
	public void removeItem(int index,String itemName) {
		arrayTodoItems.remove(index);
	
	}

	@Override
	public void addItem(TodoList todoList) {
		arrayTodoItems.add(todoList);
		numberOfTodoItems++;

	}

	@Override
	public void deleteItem() {
		

	}

	@Override
	public void editStatus(int index,String status) {
		TodoList todoItem=(TodoList) arrayTodoItems.get(index);
		todoItem.setStatus(status);
	}

	@Override
	public List<TodoList> listAllTodo() {
		return null;
	}

	

}
