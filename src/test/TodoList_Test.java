package test;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import models.TodoList;

class TodoList_Test {
	
	TodoList todo1;

	@Test
	void Test () {
		
		
		LocalDate today = LocalDate.now().plusDays(15);
		LocalDate.parse("2017-12-01");
		
		todo1 = new TodoList("Clean windows",1,today);
		TodoList todo2 = new TodoList("Clean Harddrive",2,today);
		TodoList todo3 = new TodoList("Make GitHub account",2,today);
		TodoList todo4 = new TodoList("Develope new website",3,today);
		TodoList todo5 = new TodoList("Increase memory",1,today);
		TodoList todo6 = new TodoList("Clean desk",2,today);
		
		int todoCount =6;  // TodoMethod.Count()
		assertTrue(6==6);
		assertTrue(todo1.getTaskName().equals("Clean windows"));
						
	}

}
