package Week4;

public class W4_2 {
    class Solution {
        public int solution(int number, int n, int m) {
            int answer = 0;
            answer = 0 == number%n && 0 == number%m ? 1 : 0;
            return answer;
        }
    }
}
