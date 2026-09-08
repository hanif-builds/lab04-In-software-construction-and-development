import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Homework 1 - Enhanced Map Tracking
 *
 * Tracks unique student records using a Map<Integer, String> keyed by
 * student ID. Exposes the set of all IDs as an unmodifiable Set so
 * callers cannot corrupt the directory's key set from the outside.
 */
public class StudentDirectory {

    private final Map<Integer, String> students = new HashMap<>();

    public void addStudent(int id, String name) {
        students.put(id, name);
    }

    public String getStudentName(int id) {
        return students.get(id);
    }

    /**
     * Returns the set of all student IDs, wrapped so it cannot be modified.
     * Attempting to add/remove from the returned Set throws
     * UnsupportedOperationException.
     */
    public Set<Integer> getAllIDs() {
        return Collections.unmodifiableSet(students.keySet());
    }

    public static void main(String[] args) {
        StudentDirectory directory = new StudentDirectory();
        directory.addStudent(101, "Ali");
        directory.addStudent(102, "Sara");
        directory.addStudent(103, "Bilal");

        Set<Integer> ids = directory.getAllIDs();
        System.out.println("Student IDs: " + ids);

        try {
            ids.add(999);
            System.out.println("Add succeeded (unexpected!)");
        } catch (UnsupportedOperationException e) {
            System.out.println("Caught expected exception: " + e.getClass().getSimpleName()
                    + " - cannot modify the returned ID set.");
        }
    }
}
