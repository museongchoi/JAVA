package Week5;

// 코드 처리하기
public class W5_1 {
    class Solution {
        public String solution(String code) {
            String answer = "";
            int mode = 0;

            for(int idx = 0; idx < code.length(); idx++) {
                if(code.charAt(idx) == '1') mode = 1 - mode;
                else if(idx%2 == mode) answer += code.charAt(idx);
            }
            return "".equals(answer) ? "EMPTY" : answer;
        }
    }
}

/*
class Solution {
    public String solution(String code) {
        String answer = "";
        int mode = 0;

        for(int idx = 0; idx < code.length(); idx++) {
            if(mode == 0) {
                if(code.charAt(idx) == '1') {
                    mode = 1;
                } else if (idx%2 == 0) {
                    answer += code.charAt(idx);
                }
            } else if(mode == 1) {
                if(code.charAt(idx) == '1') {
                    mode = 0;
                } else if (idx%2 == 1) {
                    answer += code.charAt(idx);
                }
            }
        }
        if(mode == 0 && answer.equals("")) {
            answer = "EMPTY";
        }
        return answer;
    }
}
 */