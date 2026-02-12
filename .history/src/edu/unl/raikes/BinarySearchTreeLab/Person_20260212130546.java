package edu.unl.raikes.BinarySearchTreeLab;

//TODO: ADD JAVADOC COMMENT
public class Person implements Comparable<Person> {
	int key;
	String name;

	// TODO: ADD JAVADOC COMMENT
	Person(int NUID, String name) {
		this.key = NUID;
		this.name = name;
	}

	// TODO: ADD JAVADOC COMMENT
	public String toString() {
		return "NUID: " + this.key + "  Name: " + name;
	}

	// TODO: ADD JAVADOC COMMENT
	public int compareTo(Person other) {
		return Integer.compare(key, other.key);
	}
}
