package Week7;

// 카운트 업
public class W7_3 {
    class Solution {
        public int[] solution(int start_num, int end_num) {
            int[] answer = new int[end_num - start_num + 1];
            int cnt = 0;

            for(int i = start_num; i <= end_num; i++)
            {
                answer[cnt] = i;
                cnt++;
            }

            return answer;
        }
    }
}

/*
class Solution {
    public int[] solution(int start, int end) {
        int[] answer = new int[end - start+1];
        for(int i =0; i<= end - start; i++) {
            answer[i] = start + i;
        }
        return answer;
    }
}
 */