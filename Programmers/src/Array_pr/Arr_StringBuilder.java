package Array_pr;

public class Arr_StringBuilder {
    class Solution {
        public int[] solution(int[] arr, int[] query) {
            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < arr.length; i++)
            {
                sb.append(String.valueOf(arr[i]));
            }

            for(int j = 0; j < query.length; j++)
            {
                int tmp = query[j];
                if(tmp%2 == 0)
                {
                    sb.delete(tmp+1, sb.length());
                    System.out.println(sb);
                } else {
                    sb.delete(0, tmp);
                    System.out.println(sb);

                }
            }

            int[] answer = new int[sb.length()];
            for(int i = 0; i < sb.length(); i++)
            {
                answer[i] = sb.charAt(i) - '0';
            }
            return answer;
        }
    }
}

//2
/*
import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] query) {
        for(int i = 0; i < query.length; i++)
        {
            int tmp = query[i];
            if(tmp%2 == 0)
            {
                arr = Arrays.copyOfRange(arr, 0, tmp+1);
            } else {
                arr = Arrays.copyOfRange(arr, tmp, arr.length);
            }
        }
        int[] answer = new int[arr.length];
        for(int j = 0; j < arr.length; j++)
        {
            answer[j] = arr[j];
        }

        return answer;
    }
}
 */

//3
/*
import java.util.*;
class Solution {
    public int[] solution(int[] arr, int[] query) {
        for(int i = 0; i < query.length; i++)
        {
            if(i%2 == 0) // 짝수 인덱스 일때
            {
                arr = Arrays.copyOfRange(arr, 0, query[i]+1);
            } else {    // 홀수 인덱스 일때
                arr = Arrays.copyOfRange(arr, query[i], arr.length);
            }
        }

        return arr;
    }
}
 */