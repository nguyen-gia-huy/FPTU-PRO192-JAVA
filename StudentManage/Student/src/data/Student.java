package data;

import java.time.LocalDate;


public class Student {
    private String studentID;
    private String fullName;
    private LocalDate birthDate;
    private double gpa;

    public Student() {
    }

    
    public Student(String studentID, String fullName, LocalDate birthDate, double gpa) {
        this.studentID = studentID;
        this.fullName = fullName;
        this.birthDate = birthDate;
        setGpa(gpa);
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        if (gpa >= 0 && gpa <= 10) {
            this.gpa = gpa;
        } else if (gpa >= 11 && gpa <= 100) {
            this.gpa = gpa / 10;
        } else {
            throw new IllegalArgumentException("GPA phai thuoc thang diem 10");
        }
    }

    @Override
    public String toString() {
        return  "StudentID= " + studentID + '\'' + ", FullName='" + fullName + '\'' + ", BirthDate=" + birthDate + ", Gpa=" + gpa ;
    }
}
