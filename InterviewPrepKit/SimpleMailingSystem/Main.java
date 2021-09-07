import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    boolean loop = true;

    while (loop) {
      System.out.println(
          " 1. Create User \n 2. Create Group \n 3. Group Assignment \n 4. Compose Mail \n 5. Inbox \n 6. Sent Mail \n 7. Delete Mail \n 8. Recall \n 9. Share Inbox \n 10. Exit");
      int choice = s.nextInt();
      switch (choice) {
        case 1: {
          System.out.println(" *** Create User *** ");
          System.out.println("Enter User Name: ");
          String userName = s.next();
          System.out.println("Enter Email ID: ");
          String email = s.next();
          if (!email.contains("@")) {
            System.err.println("Invalid Email");
            return;
          }
          System.out.println("Enter Password: ");
          String password = s.next();
          Processor.createUser(userName, email, password);
        }
          break;
        case 2: {
          System.out.println(" *** Create Group *** ");
          System.out.println("Enter Group Name: ");
          String groupName = s.next();
          System.out.println("Enter Group Mail ID: ");
          String groupMail = s.next();
          if (!groupMail.contains("@")) {
            System.err.println("Invalid Email");
            return;
          }
          System.out.println("Enter Group Mail Password: ");
          String password = s.next();
          System.out.println("Enter Group Description: ");
          String description = s.next();
          Processor.createGroup(groupName, groupMail, password, description);
        }
          break;
        case 3: {
          System.out.println(" *** Group Assignment *** ");
          System.out.println(" Enter Group ID: ");
          int groupId = s.nextInt();
          System.out.println(" Enter User ID: ");
          int userId = s.nextInt();
          System.out.println(" Add / Remove: ");
          String option = s.next();
          switch (option.toUpperCase()) {
            case "ADD": {
              Processor.createGroupAssignment(groupId, userId);
            }
              break;
            case "REMOVE": {
              Processor.removeGroupAssignment(groupId, userId);
            }
              break;
            default: {
              System.out.println("Invalid Option: Please type add or remove only \n\n\n");
            }
          }

        }
          break;
        case 4: {
          System.out.println(" *** Compose Mail *** ");

          System.out.println("Enter from User Id: ");
          int userId = s.nextInt();
          String fromEmail = Processor.users.get(userId).email;
          System.out.println("Enter to Email Address: ");
          String toEmail = s.next();
          System.out.println("Enter Subject: ");
          String subject = s.next();
          System.out.println("Enter Content: ");
          String content = s.next();

          Mail mail = new Mail(fromEmail, toEmail, subject, content);
          Processor.composeMail(mail);
        }
          break;
        case 5: {
          System.out.println(" *** Inbox *** ");
          System.out.println("Enter User ID: ");
          int userId = s.nextInt();
          Processor.printInbox(userId);
        }
          break;
        case 6: {
          System.out.println(" *** Sent Mail *** ");
          System.out.println("Enter User ID: ");
          int userId = s.nextInt();
          Processor.printSentMail(userId);
        }
          break;
        case 7: {
          System.out.println(" *** Delete Mail *** ");
          System.out.println("Enter User ID: ");
          int userId = s.nextInt();
          System.out.println("From Inbox/Sent: ");
          String option = s.next();
          switch (option.toUpperCase()) {
            case "INBOX": {
              System.out.println("Enter Serial Number to delete from Inbox: ");
              int sNumber = s.nextInt();
              Processor.deleteMail(userId, sNumber, "inbox");
            }
              break;
            case "SENT": {
              System.out.println("Enter Serial Number to delete from Sent Mails: ");
              int sNumber = s.nextInt();
              Processor.deleteMail(userId, sNumber, "sent");
            }
          }
        }
          break;
        case 8: {
          System.out.println(" *** Recall *** ");
          System.out.println("Enter User ID: ");
          int userId = s.nextInt();
          System.out.println("Enter the Serial Number to Recall: ");
          int sNumber = s.nextInt();
          Processor.recall(userId, sNumber);

        }
          break;
        case 9: {
          System.out.println(" *** Share Mail *** ");

        }
          break;
        case 10: {
          loop = false;
          System.out.println(" *** Exited *** ");
        }
          break;
        default: {
          loop = false;
          System.out.println(" *** Exited - Invalid Option Selected *** ");

        }

      }

    }

  }
}
