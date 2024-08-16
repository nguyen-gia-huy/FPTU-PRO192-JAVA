
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
public class Part1 {
    public static void main(String[] args) {
        int rows;
        int cols;
        int matrix[][];
        Scanner sc=new Scanner (System. in);
        System.out.println("Nhap so dong : ");
        rows=sc.nextInt ();
        System. out.println("Nhap so cot: ");
        cols=sc.nextInt ();
        matrix=new int [rows][cols];
        System.out.println("Nhap ma tran");
        for(int i = 0; i < rows; i++){
             for(int j=0;j<cols;j++) {
                System.out.print("\nm["+i+"]["+j+"]=");
                matrix[i][j]=sc.nextInt();
            }
        }
        System.out.println("Ma tran da duoc nhap:");
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols; j++) {
                System.out.format ("%3d",matrix[i][j]);
            }
            System. out.println("\n");
        }
        int sum = 0;
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols; j++) {
                sum += matrix[i][j];
            }
        }
        System.out.println("Tong : "+sum);
        System.out.println("Trung Binh:" +(float)sum/(rows*cols));
    }
}
