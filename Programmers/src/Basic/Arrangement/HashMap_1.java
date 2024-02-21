package Basic.Arrangement;
import java.util.*;

// 진료순서 정하기
public class HashMap_1 {
    //import java.util.*;
    class Solution {
        public int[] solution(int[] emergency) {
            Map<Integer, Integer> map = new HashMap<>();
            // HashMap 생성
            // emergency를 카피 후 정렬 -> emergency 길이 size 저장 -> 반복문을 통해 첫번째 값과 순위(배열 길이 - 인덱스)를 map에 저장
            // emergency는 키값 순위는 value값이 되어 저장 -> 반복문을 통해 emergency 배열에 순위 value 값을 저장.
            int[] emergencySort = Arrays.copyOfRange(emergency, 0, emergency.length);
            Arrays.sort(emergencySort);
            int size = emergency.length;
            for(int i = 0; i<emergencySort.length; i++){
                int e = emergencySort[i];
                map.put(e, size-i);
            }
            for(int i = 0; i<emergency.length; i++){
                emergency[i] = map.get(emergency[i]);
            }
            return emergency;
        }
    }

}

// my code
/*
import java.util.*;

class Solution {
    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];

        Integer[] sortarr = new Integer[emergency.length];
        for(int i = 0; i < emergency.length; i++)
        {
            sortarr[i] = emergency[i];
        }
        Arrays.sort(sortarr, Collections.reverseOrder());

        for(int i = 0; i < sortarr.length; i++)
        {
            for(int j = 0; j < emergency.length; j++)
            {
                if(sortarr[i].equals(emergency[j]))
                {
                    answer[j] = i+1;
                }
            }
        }

        return answer;
    }
}
 */

// 최적화
/*
import java.util.*;

class Solution {
    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];

        for(int i = 0; i < answer.length; i++)
        {
            int idx = 1;
            for(int j = 0; j < answer.length; j++)
            {
                if(emergency[i] < emergency[j])
                {
                    idx++;
                }
            }
            answer[i] = idx;
        }

        return answer;
    }
}
 */