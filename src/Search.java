import java.util.*;
public class Search<V> {
    private WeightedGraph<V> graph;

    public Search(WeightedGraph<V> graph) {
        this.graph = graph;
    }

    public List<Vertex<V>> BFS(Vertex<V> startVertex) {
        List<Vertex<V>> called = new ArrayList<>();
        Queue<Vertex<V>> queue = new LinkedList<>();
        called.add(startVertex);
        queue.offer(startVertex);
        while (!queue.isEmpty()) {
            Vertex<V> currentVertex = queue.poll();
            List<Vertex<V>> nexts = graph.getAdjacentVertices(currentVertex);
            for (Vertex<V> next : nexts) {
                if (!called.contains(next)) {
                    called.add(next);
                    queue.offer(next);
                }
            }
        }
        return called;
    }
}
