package Week4;

// flag 에 따라 다른 값 반환하기
public class W4_5 {
    class Solution {
        public int solution(int a, int b, boolean flag) {
            int answer = 0;
            if(flag) {
                answer = a + b;
            } else {
                answer = a - b;
            }

            return answer;
        }
    }
}

/*
class Solution {
    public int solution(int a, int b, boolean flag) {
        return flag ? a + b : a - b;
    }
}
 */