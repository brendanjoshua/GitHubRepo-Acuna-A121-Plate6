import java.util.*;

public class GraphConnectivity {
    private static Map<Integer, List<Integer>> adjList = new HashMap<>();

    // Function to add an edge to the graph
    public static void addEdge(int u, int v) {
        adjList.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        adjList.computeIfAbsent(v, k -> new ArrayList<>()).add(u); // Since the graph is undirected
    }

    // Function to check if the graph is connected
    public static boolean isConnected() {
        Set<Integer> visited = new HashSet<>();
        if (adjList.isEmpty()) return true; // If no edges, graph is trivially connected

        Queue<Integer> queue = new LinkedList<>();
        int startVertex = adjList.keySet().iterator().next();
        queue.offer(startVertex);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            visited.add(current);
            for (int neighbor : adjList.getOrDefault(current, Collections.emptyList())) {
                if (!visited.contains(neighbor)) {
                    queue.offer(neighbor);
                }
            }
        }
        return visited.size() == adjList.size();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of edges:");
        int edges = scanner.nextInt();

        System.out.println("Enter the edges (u v):");
        for (int i = 0; i < edges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            addEdge(u, v);
        }

        if (isConnected()) {
            System.out.println("The graph is connected.");
        } else {
            int connectedComponents = 0;
            Set<Integer> visited = new HashSet<>();

            for (int vertex : adjList.keySet()) {
                if (!visited.contains(vertex)) {
                    bfs(vertex, visited);
                    connectedComponents++;
                }
            }
            System.out.println("The graph is disconnected.");
            System.out.println("Number of connected components: " + connectedComponents);
        }

        scanner.close();
    }

    // Helper function for BFS traversal
    private static void bfs(int startVertex, Set<Integer> visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startVertex);
        visited.add(startVertex);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor : adjList.getOrDefault(current, Collections.emptyList())) {
                if (!visited.contains(neighbor)) {
                    queue.offer(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }
}
