//
import java.util.*;

public class MorseCodeTranslator {
    static Map<Character, String> morseMap = new HashMap<>();

    static {
        morseMap.put('A', ".-"); morseMap.put('B', "-...");
        morseMap.put('C', "-.-."); morseMap.put('D', "-..");
        morseMap.put('E', "."); morseMap.put('F', "..-.");
        morseMap.put('G', "--."); morseMap.put('H', "....");
        morseMap.put('I', ".."); morseMap.put('J', ".---");
        morseMap.put('K', "-.-"); morseMap.put('L', ".-..");
        morseMap.put('M', "--"); morseMap.put('N', "-.");
        morseMap.put('O', "---"); morseMap.put('P', ".--.");
        morseMap.put('Q', "--.-"); morseMap.put('R', ".-.");
        morseMap.put('S', "..."); morseMap.put('T', "-");
        morseMap.put('U', "..-"); morseMap.put('V', "...-");
        morseMap.put('W', ".--"); morseMap.put('X', "-..-");
        morseMap.put('Y', "-.--"); morseMap.put('Z', "--..");
    }

    public static void main(String[] args) {
        String text = "JAVA";
        System.out.println("Original: " + text);

        StringBuilder morse = new StringBuilder();
        for (char c : text.toUpperCase().toCharArray()) {
            morse.append(morseMap.get(c)).append(" ");
        }

        System.out.println("Morse Code: " + morse.toString());
    }
}
