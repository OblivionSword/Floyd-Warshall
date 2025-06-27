public class Floyd_Warshall {
	
	static final int INF = Integer.MAX_VALUE;

    public int[][] floydWarshall(int[][] graph) {
    	int V = graph.length;
        int[][] dist = new int[V][V];

        // let dist be a |V| × |V| array of minimum distances initialized to ∞ (infinity)
        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++)
                dist[i][j] = INF;

        for (int u = 0; u < V; u++) {
            for (int v = 0; v < V; v++) {
                if (graph[u][v] != INF) {
                    dist[u][v] = graph[u][v];
                }
            }
        }

        for (int v = 0; v < V; v++) {
            dist[v][v] = 0;
        }

        // Floyd-Warshall
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF && // check if there's a path
                        dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        return dist;
    }

}
