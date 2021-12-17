import java.util.*;

/**
 * @author Nikolaos Gounakis
 * @summary Recitation on JCF
 * @notes useful links:
 *        https://www.edureka.co/blog/java-collections/
 *        https://www.javatpoint.com/collections-in-java
 *        https://www.javatpoint.com/java-map
 */
public class jfc_front {

    // students to be accessed through the whole class
    private static student s1 = new student(2, "Nikos", 97);
    private static student s2 = new student(1, "Giorgos", 80);
    private static student s3 = new student(3, "Maria", 34);

    public static void main(String[] args) throws Exception {

        /**
         * Uncomment one example at a time and run it
         */

        // Comparable and Comparator
        // example1();

        // Stack
        // example2();

        // Lists
        // example3();

        // Set
        // example4();

        // Map
        // example5();

        // Collections
        example6();
        
    }

    public static void print(Object o) {
        System.out.println(o);
    }

    /**
     * Comparable and Comparator
     */
    public static void example1() {

        // using compareTo
        int comparison = s1.compareTo(s2);
        if (comparison < 0)
            print(s1 + " has smaller score than " + s2);
        else
            print(s1 + " has not smaller score than " + s2);

        // using comparator
        studentComparator comp = new studentComparator();
        comparison = comp.compare(s1, s3);
        if (comparison < 0)
            print(s1 + " has smaller id than " + s3);
        else
            print(s1 + " has not smaller id than " + s3);

    }

    /**
     * Stack Example
     */
    public static boolean inputOk(String s) {
        Stack<Character> stack = new Stack<Character>();
        boolean match = true;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(')
                stack.push(ch);
            else if (ch == ')') {
                if (stack.isEmpty()) {
                    match = false;
                    break;
                } else
                    stack.pop();
            }
        }
        if (!stack.isEmpty())
            match = false;
        return match;
    }

    public static void example2() {
        String str1 = "abc(d)()";
        String str2 = "()s(()";
        print(str1 + " is valid: " + inputOk(str1));
        print(str2 + " is valid: " + inputOk(str2));
    }

    /**
     * List example
     * 
     * @ArrayList maintains the insertion order , is dynamic and it is good when
     *            storing data not when manipulating and deleting because it
     *            requires shifting
     * @LinkedList also maintains the insertion order , is a doubly linked list and
     *             can be used for fast data manipulation , no shifting required
     * @Vector similar to ArrayList but contains methods that are not included in
     *         Collection framework
     */
    public static void example3() {
        List<student> studentList = new ArrayList<>();

        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);

        print(studentList);
        // remove s2
        studentList.remove(s2);
        print("after removing " + s2);
        print(studentList);
        // add s1 again
        studentList.add(s1);
        print("after adding " + s1 + " again");
        print(studentList);
        // remove s1
        studentList.remove(s1);
        print("after removing " + s1);
        print(studentList);
        // add s2
        studentList.add(s2);
        print("after adding " + s2);
        print(studentList);

        // access elements
        print("\nAccess elements via iterator");
        Iterator itt = studentList.iterator();
        while (itt.hasNext()) {
            student s = (student) itt.next();
            s.score += 100;
            print(s);
        }

        // access elements via for loop
        print("\nAccess elements via for loop");
        for (student s : studentList) {
            print(s);
        }
    }

    /**
     * Set example
     * 
     * @HashSet uses hash table and does not maintain the insertion order
     * @LinkedHashSet maintains the insertion order
     * @TreeSet stores data in ascending order, because it is a tree it is faster
     *          than the above (log(n) < n)
     */
    public static void example4() {
        /*
         * note , we use the comparator we implement for sorting students by id
         * if we dont then because the student has an implemented compareTo method
         * the @TreeSet will use that , so it will sort by score
         */
        final studentComparator comp = new studentComparator();
        Set<student> studentSet = new TreeSet<student>(comp);
        studentSet.add(s1);
        studentSet.add(s2);
        studentSet.add(s3);

        // access
        for (student s : studentSet) {
            print(s + " id: " + s.id + " score: " + s.score);
        }
    }

    /**
     * 
     * Maps examples
     * 
     * @HashMap HashMap is the implementation of Map, but it doesn't maintain any
     *          order.
     * @LinkedHashMap LinkedHashMap is the implementation of Map. It inherits
     *                HashMap class. It maintains insertion order.
     * @TreeMap TreeMap is the implementation of Map and SortedMap. It maintains
     *          ascending order.
     */
    public static void example5() {
        Map<Integer, student> studentMap = new TreeMap<>();
        studentMap.put(s1.id, s1);
        studentMap.put(s2.id, s2);
        studentMap.put(s3.id, s3);
        print(studentMap);

        // get student with id = 2
        print("Get student with id=2");
        print(studentMap.get(2));

        // YOU CANT TRAVERSE A MAP! you have to iterate through the set of keys
        print("\nTraverse using keyset of map");
        for (Integer i : studentMap.keySet()) {
            print(studentMap.get(i));
        }

    }

    /**
     * Collection functions examples
     */
    public static void example6() {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(4);
        list.add(25);
        list.add(10);
        list.add(1);

        print("ArrayList maintains the insertion order");
        print(list);

        // sorting
        Collections.sort(list);
        print("After sorting");
        print(list);

        // shuffle
        Collections.shuffle(list);
        print("After Shuffling");
        print(list);

        // max , min
        Integer max = Collections.max(list);
        Integer min = Collections.min(list);
        print("max: " + max + "     min: " + min);

    }

}
