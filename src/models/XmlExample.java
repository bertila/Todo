package models;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XmlExample {
	public void saveXml(TodoListCatalog catalog, String command) {

		switch (command) {
		case "save": {
			// Using XmlIO to save an object to file, errors are unexpected (write protected files)
			try {
				XMLIO.saveObject("todolist.xml", catalog);
				break;
			} catch (IOException ex) {
				Logger.getLogger(Task.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		case "load": {
			// Loading with XmlIO, in this case the file might be missing.
			try {
				catalog = XMLIO.loadObject("todolist.xml", TodoListCatalog.class);
			} catch (IOException ex) {
				System.out.println("Could not load todolist.xml");
			}
			break;

		}

		}

	}



	//Where TodoList.class is a seperate class containing the collection to be saved to xml
	//Add default constructor and use public fields in TodoList.class     
	//data is the object to be saved to xml
	//The xml file should be placed in the root of the project








}
