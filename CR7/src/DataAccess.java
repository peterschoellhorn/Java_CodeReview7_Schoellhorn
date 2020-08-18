import java.sql.*;
import java.lang.*;
import java.util.ArrayList;
import java.util.List;

public class DataAccess {

  private final Connection connection;

  public DataAccess() throws SQLException, ClassNotFoundException {
    Class.forName("org.mariadb.jdbc.Driver");
    System.out.println("** Connecting to Database **");
    String url = "jdbc:mariadb://localhost:3300/CR7_Schoellhorn";
    connection = DriverManager.getConnection(
        url,
        User.getUser(),
        User.getPassword());
    System.out.println("** Connected to Database **");
    connection.setAutoCommit(true);
    connection.setReadOnly(false);
  }

  public void closeDb() throws SQLException {
    System.out.println("** Closing connection to Database **");
    connection.close();
  }

  public List<Student> getAllRowsStudents() throws SQLException {
    String sql = "SELECT * FROM students";
    PreparedStatement preparedStatement = connection.prepareStatement(sql);
    ResultSet resultSet = preparedStatement.executeQuery();
    List<Student> list = new ArrayList<>();

    while(resultSet.next()) {
      int student_id = resultSet.getInt("student_id");
      String name = resultSet.getString("name");
      String surname = resultSet.getString("surname");
      String email = resultSet.getString("email");
      list.add(new Student(student_id, name, surname, email));
    }
    preparedStatement.close();
    return list;
  }

  public List<Teacher> getAllRowsTeachers() throws SQLException {
    String sql = "SELECT * FROM teachers";
    PreparedStatement preparedStatement = connection.prepareStatement(sql);
    ResultSet resultSet = preparedStatement.executeQuery();
    List<Teacher> list = new ArrayList<>();

    while(resultSet.next()) {
      int teacher_id = resultSet.getInt("teacher_id");
      String name = resultSet.getString("name");
      String surname = resultSet.getString("surname");
      String email = resultSet.getString("email");
      list.add(new Teacher(teacher_id, name, surname, email));
    }
    preparedStatement.close();
    return list;
  }

  public List<Classes> getAllRowsClasses() throws SQLException {
    String sql = "SELECT * FROM classes";
    PreparedStatement preparedStatement = connection.prepareStatement(sql);
    ResultSet resultSet = preparedStatement.executeQuery();
    List<Classes> list = new ArrayList<>();

    while(resultSet.next()) {
      int course_id = resultSet.getInt("course_id");
      String class_name = resultSet.getString("class_name");
      list.add(new Classes(course_id, class_name));
    }
    preparedStatement.close();
    return list;
  }


  public List<Enrollment> getTeachersCourse(int selectTeacher) throws SQLException {
    String sql = "SELECT classes.*, teachers.* " +
        "FROM teachers " +
        "INNER JOIN enrollment " +
        "ON teachers.teacher_id = enrollment.FK_teacher_id " +
        "INNER JOIN classes " +
        "ON classes.course_id = enrollment.FK_course_id " +
        "WHERE teachers.teacher_id=" + selectTeacher;
    PreparedStatement preparedStatement = connection.prepareStatement(sql);
    ResultSet resultSet = preparedStatement.executeQuery();
    List<Enrollment> list = new ArrayList<>();

    while(resultSet.next()) {
      int FK_student_id = resultSet.getInt("FK_student_id");
      int FK_course_id = resultSet.getInt("FK_course_id");
      int FK_teacher_id = resultSet.getInt("FK_teacher_id");
      list.add(new Enrollment(FK_student_id, FK_course_id, FK_teacher_id));
    }
    preparedStatement.close();
    return list;
  }



  public Connection getConnection() {
    return connection;
  }
}
