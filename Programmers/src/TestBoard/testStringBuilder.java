package TestBoard;
import java.lang.StringBuilder;

public class testStringBuilder {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("문자열").append("연결");
        String str = stringBuilder.toString();
        System.out.println(stringBuilder);
        System.out.println(str);
    }

}
