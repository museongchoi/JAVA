package Week9;

// 부분 문자열 이어 붙여 문자열 만들기
public class W9_2 {
    class Solution {
        public String solution(String[] my_strings, int[][] parts) {
            String answer = "";
            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < parts.length; i++)
            {
                int staidx = parts[i][0];
                int endidx = parts[i][1];
                for(int j = staidx; j <= endidx; j++)
                {
                    sb.append(my_strings[i].charAt(j));
                }
            }

            return answer = sb.toString();
        }
    }
}
