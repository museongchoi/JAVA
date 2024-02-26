package Graph_pr;

// 가장 먼 노드
public class Graph_1 {
    
}


// 배열 리스트 adj []list
/*
import java.util.*;
class Solution {
    List<Integer>[] adj;
    int[] visit;
    int depth = 0;

    public int solution(int n, int[][] edge) {
        int answer = 0;
        visit = new int[n+1];
        adj = new ArrayList[n+1];
        for(int i = 1; i <= n; i++)
        {
            adj[i]=new ArrayList<>();
        }
        for(int i = 0; i < edge.length; i++)
        {
            adj[edge[i][0]].add(edge[i][1]);
            adj[edge[i][1]].add(edge[i][0]);
        }
        bfs(1, 1);

        for(int j = 1; j <= n; j++)
        {
            if(visit[j] == depth)
            {
                answer++;
            }
        }

        return answer;
    }
    public void bfs(int start, int cnt) {
        visit[start] = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        q.add(cnt);

        while(!q.isEmpty())
        {
            int nowNode = q.poll();
            int maxdepth = q.poll();

            if(depth < maxdepth) {
                depth = maxdepth;
            }
            for(int i = 0; i < adj[nowNode].size(); i++)
            {
                int next = adj[nowNode].get(i);
                if(visit[next] != 0)
                {
                    continue;
                }
                visit[next] = maxdepth+1;
                q.add(next);
                q.add(maxdepth+1);
            }
        }

    }
}
 */