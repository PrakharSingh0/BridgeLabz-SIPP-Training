public class person {
    private String Name;
    private int Age;

    person(String Name,int age){
        this.Name=Name;
        this.Age=age;
    }

    // Copy Constructor
    person(person copyObject){
        this.Name=copyObject.Name;
        this.Age=copyObject.Age;
    }

    void DisplayOutput(){
        System.out.println("Name :"+this.Name);
        System.out.println("Age :"+this.Age);
    }

    public static void main(String[] args) {
        person pp=new person("Prakhar",22);
        person per=new person(pp);
        per.DisplayOutput();
    }
}
