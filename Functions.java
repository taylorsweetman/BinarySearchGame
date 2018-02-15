package binarysearch;

import java.util.Scanner;

public class Functions {

    //I chose to use doubles to prevent integer overflow. There's a process to ensure whole number input.
    private double maxVal;
    private double minVal;
    private double initialMax;
    private double currentMid;
    private double numberOfTries;

    public void inputProcess() {
        System.out.println("I will try to guess your secret number");
        System.out.println("What is the maximum integer value your number could take?");
        initialMax = readDouble();
        maxVal = initialMax;
        System.out.println("Think of a number between 0 and " + initialMax);

        //numberOfTries calculates how many guesses it will take
        //in the worst case scenario to guess the user's number using binary search.
        numberOfTries = Math.ceil(Math.log(initialMax) / Math.log(2));
        
        System.out.println("Okay got your number? I think I can guess your number in " + numberOfTries + " tries. Try and prove me wrong!");
        loopProcess();
    }

    public double readDouble() {
        Scanner reader = new Scanner(System.in);
        double input = Double.parseDouble(reader.nextLine());
        
        //The loop below ensures that the input is a whole number
        while (input % 1 != 0) {
            System.out.println("Please enter a whole number");
            input = Double.parseDouble(reader.nextLine());
        }
        return input;
    }

    public String readString() {
        Scanner reader = new Scanner(System.in);
        String input = reader.nextLine();
        input = input.toUpperCase().trim();
        return input;
    }

    //Calculates the current mid point of all possible numbers that have not been eliminated by the user
    public void findMiddle() {
        double newMid = Math.floor((maxVal + minVal) / 2);
        currentMid = newMid;
    }

    //This function continually asks the user if their input is higher than the mid point of the possible numbers
    //It then cuts the data in half and only accepts the half of the data the user specifies
    //Once the search algorithm identifies the number, it notifies the user how many guesses it took.
    public void loopProcess() {
        int i = 0;
        while (true) {
            findMiddle();
            System.out.println("Is your number greater than " + currentMid + "? [Y or N]");
            i++;
            if (rightOfMid()) {
                minVal = currentMid + 1;
            } else {
                maxVal = currentMid;
            }
            if (minVal == maxVal) {
                System.out.println("Your number is " + minVal + "!");
                System.out.println("I guessed it in " + i + " tries");
                break;
            }
        }
    }

    //Asks the user if their number is in the right half of the possible number set
    public boolean rightOfMid() {
        String input = readString();
        while (true) {
            if (!(input.equals("Y") || input.equals("N"))) {
                System.out.println("Please enter \"Y\" or \"N\"");
                input = readString();
            } else {
                break;
            }
        }
        return input.equals("Y");
    }
}
