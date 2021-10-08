package frontistirio01.basic_examples;
import java.util.Random;

public class ImportExample {

    public static void main(String args[]) {

        Random rand = new Random();
        int number = rand.nextInt(50) + 1;

        System.out.println("A random integer in range [1,50]: " + number);
    }
}
