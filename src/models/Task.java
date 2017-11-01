package models;

import java.time.LocalDate;

import UI.Status;

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		String returnValue ="";
		
		
		return "Task taskName=" + retValue(taskName,25) + " priority" + retValue(priority,3) + " status=" + retValue(status,7) + " dateDeadline="
				+ retValue(dateDeadline.toString(),12) + " dateEntered=" + retValue(dateEntered.toString(),12) + " id=" + retValue(id,7) + " currentRecord=" + retValue(currentRecord,5);
	}
	
	private String retValue(String input, int length) {
		String space = new String(new char[25]).replace('\0', ' ');
		String ret = (input + space).substring(0, length); 
		
		return ret;
		
	}
	
	private String retValue(int input, int length) {
		String convert = Integer.toString(input);
			
		return retValue(convert, length);
		
	}
	
	private String retValue(Status input, int length) {
		return retValue(input.toString(), length);
		
	}


}
