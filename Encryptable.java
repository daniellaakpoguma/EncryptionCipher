/**
 * A brief description of the role of this class: Interface for Encryptable Classes
 * Student Name: Akpoguma Oghenerukevwe
 * Student Number: 041075624
 * Course: CST8132 Object Oriented Programming
 * Program: CET-CS-Level 2
 * Professor:James Mwangi PhD.
 *
 */

/**
 * Contains classes and interfaces for encryption
 */
package encryption;


/**
 * @author Oghenerukevwe Akpoguma
 * @version 1
 * @since 15th March, 2022.
 */

/**
 * Encryptable interface to be used for classes that can be encrypted
 */
public interface Encryptable {
	/** The start character for printable ASCII characters
	 */
	int START_CHAR = ' ' ; 
	/**
	 * The end character for printable ASCII characters
	 */
	int END_CHAR = 'z';
	/**
	 * The range for printable ASCII characters
	 */
	int RANGE = (END_CHAR - START_CHAR)+ 1;
	
	/*
	 * method that does not have body that gives the encrypted version of the given string
	 */
	
	/**
	 * Performs the encryption process
	 * @param input the plain text to be encrypted
	 * @return the encrypted version of the plain text
	 */
	String encrypt (String input); 
	
	/*
	 * method that does not have body that gives the decrypted version of the given encrypted string
	 */
	
	/**
	 * Performs the decryption process
	 * @param input The encrypted text to be decrypted
	 * @return The decrypted version of the test
	 */
	String decrypt (String input);
}
