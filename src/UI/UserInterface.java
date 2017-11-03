package UI;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import models.InputType;
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
			System.out.print("4 Check deadline | ");
			System.out.print("5 List Sorted | ");
			System.out.print("6 Remove | ");
			System.out.println("7 Search |");
			System.out.println("8 Entering more values |");
			System.out.println("9 Exit");

			String select = scString.next();
			try {
				selected = Integer.parseInt(select);
			}
			catch (Exception e) {
				selected =0;
			}
			finally{

			}
			
			switch (selected) {
			case 1:
				// Enter task
				enterNewTask();
				break;
			case 2:
				// Delete task
				deleteTask();
				break;

			case 3:
				editStatusFromList();
				// Edit status
				break;

			case 4:
				// Check deadline
				checkDeadline();
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
				searchByText();
				break;

			case 8:
				System.out.println("Entering more values");
					enterBulkValues();
					break;
			case 9:
				System.out.println("Exiting program");
				return;

			default:
				System.out.println("Invalid option selected!");
				break;
			}
		} while (selected !=9);
	}


	public void searchByText() {
		System.out.println("Enter task text to search for:");
		String textSearch = scString.next();

		List<Task> list = methode.listAllTodo();

		Iterator<Task> itr = list.iterator();
		boolean found = false;
		while(itr.hasNext()) {
			Task task = itr.next();
			if (task.getTaskName().indexOf(textSearch) >=0) {
				System.out.println("Task with name" +task.getTaskName() + "found" );
				found= true;
			}
		}
		if (found==false) {
			System.out.println("Could not find the task");
		}
	}

	public void checkDeadline() {
		methode.checkIfDeadLineExceeded();
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
		if (id.equalsIgnoreCase("O")){
			editStatus(select,Status.OPEN);
		}
		else if (id.equalsIgnoreCase("D")) {
			editStatus(select,Status.DONE);
		}
	}

	private void enterBulkValues() {
		Random rand = new Random();

		LocalDate today = LocalDate.now();
		
		int days = rand.nextInt(200);
		Task todo1 = new Task("Clean windows",1,today.plusDays(days));
		methode.addItem(todo1);

		days = rand.nextInt(200);
		Task todo2 = new Task("Clean Harddrive",2,today.plusDays(days));
		methode.addItem(todo2);
		days = rand.nextInt(200);
		Task todo3 = new Task("Make GitHub account",2,today.plusDays(days));
		methode.addItem(todo3);
		days = rand.nextInt(200);
		Task todo4 = new Task("Develope new website",3,today.plusDays(days));
		methode.addItem(todo4);
	}

	void enterNewTask() {
		String date;
		int prio;
		LocalDate dateOut;
		System.out.println("Enter taskname:\t");
		GetInput input = new GetInput();
		String task = input.getKeyboard(InputType.STRING);
		
		do {
			System.out.println("Enter priority:\t");
			String sPrio = input.getKeyboard(InputType.INTEGER);
			prio = Integer.parseInt(sPrio);
		} while (prio<=0 || prio >=3);
		

		do {
			System.out.println("Deadline date:\t");
			date =input.getKeyboard(InputType.DATE);
		} while (date == null);
		
		dateOut = LocalDate.parse(date);
		
		Task todo = new Task(task,prio,dateOut);
		methode.addItem(todo );
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
			Collections.sort(list, new TaskDeadlineDateComparator());
		case "3":
			Collections.sort(list, new TaskNamePriorityComparator());
		case "4":
			// Collections.sort(list, new TaskNamePriorityComparator());
			
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


