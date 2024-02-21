package Basic.Arrangement;

// 점의 위치 구하기
public class Ternary_Oper_1 {
    class Solution {
        public int solution(int[] dot) {
            int answer = 0;
            int x = dot[0];
            int y = dot[1];

            if(x >= 0)
            {
                answer = y >= 0 ? 1 : 4;
            } else {
                answer = y >= 0 ? 2 : 3;
            }
            return answer;
        }
    }
}

/*
class Solution {
    public int solution(int[] dot) {
        int answer = 0;
        int i = 0;
        if(dot[i] <= 0 || dot[i+1] <= 0)
        {
            answer = dot[i] <= 0 && dot[i+1] <= 0 ? 3 : dot[i] <= 0 ? 2 : 4;
        } else {
            answer = 1;
        }
        return answer;
    }
}
 */