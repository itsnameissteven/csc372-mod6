import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
      ArrayList<Student> students = new ArrayList<>();
      RollnoComparator rollnoComparator = new RollnoComparator();
      NameComparator nameComparator = new NameComparator();
      MergeSort mergeSortRollNo = new MergeSort (rollnoComparator);
      MergeSort mergeSortName = new MergeSort(nameComparator);

      // Add a list of students.
      students.add(new Student(7, "David Lee", "741 Birch St"));
      students.add(new Student(1, "John Doe", "123 Main St"));
      students.add(new Student(4, "Emily Davis", "321 Pine St"));
      students.add(new Student(5, "Michael Wilson", "654 Maple St"));
      students.add(new Student(8, "Emma Taylor", "852 Walnut St"));
      students.add(new Student(10, "Olivia White", "147 Cherry St"));
      students.add(new Student(3, "Bob Johnson", "789 Oak St"));
      students.add(new Student(6, "Sarah Brown", "987 Cedar St"));
      students.add(new Student(2, "Alice Smith", "456 Elm St"));
      students.add(new Student(9, "James Clark", "369 Laurel St"));


      // Sort data by roll number, using the starting point of 0 and ending point of array size
      mergeSortRollNo.sortArray(students, 0, students.size() -1);

      System.out.println("Sorted by Name\n");
      for(Student student : students) {
        System.out.println(student.toString());
      }

       // Sort data by roll name, using the starting point of 0 and ending point of array size
       mergeSortName.sortArray(students, 0, students.size() -1);

       System.out.println("\nSorted by Number\n");
       for(Student student : students) {
         System.out.println(student.toString());
       }

  }
}