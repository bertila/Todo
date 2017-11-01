package models;

import java.util.List;

public interface Methods  {
	void deleteItem(int index);
	
	void editStatus(int index,Status status);
	
	List<Task> listAllTodo();
	void addItem(Task todoList);
	void removeDoneItems();
	Task searchSpecificItem(String taskName);
	void checkIfDeadLineExceeded();

	

}
