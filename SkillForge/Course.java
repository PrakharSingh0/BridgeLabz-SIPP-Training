package SkillForge;


public class Course implements ICertifiable{
	
	String tittle;
    private int Rating;
    String[] modules;
    Users stuNameUsers;
    Instructor instructorName;

    Course(){
        this.tittle="Default Tittle";
        this.instructorName=null;
        this.Rating=10;
        this.modules=null;
    }

    Course(String tittle,Instructor Instructor,int Rating,String[] modules){
        this.tittle=tittle;
        this.instructorName=Instructor;
        this.Rating=Rating;
        this.modules=modules;
    }

    @Override
    public void genrateCertificate(Users studentName) {
        System.out.println("-------------------------------");
        System.out.println("          Certificate          ");
        System.out.println("-------------------------------");
        System.out.println("Course Tittle :"+this.tittle);
        System.out.println("Completed By : "+studentName.Student);
        System.out.println("Instructed By : "+instructorName.InstructorName);
        System.out.println("No of Modules"+modules.length);
        System.out.println("Rating :"+this.Rating);
        System.out.println("-------------------------------");
    }
}
