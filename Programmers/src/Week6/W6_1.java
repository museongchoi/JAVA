package Week6;
import java.util.*;
// 마지막 두 원
public class W6_1 {
    class Solution {
        public List solution(int[] num_list) {
            List<Integer> answer = new ArrayList<>();

            for(int i = 0; i < num_list.length; i++) {
                answer.add(num_list[i]);
                if(i == num_list.length - 1) {
                    answer.add(num_list[i] > num_list[i-1] ? (num_list[i] - num_list[i-1]) : (num_list[i] * 2));
                }
            }

            return answer;
        }
    }
}

/*
// 너무 단순 무식함
class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length + 1];

        for(int i = 0; i < num_list.length; i++) {
            answer[i] = num_list[i];
        }
        answer[answer.length - 1] = num_list[num_list.length - 1] > num_list[num_list.length - 2] ?
        num_list[num_list.length - 1] - num_list[num_list.length - 2] : num_list[num_list.length - 1] * 2;

        return answer;
    }
}
 */
