package JavaLec_0404_Week5;

public class CaesarCipherTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Step 1 : Init Value, plaintext, key...

		//String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String plaintext = "Hello World!!!";
		int key = 3;
		String ciphertext = "";
		String output = "";
		int temp;
		String encValue, decValue;

		System.out.println("plaintext : " + plaintext);
		// Step 2 : Encryption
		
		for (int i=0; i<plaintext.length(); i++) {
			if (LETTERS.contains(""+plaintext.charAt(i))) {
				temp = (LETTERS.indexOf(plaintext.charAt(i)) + key) % LETTERS.length();				
				encValue = LETTERS.substring(temp, temp+1);
				ciphertext += encValue;
			}
			else {
				ciphertext += plaintext.charAt(i);
			}
		}
		System.out.println("ciphertext:" + ciphertext);
		
		// Step 3 : Decryption
		for (int i=0; i<ciphertext.length(); i++) {
			if (LETTERS.contains(""+ciphertext.charAt(i))) {
				temp = (LETTERS.indexOf(ciphertext.charAt(i)) - key) % LETTERS.length();
				if (temp<0)
					temp += LETTERS.length();
				decValue = LETTERS.substring(temp, temp+1);
				output += decValue;
			}
			else {
				output += ciphertext.charAt(i);
			}
		}
		System.out.println("plaintext:" + output);
	}

}
