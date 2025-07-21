package com.student;

import java.util.Scanner;


public class StudentImpl implements IStudents{
private Students [] studentsArray=new Students[10];
private int count=0;
    @Override
    public void addStudent(Students s) {
        if(count<studentsArray.length)
        {
            studentsArray[count++]=s;
        }
        else {
            System.out.println("Cannot add Student beacuse seats are full!!!");
        }
        
    }

    @Override
    public void display() {
        sortByAge();
        for(int i=0;i<count;i++)
        {
            System.out.println(studentsArray[i].toString());
        }
        
    }

    @Override
    public void sortByAge() {
        for(int i=0;i<count-1;i++)
        {
            for(int j=i+1;j<count-i-1;j++)
            {
                if(studentsArray[i].age>studentsArray[j].age)
                {
                    Students tempStudents=studentsArray[i];
                    studentsArray[i]=studentsArray[j];
                    studentsArray[j]=tempStudents;
                }
            }
        }
        display();
    }

    @Override
    public void displayChoice() {
        int choice=0;
        Scanner s=new Scanner(System.in);
        while(choice!=4) {
        System.out.println("Enter your choice : ");
        System.out.println("1.Add Student :\n2.Sort By Age \n3.Display\n4.Exit : ");
        choice=s.nextInt();
      
        switch (choice) {
            
            case 1:
                int id=(int) Math.random();
                System.out.println("Enter your Name:-");
                String nameString=s.next();
                System.out.println("Enter your age:-");
                int age=s.nextInt(); 
                Students students=new Students(id, nameString, age);
                addStudent(students);
                if(students!=null)
                System.out.println("Student added successfully");
                break;
            case 2:
                sortByAge();
                 break;
                 
            case 3:
                display();
                break;
            case 4:
                break;
            default:
                System.out.println("Enter correct choice");
                break;
        }
        
       }
    }
    
}
