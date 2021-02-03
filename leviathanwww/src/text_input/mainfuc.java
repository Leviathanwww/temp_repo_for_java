package text_input;

import java.util.Scanner;

import text_input.sheet_controller;

public class mainfuc {
	/**
	 * In order to have strong independence between classes, 
	 * the main function is taken out separately.
	 * The main realization of the interface selection function, 
	 * to achieve user - friendly.
	 */
	public static void showSlogen() {
		/**
		 * put it separately in order to avoid redundant code.
		 */
		System.out.println("welcome to the textinput program!\n"
				+ "1.create a new text\n"
				+ "2.turn to a certain text\n"
				+ "3.delete certain text\n"
				+ "4.show all title to me\n"
				+ "5.exit");
	}
	public static void main(String[] args) {
		//main function of the program.
		sheet_controller workspace  = new sheet_controller();
		Scanner in = new Scanner(System.in);
		showSlogen();
		String key_input = in.nextLine();
		while(!key_input.equals("5")) {
			if(key_input.equals("1")) {
				System.out.println("(CREATE)enter the Title of the text.");
				workspace.addWindows(in.nextLine());
			} 
			else if(key_input.equals("2")) {
				System.out.println("(OPEN)enter the Title of the text.");
				workspace.getWindows(in.nextLine()).mainFunc();
				showSlogen();
			} 
			else if(key_input.equals("3")) {
				System.out.println("(DELETE)enter the Title of the text.");
				workspace.deleteWindows(in.nextLine());
			} 
			else if(key_input.equals("4")) {
				workspace.showAllWindows();
			} 
			System.out.println("enter the number of functions");
			key_input = in.nextLine();
		}
		System.out.println("exiting....");
		}

	}


