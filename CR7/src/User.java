public class User {
  private static final String user = ${"DB_USER"};
  private static final String password = ${"DB_ROOT"};

  public static String getUser() {
    return user;
  }

  public static String getPassword() {
    return password;
  }

}
