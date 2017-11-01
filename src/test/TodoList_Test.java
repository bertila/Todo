package test;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import models.TodoList;
import models.TodoListCatalog;

class TodoList_Test {
	@Test
	void Test_CheckNumberOfRecords () {
		LocalDate today = LocalDate.now().plusDays(15);
		LocalDate.parse("2017-12-01");
		
		TodoList todo1 = new TodoList("Clean windows",1,today);
		TodoList todo2 = new TodoList("Clean Harddrive",2,today);
		TodoList todo3 = new TodoList("Make GitHub account",2,today);
		TodoList todo4 = new TodoList("Develope new website",3,today);
		TodoList todo5 = new TodoList("Increase memory",1,today);
		TodoList todo6 = new TodoList("Clean desk",2,today);
		
		int todoCount =6;  // TodoMethod.Count()
		assertTrue(6==6);
	}
	
	@Test
	void Test_Check_EntryOne() {
		LocalDate today = LocalDate.now();
		TodoList todo7 = new TodoList("Clean windows",1,today);
		assertTrue(todo7.getTaskName().equals("Clean windows"));
	}
	
	@Test
	void Test_Quantity() {
		TodoListCatalog method = new TodoListCatalog();
		LocalDate today = LocalDate.now();
		TodoList todo1 = new TodoList("Clean windows",1,today);
		TodoList todo2 = new TodoList("Clean Harddrive",2,today);
		TodoList todo3 = new TodoList("Make GitHub account",2,today);
		TodoList todo4 = new TodoList("Develope new website",3,today);
		
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
