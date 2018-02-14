package binarysearch;

import java.util.Scanner;

public class Functions {
    
    private int maximumVal;

    public Functions() {

    }

    public void inputProcess() {
        System.out.println("I will try to guess your secret number.");
        System.out.println("What is the maximum value your number could take?");
        maximumVal = Integer.parseInt(read());
    }

    public String read() {
        Scanner reader = new Scanner(System.in);
        String input = reader.nextLine();
        return input;
    }
    
    public int findMiddle(){
        
    }
    

}
