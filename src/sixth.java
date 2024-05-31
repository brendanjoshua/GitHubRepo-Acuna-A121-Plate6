import java.util.*;

public class sixth {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of vertices:");
        int n = scanner.nextInt();

        System.out.println("Enter the number of edges:");
        int m = scanner.nextInt();

        Map<Integer, Map<Integer, Integer>> adjacencyMatrix = new HashMap<>();

        System.out.println("Enter the edges (pairs of vertices, for directed edges enter u v):");
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            adjacencyMatrix.putIfAbsent(u, new HashMap<>());
            Map<Integer, Integer> edges = adjacencyMatrix.get(u);
            edges.put(v, edges.getOrDefault(v, 0) + 1);
        }

        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(adjacencyMatrix.getOrDefault(i, new HashMap<>()).getOrDefault(j, 0) + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
