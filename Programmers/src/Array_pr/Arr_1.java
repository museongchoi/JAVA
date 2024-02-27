package Array_pr;

public class Arr_1 {
    class Solution {
        public int[][] solution(int[] num_list, int n) {
            int m = num_list.length / n;
            int[][] answer = new int[m][n];
            int cnt = 0;

            for(int i = 0; i < m; i++)
            {
                for(int j = 0; j < n; j++)
                {
                    answer[i][j] = num_list[cnt];
                    cnt++;
                }
            }

            return answer;
        }
    }
}

/*
class Solution {
    public int[][] solution(int[] num_list, int n) {
        int[][] answer = {};

        int length = num_list.length;

        answer = new int[length/n][n];

        for(int i=0; i<length; i++){
            answer[i/n][i%n]=num_list[i];
        }

        return answer;
    }
}
 */