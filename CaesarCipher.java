/**
 * A brief description of the role of this class: An Encryptable class that uses a Caesar cipher to encrypt/decrypt strings
 * Student Name: Akpoguma Oghenerukevwe
 * Student Number: 041075624
 * Course: CST8132 Object Oriented Programming
 * Program: CET-CS-Level 2
 * Professor:  James Mwangi PhD.
 *
 */
package encryption.ciphers;

import encryption.Encryptable; //importing interface

/**
 * @author Oghenerukevwe Akpoguma
 * @version 1
 * @since 15th March, 2022.
 */

/**
 * Uses the Encryptable interface to encrypt and decrypt text using Caesar Cipher
 *
 */
public class CaesarCipher implements Encryptable {
	/**
	 * Key used to cipher plain or encrypted text
	 */
	private int key;
	
	/*
	 * create Caesar cipher with the given shift
	 */
	
	/**
	 * Parameterized constructor for the CaesarCipher Object
	 * @param shift The value by which the plain or encrypted text is moved
	 */
	public CaesarCipher(int shift) {
		this.key = shift;
	}
	
	/*
	 * method that gives the encrypted version of the given string using a Caesar cipher
	 */
	
	/**
	 * Encryption using a Caesar Cipher
	 * @param input Text to be encrypted
	 * @return The encrypted version of the text
	 */
	@Override
	public String encrypt(String input) { //
	    String encryptedWord = ""; //String for the encrypted word
	    for (int i = 0; i < input.length(); i++) { //for loop for iterating through the given string
            char letter = input.charAt(i); //getting the individual letter at each position of the string
            if (letter >= START_CHAR && letter <= END_CHAR) { //setting the range of characters
                char encryptedLetter = (char) ((letter - START_CHAR + key) % RANGE + START_CHAR);// encryption method
                encryptedWord += encryptedLetter;//adding encrypted letter to the string
            }
        }
        return encryptedWord;
    }
	
	/*
	 * method that gives the decrypted version of the given encrypted string using a Caesar cipher
	 */
	
	/**
	 * Decryption using a Caesar Cipher
	 * @param input Text to be decrypted
	 * @return The decrypted version of the text
	 */
	@Override
	public String decrypt(String input) {
		String decryptedWord = ""; //String for the decrypted word
		for (int i = 0; i < input.length(); i++) { //for loop for iterating through the given string
            char letter = input.charAt(i); //getting the individual letter at each position of the string
            if (letter >= START_CHAR && letter <= END_CHAR) { //setting the range of characters
                char decryptedLetter = (char) ((letter - START_CHAR - key + RANGE) % RANGE + START_CHAR); // decryption method
                decryptedWord += decryptedLetter; //adding decrypted letter to the string
            }
		}
		return decryptedWord;
	}
}
