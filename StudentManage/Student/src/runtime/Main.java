package runtime;


import data.StudentManager;
import java.time.LocalDate;
import java.util.Scanner;
import utils.Inputter;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager sm = new StudentManager();
        boolean out = true;
        while(out){
            System.out.println("-----------------------------------------------------------------------------------");
            System.out.println("___________________________________________");
            System.out.println("|Application for managing students by Java|");
            System.out.println("|1.Show all students information          |");
            System.out.println("|2.Insert Student                         |");
            System.out.println("|3.Find Student                           |");
            System.out.println("|4.Modify Student Information             |");
            System.out.println("|5.Remove Student By ID                   |");
            System.out.println("|6.Exit program                           |");
            System.out.println("|_________________________________________|");
            int choice;
            do{
                choice = Inputter.getAnIteger(">Your choice: ", ">Choose 1-6");
                if(choice <= 0 || choice >= 7){
                    System.out.println(">Invalid choice. Please try again");
                    out = false;
                }
                out = true;
            }while(choice <= 0 || choice >= 7);
            switch(choice){
                case 1:{
                    sm.liststudents();
                    break;
                }
                case 2:{
                       sm.handleAddStudent();
                    break;
                }
                case 3:{
                    sm.handleSearchStudent();
                    break;
                }
                case 4:{
                    sm.handleUpdateStudent();
                    break;
                }
                case 5:{
                    sm.handleRemoveStudent();
                    break;
                }
                 default:{
                    out = false;
                }
            }                                                      
        }
    }
}
