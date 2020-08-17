import javax.sql.DataSource;
import java.sql.SQLException;

public class Main {

  public static DataAccess dataAccess;

  public static void main( String[] args ) {

    UI.menu();

  }
  static public void init() {
    try {
      dataAccess = new DataAccess();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  static public void stop() {
    try {
      dataAccess.closeDb();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
