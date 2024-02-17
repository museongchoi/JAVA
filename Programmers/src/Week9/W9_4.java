package Week9;
import java.util.*;

// 접미사 배열
public class W9_4 {
    //import java.util.*;

    class Solution {
        public String[] solution(String my_string) {
            int mylen = my_string.length();
            String[] answer = new String[mylen];

            for(int i = 0; i < mylen; i++)
            {
                answer[i] = my_string.substring(i);
            }
            Arrays.sort(answer);

            return answer;
        }
    }
}
