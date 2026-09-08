/**
 * Lab Task 1 - Mutability & Performance (String vs StringBuilder)
 *
 * Demonstrates the performance difference between immutable String
 * concatenation (which creates a new object on every '+') and mutable
 * StringBuilder.append() (which modifies an internal buffer in place).
 */
public class StringPerformance {

    /**
     * Builds a string of numbers 0..n-1 using immutable String concatenation.
     * Each "+" creates a brand new String object and copies all previous
     * characters into it, leading to O(n^2) total time.
     */
    public static String buildString(int n) {
        String s = "";
        for (int i = 0; i < n; i++) {
            s = s + i;
        }
        return s;
    }

    /**
     * Builds the same string using a mutable StringBuilder.
     * append() grows an internal char array and copies only when the
     * buffer needs to resize, giving amortized O(n) total time.
     */
    public static String buildStringBuilder(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(i);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int n = 10000;

        long startString = System.nanoTime();
        String result1 = buildString(n);
        long endString = System.nanoTime();
        double stringTimeMs = (endString - startString) / 1_000_000.0;

        long startSb = System.nanoTime();
        String result2 = buildStringBuilder(n);
        long endSb = System.nanoTime();
        double sbTimeMs = (endSb - startSb) / 1_000_000.0;

        System.out.println("=== String vs StringBuilder Performance (n = " + n + ") ===");
        System.out.println("String concatenation time     : " + stringTimeMs + " ms");
        System.out.println("StringBuilder append time      : " + sbTimeMs + " ms");
        System.out.println("Results equal? " + result1.equals(result2));
        System.out.println("StringBuilder was approximately "
                + (stringTimeMs / Math.max(sbTimeMs, 0.0001)) + "x faster");
    }
}
