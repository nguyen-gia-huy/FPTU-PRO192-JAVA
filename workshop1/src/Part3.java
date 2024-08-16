
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
public class Part3 {
    public static void main(String[] args) {
        String[] list = new String[10];
        for(int i = 0; i < 10; i++){
            Scanner sc = new Scanner(System.in);
            list[i] = sc.nextLine();
        }
        for(int i = 0; i < 10; i++){
          char first;
          String remain;
          String name;
           first = Character.toUpperCase(list[i].charAt(0));
           remain = list[i].substring(1);
           list[i] = first + remain;
        }    
        for (String name : list) {
            System.out.println(name);
        }
    }
}
