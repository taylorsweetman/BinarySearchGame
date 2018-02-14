package binarysearch;

import java.util.Scanner;

public class Functions {

    private double maxVal;
    private double minVal;
    private double initialMax;
    private double currentMid;
    private double numberOfTries;

    public Functions() {

    }

    public void inputProcess() {
        System.out.println("I will try to guess your secret number");
        System.out.println("What is the maximum integer value your number could take?");
        initialMax = (double) readDouble();
        maxVal = initialMax;
        System.out.println("Think of a number between 0 and " + initialMax);
        numberOfTries = (Math.log(initialMax) / Math.log(2)) + 1;
        System.out.println("Okay got your number? I think I can guess your number in " + numberOfTries + " tries. Try and prove me wrong!");
        loopProcess();

    }

    public double readDouble() {
        Scanner reader = new Scanner(System.in);
        double input = Double.parseDouble(reader.nextLine());
        return input;
    }
    
    public String readString() {
        Scanner reader = new Scanner(System.in);
        String input = reader.nextLine();
        input = input.toUpperCase().trim();
        return input;
    }

    public void findMiddle() {
        double newMid = Math.floor((maxVal + minVal) / 2);
        currentMid = newMid;
    }

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
