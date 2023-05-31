import java.util.*;
public class DijkstraSearch<V> {
    private WeightedGraph<V> graph;
    public DijkstraSearch(WeightedGraph<V> graph){
        this.graph = graph;
    }
    public Map<Vertex<V>, Double> dijkstra(Vertex<V> startVertex){
        Map<Vertex<V>, Double> distances = new HashMap<>();
        PriorityQueue<Vertex<V>> priorityQueue = new PriorityQueue<>(Comparator.comparingDouble(distances::get));
        for(Vertex<V> vertex : graph.getVertices()){
            distances.put(vertex, Double.MAX_VALUE);
        }

    }
}