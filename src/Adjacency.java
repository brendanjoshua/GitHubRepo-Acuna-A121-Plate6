import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Adjacency {

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

        Map<String, Integer> edgeCount = new HashMap<>();

        System.out.println("Edges and their counts:");
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (adjacencyMatrix[i][j] > 0) {
                    String edge = "(" + i + ", " + j + ")";
                    edgeCount.put(edge, edgeCount.getOrDefault(edge, 0) + adjacencyMatrix[i][j]);
                    System.out.println(edge + ": " + adjacencyMatrix[i][j]);
                }
            }
        }

        System.out.println("\nSummary of edge counts:");
        for (Map.Entry<String, Integer> entry : edgeCount.entrySet()) {
            System.out.println(entry.getKey() + " appears " + entry.getValue() + " times");
        }

        scanner.close();
    }
}
