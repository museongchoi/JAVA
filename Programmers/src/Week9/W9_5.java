package Week9;

// 접미사인지 확인하기
public class W9_5 {
    class Solution {
        public int solution(String my_string, String is_suffix) {
            int answer = 0;
            int mylen = my_string.length();
            String mytmp = "";

            for(int i = 0; i < mylen; i++)
            {
                mytmp = "";
                mytmp = my_string.substring(i);
                if(mytmp.equals(is_suffix)) {
                    answer = 1;
                }
            }

            return answer;
        }
    }
}
