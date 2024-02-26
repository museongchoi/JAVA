package Basic.Arrangement;

public class STarr_substring {
    class Solution {
        public String solution(String my_string, int n) {
            String answer = "";
            answer = my_string.substring(0, n);
            return answer;
        }
    }
}

/*
class Solution {
    public String solution(String my_string, int n) {
        String answer = "";
        for(int i = 0; i < n; i++)
        {
            answer += my_string.charAt(i);
        }
        return answer;
    }
}
 */