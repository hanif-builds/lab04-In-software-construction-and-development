Lab Task 04 – Data Types, Mutability, and Collections

Course: Software Construction — 5th Semester Software Engineering Instructor: Engr. Rizwan Shah Date: 08 Sep 2026

Objective

Apply concepts of mutability, interface implementations (List, Map, Set), and safe iterator traversal using Java Collections.

What Was Implemented
File	Task	Description
CourseManager.java	Lab Task 2	Shows ConcurrentModificationException when removing from a List in a for-each loop, then fixes it using Iterator.remove(). Final list: ["8.03", "14.03"].
StringPerformance.java	Lab Task 1	Compares String concatenation vs StringBuilder.append() for n = 10000, printing execution time for each to demonstrate O(n²) vs O(n) behavior.
TreasureMap.java	Lab Task 3	Uses a HashMap<String, Double>, updates "palm" to its value plus the map's size, and sums all values via values().
Zoo.java	Lab Task 4	Wraps a mutable List<String> with Collections.unmodifiableList() and demonstrates the resulting UnsupportedOperationException on add().
StudentDirectory.java	Homework 1	Map<Integer, String> of student records; getAllIDs() returns an unmodifiable Set<Integer> view of the key set.
Point.java	Homework 2	Fully immutable final class with final int x, y, no setters, and a translate() method that returns a new Point instead of mutating state.

All classes are located in src/main/java/com/university/lab/lab4/.

How to Run

This is a Maven project. You can run it either through NetBeans or the command line.

Option 1 — NetBeans
Open the project in NetBeans.
In the Projects panel, expand Source Packages → com.university.lab.lab4.
Right-click any class (e.g. CourseManager.java) → Run File.
Output appears in the Output console at the bottom.
Option 2 — Command line (Maven)

Compile the project:

bash
mvn compile

Run a specific class:

bash
mvn exec:java -Dexec.mainClass="com.university.lab.lab4.CourseManager"

Replace CourseManager with StringPerformance, TreasureMap, Zoo, StudentDirectory, or Point to run the other classes.

Reflection

This lab reinforced why choosing the right data structure and mutability model matters in practice, not just in theory. Concatenating strings in a loop looked harmless but scaled badly (O(n²)) compared to StringBuilder, which was a clear, measurable lesson rather than an abstract one. Working with Iterator.remove() instead of modifying a List mid-for-each made it obvious why ConcurrentModificationException exists — it protects against silently corrupting iteration state. Wrapping collections with Collections.unmodifiableList() / unmodifiableSet() and designing the Point class as fully immutable also showed how immutability can be enforced structurally (via final and no setters) rather than just by convention, which reduces a whole class of bugs where an object's internal state changes unexpectedly. One challenge was getting the Maven project's main class configuration right in NetBeans, since the default setup pointed to a class that didn't exist in this project — running files individually solved that. If I extended this further, I'd add more edge cases to the tests (e.g., empty collections, larger n for the performance test) and possibly benchmark with System.nanoTime() averaged over multiple runs for more stable timing numbers.
