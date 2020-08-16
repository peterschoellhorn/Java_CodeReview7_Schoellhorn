import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.List;

public class Enrollment {
  private final int student_id;
  private final int course_id;
  private final int teacher_id;


  public Enrollment( int student_id, int course_id, int teacher_id ) {
    this.student_id = student_id;
    this.course_id = course_id;
    this.teacher_id = teacher_id;

  }

  @Override
  public String toString() {
    return "Enrollment{" +
        "student_id=" + student_id +
        ", course_id=" + course_id +
        ", teacher_id=" + teacher_id +
        '\'' +
        '}';
  }

  static public void displayTeachersCourses ( List<Classes> list) {
    String tableName = "";
    try {
      Statement stmt = DataAccess.dataAccess.getConnection().createStatement();
      String query = "SELECT * FROM enrollment";
      ResultSet rs = stmt.executeQuery(query);
      ResultSetMetaData resultSetMetaData = rs.getMetaData();
      tableName = resultSetMetaData.getTableName(1);
    }
      catch (Exception e) {
      e.printStackTrace();
    }

    System.out.println("\n** ... parsing " + tableName + " TABLE **\n");
    for (Classes item : list) {
      System.out.println(item + "\n");
    }
  }
}
