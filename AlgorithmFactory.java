public class AlgorithmFactory {

    public static Algorithm newInstance(String type, String message, int key) {
        switch (type) {
            case "shift":
                return new Shift(message, key);
            case "unicode":
                return new Unicode(message, key);

            default:
                return null;
        }
    }
}
