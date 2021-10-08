package frontistirio01.basic_examples;

public class ForLoopExample {

    public static void forMethod(int num) {
        for (int i = 1; i < num; i++) {
            System.out.println(i);
        }
    }

    public static void main(String args[]) {
        forMethod(5);
    }

}
