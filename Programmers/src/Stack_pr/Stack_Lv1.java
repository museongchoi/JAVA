package Stack_pr;
import java.util.*;

// 같은 숫자는 싫어
public class Stack_Lv1 {
    //import java.util.*;

    public class Solution {
        public int[] solution(int []arr) {
            Stack<Integer> stack = new Stack<>();

            for(int i = 0; i < arr.length; i++)
            {
                if(stack.isEmpty() == true)
                {
                    stack.push(arr[i]);
                }
                if(stack.peek() != arr[i])
                {
                    stack.push(arr[i]);
                }
            }
            int[] answer = new int[stack.size()];
            int cnt = answer.length - 1;
            while(stack.isEmpty() == false)
            {
                answer[cnt] = stack.pop();
                cnt--;
            }

            return answer;
        }
    }
}
