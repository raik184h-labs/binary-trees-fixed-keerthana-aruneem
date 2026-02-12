package edu.unl.raikes.BinarySearchTreeLab;

/**
 * Represents a person with a unique NUID key and a name.
 * Implements Comparable to allow ordering by key.
 */
public class Person implements Comparable<Person> {
    int key;
    String name;

    /**
     * Constructor for creating a Person.
     * @param NUID the unique identifier (key) for this person
     * @param name the name of this person
     */
    Person(int NUID, String name) {
        this.key = NUID;
        this.name = name;
    }

    /**
     * Returns a string representation of this person, including their NUID and name.
     * @return formatted string with the person's NUID and name
     */
    public String toString() {
        return "NUID: " + this.key + "  Name: " + name;
    }

    /**
     * Compares this person to another person by their key (NUID).
     * @param other the other Person to compare to
     * @return negative if this key is less, zero if equal, positive if greater
     */
    public int compareTo(Person other) {
        return Integer.compare(key, other.key);
    }
}
