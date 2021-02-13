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
	
	public textbox_input(String title) {this.title = title;}
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
	
	public int[] returnFirstPosition(String str) {
		/**
		 * return the first index of the word.
		 * The basic method for the future development.
		 */
		int[] position = new int[2];
		function:
		for (Map.Entry<Integer,String> me: text_input.entrySet()) {
			String strarray[] = me.getValue().split(" ");
			for (int i = 0;i <= strarray.length;i++) {
				if (strarray[i].equals(str)){
					position[0] = me.getKey();
					position[1] = i + 1;
					break function;
				}
			}
		}
		return position;
	}
	//The two methods overlap too low.In the future,
	//other ways will be considered to realize the progressive nature of the two.
	
	public HashMap<Integer,int[]> returnAllPosition(String str){
		HashMap<Integer,int[]> position = new HashMap<Integer,int[]>();
		int index = 0;
		int indexOfSearch = 0;
		for (Map.Entry<Integer,String> me: text_input.entrySet()) {
			String strarray[] = me.getValue().split(" ");
			for (int i = 0;i < strarray.length;i++) {
				if (strarray[i].equals(str)){
					int[] positionPart = new int[2];
					positionPart[0] = me.getKey();
					positionPart[1] = i + 1;
					position.put(indexOfSearch,positionPart);
					indexOfSearch += 1;
				}
			}
//			if (me.getValue().indexOf(str,index) == -1) {
//				index = 0;
//				continue;
//			}
//			else {
//				int[] positionPart = new int[2];
//				positionPart[0] = me.getKey();
//				positionPart[1] = me.getValue().indexOf(str,index);
//				position.put(indexOfSearch,positionPart);
//				index = index + 1;
//			}
		}
		return position;
	}
	public void mainFunc() {
		/**
		 * The situation is slightly different.
		 * Because of the calling relationship,
		 * the main function has to be separated out.
		 */
		Scanner in = new Scanner(System.in);
		System.out.println("welcome to the textinput program!\n"
				+ "Title: " + this.title + "\n"
				+ "while you are in the first func, enter #quit to quit.\n"
				+ "1.start write\n"
				+ "2.get certain line\n"
				+ "3.get the row numbers\n"
				+ "4.show the text\n"
				+ "5.search for the first certain word\n"
				+ "6.search for all word\n"
				+ "7.exit");
		String key_input = in.nextLine();
		while(!key_input.equals("7")) {
			if(key_input.equals("1")) {
				System.out.println("now editing...--->");
				//Implement multi-line input, identifier stop.
				String text_in = in.nextLine();
				while(!text_in.equals("#quit")) {
					this.addSingleLine(text_in);
					text_in = in.nextLine();
				}
				System.out.println("ended.");
			}
			else if(key_input.equals("2")) {
				System.out.println("enter the number of row.");
				int rowNumber = in.nextInt();
				System.out.println(this.returnLine(rowNumber));
			}
			else if(key_input.equals("3")) {
				System.out.println(this.index);
			}
			else if(key_input.equals("4")) {
				this.showAll();}
			else if(key_input.equals("5")) {
				//This code is extremely repetitive.
				//Except for testing purposes, this is not recommended
				System.out.println("now input the word you want to find.");
				String text_in = in.nextLine();
				int[] position = this.returnFirstPosition(text_in);
				System.out.println("the first index of the word lies on "
						+ position[0] + " line " + position[1] + " word");
			}
			else if(key_input.equals("6")) {
				//This code is extremely repetitive.
				//Except for testing purposes, this is not recommended
				System.out.println("now input the word you want to find.");
				String text_in = in.nextLine();
				HashMap<Integer,int[]> position =  this.returnAllPosition(text_in);
				for (Map.Entry<Integer,int[]> me: position.entrySet()) {
					System.out.println(me.getKey()+" "
												  + me.getValue()[0] + " lines "
												  + me.getValue()[1] + " words ");
				}
			}
			System.out.println("enter the number of functions");
			key_input = in.nextLine();
			}	
	}
	public static void main(String[] args) {
		//for debug.
	}

}
