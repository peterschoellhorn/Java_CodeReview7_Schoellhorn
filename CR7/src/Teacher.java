import java.sql.*;
import java.util.List;

public class Teacher {
  private int teacher_id;
  private String name;
  private String surname;
  private String email;

  public Teacher( int teacher_id, String name, String surname, String email ) {
    this.teacher_id = teacher_id;
    this.name = name;
    this.surname = surname;
    this.email = email;
  }

  public int getTeacher_id() {
    return teacher_id;
  }

  public void setTeacher_id( int teacher_id ) {
    this.teacher_id = teacher_id;
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
    return "Teacher{" +
        "teacher_id=" + teacher_id +
        ", name='" + name + '\'' +
        ", surname='" + surname + '\'' +
        ", email='" + email + '\'' +
        '}';
  }
  static public void displayTeachers ( List< Teacher > list) {

    String tableName = "";
    try {
      Statement stmt = DataAccess.dataAccess.getConnection().createStatement();
      String query = "SELECT * FROM teachers";
      ResultSet rs = stmt.executeQuery(query);
      ResultSetMetaData resultSetMetaData = rs.getMetaData();
      tableName = resultSetMetaData.getTableName(1);
    }
      catch (Exception e) {
      e.printStackTrace();
    }

    System.out.println("\n** ... parsing " + tableName + " TABLE **\n");
    for (Teacher item : list) {
      System.out.println(item + "\n");
    }
  }
}
