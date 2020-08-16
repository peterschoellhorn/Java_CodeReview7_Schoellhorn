import java.util.Scanner;

public class UI {

  static DataAccess dataAccess;

  public static void menu() {

    String menu =

        "+---------------------------------------------+\n" +
            "|          SCHOOL ADMIN SYSTEM V 0.9          |\n" +
            "|---------------------------------------------|\n" +
            "|                   WELCOME                   |\n" +
            "|---------------------------------------------|\n" +
            "|                   OPTIONS                   |\n" +
            "|---------------------------------------------|\n" +
            "|                                             |\n" +
            "| 1) DISPLAY ALL STUDENTS                     |\n" +
            "| 2) DISPLAY ALL TEACHERS                     |\n" +
            "| 3) DISPLAY ALL AVAILABLE COURSES            |\n" +
            "| 4) DISPLAY ALL COURSES OF TEACHER (X)       |\n" +
            "| 5) PRINT REPORT                             |\n" +
            "| 0) EXIT SYSTEM                              |\n" +
            "|                                             |\n" +
            "|                                             |\n" +
            "|---------------------------------------------|\n" +
            "| SELECT (0 -4) AND PRESS <ENTER> TO PROCEED  |\n" +
            "+---------------------------------------------+";


    int EXIT = 0;
    int DISPLAY_ALL_STUDENTS = 1;
    int DISPLAY_ALL_TEACHERS = 2;
    int DISPLAY_ALL_COURSES = 3;
    int DISPLAY_TEACHERS_COURSE = 4;
    int PRINT_REPORT = 5;


    boolean toContinue = true;

    while (toContinue) {
      System.out.println(menu);
      Scanner inputScanner = new Scanner(System.in);
      int input;
      input = inputScanner.nextInt();
      Main.init();
      switch (input) {
        case 0:
          Main.stop();
          System.out.println("PROGRAM CLOSED");
          toContinue = false;
          break;
        case 1:
          try {
            Student.displayStudents(dataAccess.getAllRowsStudents());
          } catch (Exception e) {
            e.printStackTrace();
          }
          break;
        case 2:
          try {
            Teacher.displayTeachers(dataAccess.getAllRowsTeachers());
          } catch (Exception e) {
            e.printStackTrace();
          }
        case 3:
          try {
            Classes.displayClasses(dataAccess.getAllRowsClasses());
          } catch (Exception e) {
            e.printStackTrace();
          }
        case 4:
          System.out.println("Please enter the ID of the Teacher to show assigned classes: ");
          Scanner subInputScanner = new Scanner(System.in);
          int selectTeacher = subInputScanner.nextInt();
          try {
            Enrollment.displayTeachersCourses(dataAccess.getTeachersCourse(selectTeacher));
          } catch (Exception e) {
            e.printStackTrace();
          }
          subInputScanner.close();
          break;
      }
      inputScanner.close();
    }
  }
}