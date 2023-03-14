package Week4;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ2178 {
    static int N,M,n,m;
    static int[][] map;
    static boolean[][] visited;
    static int[][] check;
    static Queue<Point> queue;

    //  N 세로, M 가로
    public static void main(String[] args) throws IOException
    {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        check = new int[N][M];

        for(int i = 0; i < N; i++)
        {
            String str = bf.readLine();
            for(int j = 0; j < M; j++)
            {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        BFS(0,0);
        System.out.println(check[N-1][M-1]);
    }
    private static void BFS(int x, int y)
    {
        visited[x][y] = true;
        check[x][y] = 1;
        queue = new LinkedList<>();
        queue.add(new Point(x,y));

        while (!queue.isEmpty())
        {
            Point tmp = queue.poll();
            n = tmp.x;
            m = tmp.y;

            if(n-1 >= 0 && map[n-1][m] == 1 && visited[n-1][m] != true)
            {
                tmp.x = n-1;
                tmp.y = m;
                queue.add(tmp);
                visited[n-1][m] = true;
                check[n-1][m] = check[n][m]+1;
            }
            if(n+1 < N && map[n+1][m] == 1 && visited[n+1][m] != true)
            {
                tmp.x = n+1;
                tmp.y = m;
                queue.add(tmp);
                visited[n+1][m] = true;
                check[n+1][m] = check[n][m]+1;
            }
            if(m-1 > 0 && map[n][m-1] == 1 && visited[n][m-1] != true)
            {
                tmp.x = n;
                tmp.y = m-1;
                queue.add(tmp);
                visited[n][m-1] = true;
                check[n][m-1] = check[n][m]+1;
            }
            if(m+1 < M && map[n][m+1] == 1 && visited[n][m+1] != true)
            {
                tmp.x = n;
                tmp.y = m+1;
                queue.add(tmp);
                visited[n][m+1] = true;
                check[n][m+1] = check[n][m]+1;
            }
        }
    }
}
