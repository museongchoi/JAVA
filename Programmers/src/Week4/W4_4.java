package Week4;

// 조건 문자열
public class W4_4 {
    class Solution {
        public int solution(String ineq, String eq, int n, int m) {
            int answer = 0;

            if(ineq.equals(">")) {
                if(eq.equals("=")) {
                    return n >= m ? 1 : 0;
                } else if(eq.equals("!")) {
                    return n > m ? 1 : 0;
                }
            } else if(ineq.equals("<")) {
                if(eq.equals("=")) {
                    return n <= m ? 1 : 0;
                } else if(eq.equals("!")) {
                    return n < m ? 1 : 0;
                }
            }
            return answer;
        }
    }
}