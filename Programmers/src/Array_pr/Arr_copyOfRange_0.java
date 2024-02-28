package Array_pr;
import java.util.*;

// 뒤에서 5등까지
public class Arr_copyOfRange_0 {
    //import java.util.*;
    class Solution {
        public int[] solution(int[] num_list) {
            Arrays.sort(num_list);
            int[] answer = Arrays.copyOfRange(num_list, 0, 5);

            return answer;
        }
    }
}

/*
import java.util.*;
class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[5];
        Arrays.sort(num_list);
        for(int i = 0; i < 5; i++)
        {
            answer[i] = num_list[i];
        }
        return answer;
    }
}
 */