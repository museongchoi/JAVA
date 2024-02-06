package Week5;

// 이어 붙인 수
public class W5_5 {
    class Solution {
        public int solution(int[] num_list) {
            int answer = 0;
            StringBuilder odd = new StringBuilder();
            StringBuilder even = new StringBuilder();

            for(int i = 0; i < num_list.length; i++) {
                StringBuilder target = (num_list[i]%2 == 0) ? even : odd;
                target.append(num_list[i]);
            }

            answer = Integer.parseInt(even.toString()) + Integer.parseInt(odd.toString());

            return answer;
        }
    }
}

/*
class Solution {
    public int solution(int[] num_list) {
        int answer = 0;

        int even = 0;
        int odd = 0;

        for(int num : num_list) {
            if(num % 2 == 0) {
                even *= 10;
                even += num;
            } else {
                odd *= 10;
                odd += num;
            }
        }
        answer = even + odd;

        return answer;
    }
}
 */