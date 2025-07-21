package com.student;

public class StudentsMain {
    
    public static void main(String[] args) {
        IStudents students=new StudentImpl();
        students.displayChoice();
   }
}
