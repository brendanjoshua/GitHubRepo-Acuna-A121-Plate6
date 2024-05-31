import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class four {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of vertices:");
        int n = scanner.nextInt();

        System.out.println("Enter the number of edges:");
        int m = scanner.nextInt();

        Map<Integer, Integer> degreeMap = new HashMap<>();

        System.out.println("Enter the edges (pairs of vertices):");
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();

            degreeMap.put(u, degreeMap.getOrDefault(u, 0) + 1);
            degreeMap.put(v, degreeMap.getOrDefault(v, 0) + 1);
        }

        System.out.println("Degree of each vertex:");
        for (int i = 0; i < n; i++) {
            System.out.println("Vertex " + i + ": " + degreeMap.getOrDefault(i, 0));
        }

        scanner.close();
    }
}
