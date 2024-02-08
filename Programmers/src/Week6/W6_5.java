package Week6;
import java.util.*;

// 수열과 구관 쿼리 2
// 가장 큰 값으로 answer 배열을 초기화, queries 길이 만큼 + 탐색 범위 만큼 반복문을 돌리면서 최소값을 찾는다.
// 여기서 탐색 범위는 2차원 배열 안에 idx 0, 1이 범위를 가르킨다.
public class W6_5 {
    // import java.util.*;

    class Solution {
        public int[] solution(int[] arr, int[][] queries) {
            int[] answer = new int[queries.length];
            Arrays.fill(answer, Integer.MAX_VALUE);

            for(int j = 0; j < queries.length; j++)
            {
                for(int i = queries[j][0]; i <= queries[j][1]; i++)
                {
                    if(arr[i] > queries[j][2])
                    {
                        answer[j] = Math.min(answer[j], arr[i]);
                    }
                }
                if(answer[j] == Integer.MAX_VALUE) {
                    answer[j] = -1;
                }
            }

            return answer;
        }
    }
}
