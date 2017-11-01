package UI;

import java.time.LocalDate;
import java.util.Scanner;

import models.TodoList;
import models.TodoListCatalog;

public class UserInterface extends TodoListCatalog {
	Scanner sc1 = new Scanner(System.in);
	Scanner sc2 = new Scanner(System.in);
	public void startInput() {
		
		System.out.print("Select function | ");
		System.out.print("1 New Task | ");
		System.out.print("2 Delete Task | ");
		System.out.print("3 Edit Status | ");
		System.out.print("4 List Deadline | ");
		System.out.print("5 List Sorted | ");
		System.out.print("6 Remove Task | ");
		System.out.println("7 Search");
				
		
		int select = sc1.nextInt();
		
		switch (select) {
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


		default:
			return;
		}
	}
	
	void enterNewTask() {
		System.out.println("Enter taskname:\t");

		String task = sc2.next();
		
		System.out.println("Enter priority:\t");
		String prio = sc1.next();
		int prioInt = Integer.parseInt(prio);
		
		System.out.println("Deadline date:\t");
		String date =sc2.next();
		LocalDate date2 = LocalDate.parse(date);
		
		TodoList lst = new TodoList(task,prioInt,date2);
		System.out.println(lst.getTaskName());
		sc1.close();
		
		sc2.close();
	}
	
	private void getScannerInfo() {
		
	}
}


