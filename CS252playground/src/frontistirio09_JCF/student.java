/**
 * @author Nikolaos Gounakis
 * @summary Class of student
 */
public class student implements Comparable {

    public String name;
    public int score;
    public int id;

    public student(int id, String name, int score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    /**
     * Student class implements Comparable so we must implement the compareTo
     * function. We throw a ClassCastException error in case we dont want to compare
     * the student to every other class but the parameter must be an object.
     */
    public int compareTo(Object o) throws ClassCastException {
        if (o instanceof student) {
            // if they have the same score the results is 0, if ... , if ...
            return this.score - ((student) o).score;
        } else {
            throw new ClassCastException("The object is not a student!");
        }
    }

    public String toString() {
        return this.name;
    }
}
