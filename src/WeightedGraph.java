import java.util.*;
public class WeightedGraph<V>{
    private Map<Vertex<V>, List<Vertex<V>>> map;
    private WeightedGraph(){
        this.map = new HashMap<>();
    }
    public void addVertex(Vertex<V> vertex){
        map.put(vertex, new ArrayList<>());
    }
public void addEdge(Vertex<V> source, Vertex<V> destination, double weight) {
    if (map.containsKey(source) && map.containsKey(destination)) {
        source.addAdjacentVertex(destination, weight);
        map.get(source).add(destination);
    } else {
        throw new IllegalArgumentException("Vertex not located in this graph.");
    }

}
public List<Vertex<V>> getAdjacentVertices(Vertex<V> vertex) {
    if (map.containsKey(vertex)) {
        return map.get(vertex);
    } else {
        throw new IllegalArgumentException("Vertex not located in this graph.");
    }
}

public Set<Vertex<V>> getVertices(){
            return map.keySet();
    }

}