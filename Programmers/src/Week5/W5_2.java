package Week5;

// 등차수열의 특정한 항만 더하
// stream 사용 방법 알아보기
public class W5_2 {
    class Solution {
        public int solution(int a, int d, boolean[] included) {
            int answer = 0;
            int ad = a;

            for(int i = 0; i < included.length; i++) {
                if(included[i] == true) {
                    answer += ad;
                }
                ad += d;
            }
            return answer;
        }
    }
}
