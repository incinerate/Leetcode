package google;

public class RedundantConnection2 {

	public int[] findRedundantDirectedConnection(int[][] edges) {
        int N = edges.length;
        int twoParentsEdge = -1;
        int makeCycleEdge = -1;
        UnionFind unionFind = new UnionFind(N +1);

        int[] parents = new int[N +1];
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            // have two parents
            if(parents[v] != 0)
            {
                twoParentsEdge = i;
                break;
            }else {
                parents[v] = u;
            }
        }

        for (int i = 0; i < edges.length; i++) {
            if(i == twoParentsEdge)continue;
            int u = edges[i][0];
            int v = edges[i][1];
            if(!unionFind.union(u,v))
            {
                makeCycleEdge = i;
                break;
            }
        }

        // have cycle and twoParents edge, delete first twoParents edge.
        if(makeCycleEdge != -1 && twoParentsEdge != -1)
        {
            int v = edges[twoParentsEdge][1];
            int u = parents[v];
            return new int[]{u,v};
        }

        // no two parents edge, just have cycle edge
        if(makeCycleEdge != -1)
        {
            return edges[makeCycleEdge];
        }

        // no cycle edge, just have two parent edge.
        if(twoParentsEdge != -1)
        {
            return edges[twoParentsEdge];
        }


        // no Redundant Connection
        return new int[]{0,0};

    }




    public class UnionFind {

    private int count;
    private int[] parents;
    private int[] rank;
    public UnionFind(int size)
    {
        this.count = size;
        parents = new int[count];
        for (int i = 0; i < size; i++) {
            parents[i] = i;
        }
        rank = new int[count];
    }

    public int find(int i)
    {
        while (parents[i] != i)
        {
            parents[i] = parents[parents[i]];
            i = parents[i];
        }
        return parents[i];
    }

    public boolean union(int p, int q)
    {
        int pp = find(p);
        int pq = find(q);
        if(pp == pq)return false;
        if(rank[pp] < rank[pq])
        {
            parents[pp] = pq;
        }else {
            if(rank[pp] == rank[pq])
            {
                rank[pp]++;
            }
            parents[pq] = pp;
        }
        return true;
    }

    public boolean isConnected(int p, int q)
    {
        int pp = find(p);
        int pq = find(q);
        return pp == pq;
    }

    public int getCount()
    {
        return this.count;
    }
}
}
