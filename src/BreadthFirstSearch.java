import java.util.*;
import java.util.Arrays;
public class BreadthFirstSearch<V> extends Search<V> {
    private Set<Vertex<V>> visited;
    public BreadthFirstSearch(WeightedGraph<V> graph){
        super(graph);
        visited = new HashSet<>();
    }
    public void BFS(Vertex<V> startVertex){
        Queque<Vertex<V>> queque = new LinkedList<>();
        queque.offer(startVertex);
        visited.add(startVertex);
        while(!queque.isEmpty()){
            Vertex<V> currentVertex = queque.poll();
        }
    }
}
