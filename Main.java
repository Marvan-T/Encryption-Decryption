import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        String action = "enc";
        String message = "";
        int key = 0;
        String outLocation = "";
        String algorithm = "shift";

        boolean dataPresent = false;
        boolean outArgument = false;

        for (int i = 0; i < args.length; i++) {
            if (args[i].contains("-key")) {
                key = Integer.parseInt(args[i+1]);
            } else if (args[i].contains("-data")) {
                message = args[i + 1];
                dataPresent = true;
            } else if (args[i].contains("-mode")) {
                action = args[i + 1];
            } else if (args[i].contains("-out")) {
                outLocation = args[i + 1];
                outArgument = true;
            } else if (args[i].contains("-alg")) {
                algorithm = args[i + 1];
            }
        }

        if (!dataPresent) { //read data based on a file location
            for (int i = 0; i < args.length; i++) {
                if (args[i].contains("-in")) {
                    message = textRead(args[i + 1]);
                    break;
                }
            }
        }

        Algorithm aAlgorithm = AlgorithmFactory.newInstance(algorithm, message, key);

        switch (action) {
            case "enc":
                outPut(outArgument, outLocation, aAlgorithm.encrypt());
                break;

            case "dec":
                outPut(outArgument, outLocation, aAlgorithm.decrypt());
                break;
        }

    }

    public static void outPut(boolean outArgument, String outLocation, String result) {
        if (outArgument) {
            writeFile(outLocation, result); //write to a file
        } else {
            System.out.println(result);
        }
    }

    public static String textRead(String fileLocation) {
        try {
            return new String(Files.readAllBytes(Paths.get(fileLocation)));
        } catch (IOException e) {
            System.out.println("Error in reading the file");
            return null;
        }
    }

    public static void writeFile(String fileLocation, String messageToOut) {
        try (PrintWriter printWriter = new PrintWriter(fileLocation)) {
            printWriter.println(messageToOut);
        } catch (IOException e) {
            System.out.println("Error in writing to file");
        }
    }

}