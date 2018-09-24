import java.io.*;

class GameHelper {
    public String getUserInput(String prompt) {
        String inputLine = null;
        System.out.print(prompt + " ");
        try {
            BufferedReader is = new BufferedReader(
                    new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine.length() == 0 ) return null;
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        return inputLine;
    }
}

public class CreditCard {
    public static void main(String[]args){

        GameHelper helper = new GameHelper();

        long numInput;

        // check input type, only allow integers
        while (true) {
            try {
                String input = helper.getUserInput("Enter credit card number");
                numInput = Long.parseLong(input);
                System.out.println(numInput);

                // check for special characters
                    String replaceAllInput = input.replaceAll("[^0-9]", "");
                    if (replaceAllInput != input) {
                        System.out.println("Not a valid input, there are special characters.");
                    }
                    else {
                        // check length
                        long inputLength = String.valueOf(numInput).length();
                        System.out.println(inputLength);
                        if (inputLength > 13 & inputLength < 19) {
                            break;
                        } else {
                            System.out.println("Not a valid input, credit card must have been 14 and 18 digits.");
                        }
                    }
            } catch (NumberFormatException e) {
                System.out.println("Not a valid input, please only enter numbers.");
            }
        }
    }
}

