package Week6;
import java.util.Arrays;

// 수 조작하기 1
public class W6_2 {
    class Solution {
        // import java.util.Arrays;
        public int solution(int n, String control) {
            char[] list = control.toCharArray();
            int answer = 0;

            for(int i = 0; i < list.length; i++) {
                if(list[i] == 'w') {
                    n += 1;
                } else if(list[i] == ('s')) {
                    n -= 1;
                } else if(list[i] == ('d')) {
                    n += 10;
                } else {
                    n -= 10;
                }
            }

            return answer = n;
        }
    }

}

/*
class Solution {
    public int solution(int n, String control) {
        int answer = n;

        for(char ch : control.toCharArray()) {
            switch(ch) {
                case 'w': answer += 1; break;
                case 's': answer -= 1; break;
                case 'd': answer += 10; break;
                case 'a': answer -= 10; break;
                default:break;
            }
        }

        return answer;
    }
}
 */
