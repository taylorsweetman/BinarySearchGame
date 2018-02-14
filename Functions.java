package binarysearch;

import java.util.Scanner;

public class Functions {

    private int maxVal;
    private int minVal;
    private int initialMax;
    private int currentMid;
    private int numberOfTries;

    public Functions() {

    }

    public void inputProcess() {
        System.out.println("I will try to guess your secret number");
        System.out.println("What is the maximum value your number could take?");
        initialMax = Integer.parseInt(read());
        maxVal = initialMax;
        System.out.println("Think of a number between 0 and " + initialMax);
        numberOfTries = (int) (Math.log(initialMax) / Math.log(2)) + 1;
        System.out.println("Okay got your number? I think I can guess your number in " + numberOfTries + " tries. Try and prove me wrong!");
        loopProcess();

    }

    public String read() {
        Scanner reader = new Scanner(System.in);
        String input = reader.nextLine();
        return input;
    }

    public void findMiddle() {
        int newMid = (maxVal + minVal) / 2;
        currentMid = newMid;
    }

    public void loopProcess() {
        while (true) {
            findMiddle();
            System.out.println("Is your number greater than " + currentMid + "? [Y or N]");
            if (rightOfMid()) {
                minVal = currentMid + 1;
            } else {
                maxVal = currentMid;
            }
            if (minVal == maxVal) {
                System.out.println("Your number is " + minVal + "!");
                break;
            }
        }
    }

    public boolean rightOfMid() {
        return read().equals("Y");
    }

}
