package models;

import java.time.LocalDate;

import models.Status;

public class Task {
	private String taskName;
	private int priority;
	private Status status;
	private LocalDate dateDeadline;
	private LocalDate dateEntered;
	private int id=0;
	private int currentRecord=0;
	
	public Task(String taskName, int priority, LocalDate dateDeadline) {
		this.id=currentRecord;
		this.taskName = taskName;
		this.priority = priority;
		this.dateDeadline = dateDeadline;
		this.dateEntered = LocalDate.now();
		this.status = Status.OPEN;
		
		currentRecord++;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public LocalDate getDateDeadline() {
		return dateDeadline;
	}

	public void setDateDeadline(LocalDate dateDeadline) {
		this.dateDeadline = dateDeadline;
	}

	public LocalDate getDateEntered() {
		return dateEntered;
	}

	public void setDateEntered(LocalDate dateEntered) {
		this.dateEntered = dateEntered;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "Task [taskName=" + taskName + ", priority=" + priority + ", status=" + status + ", dateDeadline="
				+ dateDeadline + ", dateEntered=" + dateEntered + ", id=" + id + ", currentRecord=" + currentRecord
				+ "]";
	}

}
