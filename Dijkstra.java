package Graph;

public class Dijkstra {

	/*
	 * 计算一个节点到其他所有节点的最短路径 该算法要求图中不存在负权边
	 * o(n^2)
	 */

	static int[][] graph;

	public Dijkstra() {
		graph = new int[][] { { Integer.MAX_VALUE, 7, 9, Integer.MAX_VALUE,Integer.MAX_VALUE, 14 },
				{ 7, Integer.MAX_VALUE, 10,15, Integer.MAX_VALUE, Integer.MAX_VALUE },
				{ 9, 10, Integer.MAX_VALUE, 11, Integer.MAX_VALUE ,2},
				{ Integer.MAX_VALUE, 15,11, Integer.MAX_VALUE,6, Integer.MAX_VALUE },
				{ Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 6,Integer.MAX_VALUE,9},
				{14,Integer.MAX_VALUE,2,Integer.MAX_VALUE,9,Integer.MAX_VALUE}};
	}

	public static void dijkstra(int v0) {
		int len = graph.length;
		int[] dist = new int[len];
		int min_dist = Integer.MAX_VALUE;
		int min_j = -1;
		for (int i = 0; i < len; i++) {
			dist[i] = graph[v0][i];
			if (min_dist > dist[i]) {
				min_dist = dist[i];
				min_j = i;
			}
		}
		boolean [] is_sure = new boolean[len];
		is_sure[v0] = true;
		is_sure[min_j] = true;
		for (int k = 2; k <= len; k++) {
			min_dist = Integer.MAX_VALUE;
			int min_i = -1;
			is_sure[min_j] = true;
			for (int i = 0; i < len; i++) {
				if(i == v0)
					continue;
				if (graph[min_j][i] < Integer.MAX_VALUE && dist[i] > dist[min_j] + graph[min_j][i]) {
					dist[i] = dist[min_j] + graph[min_j][i];
				}
				if (!is_sure[i] && dist[i] < min_dist) {
					min_dist = dist[i];
					min_i = i;
				}
			}
			min_j = min_i;
		}
		for (int i = 0; i < len; i++) {
			System.out.println(dist[i] + "  ");
		}
	}
}
