/**
 * A brief description of the role of this class: An Encryptable class that uses a Vigenere cipher to encrypt/decrypt strings
 * Student Name: Akpoguma Oghenerukevwe
 * Student Number: 041075624
 * Course: CST8132 Object Oriented Programming
 * Program: CET-CS-Level 2
 * Professor:  James Mwangi PhD.
 *
 */
package encryption.ciphers;

import encryption.Encryptable;

/**
 * @author Oghenerukevwe Akpoguma
 * @version 1
 * @since 15th March, 2022.
 */


/**
 * Uses the Encryptable interface to encrypt and decrypt text using Vigenere Cipher
 *
 */
public class VigenereCipher implements Encryptable{
	/**
	 * Key used to cipher plain or encrypted text
	 */
	private String key;
	/**
	 * length of key
	 */
	private int keyLength;
	
	/*
	 * create Vigenere cipher with the given shift
	 */
	
	/**
	 * Parameterized constructor for the VigenereCipher Object
	 * @param password The value by which the plain or encrypted text is moved 
	 */
	public VigenereCipher(String password) {
		this.key = password;
		this.keyLength= key.length();
	}

	/*
	 * method that gives the encrypted version of the given string using a Vigenere cipher
	 */
	/**
	 * Encryption using a Vigenere Cipher
	 * @param input Text to be encrypted
	 * @return The encrypted version of the text
	 */
	@Override
	public String encrypt(String input) {
		 String encryptedWord = ""; //String for the encrypted word
		  int keyIndex = 0;
		  for (int i = 0; i < input.length(); i++) { //for loop for iterating through the given string
			   char letter = input.charAt(i);//getting the individual letter at each position of the string
	           if (letter >= START_CHAR && letter <= END_CHAR) {//setting the range of characters
	        	   int keyLetter =  key.charAt(keyIndex) - START_CHAR;//getting individual key letters
	        	   keyIndex = (keyIndex + 1) % keyLength; // increasing the index
	            char encryptedLetter = (char) ((letter - START_CHAR + keyLetter) % RANGE + START_CHAR);// encryption method
	            encryptedWord = encryptedWord + encryptedLetter;
	        }
		  }
	        return encryptedWord; // returning string
	    }
	
	/*
	 * method that gives the decrypted version of the given encrypted string using a Vigenere cipher
	 */
	
	/**
	 * Decryption using a Caesar Cipher
	 * @param input Text to be decrypted
	 * @return The decrypted version of the text
	 */
	@Override
	public String decrypt(String input) {
		 String decryptedWord = ""; //String for the decrypted word
		  int keyIndex = 0;
		  for (int i = 0; i < input.length(); i++) { //for loop for iterating through the given string
			   char letter = input.charAt(i); //getting the individual letter at each position of the string
	           if (letter >= START_CHAR && letter <= END_CHAR) {//setting the range of characters
	        	   int keyLetter =  key.charAt(keyIndex) - START_CHAR;
	        	   keyIndex = (keyIndex + 1) % key.length();
	        	   char decryptedLetter = (char) ((letter - START_CHAR - keyLetter + RANGE) % RANGE + START_CHAR);// decryption method
	            decryptedWord = decryptedWord + decryptedLetter;
	        }
		  }
	        return decryptedWord;// returning string
	    }

}

