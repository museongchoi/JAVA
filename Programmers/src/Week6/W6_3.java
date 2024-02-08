package Week6;

// 수 조작하기2
public class W6_3 {
    class Solution {
        public String solution(int[] numLog) {
            String answer = "";

            for(int i = 0; i < numLog.length; i++) {
                if(i == numLog.length-1) {
                    break;
                }
                int j = numLog[i+1] - numLog[i];
                switch(j) {
                    case 1 :
                        answer += 'w';
                        break;
                    case -1 :
                        answer += 's';
                        break;
                    case 10 :
                        answer += 'd';
                        break;
                    case -10 :
                        answer += 'a';
                        break;
                }
            }

            return answer;
        }
    }
}

// for 문을 사용하여 idx 가 넘어가지 않게 i 는 증가 idx 는 0과 1을 비교
/*
        for(int i=1; i<numLog.length; i++){
            int j = numLog[i-1] - numLog[i];
            switch(j){
                case -1 : answer+='w'; break;
                case 1 : answer+='s'; break;
                case -10 : answer+='d'; break;
                case 10 : answer+='a'; break;
            }
        }

 */