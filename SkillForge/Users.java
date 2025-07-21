package SkillForge;


public class Users extends Instructor{
	String Student;
	Course appliedCourse;
	
	public Users() {
		this.Student="XYZ";
		this.appliedCourse=null;
	}
	
	public Users(String Student,Course course) {
		this.Student=Student;
		this.appliedCourse = course;
	}
}
