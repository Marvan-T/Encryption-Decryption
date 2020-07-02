public abstract class Algorithm {

    String message;
    int key;
    StringBuilder builder = new StringBuilder();

    public Algorithm(String message, int key) {
        this.message = message;
        this.key = key;
    }

    abstract String encrypt();

    abstract String decrypt();

}
