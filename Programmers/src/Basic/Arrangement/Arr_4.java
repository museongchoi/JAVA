package Basic.Arrangement;

public class Arr_4 {
    class Solution {
        public int[] solution(int[] arr, int[] query) {
            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < arr.length; i++)
            {
                sb.append(String.valueOf(arr[i]));
            }

            for(int j = 0; j < query.length; j++)
            {
                int tmp = query[j];
                if(tmp%2 == 0)
                {
                    sb.delete(tmp+1, sb.length());
                    System.out.println(sb);
                } else {
                    sb.delete(0, tmp);
                    System.out.println(sb);

                }
            }

            int[] answer = new int[sb.length()];
            for(int i = 0; i < sb.length(); i++)
            {
                answer[i] = sb.charAt(i) - '0';
            }
            return answer;
        }
    }
}
