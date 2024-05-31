import java.util.Scanner;

public class Cycle {

    static class UnionFind {
        int[] parent, rank;

        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int u) {
            if (parent[u] != u) parent[u] = find(parent[u]);
            return parent[u];
        }

        boolean union(int u, int v) {
            int rootU = find(u), rootV = find(v);
            if (rootU == rootV) return false;
            if (rank[rootU] > rank[rootV]) parent[rootV] = rootU;
            else if (rank[rootU] < rank[rootV]) parent[rootU] = rootV;
            else { parent[rootV] = rootU; rank[rootU]++; }
            return true;
        }
    }

    static boolean isCyclic(int[][] graph) {
        int n = graph.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (graph[i][j] != 0 && !uf.union(i, j)) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of vertices:");
        int n = scanner.nextInt();

        int[][] adjacencyMatrix = new int[n][n];
        System.out.println("Enter the adjacency matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adjacencyMatrix[i][j] = scanner.nextInt();
            }
        }

        System.out.println(isCyclic(adjacencyMatrix) ? "The graph contains a cycle." : "The graph does not contain a cycle.");
        scanner.close();
    }
}
