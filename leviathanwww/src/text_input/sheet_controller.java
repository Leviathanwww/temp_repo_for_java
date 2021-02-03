package text_input;


import java.util.HashMap;
import java.util.Set;

import text_input.textbox_input;

public class sheet_controller {
	//Implementing multiple Windows.
	private HashMap<String, textbox_input> windows = new HashMap<String, textbox_input>();

	public void addWindows(String Title) {
		/**
		 * Create a new text box titled String Title
		 */
		textbox_input sheet = new textbox_input(Title);
		this.windows.put(Title, sheet);
		System.out.println(Title + " added");
	}
	
	public void showAllWindows() {
		/**
		 * show all text name.
		 */
		System.out.println("Here is the title: ");
		Set<String> allTitle = this.windows.keySet();
		for (String title : allTitle) {
			System.out.println(title);
		}
	}
	
	public textbox_input getWindows(String Title) {
		/**
		 * to get the private property ---- Title.
		 */
		return this.windows.get(Title);
	}
	
	public void deleteWindows(String Title) {
		/**
		 * There is only one feature that has been implemented, 
		 * deletion of the end.
		 */
		this.windows.remove(Title);
		System.out.println("Delete successfully");
	}
	public static void main(String[] args) {
		//for debug.
	}

}
