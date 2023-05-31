import org.w3c.dom.ls.LSInput;

import java.util.*;
public class BreadthFirstSearch<V> {
private WeightedGraph<V> graph;
public BreadthFirstSearch(WeightedGraph<V> graph){
    this.graph = graph;
}
public List<Vertex<V>> BFS(Vertex<V> startVertex){
    List<Vertex<V>> called = new ArrayList<>();
    Queue<Vertex<V>> queue = new LinkedList<>();
    called.add(startVertex);
    queue.offer(startVertex);
    while(!queue.isEmpty()){
        Vertex<V> currentNode = queue.poll();
        List<Vertex<V>> nexts = graph.getAdjacentVertices(currentNode);
        for(Vertex<V>)
    }
}
}