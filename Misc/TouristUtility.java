package Misc;

import java.util.HashMap;
import java.util.Map;
import static java.util.Map.entry;

import Misc.Tourist;

public class TouristUtility {

  private Tourist[] tourist;

  Map<String, Integer> travelCosts = new HashMap<>(
      Map.ofEntries(entry("GOA", 2000), entry("DELHI", 2500), entry("MANALI", 3000)));

  public Tourist[] getTourist() {
    return tourist;
  }

  public void setTourist(Tourist[] tourist) {
    this.tourist = tourist;
  }

  // Method for validating Tourist Ids

  public void addValidTourists(String records[]) {
    for (String record : records) {
      String[] elems = record.split(":");
      if (elems[0].substring(0, 2).equalsIgnoreCase(elems[1].substring(0, 2))) {
        Tourist newTourist = new Tourist(elems[0], elems[1], elems[2], Integer.parseInt(elems[3]));
        this.tourist[this.tourist.length] = newTourist;
      }
    }
  }

  // Method for calculating travel cost

  public String[] calculateTravelCost() {
    int daysOfTravel = 0, costPerDay = 0, i = 0;
    String[] result = new String[tourist.length];
    double total = 0;
    for (Tourist T : this.tourist) {
      daysOfTravel = T.getDaysOfTravel();
      costPerDay = travelCosts.get(T.getDestination().toUpperCase());
      total = daysOfTravel * costPerDay;

      if (daysOfTravel > 5) {
        total = (total * 0.85);
      }

      T.setTravelCost(total);
      result[0] = T.toString();
      i++;
    }
    return result;
  }

}
