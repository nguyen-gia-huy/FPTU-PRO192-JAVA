package data;




import data.Student;
import java.time.LocalDate;
import utils.Inputter;
import java.util.ArrayList;
import java.util.Scanner;



public class StudentManager {
        ArrayList<Student> students = new ArrayList<>();
//-----------------------------------Add-------------------------------------------       
       public void handleAddStudent() {
           boolean check;
           do{
               boolean isDup = true;
           String newStudentID = null;
           boolean checkESC = true;
           while(isDup){
           newStudentID = Inputter.getString(">Enter studentID (SE000000): ", ">Wrong format", "^[S][E]\\d{6}");
           int position = handleSearchStudentById(newStudentID);
           if(position == -1){
               isDup= false;   
            }else {
               System.out.println(">StudentID is Duplicate!");
               isDup=true;
           }
       }
        String newFullName = Inputter.getString(">Enter fullname: ", ">Do not empty");
        //int newDate = Inputter.getAnIteger("Enter day of bitrh (Day between 1->31): ", "Day between 1-31", 1, 32);
        int newMonth = Inputter.getAnIteger(">Enter month of birth (1-12): ", ">Month between 12", 1, 12);
            int newDate;
                if (newMonth == 2) {
                    newDate = Inputter.getAnIteger(">Enter day of birth (1-28): ", ">Day between 1-28", 1, 28);
                } else if (newMonth == 4 || newMonth == 6 || newMonth == 9 || newMonth == 11) {
                    newDate = Inputter.getAnIteger(">Enter day of birth (1-30): ", ">Day between 1-30", 1, 30);
                } else {
                    newDate = Inputter.getAnIteger(">Enter day of birth (1-31): ", ">Day between 1-31", 1, 31);
                }
         int newYear = Inputter.getAnIteger(">Enter year of birth (1940-2006): ", ">Year must from 1940 to 2006", 1940, 2006);
        LocalDate newBirthDate =  LocalDate.of(newYear,newMonth,newDate);
        double newGPA = Inputter.getADouble(">Enter GPA (0-10): ", ">GPA must on the scale 1-10", 0, 10);
        
        Student nStudent = new Student(newStudentID, newFullName, newBirthDate, newGPA);
        students.add(nStudent);
           check = useAgain();
           }while(check);
}
//--------------------------------remove----------------------------------- 
       public void handleRemoveStudent() {
           boolean check;
           do{
               if(students.isEmpty()){
               System.out.println(">StudentList is empty");
               break;
               }
               String studentID = Inputter.getString(">Enter studentID (SE000000)\n>Press X to exit: ", ">Wrong format", "^[S][E]\\d{6}|^[Xx]$");
               
               if (studentID.equalsIgnoreCase("X")) {
               System.out.println(">Exiting...");
               break;
               }
               if(handleSearchStudentById(studentID) == -1){
               System.out.println(">Student does not exist");
               }else{
              // System.out.println("------Information Of Student------");
              // System.out.println(students.get(handleSearchStudentById(studentID)));
              // System.out.println("Are You Sure To Remove ? (Yes/No)");
               students.remove(students.get(handleSearchStudentById(studentID)));
               System.out.println("--------Student removed successfully!--------");
               }
               check = useAgain();
           }while(check);
    }
//-------------------------------Update--------------------------------------
       public void handleUpdateStudent(){
           boolean check;
           if(students.isEmpty()){
            System.out.println(">StudentList is empty");
            return;
        }
           do{
               String studentID = Inputter.getString(">Enter studentID that you want to modify (Format SE000000) \n>Press X to exit: ", ">Wrong format", "^[S][E]\\d{6}|^[Xx]$");
           
               if (studentID.equalsIgnoreCase("X")) {
                System.out.println(">Exiting...");
                break;
        }
               
               int position = handleSearchStudentById(studentID);
           Student st;
           if(position != -1){
               st = students.get(position);
           }else{
               st = null;
           }
     
           if(st == null){
               System.out.println(">Not Found !!!");
           }else{
               System.out.println("-----------Information Student----------");
               System.out.println(st);
               System.out.println("----------------Updating----------------");
               //String newStudentID = Inputter.getString("Enter new studentID", "Wrong format", "SE\\d{6}");
               String newFullName = Inputter.getString(">Enter new fullname: ", ">can not empty");
               //int newDate = Inputter.getAnIteger("Enter day of bitrh (Day between 1-31): ", "Date between 1-31", 1, 32);
               
               int newMonth = Inputter.getAnIteger(">Enter month of birth (1-12): ", ">Month between 12", 1, 12);
               int newDate;
                    if (newMonth == 2) {
                        newDate = Inputter.getAnIteger(">Enter day of birth (1-28): ", ">Day between 1-28", 1, 28);
                    } else if (newMonth == 4 || newMonth == 6 || newMonth == 9 || newMonth == 11) {
                        newDate = Inputter.getAnIteger(">Enter day of birth (1-30): ", ">Day between 1-30", 1, 30);
                    } else {
                        newDate = Inputter.getAnIteger(">Enter day of birth (1-31): ", ">Day between 1-31", 1, 31);
                    }                  
               int newYear = Inputter.getAnIteger(">Enter year of birth (1940-2006): ", ">Year must from 1940 to 2006", 1940, 2006);
               LocalDate newBirthDate =  LocalDate.of(newYear,newMonth,newDate);
               double newGPA = Inputter.getADouble(">Enter new GPA(0-10): ", ">GPA must on the scale 1-10", 0, 10);
               //set lai gia tri
               //st.setStudentID(newStudentID);newDate
               
               st.setFullName(newFullName);
               st.setBirthDate(newBirthDate);
               st.setGpa(newGPA);
               System.out.println("----------Update succesfully--------");
           }
           check = useAgain();
        }while(check);
    }
       
