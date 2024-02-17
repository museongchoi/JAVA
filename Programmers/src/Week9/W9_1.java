package Week9;
import java.util.*;

// 배열 만들기 5
public class W9_1 {
    //import java.util.*;

    class Solution {
        public int[] solution(String[] intStrs, int k, int s, int l) {
            List<Integer> relist = new ArrayList<>();
            StringBuilder sbstr = new StringBuilder();

            for(int i = 0; i < intStrs.length; i++)
            {
                for(int j = s; j <= s+l-1; j++)
                {
                    sbstr.append(intStrs[i].charAt(j));
                }
                int tmp = Integer.parseInt(sbstr.toString());
                if(k < tmp) {
                    relist.add(tmp);
                }
                sbstr.setLength(0);
            }
            int[] answer = new int[relist.size()];
            for(int i = 0; i < relist.size(); i++)
            {
                answer[i] = relist.get(i);
            }
            return answer;
        }
    }
}
