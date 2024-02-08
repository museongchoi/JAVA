package Week6;

// 수열과 구간 쿼리 3
public class W6_4 {
    class Solution {
        public int[] solution(int[] arr, int[][] queries) {
            int[] answer = {};
            int tmp = 0;

            for(int i = 0; i < queries.length; i++) {
                tmp = arr[queries[i][0]];
                arr[queries[i][0]] = arr[queries[i][1]];
                arr[queries[i][1]] = tmp;
            }

            return answer = arr;
        }
    }
}
