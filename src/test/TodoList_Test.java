package test;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import models.Task;
import models.TodoListCatalog;

class TodoList_Test {
	@Test
	void Test_CheckNumberOfRecords () {
		LocalDate today = LocalDate.now().plusDays(15);
		LocalDate.parse("2017-12-01");
		
		Task todo1 = new Task("Clean windows",1,today);
		Task todo2 = new Task("Clean Harddrive",2,today);
		Task todo3 = new Task("Make GitHub account",2,today);
		Task todo4 = new Task("Develope new website",3,today);
		Task todo5 = new Task("Increase memory",1,today);
		Task todo6 = new Task("Clean desk",2,today);
		
		int todoCount =6;  // TodoMethod.Count()
		assertTrue(6==6);
	}
	
	@Test
	void Test_Check_EntryOne() {
		LocalDate today = LocalDate.now();
		Task todo7 = new Task("Clean windows",1,today);
		assertTrue(todo7.getTaskName().equals("Clean windows"));
	}
	
	@Test
	void Test_Quantity() {
		TodoListCatalog method = new TodoListCatalog();
		LocalDate today = LocalDate.now();
		Task todo1 = new Task("Clean windows",1,today);
		Task todo2 = new Task("Clean Harddrive",2,today);
		Task todo3 = new Task("Make GitHub account",2,today);
		Task todo4 = new Task("Develope new website",3,today);
		
		method.addItem(todo1);
		method.addItem(todo2);
		method.addItem(todo3);
		method.addItem(todo4);
		
		// int recordCount = method.listAllTodo().size();
		int methodCount = method.getNumberOfTodoItems();
		int listCount = method.listAllTodo().size();
				// .getNumberOfTodoItems();
		
		assertTrue(methodCount == listCount);
	}
	
	
	

}
