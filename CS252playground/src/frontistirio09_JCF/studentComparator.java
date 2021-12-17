import java.util.Comparator;

/**
 * @author Nikolaos Gounakis
 * @summary Student comparator with id
 */
public class studentComparator implements Comparator {

    /**
     * compare students by id
     */
    public int compare(Object o1, Object o2) {

        return ((student) o1).id - ((student) o2).id;
    }

}
