package models;

import java.util.List;

public interface Methods  {
	void deleteItem(int index,String itemName);
	
	void editStatus(int index,String status);
	
	List<Task> listAllTodo();
	void addItem(Task todoList);
	void removeDoneItems();
	Task searchSpecificItem(String taskName);
	void checkIfDeadLineExceeded();

	

}
