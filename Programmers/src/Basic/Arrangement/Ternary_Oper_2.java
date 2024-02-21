package Basic.Arrangement;

// 합성수 찾기
public class Ternary_Oper_2 {
    class Solution {
        public int solution(int n) {
            int answer = 0;

            for(int i = 1; i <= n; i++)
            {
                int cnt = 0;
                for(int j = 1; j <= n; j++)
                {
                    cnt += i%j == 0 ? 1 : 0;
                }
                answer += cnt >= 3 ? 1 : 0;
            }

            return answer;
        }
    }
}

// code1

/*
class Solution {
    public int solution(int n) {
        int answer = 0;

        for(int i = 1; i <= n; i++)
        {
            int cnt = 0;
            for(int j = 1; j <= n; j++)
            {
                if(i%j == 0)
                {
                    cnt++;
                }
            }
            if(cnt >= 3)
            {
                answer++;
            }
        }

        return answer;
    }
}
 */