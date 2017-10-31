package models;

import java.util.List;

public interface Methods  {
	void removeItem(String itemName);
	void addItem();
	void deleteItem();
	void editStatus();
	
	List<TodoList> listAllTodo();
	
	
	

}
