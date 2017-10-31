package models;

import java.util.ArrayList;
import java.util.List;

public class TodoListMethods implements Methods {
	private static ArrayList arrayTodoItems;
	
	public TodoListMethods() {
		arrayTodoItems = new ArrayList<TodoList>();
	}
	
	@Override
	public void removeItem(String itemName) {
	
	}

	@Override
	public void addItem(TodoList todoList) {
		arrayTodoItems.add(todoList);

	}

	@Override
	public void deleteItem() {
		

	}

	@Override
	public void editStatus(TodoList todoList) {
	}

	@Override
	public List<TodoList> listAllTodo() {
		return null;
	}

}
