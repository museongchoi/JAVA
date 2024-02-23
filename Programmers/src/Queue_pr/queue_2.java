package Queue_pr;
import java.util.*;

// 다리를 지나는 트럭
public class queue_2 {
    //import java.util.*;

    class Solution {
        public int solution(int bridge_length, int weight, int[] truck_weights) {
            int answer = 0;
            Queue<Integer> q = new LinkedList<>();

            int sum = 0; // 현재 무게
            int time = 0; // 시간
            for(int i = 0; i < truck_weights.length; i++)
            {
                int truck = truck_weights[i];
                while(true)
                {
                    // 다리가 비어 있을 경우
                    if(q.isEmpty())
                    {
                        q.add(truck);
                        sum += truck;
                        time++;
                        break;
                    } else if(q.size() == bridge_length) // 다리가 꽉 차있을 경우
                    {
                        sum -= q.poll();
                    } else {
                        if(sum + truck <= weight)
                        {
                            q.add(truck);
                            sum += truck;
                            time++;
                            break;
                        } else {
                            q.add(0);
                            time++;
                        }
                    }
                }
            }
            answer = time + bridge_length;
            return answer;
        }
    }
}
