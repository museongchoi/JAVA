package Week5;

// 원소들의 곱과 합
public class W5_4 {
    class Solution {
        public int solution(int[] num_list) {
            int answer = 0;
            int times = 1;
            int numSquare = 0;

            for(int i = 0; i < num_list.length; i++) {
                times *= num_list[i];
                numSquare += num_list[i];
            }

            answer = times < Math.pow(numSquare, 2) ? 1 : 0;
            return answer;
        }
    }
}
