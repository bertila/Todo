package models;

import java.util.List;

public interface Methods  {
	void removeItem(int index,String itemName);
	
	void deleteItem();
	void editStatus(int index,String status);
	
	List<TodoList> listAllTodo();
	void addItem(TodoList todoList);
	
	
	

}
