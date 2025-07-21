package StudentLinkedList;

public class StudentLinkedList {
    StudentNode Head;
    StudentNode Tail;

    class StudentNode {
        int RollNo;
        String Name;
        int Age;
        StudentNode Next;

        StudentNode(int RollNo, String Name, int Age) {
            this.RollNo = RollNo;
            this.Name = Name;
            this.Age = Age;
            Next = null;
        }
    }

    public StudentNode AddStudent(int RollNo, String Name, int Age) {
        StudentNode newStudent = new StudentNode(RollNo, Name, Age);
        if (this.Head == null) {
            Head = Tail = newStudent;
            return Head;
        }
        newStudent.Next = Head;
        Head = newStudent;
        return Head;
    }

    public void PrintListOfStudents() {
        if (Head == null)
            return;
        StudentNode curr = Head;
        while (curr != null) {
            System.out.println("Roll No :" + curr.RollNo + " Student Name :" + curr.Name + " Age: " + curr.Age);
            curr = curr.Next;
        }
    }

}
