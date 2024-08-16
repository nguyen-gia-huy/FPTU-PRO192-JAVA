
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nguye
 */
public class Part2_2 {
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        String input;
        boolean valid = false;
        
        do {
            try {
                System.out.print("Input the string 1: ");
                input = scanner.nextLine();
                
                if (input.matches("SE\\d{3}")) {
                    System.out.println("The string is " + input);
                    valid = true;
                } else {
                    throw new InvalidStringException("The string is invalid");
                }
            } catch (InvalidStringException e) {
                System.out.println(e.getMessage());
            }
        } while (!valid);
        
        scanner.close();
    }
}

class InvalidStringException extends Exception {
    public InvalidStringException(String message) {
        super(message);
    }
}
