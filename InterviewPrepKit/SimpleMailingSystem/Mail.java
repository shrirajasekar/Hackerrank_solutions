public class Mail {
  String subject;
  String content;
  String from;
  String to;
  String status;

  public Mail(String from, String to, String subject, String content) {
    this.from = from;
    this.to = to;
    this.subject = subject;
    this.content = content;
  }
}
