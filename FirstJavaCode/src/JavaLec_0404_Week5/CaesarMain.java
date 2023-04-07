package JavaLec_0404_Week5;

public class CaesarMain {
    public static void  main(String[] atgs)
    {
        CaesarCipher cc = new CaesarCipher();
        cc.plaintext = "Java Programming";
        cc.key = 4;
        
        // 암호화 및 결과 출력
        cc.encrypt();
        
        // 복호화 및 결과 출력
        cc.decrypt();

        CaesarCipher myCipher = new CaesarCipher("Hello World", 6);
        myCipher.encrypt();
        myCipher.decrypt();

    }
}
