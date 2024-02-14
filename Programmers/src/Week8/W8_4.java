package Week8;

// 9로 나눈 나머지
public class W8_4 {
    class Solution {
        public int solution(String number) {
            int answer = 0;
            int tmp = 0;

            for(int i = 0; i < number.length(); i++)
            {
                answer += number.charAt(i)-'0';
            }

            return answer%9;
        }
    }
}
