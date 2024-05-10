import java.util.HashMap;
import java.util.*;

public class subCipher {
	public static Map<Character, Character> cipherMapping() {
		String legalMessage = "abcdefghijklmnopqrstuvwxyz";
		Map<Character, Character> cipherMap = new HashMap<>();
		
		Scanner in = new Scanner(System.in);
		
		for(int a=0; a<legalMessage.length(); a++) {
				char subLetter = legalMessage.charAt(a);
				System.out.print("Replace " + subLetter + " with: ");
				char cipherText = in.next().charAt(0);
				cipherMap.put(subLetter, cipherText);		
		}
		
		return cipherMap;
	}

	public static String encrypt(String message, Map<Character, Character> cipherMap) {
			StringBuilder ciphertext = new StringBuilder();
			
			char[] characters = message.toCharArray();
			for(int i = 0; i < characters.length; i++) {
				char character = characters[i];
				if(Character.isLetter(character)) {
					char encryptedLetter = cipherMap.getOrDefault(Character.toLowerCase (character), character);
					if(Character.isUpperCase(character)) {
							ciphertext.append(Character.toUpperCase(encryptedLetter));
					}
				
					else {
						ciphertext.append(encryptedLetter);
					}
				}
				else {
					ciphertext.append(character);
				}
			}
				return ciphertext.toString();
					
			}
			
	public static void main(String[] args) {
			Map<Character, Character> cipherMap = cipherMapping();
			String lowerLetter = "abcdefghijklmnopqrstuvwxyz";
			System.out.println("Enter a message using the legal set: " + lowerLetter);
			Scanner in = new Scanner(System.in);
			String user = in.nextLine();
			String cipher = encrypt(user, cipherMap);
			System.out.println("Encrypted Message: " + cipher);
	}

}
