package models;

import java.util.List;

public interface Methods  {
	void deleteItem(int index,String itemName);
	
	void editStatus(int index,String status);
	
	List<TodoList> listAllTodo();
	void addItem(TodoList todoList);
	void removeDoneItems();
	TodoList searchSpecificItem(String taskName);
	void checkIfDeadLineExceeded();

	

}
