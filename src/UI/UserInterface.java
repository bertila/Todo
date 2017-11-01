package UI;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import models.Status;
import models.Task;
import models.TodoListCatalog;


public class UserInterface extends TodoListCatalog {
	Scanner scString = new Scanner(System.in);
	Scanner scInt = new Scanner(System.in);
	
	TodoListCatalog methode = new TodoListCatalog();
	
	int selected;
	public void startInput() {
		
		do {
			System.out.print("Select function | ");
			System.out.print("1 New | ");
			System.out.print("2 Delete | ");
			System.out.print("3 Edit | ");
			System.out.print("4 List Date | ");
			System.out.print("5 List Sorted | ");
			System.out.print("6 Remove | ");
			System.out.println("7 Search |");
			System.out.println("8 Entering more values |");
			System.out.println("9 Exit");

			String select = scString.next();
			selected = Integer.parseInt(select);

			switch (selected) {
			case 1:
				// Enter task
				enterNewTask();
				break;
			case 2:
				// Delete task
				break;

			case 3:
				editStatusFromList();
				// Edit status
				break;

			case 4:
				// Check deadline
				break;

			case 5:
				listAllTasks();
				// List all sorted
				break;

			case 6:
				removeDoneTodo();
				break;

			case 7:
				// Search for a specific item
				break;

			case 8:
				System.out.println("Entering more values");
				enterBulkValues();
				
			case 9:
				System.out.println("Exiting program");
				return;
				
			default:
				System.out.println("Invalid option selected!");
				break;
			}
		} while (selected !=8);
	}
	
	private void deleteTask() {
		System.out.println("Select ID to change");
		String id = scString.next();
		
		int select = Integer.parseInt(id);
		
		methode.deleteItem(select);
		
		
	}
	
	private void removeDoneTodo() {
		methode.removeDoneItems();
	}
	
	private void editStatusFromList() {
		System.out.println("Select ID to change");
		String id = scString.next();
		
		int select = Integer.parseInt(id);
		
		System.out.println("Select status (O)PEN/(D)ONE");
		id = scString.next();
		if (id.equals("O")){
			editStatus(select,Status.OPEN);
		}
		else if (id.equals("D")) {
			editStatus(select,Status.DONE);
		}
	}
	
	private void enterBulkValues() {
		Random rand = new Random();
		
		LocalDate today = LocalDate.now();
		
		int days = rand.nextInt(100);
		Task todo1 = new Task("Clean windows",1,today.minusDays(days));
		methode.addItem(todo1);
		
		days = rand.nextInt(100);
		Task todo2 = new Task("Clean Harddrive",2,today.minusDays(days));
		methode.addItem(todo2);
		
		days = rand.nextInt(100);
		Task todo3 = new Task("Make GitHub account",2,today.plusDays(days));
		methode.addItem(todo3);
		
		days = rand.nextInt(100);
		Task todo4 = new Task("Develope new website",3,today.plusDays(days));
		methode.addItem(todo4);
		
		
	}
	


	void enterNewTask() {
		System.out.println("Enter taskname:\t");
		String task = scString.next();

		System.out.println("Enter priority:\t");
		
		String prio = scString.next();
		int prioInt = Integer.parseInt(prio);
		
		System.out.println("Deadline date:\t");
		String date =scString.next();
		LocalDate date2 = LocalDate.parse(date);
		
		Task todo = new Task(task,prioInt,date2);
		
		methode.addItem(todo );

		// scString.close();
	}

	private void getScannerInfo() {

	}

	private void searchForText(String find) {

	}
	
	private void listAllTasks() {
		
		System.out.println("Sort byTask (1), Sort byDueDate (2), Sort byPriority (3)");
		String sort = scString.next();
		
		List<Task> list = methode.listAllTodo();
		
		switch (sort) {
		case "1":
			Collections.sort(list, new TaskNameComparator());
			break;
		case "2":
			Collections.sort(list, new TaskDueDateComparator());
			
		case "3":
			Collections.sort(list, new TaskPriorityComparator());
		default:
			break;
		}
		
		System.out.println("List size=" + list.size());
		for (Task nextTask : list) {
			System.out.println(nextTask);
		}
		
		
	}
	public void editProperties(int indexID,Status status) {
		methode.editStatus(indexID, status);
	}
}


