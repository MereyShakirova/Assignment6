import java.util.*;
public class WeightedGraph<V>{
    private Map<Vertex<V>, List<Vertex<V>>> map;
    private WeightedGraph(){
        this.map = new HashMap<>();
    }
    public void addVertex(Vertex<V> vertex){
        map.put(vertex, new ArrayList<>());
    }

}