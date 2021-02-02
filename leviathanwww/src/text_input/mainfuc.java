package text_input;

import java.util.Scanner;

import text_input.test_input;

public class mainfuc {

	public static void main(String[] args) {
		//main function of the program.
		test_input workspace  = new test_input();
		Scanner in = new Scanner(System.in);
		System.out.println("welcome to the textinput program!\n"
				+ "1.create a new text\n"
				+ "2.turn to a certain text\n"
				+ "3.delete certain text\n"
				+ "4.show all title to me\n"
				+ "5.exit");
		String key_input = in.nextLine();
		while(!key_input.equals("5")) {
			if(key_input.equals("1")) {
				System.out.println("enter the Title of the text.");
				workspace.addWindows(in.nextLine());
			} 
			else if(key_input.equals("2")) {
				System.out.println("enter the Title of the text.");
				workspace.getWindows(in.nextLine()).mainFunc();
			} 
			else if(key_input.equals("3")) {
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


