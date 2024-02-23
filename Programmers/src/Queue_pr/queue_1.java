package Queue_pr;
import java.util.*;

// 스택/큐 -> 기능개발
public class queue_1 {
    //import java.util.*;

    class Solution {
        public int[] solution(int[] progresses, int[] speeds) {
            Queue<Integer> qu = new LinkedList<>();
            List<Integer> listcnt = new ArrayList<>();

            for(int i = 0; i < progresses.length; i++)
            {
                int pro = 100 - progresses[i];
                int spe = speeds[i];
                int tmp = pro % spe > 0 ? (pro/spe)+1 : pro/spe;
                if(!qu.isEmpty() && tmp > qu.peek())
                {
                    listcnt.add(qu.size());
                    qu.clear();
                }
                qu.add(tmp);
            }
            listcnt.add(qu.size());

            int[] answer = new int[listcnt.size()];
            for(int i = 0; i < listcnt.size(); i++)
            {
                answer[i] = listcnt.get(i);
            }

            return answer;
        }
    }
}

/*
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> qu = new LinkedList<>();
        List<Integer> listcnt = new ArrayList<>();

        for(int i = 0; i < progresses.length; i++)
        {
            int pro = 100 - progresses[i];
            int spe = speeds[i];
            int tmp = pro % spe > 0 ? (pro/spe)+1 : pro/spe;
            qu.add(tmp);
        }

        while(!qu.isEmpty()) {
            int cnt = 1;    // 배포 개수
            int val = qu.poll();    // 배포 가능 일수
            while (!qu.isEmpty() && val >= qu.peek())
            {
                qu.poll();
                cnt++;
            }
            listcnt.add(cnt);
        }

        int[] answer = new int[listcnt.size()];
        for(int i = 0; i < listcnt.size(); i++)
        {
            answer[i] = listcnt.get(i);
        }

        return answer;
    }
}
 */