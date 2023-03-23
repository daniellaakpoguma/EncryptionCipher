/**
 * A brief description of the role of this class: Main for the programming
 * Student Name:Akpoguma Oghenerukevwe
 * Student Number: 041075624
 * Course: CST8132 Object Oriented Programming
 * Program: CET-CS-Level 2
 * Professor:  James Mwangi PhD.
 *
 */

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import encryption.Encryptable;
import encryption.ciphers.CaesarCipher;
import encryption.ciphers.VigenereCipher;

/**
 * @author Oghenerukevwe Akpoguma
 * @version 1
 * @since 15th March, 2022.
 */

/**
 * Software application main
 */
public class Lab4Test {
	/**
	 * Private scanner object shared by all method
	 */
	private Scanner input = new Scanner(System.in);
	
	/**
	 * Default constructor for Lab4Test
	 */
	public Lab4Test(){}
	
	/*
	 * Prints menu options
	 */
	
	/**
	 * 
	 * @param options A vargargs of menu options to be displayed to the user
	 * @return The printed menu options
	 */
	public String printOptions(String... options) {
		String optionsMenu = "";
	    for (int i = 0; i < options.length; i++) {
	    	 optionsMenu = optionsMenu + options[i] + "\n";
	    }
	    return optionsMenu;
	}
	
	/*
	 * Using a vararg of menu options have user select one and return option number
	 */
	
	/**
	 * 
	 * @param options  A vargargs of menu options to be displayed to the user
	 * @return The options given to the method 
	 */
	public int getMenuItem(String... options) {
	    String print = printOptions(options);
	    int selectedOption = getInt(  print + "Select option:", 1, 4);
	    return selectedOption;
	}
	
	/*
	 * Get a string from the user
	 */
	
	/**
	 * 
	 * @param prompt To be displayed to the user
	 * @return The string read from the keyboard using the scanner
	 */
	public String getString(String prompt) {
		input = new Scanner(System.in);
		System.out.print(prompt);//print given prompt
		String userString = input.nextLine(); //get string from user containing space
		return userString; //return string
	}
	
	/*
	 * Get an integer from the user
	 */
	
	/**
	 * 
	 * @param prompt To be displayed to the user
	 * @param min Value that the inputted integer can be
	 * @param max Value that the inputted integer can be
	 * @return The integer read from the keyboard using the scanner that is in the proper range
	 */
	public int getInt (String prompt, int min, int max) {  
		boolean invalidInput = true;
		int inputInt = 0;
			do {
				System.out.print(prompt); //print prompt
				try {
					inputInt = input.nextInt(); //gets int from user
					if(min <= inputInt && inputInt <= max) { //range of integer from user
						invalidInput = false;
					}else {
						System.out.println("Please select a number in the range"); //prints if number is out of range
						input.nextLine();
					}
				}catch(InputMismatchException e) {
					System.out.println("Please enter an integer"); //prints if invalid input is entered
					input.nextLine();
				}	
			}while(invalidInput);
		return inputInt;
	}
	
	/*
	 * Get the encryption method from the user	
	 */
	
	/**
	 * 
	 * @return The chosen Encryption method object
	 */
	public Encryptable getMethod() {
		int caesarShift;
		String vigenerePassword;
		Encryptable chosenMethod = null;
		int method;
		String newLine = System.lineSeparator();  
				method = getInt("Encryption method" + newLine + "1 - Caesar" + newLine + "2 - Vigenere" + newLine + "Select option:" ,1,2);
					if (method == 1) {  
								caesarShift = getInt("Shift value:", 0, Encryptable.RANGE); //constructor parameter for Caesar Cipher
								CaesarCipher caesar = new CaesarCipher(caesarShift); //creates new Caesar Cipher object
								chosenMethod = caesar; //returns said object
					}else if (method == 2) {
								vigenerePassword = getString("Password:"); //constructor parameter for Vigenere Cipher
								VigenereCipher vigenere = new VigenereCipher(vigenerePassword);//creates new Vigenere Cipher object
								chosenMethod = vigenere;//returns said object
						}
		return chosenMethod; //returns object of chosen Class
	}
	
	/*
	 * Application main
	 */
	
	/**
	 * 
	 * @param args Variable of Strings to be displayed to the user
	 */
	public static void main(String[] args) {
		System.out.println("Encryption tester");
		
		ArrayList <String> encryptedText = new ArrayList <String>(); //array List for encrypted Text
		Lab4Test test = new Lab4Test();
		int selectedOption;
		String normalText = null;
		
		do {
	    selectedOption = test.getMenuItem("1 - Encrypt text", "2 - Decrypt text", "3 - Display encrypted list", "4 - Exit");
	    
	    switch (selectedOption) {
	    	case 1:
	    		normalText = test.getString("Please enter text to be encrypted:");
	    		Encryptable encryptMethod = test.getMethod(); //chooses encryption method
	    		String encryptText = encryptMethod.encrypt(normalText); //passes plain text into encryption method
	    		encryptedText.add(encryptText); //add encrypted text into array list
	    		System.out.println("Encrypted value is "  + encryptText);
	    		break;
	    	case 2:
	    		if(encryptedText.isEmpty()) {
	    			System.out.println ("Nothing to decrypt"); //prints if array list is empty
	    		}else {
	    			int encryptList = test.getInt("Message number you want to decrypt:",1, encryptedText.size());
	    			Encryptable decryptMethod = test.getMethod(); //chooses decryption method
	    			String decryptText = decryptMethod.decrypt(encryptedText.get(encryptList-1));
	    			System.out.println("Decrypted value #" + encryptList + " is " + decryptText);
	    		}
	    		break;
	    	case 3:
	    		if (encryptedText.isEmpty()) {
	    		    System.out.println("Nothing to display");  //prints if array list is empty 
	    		} else {
	    			System.out.println("----------------");
	    		    for (int i = 0; i < encryptedText.size(); i++) {
	    		        System.out.println("#" + (i+1) + ": " + encryptedText.get(i)); //prints array list member
	    		    }
	    		    System.out.println("----------------");
	    		}
	    		break;
	    	case 4:
	    		break;
	    	}
		}while(selectedOption != 4);
		
		System.out.println ("Good bye!");
	}
	
}
