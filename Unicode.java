public class Unicode extends Algorithm {


    public Unicode(String message, int key) {
        super(message, key);
    }

    @Override
    public String encrypt() {
        if (message == null) {
            return " ";
        } else {
            for (char c : message.toCharArray()) {
                char encrypt = (char)(c + key);
                builder.append(encrypt);
            }
            return builder.toString();
        }
    }

    @Override
    public String decrypt() {
        if (message == null) {
            return " ";
        } else {
            for (char c : message.toCharArray()) {
                char decrypt = (char) (c - key);
                builder.append(decrypt);
            }
            return builder.toString();
        }

    }
}
