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
        distances.put(startVertex, 0.0);
        priorityQueue.offer(startVertex);
        while(!priorityQueue.isEmpty()){
            Vertex<V> currentNode = priorityQueue.poll();
            double currentDistance = distances.get(currentNode);
            for(Map.Entry<Vertex<V>, Double> entry : currentNode.getAdjacentVertices().entrySet()){
                Vertex<V> nextNode = entry.getKey();
                double edgeWeight = entry.getValue();
                double newDistance = currentDistance + edgeWeight;
            }
        }
    }
}