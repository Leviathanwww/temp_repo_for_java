package text_input;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class textbox_input {
	/**
	 * This class implements the following functions: 
	 * initialize the indexed text box;
	 * Returns the value of the specified row;
	 * Specifies the return of an array of multi_row values
	 * Print documents.
	 */
	//Initialize the text_box. 
	public String title = "";
	private HashMap<Integer,String> text_input = new HashMap<Integer,String>();
	private int index = 1;

	public textbox_input(String title) {
		this.title = title;
	}
	public String returnLine(int index) {
		/**
		 *  This function is used to return a string with a specific 
		 *  number of lines in the text box
		 */
		return this.text_input.get(index);
	}
	
	public ArrayList<String> returnLine(int findex, int hindex) {
		/**
		 * This function is designed to read multiple lines of text in
		 * the format of array_list
		 */
		ArrayList<String> temp_list = new ArrayList<String>();
		for(int i = findex; i <= hindex; i++) {
			temp_list.add(this.returnLine(i));
		}
		return temp_list;
	}
	
	public void showAll() {
		/**
		 * This function is designed to take advantage of the hash_map feature 
		 * to print text content with a number of lines.
		 */
		for (Map.Entry<Integer,String> me: text_input.entrySet()) {
			System.out.println(me.getKey()+" "+me.getValue());
		}
	}
	
	public void addSingleLine(String line) {
		/**
		 * This function can add a new row.
		 */
		this.text_input.put(index, line);
		index = index + 1;
	}
	
	public int returnRow() {
		/**
		 * This function returns the total number of rows.
		 */
		return this.index;
	}
	
	public void deleteLastLine() {
		/**
		 * This function deletes the last number of rows.
		 */
		System.out.println("Delete"+this.text_input.remove(index)+"successfully");
		index = index - 1;
	}
	
	public void mainFunc() {
		Scanner in = new Scanner(System.in);
		System.out.println("welcome to the textinput program!\n"
				+ "Title: " + this.title + "\n"
				+ "while you are in the first func, enter #quit to quit.\n"
				+ "1.start write\n"
				+ "2.get certain line\n"
				+ "3.get the row numbers\n"
				+ "4.show the text\n"
				+ "5.exit");
		String key_input = in.nextLine();
		while(!key_input.equals("5")) {
			if(key_input.equals("1")) {
				System.out.println("now editing...--->");
				String text_in = in.nextLine();
				while(!text_in.equals("#quit")) {
					this.addSingleLine(text_in);
				}
				System.out.println("ended.");
			}
			else if(key_input.equals("2")) {
				System.out.println(this.returnLine(in.nextInt()));
			}
			else if(key_input.equals("3")) {
				System.out.println(this.index);
			}
			else if(key_input.equals("4")) {
				this.showAll();}
			System.out.println("enter the number of functions");
			key_input = in.nextLine();
			}	
	}
	public static void main(String[] args) {
		//for debug.
	}

}
