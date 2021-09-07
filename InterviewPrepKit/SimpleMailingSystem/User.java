import java.util.HashMap;

public class User {
  static int id = 1;
  String userName;
  String email;
  String password;
  int userId;
  HashMap<Integer, Mail> inbox = new HashMap();
  HashMap<Integer, Mail> sentMail = new HashMap();

  public User(String userName, String email, String password) {
    this.userName = userName;
    this.email = email;
    this.password = password;
    this.userId = id++;
  }
}
