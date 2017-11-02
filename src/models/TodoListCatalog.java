package models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import UI.TaskIdComparator;

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
	public void deleteItem(int index) {
		arrayTodoItems.remove(index);

	}

	@Override
	public void addItem(Task todoList) {
		arrayTodoItems.add(numberOfTodoItems, todoList);
		numberOfTodoItems++;

	}

	@Override
	public List<Task> listAllTodo() {

		return arrayTodoItems;
	}

	@Override
	public void removeDoneItems() {

		List<Task> arrayList = listAllTodo();
		for(Task task:arrayList) {
			if (task.getStatus()==Status.DONE) {
				arrayTodoItems.remove(task.getId());
			}
		}
	}

	@Override
	public Task searchSpecificItem(String taskName) {
		return null;
	}

	@Override
	public void checkIfDeadLineExceeded() {
		// check if due date passed

		List<Task> arrayList = listAllTodo();
		LocalDate now= LocalDate.now();



		for(Task task:arrayList) {
			LocalDate taskDeadLineDate=task.getDateDeadline();
			if (taskDeadLineDate.compareTo(now)>0)  {
				System.out.println(task.getTaskName() + "/"+task.getDateDeadline());
			}
		}

	}

	//	public void editTask(int indexID,String status,int priority) {
	//		Task task= (Task) arrayTodoItems.get(indexID);
	//		task.setStatus(indexID,status);
	//		task.setPriority(priority);
	//		
	//	}

	public Task findTaskByID(int search) {
		// TODO Bertil

		List<Task> arrayList = listAllTodo();
		// if (arrayList.contains(search)) {
		for (Task nextTask : arrayList) {
			if (nextTask.getId() == search) {
				return nextTask;
			}
		}
		//		// }
		//		else
		//		{
		//			return null;
		//		}





		// }
		return null;
	}

	public Task findTaskByID(String search) {
		// Task todoItem=(Task) arrayTodoItems.get(id);

		return null;
	}

	@Override
	public void editStatus(int id, models.Status status){
		// TODO
		// ID is not related to id=x

		// int idx = Collections.binarySearch(arrayTodoItems, "id",index);
		// int index = Collections.binarySearch(arrayTodoItems, "id", new TaskIdComparator());
		Task tFound = findTaskByID(id);

		if (tFound == null) {
			return; 
		}
		else if (tFound.getId()==id) {
			// Task todoItem=(Task) arrayTodoItems.get(id);
			if(tFound!=null) {
				tFound.setStatus(status); 
			}else {
				System.out.println("The item was not found");
			}
		}
		return;
	}

}
