public class Enrollment {
  private int student_id;
  private int course_id;
  private int teacher_id;
  private String course_name;

  public Enrollment( int student_id, int course_id, int teacher_id, String course_name ) {
    this.student_id = student_id;
    this.course_id = course_id;
    this.teacher_id = teacher_id;
    this.course_name = course_name;
  }

  public int getStudent_id() {
    return student_id;
  }

  public void setStudent_id( int student_id ) {
    this.student_id = student_id;
  }

  public int getCourse_id() {
    return course_id;
  }

  public void setCourse_id( int course_id ) {
    this.course_id = course_id;
  }

  public int getTeacher_id() {
    return teacher_id;
  }

  public void setTeacher_id( int teacher_id ) {
    this.teacher_id = teacher_id;
  }

  public String getCourse_name() {
    return course_name;
  }

  public void setCourse_name( String course_name ) {
    this.course_name = course_name;
  }

  @Override
  public String toString() {
    return "Enrollment{" +
        "student_id=" + student_id +
        ", course_id=" + course_id +
        ", teacher_id=" + teacher_id +
        ", course_name='" + course_name + '\'' +
        '}';
  }
}
