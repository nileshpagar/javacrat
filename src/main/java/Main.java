import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.StringTokenizer;

/**
 * The Main class implements an application that reads lines from the standard input
 * and prints them to the standard output.
 */
public class Main {
    /**
     * Iterate through each line of input.
     */
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        while ((line = in.readLine()) != null) {
            System.out.println(checkStrings(line));
        }
    }

    public static int checkStrings(String input) {
        int result = 0;
        int indexOfSeparator = input.indexOf(",");
        if (indexOfSeparator != -1) {
            String stringToSearch = input.substring(indexOfSeparator+1).trim();
            String stringToSearchFrom = input.substring(0, indexOfSeparator).trim();
            if (stringToSearchFrom.endsWith(stringToSearch)) {
                result = 1;
            }
        }
        return result;
    }
}
