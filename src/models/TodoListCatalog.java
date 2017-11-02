package models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
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
		Iterator<Task> it = arrayList.iterator();
		
		while (it.hasNext()) {
			Task t = it.next();
			// System.out.print(t.getTaskName());
			if (t.getStatus().equals(Status.DONE)){
				it.remove();
				// System.out.println("Done");
				// arrayTodoItems.remove(t.getId());
			}
		}
				
		
//		for(Task task : arrayList) {
//			if (task.getStatus().equals(Status.DONE)) {
//				arrayTodoItems.remove(task.getId());
//				
//				// System.out.println(task.getId() + " "  +task.getCurrentRecord()+ " " +task.getTaskName());
//				// arrayTodoItems.remove(0);
//				//task.getCurrentRecord()
//					// (task.getId());
//			}
//		}
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
		List<Task> arrayList = listAllTodo();
		for (Task nextTask : arrayList) {
			if (nextTask.getId() == search) {
				return nextTask;
			}
		}
		return null;
	}

	public Task findTaskByID(String search) {
		List<Task> arrayList = listAllTodo();
		for (Task nextTask : arrayList) {
			if (nextTask.getTaskName().indexOf(search)>0) {
				return nextTask;
			}
		}
		return null;
	}

	@Override
	public void editStatus(int id, models.Status status){
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
