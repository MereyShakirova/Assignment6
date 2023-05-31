import java.util.List;
import java.util.Map;

public class Main{
    public static void main(String[] args){
        WeightedGraph<String> graph = new WeightedGraph<>();
        Vertex<String> vertex1 = new Vertex<>("Mu");
        Vertex<String> vertex2 = new Vertex<>("Sigma");
        Vertex<String> vertex3 = new Vertex<>("Alpha");
        Vertex<String> vertex4 = new Vertex<>("Tau");

        graph.addVertex(vertex1);
        graph.addVertex(vertex2);
        graph.addVertex(vertex3);
        graph.addVertex(vertex4);

        graph.addEdge(vertex1, vertex2, 3.4);
        graph.addEdge(vertex1, vertex3, 2.5);
        graph.addEdge(vertex2, vertex4, 5.7);
        graph.addEdge(vertex2, vertex3, 8.1);
        graph.addEdge(vertex3, vertex4, 7.8);
        graph.addEdge(vertex4, vertex1, 1.6);

        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>(graph);
        List<Vertex<String>> bfsTraversal = bfs.BFS(vertex1);
        System.out.println("BFS: " + bfsTraversal);

        DijkstraSearch<String> dijkstra = new DijkstraSearch<>(graph);
        Map<Vertex<String>, Double> distances =dijkstra.dijkstra(vertex1);
        System.out.println("Dijkstra distances from vertex1: ");
        for(Map.Entry<Vertex<String>, Double> entry : distances.entrySet()){
            System.out.println(entry.getKey().getData() + ": " + entry.getValue());
        }
    }
}

