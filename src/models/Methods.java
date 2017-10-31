package models;

import java.util.List;

public interface Methods  {
	void removeItem(String itemName);
	
	void deleteItem();
	void editStatus();
	
	List<TodoList> listAllTodo();
	void addItem(TodoList todoList);
	
	
	

}
