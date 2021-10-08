public class ExceptionExample {

    public static void main(String args[]) {

        int a;

        try {
            a = 5 / 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
