import java.util.*;

public class eight {
    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);

        System.out.print("Enter number of vertices for Graph 1: ");
        int graph1Vert = userInput.nextInt();
        int[][] graph1 = new int[graph1Vert][graph1Vert];

        System.out.print("Enter number of edges for Graph 1: ");
        int graph1Edge = userInput.nextInt();

        System.out.println("Enter edges for Graph 1 ");
        for (int i = 0 ; i < graph1Edge ; i++){
            System.out.print("Enter edge "+ (i+1)+ " : ");
            int u = userInput.nextInt() - 1;
            int v = userInput.nextInt() - 1;

            graph1[u][v] = 1;
            graph1[v][u] = 1;
        }

        System.out.print("Enter number of vertices for Graph 2: ");
        int graph2Vert = userInput.nextInt();
        int[][] graph2 = new int[graph1Vert][graph1Vert];

        System.out.print("Enter number of edges for Graph 2: ");
        int graph2Edge = userInput.nextInt();

        System.out.println("Enter edges for Graph 2 ");
        for (int i = 0 ; i < graph2Edge ; i++){
            System.out.print("Enter edge "+ (i+1)+ " : ");
            int u = userInput.nextInt() - 1;
            int v = userInput.nextInt() - 1;

            graph2[u][v] = 1;
            graph2[v][u] = 1;
        }

        if (Isomorphic(graph1, graph2)){
            System.out.println("Graphs are isomorphic");
        } else {
            System.out.println("Graphs are not isomorphic");
        }

    }

    public static boolean Isomorphic(int[][] graph1, int[][] graph2){
        if (graph1.length != graph2.length) {
            return false;
        }

        int[] graph1Degree = degreeSet(graph1);
        int[] graph2Degree = degreeSet(graph2);

        Arrays.sort(graph1Degree);
        Arrays.sort(graph2Degree);

        return Arrays.equals(graph1Degree,graph2Degree);
    }

    private static int[] degreeSet(int graph[][]){
        int length = graph.length;
        int[] sequence = new int[length];

        for(int i = 0 ; i < length ; i++){
            int degree = 0;
            for (int j = 0 ; j < length ; j++){
                if (graph[i][j] == 1){
                    degree++;
                }
            }
            sequence[i] = degree;
        }
        return sequence;
    }
}