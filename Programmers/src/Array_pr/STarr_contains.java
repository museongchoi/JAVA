package Array_pr;

// 원하는 문자열 찾기
// contains() 메소드
public class STarr_contains {
    class Solution {
        public int solution(String myString, String pat) {
            int answer = 0;
            myString = myString.toLowerCase();
            pat = pat.toLowerCase();

            if(myString.contains(pat))
            {
                answer = 1;
            }

            return answer;
        }
    }
}
