import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.List;

public class Student {
  private int student_id;
  private String name;
  private String surname;
  private String email;

  public Student( int student_id, String name, String surname, String email ) {
    this.student_id = student_id;
    this.name = name;
    this.surname = surname;
    this.email = email;
  }

  public int getStudent_id() {
    return student_id;
  }

  public void setStudent_id( int student_id ) {
    this.student_id = student_id;
  }

  public String getName() {
    return name;
  }

  public void setName( String name ) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname( String surname ) {
    this.surname = surname;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail( String email ) {
    this.email = email;
  }

  @Override
  public String toString() {
    return "Student{" +
        "student_id=" + student_id +
        ", name='" + name + '\'' +
        ", surname='" + surname + '\'' +
        ", email='" + email + '\'' +
        '}';
  }

  static public void displayStudents( List<Student> list ) {
    String tableName = "";
    try {
      Statement stmt = DataAccess.dataAccess.getConnection().createStatement();
      String query = "SELECT * FROM students";
      ResultSet rs = stmt.executeQuery(query);
      ResultSetMetaData resultSetMetaData = rs.getMetaData();
      tableName = resultSetMetaData.getTableName(1);
    }
      catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("\n** ... parsing " + tableName + " TABLE **\n");
    for (Student item : list) {
      System.out.println(item + "\n");
    }
  }

}
