package Array_pr;
import java.util.*;

// 배열 자르기
public class Arr_3 {
    //import java.util.*;
    class Solution {
        public int[] solution(int[] numbers, int num1, int num2) {
            int[] answer = {};
            answer = Arrays.copyOfRange(numbers, num1, num2+1);
            return answer;
        }
    }
}

/*
class Solution {
    public int[] solution(int[] numbers, int num1, int num2) {
        int[] answer = new int[num2-num1+1];
        int cnt = 0;

        for(int i = num1; i <= num2; i++)
        {
            answer[cnt] = numbers[i];
            cnt++;
        }

        return answer;
    }
}
 */