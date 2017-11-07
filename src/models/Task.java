package models;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import UI.LocalDateAdapter;

public class Task {
	private String taskName;
	private int priority;
	private Status status;
	
	@XmlJavaTypeAdapter(value = LocalDateAdapter.class)
	private LocalDate dateDeadline;
	
	@XmlJavaTypeAdapter(value = LocalDateAdapter.class)
	private LocalDate dateEntered;
	
	private int id = 0;
	private static int currentRecord;
	//private Date sortDate;

	public Task(String taskName, int priority, LocalDate dateDeadline) {

		this.id = currentRecord;
		this.taskName = taskName;
		this.priority = priority;
		this.dateDeadline = dateDeadline;
		this.dateEntered = LocalDate.now();
		this.status = Status.OPEN;
		currentRecord++;
	}
	
	
	public Task() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public LocalDate getLocalDateDeadline() {
		return dateDeadline;
	}

	public Date getLocaldDeadline() {
		return Date.from(dateDeadline.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	}

	public void setLocalDateDeadline(LocalDate dateDeadline) {
		this.dateDeadline = dateDeadline;
	}

	public LocalDate getLocalDateEntered() {
		return dateEntered;
	}

	public void setLocalDateEntered(LocalDate dateEntered) {
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
		
		return "Task taskName=" + retValue(taskName, 25) + " priority=" + retValue(priority, 3) + " status="
				+ retValue(status, 7) + " dateDeadline=" + retValue(dateDeadline.toString(), 12) + " dateEntered="
				+ retValue(dateEntered.toString(), 12) + " id=" + retValue(id, 7);
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

	public static int getCurrentRecord() {
		return currentRecord;
	}
}
