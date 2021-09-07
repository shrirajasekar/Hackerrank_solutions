package Misc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Misc.Tourist;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] result;
    int n = 0, i = 0;
    System.out.println("Enter the number of tourists");
    n = sc.nextInt();
    String[] tDetails = new String[n];
    System.out.println("Enter the tourist details");
    while (sc.hasNext()) {
      tDetails[i] = sc.nextLine();
      i++;
    }
    TouristUtility TUtil = new TouristUtility();
    // Call addValidTourists(tDetails)
    TUtil.addValidTourists(tDetails);
    // Call CalculateTravelCost()
    result = TUtil.calculateTravelCost();

    for (String r : result) {
      System.out.println(r);
    }

  }

}
