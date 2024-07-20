public class ErrorPropagationExample {

    public static void main(String[] args) {
        try {
            firstMethod();
        } catch (Exception e) {
            System.out.println("Caught exception in main: " + e.getMessage());
        }
    }

    public static void firstMethod() {
        secondMethod();
    }

    public static void secondMethod() {
        thirdMethod();
    }

    public static void thirdMethod() {
        // Simulate an error: division by zero
        int result = 10 / 0;
        System.out.println("Result: " + result);
    }
}


