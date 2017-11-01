package UI;

import java.time.LocalDate;
import java.util.Scanner;

import models.Task;
import models.TodoListCatalog;


public class UserInterface extends TodoListCatalog {
	Scanner scString = new Scanner(System.in);
	// Scanner scInt = new Scanner(System.in);
	int selected;
	public void startInput() {
		
		do {
			System.out.print("Select function | ");
			System.out.print("1 New Task | ");
			System.out.print("2 Delete Task | ");
			System.out.print("3 Edit Status | ");
			System.out.print("4 List Deadline | ");
			System.out.print("5 List Sorted | ");
			System.out.print("6 Remove Task | ");
			System.out.println("7 Search");
			System.out.println("8 Exit");

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
				// Edit status
				break;

			case 4:
				// Check deadline
				break;

			case 5:
				// List all sorted
				break;

			case 6:
				// Remove done Todo
				break;

			case 7:
				// Search for a specific item
				break;

			case 8:
				System.out.println("Exiting program");
				System.exit(0);
				break;


			default:
				System.out.println("Invalid option selected!");
				break;
			}
		} while (selected !=8);
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
		//TodoListMethods methode = new TodoListMethods();
		
		//methode.addItem(todo);

		// scString.close();
	}

	private void getScannerInfo() {

	}

	private void searchForText(String find) {

	}
}


