package Week9;

// 문자열의 뒤의 n글자
// .substring() 메서드 사용
public class W9_3 {
    class Solution {
        public String solution(String my_string, int n) {
            String answer = "";

            answer = my_string.substring(my_string.length() - n);

            return answer;
        }
    }

}

// substring 을 사용하지 않음
/*
class Solution {
    public String solution(String my_string, int n) {
        StringBuilder sb = new StringBuilder();

        int staidx = my_string.length() - 1;
        int endidx = staidx - n + 1;
        System.out.println(staidx);
        System.out.println(endidx);
        for(int i = staidx; i >= endidx; i--)
        {
            sb.append(my_string.charAt(i));
        }
        sb.reverse();
        String answer = sb.toString();
        return answer;
    }
}
 */