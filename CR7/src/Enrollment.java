import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.List;

public class Enrollment {
  private final int FK_student_id;
  private final int FK_course_id;
  private final int FK_teacher_id;


  public Enrollment( int FK_student_id, int FK_course_id, int FK_teacher_id ) {
    this.FK_student_id = FK_student_id;
    this.FK_course_id = FK_course_id;
    this.FK_teacher_id = FK_teacher_id;

  }

  @Override
  public String toString() {
    return "Enrollment{" +
        "student_id=" + FK_student_id +
        ", course_id=" + FK_course_id +
        ", teacher_id=" + FK_teacher_id +
        '\'' +
        '}';
  }

  static public void displayTeachersCourses ( List<Enrollment> list) {
    for (Enrollment item : list) {
      System.out.println(item.toString() + "\n");
    }
  }
}
