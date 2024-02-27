package Array_pr;

// 숨어있는 숫자의 덧셈 2
public class Split_1 {
    class Solution {
        public int solution(String my_string) {
            int answer = 0;
            String[] s = my_string.split("[^0-9]+");
            for(int i = 0; i < s.length; i++)
            {
                System.out.println(s[i]);
                if(!s[i].isEmpty())
                {
                    answer += Integer.parseInt(s[i]);
                }
            }
            return answer;
        }
    }
}
