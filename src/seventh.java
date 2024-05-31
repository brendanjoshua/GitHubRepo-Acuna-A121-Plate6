import java.util.Scanner;

public class seventh {
    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int vertices = userInput.nextInt();

        System.out.print("Enter number of edges: ");
        int edges = userInput.nextInt();

        int[][] incidenceMatrix = new int[vertices][edges];

        System.out.println("Enter the edges (pairs of vertices) and the number of times each edge appears (u v count):");
        for (int i = 0; i < edges; i++) {
            System.out.print("Enter edge " + (i + 1) + ": ");
            int u = userInput.nextInt();
            int v = userInput.nextInt();
            int count = userInput.nextInt();

            incidenceMatrix[u][i] = count;
            incidenceMatrix[v][i] = count;
        }

        System.out.println("Incidence Matrix:");
        for (int i = 0 ; i < vertices ; i++){
            for (int j = 0 ; j < edges ; j++){
                System.out.print(incidenceMatrix[i][j] + " ");
            }
            System.out.println();
        }

        userInput.close();
    }
}
