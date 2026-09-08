/**
 * Homework 2 - Designing Immutable Classes
 *
 * A fully immutable Point class:
 *  - class is declared final (cannot be subclassed to add mutable behavior)
 *  - fields x and y are final (assigned once, in the constructor, never changed)
 *  - no setter/mutator methods exist
 *  - the object's state cannot change after construction
 */
public final class Point {

    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /** Returns a NEW Point rather than mutating this one. */
    public Point translate(int dx, int dy) {
        return new Point(this.x + dx, this.y + dy);
    }

    @Override
    public String toString() {
        return "Point(" + x + ", " + y + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point p = (Point) o;
        return x == p.x && y == p.y;
    }

    @Override
    public int hashCode() {
        return 31 * x + y;
    }

    public static void main(String[] args) {
        Point p1 = new Point(2, 3);
        Point p2 = p1.translate(5, 5);
        System.out.println("p1 = " + p1);
        System.out.println("p2 = " + p2 + " (p1 is unchanged, proving immutability)");
    }
}
