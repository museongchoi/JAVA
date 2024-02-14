package Week7;
import java.util.*;

// 콜라츠 수열 만들기
public class W7_4 {
    //import java.util.*;

    class Solution {
        public int[] solution(int n) {
            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(n);

            while(n != 1)
            {
                if(n%2 == 0)
                {
                    n = n/2;
                    arr.add(n);
                } else {
                    n = 3 * n + 1;
                    arr.add(n);
                }
            }
            int[] answer = new int[arr.size()];
            for(int i = 0; i < arr.size(); i++)
            {
                answer[i] = arr.get(i);
            }

            return answer;
        }
    }
}

/*
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int n) {
        return IntStream.concat(
                        IntStream.iterate(n, i -> i > 1, i -> i % 2 == 0 ? i / 2 : i * 3 + 1),
                        IntStream.of(1))
                .toArray();
    }
}
 */
