import java.util.*;

public class Main {
    static int graph[][];
    static boolean visited[];
    static int dist[];
    static int n, m, u, v, w, a, b;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new int[n + 1][n + 1];
        visited = new boolean[n + 1];
        dist = new int[n + 1];

        // 그래프와 dist 배열 초기화
        for (int i = 0; i <= n; i++) {
            Arrays.fill(graph[i], Integer.MAX_VALUE); // 가중치는 최대값으로 초기화
            dist[i] = Integer.MAX_VALUE; // 최단거리도 최대값으로 초기화
        }

        // 간선 정보 입력
        for (int i = 0; i < m; i++) {
            u = sc.nextInt();
            v = sc.nextInt();
            w = sc.nextInt();
            graph[u][v] = Math.min(graph[u][v], w);
            graph[v][u] = Math.min(graph[v][u], w); // 양방향 그래프
        }

        // 시작점과 도착점 입력
        a = sc.nextInt();
        b = sc.nextInt();

        // 다익스트라 알고리즘 실행
        dijkstra(a);

        // 도착점까지의 최단 거리 출력
        System.out.println(dist[b] == Integer.MAX_VALUE ? -1 : dist[b]);
    }

    static void dijkstra(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) → Integer.compare(a[0], b[0])); // (노드, 거리) 기준으로 오름차순 정렬
        dist[start] = 0; // 시작점의 거리는 0
        pq.offer(new int[] {start, 0}); // (시작점, 0)

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int value = current[1];

            if (visited[node]) continue; // 이미 방문한 노드는 건너뛰기
            visited[node] = true;

            // 인접 노드 탐색
            for (int i = 1; i <= n; i++) {
                if (!visited[i] && graph[node][i] != Integer.MAX_VALUE) {
                    int newDist = value + graph[node][i];
                    if (newDist < dist[i]) {
                        dist[i] = newDist;
                        pq.offer(new int[] {i, newDist});
                    }
                }
            }
        }
    }
}
