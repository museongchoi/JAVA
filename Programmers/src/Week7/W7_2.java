package Week7;
import java.util.*;

// 배열 만들기 2
public class W7_2 {
    // import java.util.*;

    class Solution {
        public int[] solution(int l, int r) {
            ArrayList<Integer> answer = new ArrayList<>();

            for(int i = l; i <= r; i++)
            {
                int num = i;
                boolean isValid = true;
                while(num > 0)
                {
                    int tmp = num % 10;
                    if(tmp != 0 && tmp != 5)
                    {
                        isValid = false;
                        break;
                    }
                    num /= 10;
                }

                if(isValid)
                {
                    answer.add(i);
                }
            }

            if(answer.isEmpty())
            {
                return new int[] {-1};
            }

            int[] result = new int[answer.size()];
            for(int i = 0; i < result.length; i++)
            {
                result[i] = answer.get(i);
            }

            return result;
        }
    }
}
/*
주어진 코드는 주어진 범위 내에서 5의 배수를 이진수로 변환한 후에 그 값을 찾아내는 기능을 구현하고 있습니다. 코드를 해석하면 다음과 같습니다:
ArrayList<Integer> list = new ArrayList<>();: 결과값을 저장할 ArrayList를 선언합니다.
for (int i = 1; i < 64; i++) {: 1부터 63까지의 숫자에 대해 반복합니다. 이 범위는 64를 이진수로 표현하면 100000이 되는데, 이는 5의 6제곱에 해당하는 숫자입니다.
int num = Integer.parseInt(Integer.toBinaryString(i)) * 5;: 현재 숫자 i를 이진수로 변환한 후에 5를 곱하여 num 변수에 저장합니다. 이렇게 함으로써 num 변수에는 5의 배수를 이진수로 표현한 값이 저장됩니다.
if (l <= num && num <= r) list.add(num);: num 변수가 주어진 범위 l과 r 사이에 포함되는지를 확인하고, 포함된다면 list ArrayList에 해당 값을 추가합니다.
return list.isEmpty() ? new int[] { -1 } : list.stream().mapToInt(i -> i).toArray();: list ArrayList가 비어있는지 확인하고, 비어있다면 -1을 포함한 배열을 반환합니다. 그렇지 않다면 list ArrayList의 요소를 int 배열로 변환하여 반환합니다.
즉, 주어진 범위 내에서 5의 배수를 이진수로 변환한 값들을 찾아내고, 해당 값을 배열로 반환하는 기능을 구현한 코드입니다.
 */

/*
import java.util.ArrayList;

class Solution {
    public int[] solution(int l, int r) {

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i < 64; i++) {
            int num = Integer.parseInt(Integer.toBinaryString(i)) * 5;
            if (l <= num && num <= r)
                list.add(num);
        }

        return list.isEmpty() ? new int[] { -1 } : list.stream().mapToInt(i -> i).toArray();
    }
}
 */