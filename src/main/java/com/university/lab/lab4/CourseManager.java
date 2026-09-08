import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Lab Task 2 - Safe Collection Modification
 *
 * Shows why removing elements from a List during a for-each loop throws
 * ConcurrentModificationException, and how using an Iterator's own
 * remove() method fixes the problem safely.
 */
public class CourseManager {

    /**
     * UNSAFE: attempts to remove items starting with "6." using a for-each
     * loop. This will throw ConcurrentModificationException because the
     * for-each loop uses an internal iterator that detects the list was
     * structurally modified outside of it.
     */
    public void removeUnsafe(List<String> subjects) {
        for (String subject : subjects) {
            if (subject.startsWith("6.")) {
                subjects.remove(subject); // causes ConcurrentModificationException
            }
        }
    }

    /**
     * SAFE: removes items starting with "6." using an explicit Iterator
     * and iter.remove(), which keeps the iterator's internal state in
     * sync with the list, avoiding the exception.
     */
    public void removeSafe(List<String> subjects) {
        Iterator<String> iter = subjects.iterator();
        while (iter.hasNext()) {
            String subject = iter.next();
            if (subject.startsWith("6.")) {
                iter.remove();
            }
        }
    }

    public static void main(String[] args) {
        CourseManager manager = new CourseManager();

        // --- Demonstrate the unsafe (buggy) approach ---
        List<String> subjectsUnsafe = new ArrayList<>(
                List.of("6.045", "6.005", "8.03", "6.813", "14.03"));
        System.out.println("Original list: " + subjectsUnsafe);
        try {
            manager.removeUnsafe(subjectsUnsafe);
            System.out.println("Unsafe removal finished without exception (unexpected): "
                    + subjectsUnsafe);
        } catch (java.util.ConcurrentModificationException e) {
            System.out.println("Caught expected exception in removeUnsafe(): "
                    + e.getClass().getSimpleName());
        }

        // --- Demonstrate the safe (fixed) approach ---
        List<String> subjectsSafe = new ArrayList<>(
                List.of("6.045", "6.005", "8.03", "6.813", "14.03"));
        manager.removeSafe(subjectsSafe);
        System.out.println("Final list after safe removal: " + subjectsSafe);
        System.out.println("Matches expected [8.03, 14.03]? "
                + subjectsSafe.equals(List.of("8.03", "14.03")));
    }
}
