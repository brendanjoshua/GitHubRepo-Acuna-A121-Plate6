import java.util.*;

public class fifth {

    public static boolean isBipartite(int n, List<int[]> edges) {
        int[] colors = new int[n];
        Arrays.fill(colors, -1); // -1 means uncolored

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        for (int i = 0; i < n; i++) {
            if (colors[i] == -1) { // Not colored yet
                if (!bfsCheck(graph, i, colors)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean bfsCheck(Map<Integer, List<Integer>> graph, int start, int[] colors) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        colors[start] = 0; // Start coloring with color 0

        while (!queue.isEmpty()) {
            int node = queue.poll();
            int currentColor = colors[node];
            int nextColor = 1 - currentColor; // Alternate color

            List<Integer> neighbors = graph.getOrDefault(node, new ArrayList<>());
            for (int neighbor : neighbors) {
                if (colors[neighbor] == -1) {
                    colors[neighbor] = nextColor;
                    queue.add(neighbor);
                } else if (colors[neighbor] == currentColor) {
                    return false; // Found same color neighbor
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of vertices:");
        int n = scanner.nextInt();

        System.out.println("Enter the number of edges:");
        int m = scanner.nextInt();

        List<int[]> edges = new ArrayList<>();
        System.out.println("Enter the edges (pairs of vertices):");
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            edges.add(new int[]{u, v});
        }

        if (isBipartite(n, edges)) {
            System.out.println("The graph is bipartite.");
        } else {
            System.out.println("The graph is not bipartite.");
        }

        scanner.close();
    }
}
