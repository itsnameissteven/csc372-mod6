import java.util.Comparator;

public class RollnoComparator implements Comparator<Student> {
  @Override
  public int compare(Student studentA, Student studentB) {
    return Integer.compare(studentA.getRollno(), studentB.getRollno());
  }

}
