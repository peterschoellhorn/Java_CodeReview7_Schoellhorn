import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.List;

public class Classes {
  private int course_id;
  private String class_name;

  public Classes( int course_id, String class_name ) {
    this.course_id = course_id;
    this.class_name = class_name;
  }

  public int getCourse_id() {
    return course_id;
  }

  public void setCourse_id( int course_id ) {
    this.course_id = course_id;
  }

  public String getClass_name() {
    return class_name;
  }

  public void setClass_name( String class_name ) {
    this.class_name = class_name;
  }

  @Override
  public String toString() {
    return "Classes{" +
        "course_id=" + course_id +
        ", class_name='" + class_name + '\'' +
        '}';
  }
  static public void displayClasses ( List<Classes> list) {
    String tableName = "";
    try {
      Statement stmt = DataAccess.dataAccess.getConnection().createStatement();
      String query = "SELECT * FROM classes";
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
