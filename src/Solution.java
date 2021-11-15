import java.util.Locale;
import java.util.Scanner;

class Validator {
    public static boolean validate(String message) {
        return message.matches("[A-Za-z0-9 ]+");
    }
}

class Encrypter{
    static String encryptMessage (String message) throws InvalidMessageException
    {
        Validator v = new Validator();
        boolean x= v.validate(message);
        if (!x)
            throw new InvalidMessageException();
        String  s = message.toLowerCase();
        StringBuffer sb = new StringBuffer(s);
        StringBuffer ss = sb.reverse();
        return ss.toString();
    }
}

public class Solution {

    private static final Scanner INPUT_READER = new Scanner(System.in);

    public static void main(String[] args) {

        String message = INPUT_READER.nextLine();

        try {
            String encrypted_message = Encrypter.encryptMessage(message);
            if(! encrypted_message.startsWith("InvalidMessageException"))
                System.out.println(encrypted_message);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}

class InvalidMessageException extends Exception {
    public String toString(){
        return ("InvalidMessageException: Try again with valid message");
    }
}