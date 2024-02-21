package Basic.Arrangement;

// 소인수분해
public class Stream_1 {
}

/*
import java.util.*;

class Solution {
    public int[] solution(int n) {
        List<Integer> list = new ArrayList<>();
        for(int i = 2; i <= n; i++)
        {
            while(n%i == 0)
            {
                if(!list.contains(i))
                {
                    list.add(i);
                }
                n /= i;
            }
        }
        int[] answer = new int[list.size()];
        for(int j = 0; j < answer.length; j++)
        {
            answer[j] = list.get(j);
        }

        return answer;
    }
}
 */