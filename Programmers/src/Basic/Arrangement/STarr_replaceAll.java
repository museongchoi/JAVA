package Basic.Arrangement;

// replaceAll 메소드 사용
public class STarr_replaceAll {
    class Solution {
        public String solution(String rny_string) {
            String answer = "";
            answer = rny_string.replaceAll("m", "rn");
            return answer;
        }
    }
}

// 문자열의 문자 하나씩 비교
/*
class Solution {
    public String solution(String rny_string) {
        String answer = "";
        for(int i = 0; i < rny_string.length(); i++)
        {
            char ch = rny_string.charAt(i);
            if(ch == 'm')
            {
                answer += "rn";
            } else {
                answer += ch;
            }
        }
        return answer;
    }
}
 */

// ArrayList 사용
/*
import java.util.*;
class Solution {
    public String solution(String rny_string) {
        String answer = "";
        List<String> list = new ArrayList<>();

        for(int i = 0; i < rny_string.length(); i++)
        {
            if(rny_string.charAt(i) == 'm')
            {
                list.add("r");
                list.add("n");
            } else {
                char ch = rny_string.charAt(i);
                list.add(String.valueOf(ch));
            }
        }
        for(int i = 0; i < list.size(); i++)
        {
            answer += list.get(i);
        }
        return answer;
    }
}
 */