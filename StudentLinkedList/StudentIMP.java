package StudentLinkedList;

import java.util.Scanner;

import StudentLinkedList.StudentLinkedList.StudentNode;

public class StudentIMP implements IStudents{
	StudentLinkedList StudentList=new StudentLinkedList(); 
	@Override
	public void addStudentData(int id,String name,int age) {
		// TODO Auto-generated method stub
		StudentList.AddStudent(id,name,age);
		
	}

	@Override
	public void displayStudentData() {
		// TODO Auto-generated method stub
		StudentList.PrintListOfStudents();
	}

	@Override
	public void displayChoice() {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		
		int choice=0;
		while(choice!=4) {
		System.out.println("Enter Your Choice:");
		
		System.out.println("1. Add Student \n2. Sort By Age \n3. Display Records \n4. Exit");
		
		choice=scanner.nextInt();
		
		
		switch (choice) {
		case 1: {
			int id=(int) Math.random();
			System.out.println("Enter Name:");
			String nameString=scanner.next();
			
			System.out.println("Enter Age:");
			int age=scanner.nextInt();
			
			
			addStudentData(id,nameString,age);
			
			System.out.println("Record added Succesfully ---");
			break;
		}
		case 2:{
			sortAge();
			break;
		}
		case 3:{
			displayStudentData();
			break;
		}
		case 4:{
			
		}
		default:
			break;
		}
		}
	}
	
	
	@Override
	public void sortAge() {
		StudentNode current = StudentList.Head;
	    while (current != null) {
	        StudentNode index = current.Next;
	        while (index != null) {
	            if (current.Age > index.Age) {
	                // Swap Age
	                int tempAge = current.Age;
	                current.Age = index.Age;
	                index.Age = tempAge;

	                // Swap Name
	                String tempName = current.Name;
	                current.Name = index.Name;
	                index.Name = tempName;

	                // Swap RollNo
	                int tempRoll = current.RollNo;
	                current.RollNo = index.RollNo;
	                index.RollNo = tempRoll;
	            }
	            index = index.Next;
	        }
	        current = current.Next;
	    }
	    displayStudentData();
	}

}

