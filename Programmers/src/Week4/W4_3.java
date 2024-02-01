package Week4;

// 홀짝에 따라 다른 값 반환하기
public class W4_3 {
    class Solution {
        public int solution(int n) {
            int answer = 0;

            if (n % 2 == 0) {
                for (int i = 2; i <= n; i += 2) {
                    answer += Math.pow(i, 2);
                }
            } else {
                for (int i = 1; i <= n; i += 2) {
                    answer += i;
                }
            }

            return answer;
        }
    }
}

/*
class Solution {
    public int solution(int n) {
        if (n % 2 == 1) {
            return (n + 1) * (n + 1) / 2 / 2;
        } else {
            return 4 * n/2 * (n/2 + 1) * (2 * n/2 + 1) / 6;
        }
    }
}
 */