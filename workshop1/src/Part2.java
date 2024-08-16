
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
public class Part2 {
    public static void main(String[] args) {
        float num1,num2;
        String op;
        Scanner sc= new Scanner (System.in);
        System.out.println("Nhap so thu 1:");
        num1=sc.nextFloat();
        System.out.println("Nhap so thu 2:");
        num2=sc.nextFloat();
        System.out.println("Nhap phep toan can tinh (+-*/) : ");
        sc = new Scanner(System.in);
        op = sc.nextLine();
        switch (op) {
            case "+":
                System.out.println("ket qua la " + num1 +" "+ op +" "+ num2 +" = "+(num1+num2));
                break;
            case "-":
                System.out.println("ket qua la " + num1 +" "+ op +" "+ num2 +" = "+(num1-num2));
                break;
            case "*":
                System.out.println("ket qua la " + num1 +" "+ op +" "+ num2 +" = "+(num1*num2));
                break;
            case "/":
                System.out.println("kat qua la " + num1 +" "+ op +" "+ num2 +" = "+(num1/num2));
                break;
            default:
                break;
        }
    }
}
