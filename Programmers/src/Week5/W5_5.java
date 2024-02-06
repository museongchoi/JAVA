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
                even *= 10;     // 10을 곱하여 자릿수를 맞춘다.
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

//짝수: 456
//처음에 even은 0이므로, even *= 10;을 실행하면 0이 됩니다.
//그 다음에 even += 4;를 실행하면 even은 4가 됩니다.
//그 다음에 even *= 10;을 실행하면 even은 40이 됩니다.
//그 다음에 even += 5;를 실행하면 even은 45가 됩니다.
//그 다음에 even *= 10;을 실행하면 even은 450이 됩니다.
//그 다음에 even += 6;를 실행하면 even은 456이 됩니다.
//이렇게 456이 나오게 되는데, 여기서 10을 곱하는 것은 각 숫자를 이어붙일 때 자릿수를 올바르게 유지하기 위해서입니다. 짝수의 경우 자릿수를 유지하기 위해 10을 곱합니다.
//
//홀수 역시 동일한 방법으로 10을 곱해주는 이유는 같습니다. 따라서 10을 곱하는 것은 각 숫자를 이어붙일 때 자릿수를 올바르게 유지하기 위함입니다.

 */