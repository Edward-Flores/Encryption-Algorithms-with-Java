import java.util.*;

public class textAnalysis {

	public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);

	        System.out.println("Encrypted Text: ");
	        String encryptedText = in.nextLine();

	        String decryptedText = textAnalysis(encryptedText);
	        System.out.println("Decrypted Text: " + decryptedText);
	    }

	    public static String textAnalysis(String ciphertext) {
	        Map<Character, Integer> letterCount = new HashMap<>();

	        for (char l = 'a'; l <= 'z'; l++) {
	            letterCount.put(l, 0);
	        }

	        for (int a = 0; a < ciphertext.length(); a++) {
	            char character = ciphertext.charAt(a);
	            if (Character.isLetter(character)) {
	                char lowerCaseLetter = Character.toLowerCase(character);
	                letterCount.put(lowerCaseLetter, letterCount.get(lowerCaseLetter) + 1);
	            }
	        }

	        int totalLetters = 0;
	        for (int count : letterCount.values()) {
	            totalLetters += count;
	        }

	        letterCount.entrySet().stream()
	                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
	                .forEach(entry -> {
	                    char letter = entry.getKey();
	                    int count = entry.getValue();
	                    double percentage = (double) count/letter * 100;
	                    System.out.println(letter + ": " + String.format("%.2f", percentage) + "%");
	                });

	        Map<Character, Character> mapping = new HashMap<>();
	        String legalTextAlp = "abcdefghijklmnopqrstuvwxyz";
	        List<Map.Entry<Character, Integer>> sections = new ArrayList<>(letterCount.entrySet());
	        sections.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

	        for(int a=0; a< legalTextAlp.length(); a++) {
	        	char character = legalTextAlp.charAt(a);
	        	char decryptedChar = sections.get(a).getKey();
	        	mapping.put(character, decryptedChar);
	        }
	        StringBuilder decryptedText = new StringBuilder();
	        for (int a = 0; a < ciphertext.length(); a++) {
	            char character = ciphertext.charAt(a);

	            if (Character.isLetter(character)) {
	                char lowerCaseCharacter = Character.toLowerCase(character);
	                decryptedText.append(mapping.getOrDefault(lowerCaseCharacter, lowerCaseCharacter));
	            } else {
	                decryptedText.append(character);
	            }
	        }

	        return decryptedText.toString();
	    }
 
}
	
	


