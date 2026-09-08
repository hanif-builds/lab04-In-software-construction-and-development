import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Lab Task 4 - Unmodifiable Wrappers
 *
 * Demonstrates runtime immutability by wrapping a mutable List in
 * Collections.unmodifiableList(), so external callers cannot alter it.
 */
public class Zoo {

    private final List<String> animals = new ArrayList<>(List.of("lion", "tiger", "bear"));

    /**
     * Returns a read-only view of the internal animals list.
     * The underlying list is still mutable internally (via addAnimal),
     * but callers of getAnimals() cannot modify it directly.
     */
    public List<String> getAnimals() {
        return Collections.unmodifiableList(animals);
    }

    /** Internal method to legitimately add an animal (not exposed as mutable externally). */
    public void addAnimal(String animal) {
        animals.add(animal);
    }

    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        List<String> readOnlyAnimals = zoo.getAnimals();
        System.out.println("Animals: " + readOnlyAnimals);

        try {
            readOnlyAnimals.add("flamingo");
            System.out.println("Add succeeded (unexpected!)");
        } catch (UnsupportedOperationException e) {
            System.out.println("Caught expected exception: " + e.getClass().getSimpleName()
                    + " - cannot modify unmodifiable list.");
        }

        System.out.println("List after failed add attempt: " + zoo.getAnimals());
    }
}
