import java.util.Comparator;

public class NameComparator implements Comparator<Student>{
  @Override
  public int compare(Student studentA, Student studentB) { 
    return studentA.getName().compareTo(studentB.getName());
  }
}
