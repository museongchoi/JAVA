package Array_pr;

// 배수 구하기
// '/' 몫을 구하여 배수의 배열 사이즈를 미리 구한다
public class Arr_5 {
    class Solution {
        public int[] solution(int n, int k) {
            int count = n / k;
            int[] answer = new int[count];

            for (int i = 1; i <= count; i++) {
                answer[i - 1] = k * i;
            }

            return answer;
        }
    }
}

/*
import java.util.*;
class Solution {
    public int[] solution(int n, int k) {
        List<Integer> list = new ArrayList<>();

        for(int i = 1; i <= n; i++)
        {
            if(i%k == 0){
                list.add(i);
            }
        }

        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++)
        {
            answer[i] = list.get(i);
        }

        Arrays.sort(answer);

        return answer;
    }
}
 */