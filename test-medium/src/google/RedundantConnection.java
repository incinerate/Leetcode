package google;

import UnionFind.UnionFind;

public class RedundantConnection {

	public int[] findRedundantConnection(int[][] edges) {
		UnionFind unionFind = new UnionFind(edges.length);

		for (int[] edge : edges) {
			int u = edge[0];
			int v = edge[1];
			if (!unionFind.union(u, v)) {
				return edge;
			}
		}
		return null;
	}
}