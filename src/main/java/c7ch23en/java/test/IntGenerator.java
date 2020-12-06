package c7ch23en.java.test;

/**
 * @author c7ch23en
 */
public class IntGenerator {

    public IntGenerator(int max) {
    }

    public int nextInt() throws NoValuesAvailableException {
        return 0;
    }

    public static class NoValuesAvailableException extends RuntimeException {
        public NoValuesAvailableException() {
            super();
        }
    }

}
