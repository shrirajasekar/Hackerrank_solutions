import java.util.HashSet;
import java.util.Set;

public class Group {
  static int id = 1;
  String groupName;
  String groupMail;
  String password;
  String description;
  int groupId;
  Set<Integer> assignedUsers = new HashSet();

  public Group(String groupName, String groupMail, String password, String description) {
    this.groupName = groupName;
    this.groupMail = groupMail;
    this.password = password;
    this.description = description;
    this.groupId = id++;

  }
}
