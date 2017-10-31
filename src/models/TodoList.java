package models;

import java.time.LocalDate;

public class TodoList {
	private String taskName;
	private int priority;
	private LocalDate dateDeadline;
	private LocalDate dateEntered;

	
	public TodoList(String taskName, int priority, LocalDate dateDeadline) {
		this.taskName = taskName;
		this.priority = priority;
		this.dateDeadline = dateDeadline;
		this.dateEntered = LocalDate.now();
		
	}

}
