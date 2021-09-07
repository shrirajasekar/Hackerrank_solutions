package InterviewPrepKit.Challenge;

import java.lang.reflect.Constructor;

public class MicroMaxMini implements IUSBPort, ICamera, ISDCard {

  // State
  String IMEI = "";
  String modelNumber = "";
  int weight;
  int screenSize;

  // Constructor
  public MicroMaxMini() {
    this.IMEI = "1";
  }

  public MicroMaxMini(String imei) {
    this.IMEI = imei;
  }

  // Behavior

  @Override
  public void connectToPC() {
    System.out.println("Connected to PC");
  }

  @Override
  public void connectToEarphone() {
    System.out.println("Connected to EP");

  }

  @Override
  public void otg() {
    System.out.println("Connected to otg");

  }

  @Override
  public void connectToTV() {
    System.out.println("Connected to TV");

  }

  @Override
  public void chargePhone() {
    System.out.println("Charge");

  }

  @Override
  public void fileTransfer() {
    System.out.println("FT");
  }

  @Override
  public void selfie() {
    // TODO Auto-generated method stub

  }

  public static void main(String[] args) {

    MicroMaxMini phone = new MicroMaxMini();
    MicroMaxMini rethikPhone = new MicroMaxMini("112345");

  }
}
