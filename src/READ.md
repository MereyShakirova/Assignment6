# **Assignment 6 for laboratory work for  the Algorithm Data Structure **
![](https://avatars.mds.yandex.net/i?id=6d705f48c59872aa449f4a93da399e56-5658631-images-thumbs&n=13)
### Description:
!(*In this assignment you are asked to implement BFS and Djakstra for Edge-weighted graph with Vertex instead of Edge.
Provide your own implementation for classes:  Vertex, WeightedGraph, Search, BreadthFirstSearch, DijkstraSearch and Main (with example usage).*)!

### Vertex class:
#### *Explanation:*
#### *Here is the solution code:*
![](https://cbgd.ask.fm/fd3/71a30/7839/4756/8b72/0d5fc8e2f2c4/original/421914.jpg)

    import java.util.*;
    public class Vertex<V> {
        private V data;
        private Map<Vertex<V>, Double> adjacentVertices;
        public Vertex(V data) {
        this.data = data;
        this.adjacentVertices = new HashMap<>();
        }
        public V getData() {
        return data;
        }
        public void addAdjacentVertex(Vertex<V> destination, double weight) {
        adjacentVertices.put(destination, weight);
        }
        public Map<Vertex<V>, Double> getAdjacentVertices() {
        return adjacentVertices;
        }
    }

### WeightedGraph class:
#### *Explanation:*
#### *Here is the solution code:*
![](https://cbgd.ask.fm/fd3/71a30/7839/4756/8b72/0d5fc8e2f2c4/original/421914.jpg)

    import java.util.*;
    public class WeightedGraph<V>{
        private Map<Vertex<V>, List<Vertex<V>>> map;
        WeightedGraph(){
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

### Search class:
#### *Explanation:*
#### *Here is the solution code:*
![](https://cbgd.ask.fm/fd3/71a30/7839/4756/8b72/0d5fc8e2f2c4/original/421914.jpg)

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

### BreadthFirstSearch class
#### *Explanation:*
#### *Here is the solution code:*
![](https://cbgd.ask.fm/fd3/71a30/7839/4756/8b72/0d5fc8e2f2c4/original/421914.jpg)

    import java.util.*;
    public class BreadthFirstSearch<V> {
    private WeightedGraph<V> graph;
    
        public BreadthFirstSearch(WeightedGraph<V> graph) {
            this.graph = graph;
        }
    
        public List<Vertex<V>> BFS(Vertex<V> startVertex) {
            List<Vertex<V>> called = new ArrayList<>();
            Queue<Vertex<V>> queue = new LinkedList<>();
    
            called.add(startVertex);
            queue.offer(startVertex);
    
            while (!queue.isEmpty()) {
                Vertex<V> currentNode = queue.poll();
                List<Vertex<V>> nexts = graph.getAdjacentVertices(currentNode);
    
                for (Vertex<V> nextNode : nexts) {
                    if (!called.contains(nextNode)) {
                        called.add(nextNode);
                        queue.offer(nextNode);
                    }
                }
            }
            return called;
        }
    }


### DijkstraSearch class
#### *Explanation:*
#### *Here is the solution code:*
![](https://cbgd.ask.fm/fd3/71a30/7839/4756/8b72/0d5fc8e2f2c4/original/421914.jpg)

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
                    if(newDistance < distances.get(nextNode)){
                        priorityQueue.remove(nextNode);
                        distances.put(nextNode, newDistance);
                        priorityQueue.offer(nextNode);
                    }
                }
            }
            return distances;
        }
    }

# Thank you for your attention
