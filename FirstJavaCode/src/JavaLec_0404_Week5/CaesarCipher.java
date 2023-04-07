package JavaLec_0404_Week5;

import java.util.logging.Level;

public class CaesarCipher {
    String plaintext;   // 평문
    int key;    // 키
    String ciphertext = "";  // 암호문
    String output = "";  // 복호문
    final static String LATTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    
    // this 는 현재 객체
    public CaesarCipher(String s, int i) {
        this.plaintext = s;
        this.key = i;
    }

    public CaesarCipher() {

    }
    // static 은 class에서 유일하게 하나만 존재한다는 뜻

    public void encrypt() {
        for (int i=0; i<plaintext.length(); i++) {
            if (LATTERS.contains(""+plaintext.charAt(i))) {
                int temp = (LATTERS.indexOf(plaintext.charAt(i)) + key) % LATTERS.length();
                String encValue = LATTERS.substring(temp, temp+1);
                ciphertext += encValue;
            }
            else {
                ciphertext += plaintext.charAt(i);
            }
        }
        System.out.println("ciphertext:" + ciphertext);
    }

    public void decrypt() {
        for (int i=0; i<ciphertext.length(); i++) {
            if (LATTERS.contains(""+ciphertext.charAt(i))) {
                int temp = (LATTERS.indexOf(ciphertext.charAt(i)) - key) % LATTERS.length();
                if (temp<0)
                    temp += LATTERS.length();
                String  decValue = LATTERS.substring(temp, temp+1);
                output += decValue;
            }
            else {
                output += ciphertext.charAt(i);
            }
        }
        System.out.println("plaintext:" + output);
    }

    public void printOutput() {
    }
}
