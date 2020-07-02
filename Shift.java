public class Shift extends Algorithm {

    final String[] alphabet = {
            "abcdefghijklmnopqrstuvwxyz",
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    };

    public Shift(String message, int key) {
        super(message, key);
    }


    @Override
    public String encrypt() {
        if (message == null) {
            return " ";
        } else {
            for (char c: message.toCharArray()) {
                int lowerCase = alphabet[0].indexOf(c);
                int upperCase = alphabet[1].indexOf(c);
                if (lowerCase == -1 && upperCase == -1) { //not a letter in eng alphabet
                    builder.append(c);
                } else {
                    int shiftIndex;
                    if (lowerCase > -1) { //its a lowercase character
                        shiftIndex = lowerCase + key;
                        if (shiftIndex > 25) {
                            shiftIndex = shiftIndex - 26;
                        }
                        builder.append(alphabet[0].charAt(shiftIndex));
                    }
                    if (upperCase > -1) {   //its a uppercase character
                        shiftIndex = upperCase + key;
                        if (shiftIndex > 25) {
                            shiftIndex = shiftIndex - 26;
                        }
                        builder.append(alphabet[1].charAt(shiftIndex));
                    }
                }
            }
            return  builder.toString();
        }
    }

    @Override
    public String decrypt() {
        if (message == null) {
            return " ";
        } else {
            for (char c : message.toCharArray()) {
                int lowerCase = alphabet[0].indexOf(c);
                int upperCase = alphabet[1].indexOf(c);
                if (lowerCase == -1 && upperCase == -1) {
                    builder.append(c);
                } else {
                    int shiftIndex;
                    if (lowerCase > -1) {
                        shiftIndex = lowerCase - key;
                        if (shiftIndex < 0) {
                            shiftIndex = shiftIndex + 26;
                        }
                        builder.append(alphabet[0].charAt(shiftIndex));
                    }
                    if (upperCase > -1) {
                        shiftIndex = upperCase - key;
                        if (shiftIndex < 0) {
                            shiftIndex = shiftIndex + 26;
                        }
                        builder.append(alphabet[1].charAt(shiftIndex));
                    }
                }
            }
            return builder.toString();
        }
    }
}
