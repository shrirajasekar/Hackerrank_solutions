import java.util.HashMap;
import java.util.Map;

public class Processor {
  static Map<Integer, User> users = new HashMap<>(); // mapping userIds to Users
  static Map<Integer, Group> groups = new HashMap<>(); // mapping groupIds to Groups
  static Map<String, User> usersByEmail = new HashMap<>(); // mapping emails to Users
  static Map<String, Group> groupsByEmail = new HashMap<>(); // mapping emails to Groups

  public static void createUser(String userName, String email, String password) {
    User u = new User(userName, email, password);
    users.put(u.userId, u);
    usersByEmail.put(u.email, u);
    System.out.println("User Created \n\n\n");
  }

  public static void createGroup(String groupName, String groupMail, String password, String description) {
    Group g = new Group(groupName, groupMail, password, description);
    groups.put(g.groupId, g);
    groupsByEmail.put(g.groupMail, g);
    System.out.println("Group Created \n\n\n");
  }

  public static void createGroupAssignment(Integer groupId, Integer userId) {
    Group temp = Processor.groups.get(groupId);
    temp.assignedUsers.add(userId);
    groups.put(groupId, temp);
    groupsByEmail.put(temp.groupMail, temp);
    System.out.println("User added to Group \n\n\n");
  }

  public static void removeGroupAssignment(Integer groupId, Integer userId) {
    Group temp = Processor.groups.get(groupId);
    temp.assignedUsers.remove(userId);
    Processor.groups.put(groupId, temp);
    Processor.groupsByEmail.put(temp.groupMail, temp);
    System.out.println("User removed from Group \n\n\n");
  }

  public static void composeMail(Mail mail) {
    // Add mail to Sender's Sent Mail
    String fromEmail = mail.from;
    String toEmail = mail.to;
    int sentMailCount = Processor.usersByEmail.get(fromEmail).sentMail.size();
    Processor.usersByEmail.get(fromEmail).sentMail.put(sentMailCount + 1, mail);

    // Add mail to Receiver's Inbox
    int inboxMailCount = Processor.usersByEmail.get(toEmail).inbox.size();
    Processor.usersByEmail.get(toEmail).inbox.put(inboxMailCount + 1, mail);

    System.out.println("Mail Sent. \n\n\n");
  }

  public static void printInbox(int userId) {
    System.out.println(" --------------------------------------------------- ");
    System.out.println("S.No    From    To    Subject    Content");

    // Get mails from inbox and print
    users.get(userId).inbox.entrySet().forEach(entry -> {
      System.out
          .println(entry.getKey() + "               " + entry.getValue().from + "               " + entry.getValue().to
              + "               " + entry.getValue().subject + "               " + entry.getValue().content);
    });
    System.out.println(" ----------------------------------------------------- ");
  }

  public static void printSentMail(int userId) {
    System.out.println(" --------------------------------------------------- ");
    System.out.println("S.No    To    Subject    Content");

    // Get mails from sentmail and print

    users.get(userId).sentMail.entrySet().forEach(entry -> {
      System.out.println(entry.getKey() + "               " + entry.getValue().to + "               "
          + entry.getValue().subject + "               " + entry.getValue().content);
    });
    System.out.println(" ----------------------------------------------------- ");
  }

  public static void deleteMail(int userId, int sNumber, String option) {
    if (option.equals("inbox")) {
      User temp = users.get(userId);
      temp.inbox.remove(sNumber);
      users.put(userId, temp);

    } else {
      User temp = users.get(userId);
      temp.sentMail.remove(sNumber);
      users.put(userId, temp);
    }
    System.out.println("Mail deleted. \n\n\n");
  }

  public static void recall(int userId, int sNumber) {

    System.out.println("Mail Recalled. \n\n\n");
  }
}