 //----------------------------search-------------------------------------------- 
       public int handleSearchStudentById(String studentID){
           for(int i = 0; i<= students.size() - 1; i++ ){
               if(students.get(i).getStudentID().equals(studentID)){
                   return i ;
               }
           }
           return -1;
       }
 //---------------------------search---------------------------------------------
       public int handleSearchStudentByName(String fullName){
           for(int i = 0; i<= students.size() - 1; i++ ){
               if(students.get(i).getFullName().equals(fullName)){
                   return i ;
               }
           }
           return -1;
       }
 //--------------------------SearchStudentByID---------------------------------------
      public void handleSearchStudent() {
    boolean check;
    if (students.isEmpty()) {
        System.out.println(">StudentList is empty");
        return;
    }
    do {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. SearchStudentByID");
        System.out.println("2. SearchStudentByName");
        System.out.println(">Press X to exit");
        String choiceStr = sc.nextLine();
        if (choiceStr.equalsIgnoreCase("X")) {
            System.out.println(">Exiting...");
            break;
        }
        int choice = Integer.parseInt(choiceStr);
        int position = 0;
        String studentID;
        String fullName;
        if (choice == 1) {
            studentID = Inputter.getString(">Enter studentID that you want to search (SE000000):\n>Press X to exit: ", ">Wrong format", "^[S][E]\\d{6}|^[Xx]$");
            if (studentID.equalsIgnoreCase("X")) {
                System.out.println(">Exiting...");
                break;
            }
            position = handleSearchStudentById(studentID);
        }
        if (choice == 2) {
            fullName = Inputter.getString(">Enter student name that you want to search:\n>Press X to exit: ", ">Do not empty");
            if (fullName.equalsIgnoreCase("X")) {
                System.out.println(">Exiting...");
                break;
            }
            position = handleSearchStudentByName(fullName);
        }
        Student st;
        if (position != -1) {
            st = students.get(position);
        } else {
            st = null;
        }

        if (st != null) {
            System.out.println(st);
        } else {
            System.out.println(">Not Found");
        }
        check = useAgain();
    } while (check);
}

//-----------------------list all-----------------------------
        public void liststudents(){
        if(students.isEmpty()){
            System.out.println(">StudentList is empty");
            return;//ngung luon
        }
        System.out.println("___________StudentLis____________");
        for (Student st : students) {
            System.out.println(st);//tu dong .toString()
        }
    }
//----------------------UseAgain-----------------------------
       public boolean useAgain (){
        Scanner sc = new Scanner(System.in);
        System.out.printf("\n**Press ENTER to continue, ANY KEY to exit the program**\n");     
        String checkESC = sc.nextLine();
        if(checkESC.isEmpty()) return true;
        else return false;
}
       
}