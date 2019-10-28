/**
 * Problem Set 4.
 *
 * It's time to put your skills to the test. This problem set focuses on using
 * iterative control structures. The `main` method is done for you. Lines 30-39
 * trigger each of the predefined methods, which you can think of as self-contained
 * executable pieces of logic. Write your code for each exercise in the
 * corresponding method.
 *
 * The specifications for each exercise are outlined below. Your job is to write
 * lines of code to produce answers to my questions. Each exercise requires that
 * you ask the user to enter one or more values. Your code must meet the
 * requirements set forth in this section (as well as the *Deliverables* section).
 *
 * Work through these exercises on your own. Experiment, make mistakes, ask
 * questions, and fix your mistakes. It's the only way to get good at programming.
 */

import java.util.Scanner;

public class ProblemSet4 {

    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        ProblemSet4 ps = new ProblemSet4();

        // comment out or uncomment as needed

        ps.sum();
        ps.reverse();
        ps.digits();
        ps.average();
        ps.prime();
        ps.fibonacci();
        ps.factors();
        ps.mario();
        ps.luigi();
        ps.credit();

        in.close();
    }

    /*
     * Exercise 1.
     *
     * Prompt the user to enter two integers. The first integer is a lower bound, and
     * the second integer is an upper bound.
     *
     * Compute the sum of all even integers between the lower and upper bounds,
     * including the bounds themselves.
     */

    public void sum() {
      int lowerBound = 1;
      int upperBound = 0;
      int integerSum = 0;

      System.out.println("");
      do {
        System.out.print("Lower bound: ");
        lowerBound = in.nextInt();
        System.out.print("Upper bound: ");
        upperBound = in.nextInt();
      } while (lowerBound > upperBound);

      for (int i = lowerBound; i <= upperBound; i++) {
        if (i % 2 == 0) {
          integerSum += i;
        }
      }

      System.out.printf("\n%,d.\n", integerSum);
    }

    /*
     * Exercise 2.
     *
     * Prompt the user to enter a positive integer. Print the digits of this integer
     * in reverse order.
     */

    public void reverse() {
      int forwardPositiveIntegerInput;
      System.out.println("");
      do {
        System.out.print("Positive integer: ");
        forwardPositiveIntegerInput = in.nextInt();
      } while (forwardPositiveIntegerInput <= 0);
      String forwardPositiveInteger = String.valueOf(forwardPositiveIntegerInput);
      String reversePositiveInteger = "";
      String digitToAdd = "";

      for (int i = forwardPositiveInteger.length(); i > 0; i--) {
        if(i != forwardPositiveInteger.length()) {
          reversePositiveInteger = reversePositiveInteger + ", ";
        }
        digitToAdd = forwardPositiveInteger.substring(i - 1, i);
        reversePositiveInteger = reversePositiveInteger + digitToAdd;
      }
      reversePositiveInteger = reversePositiveInteger + ".";

      System.out.println("\n" + reversePositiveInteger);
    }

    /*
     * Exercise 3.
     *
     * Prompt the user to enter a positive integer. Compute the sum of all of the odd
     * digits in the integer.
     */

    public void digits() {
      int oddDigitInteger;
      int oddDigitSum = 0;

      System.out.println("");
      do {
        System.out.print("Positive integer: ");
        oddDigitInteger = in.nextInt();
      } while (oddDigitInteger <= 0);
      String oddDigitString = String.valueOf(oddDigitInteger);
      int integerToAdd;

      for (int i = oddDigitString.length(); i > 0; i--) {
        integerToAdd = Integer.parseInt(oddDigitString.substring(i - 1, i));
        if(integerToAdd % 2 == 1) {
          oddDigitSum += integerToAdd;
        }
      }

      System.out.println("\n" + oddDigitSum + ".");
    }

    /*
     * Exercise 4.
     *
     * Prompt the user to enter a series of non-negative integers. When the user
     * enters a negative integer, you can assume he or she is done entering values.
     * What is the average of the values entered?
     */

    public void average() {
      double average = 0;
      double averageInput = 0;
      double count = 0;
      double offset = 0;

      //makes a new line
      System.out.println("");

      while (averageInput >= 0) {
          System.out.print("Non-negative integer: ");
          averageInput = in.nextDouble();
          in.nextLine();
          average += averageInput;
          count += 1;
          offset = (averageInput < 0) ? averageInput : 0;
      }

      average -= offset;
      count -= 1;

      average /= count;

      System.out.printf("\n%,.2f.\n", average);
    }

    /*
     * Exercise 5.
     *
     * Prompt the user to enter a non-negative integer. Is this number prime?
     */

    public void prime() {
      //makes a new line
      System.out.println("");
      int primeInt = -1;
      while (primeInt < 0 || primeInt > (Math.pow(2, 31)-1)){
        System.out.print("Non-negative integer: ");
        primeInt = in.nextInt();
      }
      boolean isPrime = true;

      int halfPrime = primeInt / 2;
      for (int i=2;i<=halfPrime;i++){
        if (primeInt % i == 0){
          isPrime = false;
          break;
        }
      }

      if (primeInt == 1 || primeInt == 0 || isPrime == false){
        System.out.println("\nNot prime.");
      } else if (isPrime == true){
        System.out.println("\nPrime.");
      }

    }

    /*
     * Exercise 6.
     *
     * Prompt the user to enter a positive integer in the range [1, 92]. If the
     * integer the user enters is called n, what is the nth Fibonacci number?
     */

    public void fibonacci() {
      int n = 0;
       System.out.println("");
       while (n <= 0 || n > 92) {
         System.out.print("Positive integer: ");
         n = in.nextInt();
       }

       long base1 = 0;
       long base2 = 1;
       long fibonacci = 0;

       for (int i = 2; i <= n; i++) {
         fibonacci = base1 + base2;
         base1 = base2;
         base2 = fibonacci;
       }

       System.out.println("\n" + base2 + ".\n");
    }

    /*
     * Exercise 7.
     *
     * Prompt the user to enter a positive integer. What are its factors?
     */

    public void factors() {
      int integerToFactor = 0;
      String factorsOutput = "";

      while (integerToFactor <= 0) {
          System.out.print("Positive integer: ");
          integerToFactor = in.nextInt();
          in.nextLine();
      }

      for (int i = 1; i <= Math.sqrt(integerToFactor); i++) {
          if (integerToFactor % i == 0) {
              factorsOutput += i + ", ";
              factorsOutput += integerToFactor / i + ", ";
          }
      }

      factorsOutput = factorsOutput.substring(0, factorsOutput.length() - 2) + ".";
      System.out.println("\n" + factorsOutput);
    }

    /*
     * Exercise 8.
     *
     * Prompt the user to enter an integer between 1 and 24 (inclusive). Print a Super
     * Mario-style half-pyramid of the specified height.
     */

    public void mario() {
      int marioHeight = 0;
      int numberOfBlocks = 0;
      int maxBlocks = 0;
      int numberOfSpaces = 0;
      System.out.print("\n");

      while (marioHeight <= 0 || marioHeight > 24) {
          System.out.print("Height: ");
          marioHeight = in.nextInt();
          in.nextLine();
          maxBlocks = marioHeight + 1;
      }

      System.out.print("\n");
      for (int i = 1; i < maxBlocks; i++) {
          numberOfBlocks = i + 1;
          numberOfSpaces = maxBlocks - numberOfBlocks;
          for (int j = 0; j < numberOfSpaces; j++) {
              System.out.print(" ");
          }
          for (int j = 0; j < numberOfBlocks; j++) {
              System.out.print("#");
          }
          System.out.print("\n");

      }
      System.out.print("\n");
    }

    /*
     * Exercise 9.
     *
     * Prompt the user to enter an odd integer between 1 and 24 (inclusive). Print a
     * Super Mario-style full pyramid of the specified height.
     */

    public void luigi() {
      int luigiHeight = 0;
      int numberOfBlocksLuigi = 0;
      int maxBlocksLuigi = 0;
      int numberOfSpacesLuigi = 0;

      while (luigiHeight <= 0 || luigiHeight > 24) {
         System.out.print("Height: ");
         luigiHeight = in.nextInt();
         in.nextLine();
         maxBlocksLuigi = luigiHeight + 1;
      }

      System.out.print("\n");
      for (int i = 1; i < maxBlocksLuigi; i++) {
         numberOfBlocksLuigi = i + 1;
         numberOfSpacesLuigi = maxBlocksLuigi - numberOfBlocksLuigi;
         for (int j = 0; j < numberOfSpacesLuigi; j++) {
             System.out.print(" ");
         }
         for (int j = 0; j < numberOfBlocksLuigi; j++) {
             System.out.print("#");
         }
         System.out.print(" ");
         for (int j = 0; j < numberOfBlocksLuigi; j++) {
             System.out.print("#");
         }
         for (int j = 0; j < numberOfSpacesLuigi; j++) {
             System.out.print(" ");
         }
         System.out.print("\n");
      }
    }

    /* KINDA WORKS????
     * Exercise 10.
     *
     * Prompt the user to enter a credit card number (not a real one!). According to
     * Luhn's algorithm, is the credit card number valid?
     */

    public void credit() {
        System.out.print("\nNumber: ");
        String cardNumber = in.nextLine();

        //length test
        int lengthTest = cardNumber.length();
        //Card Type Tests
        String d = cardNumber.substring(0, 2);
        boolean amTests = d.equals("34") || d.equals("37");
        boolean masterTests = d.equals("51") || d.equals("52") || d.equals("53") || d.equals("54") || d.equals("55");
        boolean visaTest = cardNumber.substring(0, 1).equals("4");

        //Luhn's algorithm
        int products = 0;
        for (int i = 1; i < lengthTest; i+=2){
          String digit = cardNumber.substring(i, i+1);
          int multiplication = Integer.parseInt(digit) * 2;
          int multiplicationLength = String.valueOf(multiplication).length();
          for (int y = 0; y < multiplicationLength; y++){
            products += Integer.parseInt(String.valueOf(multiplication).substring(y, y+1));
          }
        }
        int nonProducts = 0; //non-Products math is good

        for (int i = 0; i < lengthTest; i+=2){
          String digit = cardNumber.substring(i, i+1);
          nonProducts += Integer.parseInt(digit);
        }

        int finalLuhnTest = nonProducts + products;
        String finalLuhnTestString = String.valueOf(finalLuhnTest);
        boolean luhnAlgorithm = (finalLuhnTestString.substring(finalLuhnTestString.length()-1, finalLuhnTestString.length()).equals("0"));

        if (luhnAlgorithm){
          if (lengthTest == 15 && amTests){
            System.out.println("\nAmex.");
          } else if (lengthTest == 16 && masterTests){
            System.out.println("\nMastercard.");
          } else if (visaTest && (lengthTest == 16 || lengthTest == 13)){
            System.out.println("\nVisa.");
          }
        } else {
          System.out.println("\nInvalid.");
        }
        System.out.println("");
      }
    }
