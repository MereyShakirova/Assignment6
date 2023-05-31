import java.util.*;
public class Search<V>{
    private WeightedGraph<V> graph;
    public Search(WeightedGraph<V> graph){
        this.graph = graph;
    }
    public List<Vertex<V>> BFS(Vertex<V> startVertex){
        List<Vertex<V>> visited = new ArrayList<>();
        Queue<Vertex<V>> queue = new LinkedList<>();
        visited.add(startVertex);
        queue.offer(startVertex);
        while(!queue.isEmpty()){
            Vertex<V> currentVertex = queue.poll();
            List<Vertex<V>> neighbors = graph.getAdjacentVertices(currentVertex);
            for(Vertex<V> neighbor : neighbors){
                if(!visited.contains(neighbor)){
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
    }
}
