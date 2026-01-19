import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class textDecryption {

	public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);

	        Map<Character, Character> keyMapping = getKeyMapping();

	        
	        System.out.println("Encrypted Text: ");
	        String encryptedtext = in.nextLine().toUpperCase();  
	        String decryptedtext = decryptMessage(encryptedtext, keyMapping);
	        System.out.println("Decrypted Text: " + decryptedtext);
	    }

	    public static Map<Character, Character> getKeyMapping() {
	        Map<Character, Character> keyMapping = new HashMap<>();
	        keyMapping.put('A', 'g');
	        keyMapping.put('B', 'z');
	        keyMapping.put('C', 'n');
	        keyMapping.put('D', 'b');
	        keyMapping.put('E', 'o');
	        keyMapping.put('F', 'a');
	        keyMapping.put('G', 'e');
	        keyMapping.put('H', 'r');
	        keyMapping.put('I', 'q');
	        keyMapping.put('J', 'v');
	        keyMapping.put('K', 'w');
	        keyMapping.put('L', 'h');
	        keyMapping.put('M', 'x');
	        keyMapping.put('N', 'f');
	        keyMapping.put('O', 'y');
	        keyMapping.put('P', 'i');
	        keyMapping.put('Q', 'j');
	        keyMapping.put('R', 'k');
	        keyMapping.put('S', 'c');
	        keyMapping.put('T', 's');
	        keyMapping.put('U', 'd');
	        keyMapping.put('V', 'u');
	        keyMapping.put('W', 'm');
	        keyMapping.put('X', 't');
	        keyMapping.put('Y', 'p');
	        keyMapping.put('Z', 'l');
	        return keyMapping;
	    }

	    public static String decryptMessage(String encryptedText, Map<Character, Character> keyMapping) {
	        StringBuilder decrypt = new StringBuilder();
	        for (char a : encryptedText.toCharArray()) {
	            if (Character.isLetter(a)) {
	                decrypt.append(keyMapping.getOrDefault(a, a));
	            } else {
	                decrypt.append(a);
	            }
	        }
	        return decrypt.toString();
	}

}

//This code has a built in encryption algorithm, and when ran, the user can use the key mapping to write an encrypted message
//Uppercase letters are plain text, the lowercase letters are cipher text.
//The user will enter the cipher text to output their desired plaintext
