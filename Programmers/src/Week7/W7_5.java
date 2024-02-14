package Week7;
import java.util.*;

// 배열 만들기 4
public class W7_5 {
    // import java.util.*;

    class Solution {
        public int[] solution(int[] arr) {
            ArrayList<Integer> arr1 = new ArrayList<>();
            int cnt = 0;

            for(int i = 0; i < arr.length; i+=cnt)
            {
                cnt = 0;
                if(arr1.isEmpty())
                {
                    arr1.add(arr[i]);
                    cnt = 1;
                } else {
                    if(arr1.get(arr1.size()-1) < arr[i])
                    {
                        arr1.add(arr[i]);
                        cnt = 1;
                    } else {
                        arr1.remove(arr1.size()-1);
                    }
                }
            }

            int[] stk = new int[arr1.size()];
            for(int j = 0; j < arr1.size(); j++)
            {
                stk[j] = arr1.get(j).intValue();
            }
            return stk;
        }
    }
}
