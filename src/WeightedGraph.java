import java.util.*;
public class WeightedGraph<V> {
    private Map<Vertex<V>, List<Vertex<V>>> map;
    public WeightedGraph(){
        map = new HashMap<>();
    }
    public void addVertex(Vertex<V> vertex){
        map.put(vertex, new ArrayList<>());
    }
    public void addEdge(Vertex<V> source, Vertex<V> destination, double weight) {
        source.addAdjacentVertex(destination, weight);
        destination.addAdjacentVertex(source, weight);
        map.get(source).add(destination);
        map.get(destination).add(source);
    }
    public List<Vertex<V>> takeAdjacentVertices(Vertex<V> vertex){
        return map.get(vertex);
    }
}
