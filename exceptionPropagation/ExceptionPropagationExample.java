public class ExceptionPropagationExample {

    public static void main(String[] args) throws IOException {
        try {
            firstMethod();
        } catch (IOException e) {
            System.out.println("Caught exception in main: " + e.getMessage());
        }
    }
 
    public static void firstMethod() throws IOException {
        secondMethod();
    }

    public static void secondMethod() throws IOException {
        thirdMethod();
    }

    public static void thirdMethod() throws IOException {
        // Simulate an exception
        throw new IOException("An error occurred in thirdMethod");
    }
}

// incase of checked exception the error handling will not happen automatically but will be initiated by the user

class IOException extends Exception {
    public IOException(String message) {
        super(message);
    }
}
