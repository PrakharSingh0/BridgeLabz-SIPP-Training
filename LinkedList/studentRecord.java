public class studentRecord {
    StudentNode Head;
    StudentNode Tail;

    class StudentNode {
        int RollNo;
        String Name;
        int Age;
        int Number;
        StudentNode Next;

        StudentNode(int RollNo, String Name, int Age, int Number) {
            this.RollNo = RollNo;
            this.Name = Name;
            this.Age = Age;
            this.Number = Number;
            Next = null;
        }
    }

    StudentNode AddStudentAtBeginning(int RollNo, String Name, int Age, int Number) {
        StudentNode newStudent = new StudentNode(RollNo, Name, Age, Number);
        if (this.Head == null) {
            Head = Tail = newStudent;
            return Head;
        }
        newStudent.Next = Head;
        Head = newStudent;
        return Head;
    }

    StudentNode AddStudentAtEnd(int RollNo, String Name, int Age, int Number) {
        StudentNode newStudent = new StudentNode(RollNo, Name, Age, Number);
        if (this.Head == null) {
            Head = Tail = newStudent;
            return Head;
        }
        Tail.Next = newStudent;
        Tail = newStudent;
        return Head;
    }

    StudentNode AddStudentAtNthPostion(int RollNo, String Name, int Age, int Number, int pos) {
        StudentNode newStudent = new StudentNode(RollNo, Name, Age, Number);
        if (pos == 0 || Head == null) {
            return AddStudentAtBeginning(RollNo, Name, Age, Number);
        }
        StudentNode curr = Head;
        int count = 1;
        while (curr != null && count < pos) {
            curr = curr.Next;
            count++;
        }
        if (curr == null) {
            System.out.println("Position out of bounds");
            return Head;
        }
        newStudent.Next = curr.Next;
        curr.Next = newStudent;
        if (newStudent.Next == null) {
            Tail = newStudent;
        }

        return Head;
    }

    void PrintListOfStudents() {
        if (Head == null)
            return;
        StudentNode curr = Head;
        while (curr != null) {
            System.out.println("Roll No :" + curr.RollNo + " Student Name :" + curr.Name + " Age: " + curr.Age
                    + " Number: " + curr.Number);
            curr = curr.Next;
        }
    }

    StudentNode DeleteStudentRecord(int Roll) {
        if (this.Head == null)
            return null;
        if (Head.RollNo == Roll) {
            Head = Head.Next;
            return Head;
        }
        StudentNode prev = null;
        StudentNode curr = Head;
        while (curr != null && curr.RollNo != Roll) {
            prev = curr;
            curr = curr.Next;
        }
        if (curr == null)
            return Head;
        prev.Next = curr.Next;
        if (curr == Tail) {
            Tail = prev;
        }
        return Head;
    }

    void SearchStudent(int Roll) {
        if (Head == null) {
            System.out.print("No Record Found");
            return;
        }
        StudentNode curr = Head;
        while (curr != null && curr.RollNo != Roll) {
            curr = curr.Next;
        }
        if (curr == null) {
            System.out.println("Student data not found");
            return;
        }
        System.out.println("Roll No :" + curr.RollNo + " Student Name :" + curr.Name + " Age: " + curr.Age
                + " Number: " + curr.Number);
    }

    void UpdateStudentRecord(int Roll, String Name) {
        if (Head == null) {
            System.out.print("No Record Found");
            return;
        }
        StudentNode curr = Head;
        while (curr != null && curr.RollNo != Roll) {
            curr = curr.Next;
        }
        if (curr == null) {
            System.out.println("Student data not found");
            return;
        }
       
        curr.Name=Name;

        System.out.println("Student record updated!");

        System.out.println("Roll No :" + curr.RollNo + " Student Name :" + curr.Name + " Age: " + curr.Age
                + " Number: " + curr.Number);
    }

    public static void main(String[] args) {
        studentRecord sR = new studentRecord();
        sR.AddStudentAtBeginning(11, "Prakhar Singh", 21, 89);
        sR.AddStudentAtBeginning(12, "Abhay", 22, 79);
        sR.AddStudentAtEnd(13, "Yuvraj", 22, 85);
        sR.PrintListOfStudents();
        sR.DeleteStudentRecord(13);
        System.out.println("After deleting ROll no 13");
        sR.PrintListOfStudents();
        sR.SearchStudent(15);
        sR.SearchStudent(11);
        sR.UpdateStudentRecord(12,"Ramu" );
    }
}
