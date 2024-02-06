package Week5;

// 주사위 게임 2
public class W5_3 {
    class Solution {
        public int solution(int a, int b, int c) {
            int answer = 1;
            int cnt = 1;

            if(a == b || a == c || b == c) {
                cnt++;
            }
            if(a == b && b == c) {
                cnt++;
            }
            for(int i = 1; i <= cnt; i++) {
                answer *= (Math.pow(a, i) + Math.pow(b, i) + Math.pow(c, i));
            }

            return answer;
        }
    }
}

/*
class Solution {
    public int solution(int a, int b, int c) {
        int answer = 1;
        int abc[] = {a, b, c};
        int cnt = 1;

        for(int i = 1; i < abc.length; i++) {
            if(abc[i] == abc[i-1]){
                cnt += 1;
            }
        }

        for(int i = 1; i <= cnt; i++) {
            int num = 0;
            for(int j = 0; j < abc.length; j++) {
                num += Math.pow(abc[j], i);
            }
            answer *= num;
        }
        return answer;
    }
}
 */
