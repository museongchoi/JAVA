package Week8;

// 문자열 여러번 뒤집기
public class W8_5 {
    //import java.util.*;

    class Solution {
        public String solution(String my_string, int[][] queries) {
            String answer = "";
            StringBuilder tmp = new StringBuilder(my_string);

            for(int i = 0 ; i < queries.length; i++)
            {
                // 변경해야하는 단어의 idx 시작과 끝 지점을 저장
                int staidx = queries[i][0];
                int endidx = queries[i][1];
                StringBuilder sb = new StringBuilder();
                for(int j = staidx; j <= endidx; j++)
                {
                    sb.append(tmp.charAt(j));
                }
                sb.reverse();
                tmp.replace(staidx, endidx+1, sb.toString());
            }
            answer = tmp.toString();
            return answer;
        }
    }
}

// 디버깅 프린트문 포함
/*
import java.util.*;

class Solution {
    public String solution(String my_string, int[][] queries) {
        String answer = "";
        StringBuilder tmp = new StringBuilder(my_string);

        for(int i = 0 ; i < queries.length; i++)
        {
            // 변경해야하는 단어의 idx 시작과 끝 지점을 저장
            int staidx = queries[i][0];
            int endidx = queries[i][1];
            System.out.print(staidx);
            System.out.println(endidx);
            StringBuilder sb = new StringBuilder();
            for(int j = staidx; j <= endidx; j++)
            {
                sb.append(tmp.charAt(j));
            }
            System.out.println(tmp);
            System.out.println(sb);
            sb.reverse();
            System.out.println(sb);
            tmp.replace(staidx, endidx+1, sb.toString());
            System.out.println(tmp);
        }
        answer = tmp.toString();
        return answer;
    }
}
 */