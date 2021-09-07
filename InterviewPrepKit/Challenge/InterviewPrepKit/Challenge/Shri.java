package InterviewPrepKit.Challenge;

/**
 * Shri
 */
public class Shri {

  // State
  int age;

  int weight;
  int height;
  int numberOfGf = 0;

  // Behavior / Methods
  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public int getNumberOfGf() {
    return numberOfGf;
  }

  public void setNumberOfGf(int numberOfGf) {
    this.numberOfGf = numberOfGf;
  }

  private void jump() {

  }

  private void running() {

  }

  private int add(int a, int b) {
    int sum = a + b;
    return sum;
  }

  private int add(int a, int b, int c) {
    int sum = a + b;
    return sum;
  }

  private String add(String a, String b) {
    String sum = a + b;
    return sum;
  }

  static void print() {
    System.out.println("Hello");
  }

  @Override
  public String toString() {
    return "Shri [age=" + age + ", height=" + height + ", numberOfGf=" + numberOfGf + ", weight=" + weight + "]";
  }

  public static void main(String[] args) {

    int marks[] = { 10, 12, 13, 14, 15, 10, 102, 56 }; // intialisation

    int cars[] = new int[10]; // declaration

    Shri obj1 = new Shri();
    obj1.setAge(16);

    Shri obj2 = new Shri();
    obj2.setAge(16);

    System.out.println(obj1.hashCode());
    System.out.println(obj2.hashCode());

    print();

    if (obj1 == obj2) {
      System.out.println("Equal");
    } else {
      System.out.println("No");
    }

    System.out.println(obj1.add(2, 5));
    System.out.println(obj1.add("Hello", "Shri"));

  }
}
