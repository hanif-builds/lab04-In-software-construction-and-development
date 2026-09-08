import java.util.HashMap;
import java.util.Map;

/**
 * Lab Task 3 - Complex Data Types (Map)
 *
 * Uses a HashMap<String, Double> to represent a treasure map, updates a
 * value based on the map's size, and sums all values using the values()
 * view and a for-each loop.
 */
public class TreasureMap {

    private final Map<String, Double> treasures = new HashMap<>();

    public TreasureMap() {
        treasures.put("beach", 25.0);
        treasures.put("palm", 50.0);
        treasures.put("cove", 75.0);
    }

    /**
     * Updates "palm" to be its current value plus the current size of the map.
     * (size = 3 at the time this is normally called, so 50.0 + 3 = 53.0)
     */
    public void updatePalmValue() {
        double current = treasures.get("palm");
        int size = treasures.size();
        treasures.put("palm", current + size);
    }

    /**
     * Iterates through treasures.values() with a for-each loop and returns
     * the total sum of all values in the map.
     */
    public double getTotalValue() {
        double total = 0.0;
        for (double value : treasures.values()) {
            total += value;
        }
        return total;
    }

    public Map<String, Double> getTreasures() {
        return treasures;
    }

    public static void main(String[] args) {
        TreasureMap map = new TreasureMap();
        System.out.println("Initial treasures: " + map.getTreasures());

        map.updatePalmValue();
        System.out.println("Treasures after updating 'palm': " + map.getTreasures());

        double total = map.getTotalValue();
        System.out.println("Total value of all treasures: " + total);
    }
}
