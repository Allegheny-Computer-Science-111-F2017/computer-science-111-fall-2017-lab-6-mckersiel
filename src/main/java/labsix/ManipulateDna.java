package labsix;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;


/** This class has a method that manipulates a DNA string.
  * The first line displays the name of the programmer and the date.
  */
public class ManipulateDna {

  /** This program manioulates a DNA string. 
    * Compile this program: javac ManipulateDna.java
    * Run this program: java ManipulateDna
    */
  public static void main(String[] args) {
    // display the name of the programmer and the date
    System.out.println("Liam McKersie " + new Date());
    // declare the starting file and scanner
    File dnaInputsFile = null;
    Scanner scanner = null;
    // connect the scanner to the input file
    try {
      dnaInputsFile = new File("input/dna_inputs.txt");
      scanner = new Scanner(dnaInputsFile);
    } catch (FileNotFoundException noFile) {
      System.out.println("Unable to locate file");
    }
    // Step One: Read in and display the chosen DNA string
    String dnaString = scanner.nextLine();
    System.out.println("Okay, I am going to manipulate the DNA string \"" + dnaString + "\"");
    System.out.println();
    System.out.println("Enter a string only containing C, G, T and A: " + dnaString);
    String complementDna = dnaString.toUpperCase();
    // Step Two: Compute the complement of the DNA String
    complementDna = dnaString.replace('a', 'T');
    complementDna = complementDna.replace('t', 'A');
    complementDna = complementDna.replace('c', 'G');
    complementDna = complementDna.replace('g', 'C');
    System.out.println("Complement of " + dnaString + " is " + complementDna);
    // Step Three: Insert a randomly chosen DNA letter into the DNA String
    String dna = "actg";
    Random random = new Random();
    char letter = dna.charAt(random.nextInt(4));
    int randomInsertionIndex = random.nextInt(dnaString.length());
    String dnaMutationOne = dnaString.substring(0, randomInsertionIndex) 
        + letter + dnaString.substring(randomInsertionIndex);
    System.out.println("Inserting " + letter + " at position " + randomInsertionIndex 
        + " gives " + dnaMutationOne);
    // Step Four: Delete a DNA letter from a randomly chosen position in the DNA string
    String first = dnaString.substring(0, randomInsertionIndex);
    String second = dnaString.substring(randomInsertionIndex + 1, dnaString.length());
    System.out.println("Deleting from position " + randomInsertionIndex + " gives " + first 
        + second);
    // Step Five: Change a random position in the DNA String to a randomly chosen DNA letter
    String three = dnaString.substring(0, randomInsertionIndex);
    String four = dnaString.substring(randomInsertionIndex + 1, dnaString.length());
    System.out.println("Changing position " + (randomInsertionIndex + 1) + " gives " + first
        + letter + second);
    // Step Six: Display a final thankyou message
    System.out.println();
    System.out.println("Thank you for using the ManipulateDNA program.");
    System.out.println("Have an awesome day.");
  }

}
