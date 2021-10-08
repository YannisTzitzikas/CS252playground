public class HelloWorldAdvancedExample {

    public static void main(String args[]) {

        try {
            System.out.println("Hello " + args[0]);
        } catch (Exception e) {
            System.out.println("Missing arguments!");
        }

    }

}
