package UI;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import models.InputType;
import models.Status;
import models.Task;
import models.TodoListCatalog;
import models.XmlExample;


public class UserInterface extends TodoListCatalog {
	Scanner scString = new Scanner(System.in);
	Scanner scInt = new Scanner(System.in);
	XmlExample XMLStart = new XmlExample();  

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
			System.out.print("7 Search |");
			System.out.print("8 Entering more values | ");
			System.out.print("9 Save XML | ");
			System.out.print("10 Load XML | ");
			System.out.println("11 Exit Program | ");
			
			GetInput input = new GetInput();

			String task = input.getKeyboard(InputType.INTEGER);
			selected = Integer.parseInt(task);
			
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
				// Edit status
				editStatusFromList();
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
				// Remove task that is done
				removeDoneTodo();
				break;

			case 7:
				// Search for a specific item
				searchByText();
				break;

			case 8:
				// Function to add 4 items
				System.out.println("Entering more values");
				enterBulkValues();
				break;

			case 9:
				// List<Task> list = methode.listAllTodo();
				System.out.println("Saving XML-file");
				XMLStart.saveXml( methode, "SAVE");
				break;

			case 10:
				// List<Task> list = methode.listAllTodo();
				System.out.println("Loading XML-file");
				XMLStart.saveXml( methode, "LOAD");
				break;
			case 11:
				System.out.println("Exiting program");
				return;

			default:
				System.out.println("Invalid option selected!");
				break;
			}
		} while (selected !=11);
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
		
		GetInput input = new GetInput();
		String id = input.getKeyboard(InputType.INTEGER);
		int select = Integer.parseInt(id);

		methode.deleteItem(select);
	}

	private void removeDoneTodo() {
		methode.removeDoneItems();
	}

	private void editStatusFromList() {
		System.out.println("Select ID to change");
		
		GetInput input = new GetInput();
		String id = input.getKeyboard(InputType.INTEGER);
		int select = Integer.parseInt(id);
		
		System.out.println("Select status (O)PEN/(D)ONE");
		
		id = input.getKeyboard(InputType.STRING);
		
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
		} while (prio<=0 || prio >=4);


		do {
			System.out.println("Deadline date:\t");
			date =input.getKeyboard(InputType.DATE);
		} while (date == null);

		dateOut = LocalDate.parse(date);

		Task todo = new Task(task,prio,dateOut);
		methode.addItem(todo );
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


