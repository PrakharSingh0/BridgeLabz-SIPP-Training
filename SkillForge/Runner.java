package SkillForge;


public class Runner {
	
	public static void main(String[] args) {
		
		Instructor Professor1=new Instructor();
		
		Course course1 = new Course("Java Fundamentals",new Instructor("Professor XYZ"),9,new String[] {"Java Basic","OOPs"});
		Course course2 = new Course("Python Fundamentals",new Instructor("Professor ABC"),10,new String[] {"Python Basic","OOPs","ML"});
		Course course3 = new Course("C++ Fundamentals",new Instructor("Professor PQR"),10,new String[] {"Basic"});
		
		Users studentUsers1 =new Users("Prakhar",course1);
		Users studentUsers2 =new Users("Abhay",course2);
		
		course1.genrateCertificate(studentUsers1);
		System.out.println();
		course2.genrateCertificate(studentUsers2);
	}

	
}

