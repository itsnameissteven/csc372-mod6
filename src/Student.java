public class Student {
  private int rollno;
  private String name, address;

  Student(int rollno, String name, String address){
    this.rollno = rollno;
    this.name = name;
    this.address = address;
  }

  // Getters
  public int getRollno() {return this.rollno;};
  public String getName() {return this.name;};
  public String getAddress() {return this.address;};

  // Setters 
  public void setRollno(int rollno) {
    this.rollno = rollno;
  }
  public void setName(String name) {
    this.name = name;
  }
  public void setAddress(String address) {
    this.address = address;
  }
  @Override
  public String toString() {
    return this.getRollno() + ", " + this.getName() + ", " + this.getAddress();
  }
}
