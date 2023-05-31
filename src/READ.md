# Assignment 6 for laboratory work for  the Algorithm Data Structure 
![](https://avatars.mds.yandex.net/i?id=6d705f48c59872aa449f4a93da399e56-5658631-images-thumbs&n=13)
### Description:
!(*In this assignment you are asked to implement BFS and Djakstra for Edge-weighted graph with Vertex instead of Edge.
Provide your own implementation for classes:  Vertex, WeightedGraph, Search, BreadthFirstSearch, DijkstraSearch and Main (with example usage).*)!

### ________________________________________

### Vertex class:
#### *Explanation:*
The Vertex class represents a vertex in a graph. It contains a data element of generic type V, which can be any object representing the vertex. It also maintains a map adjacentVertices, where the keys are adjacent vertices and the values are the weights of the edges connecting them.
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

### ________________________________________

### WeightedGraph class:
#### *Explanation:*
The WeightedGraph class represents a weighted graph. It maintains a map map where the keys are the vertices and the values are lists of adjacent vertices. It provides methods to add vertices, add edges between vertices, and retrieve the adjacent vertices of a given vertex. It also provides a method to retrieve all the vertices in the graph.
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

### ________________________________________

### Search class:
#### *Explanation:*
The Search class provides a breadth-first search (BFS) algorithm for a given graph. It takes a WeightedGraph object in its constructor. The bfs method performs a BFS traversal starting from a given start vertex. It returns a list of vertices visited during the traversal.
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

### ________________________________________

### BreadthFirstSearch class
#### *Explanation:*
The BreadthFirstSearch class is an example implementation of the Search class. It uses the BFS algorithm to traverse the graph starting from a given start vertex. The bfs method returns a list of vertices visited during the traversal.
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

### ________________________________________

### DijkstraSearch class
#### *Explanation:*
The BreadthFirstSearch class is an example implementation of the Search class. It uses the BFS algorithm to traverse the graph starting from a given start vertex. The bfs method returns a list of vertices visited during the traversal.
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

### ________________________________________

### Main class:
#### *Explanation:*
The Main class demonstrates the usage of the implemented classes. It creates a WeightedGraph object, adds vertices and edges to the graph, and performs a BFS traversal and Dijkstra's algorithm starting from a specific vertex. The results are printed to the console.
#### *Here is the solution code:*
![](https://cbgd.ask.fm/fd3/71a30/7839/4756/8b72/0d5fc8e2f2c4/original/421914.jpg)

    import java.util.List;
    import java.util.Map;
    
    public class Main{
    public static void main(String[] args){
    WeightedGraph<String> graph = new WeightedGraph<>();
    Vertex<String> vertex1 = new Vertex<>("Mu");
    Vertex<String> vertex2 = new Vertex<>("Sigma");
    Vertex<String> vertex3 = new Vertex<>("Alpha");
    Vertex<String> vertex4 = new Vertex<>("Tau");
    
            graph.addVertex(vertex1);
            graph.addVertex(vertex2);
            graph.addVertex(vertex3);
            graph.addVertex(vertex4);
    
            graph.addEdge(vertex1, vertex2, 3.4);
            graph.addEdge(vertex1, vertex3, 2.5);
            graph.addEdge(vertex2, vertex4, 5.7);
            graph.addEdge(vertex2, vertex3, 8.1);
            graph.addEdge(vertex3, vertex4, 7.8);
            graph.addEdge(vertex4, vertex1, 1.6);
    
            BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>(graph);
            List<Vertex<String>> bfsTraversal = bfs.BFS(vertex1);
            System.out.println("BFS: " + bfsTraversal);
    
            DijkstraSearch<String> dijkstra = new DijkstraSearch<>(graph);
            Map<Vertex<String>, Double> distances =dijkstra.dijkstra(vertex1);
            System.out.println("Dijkstra distances from vertex1: ");
            for(Map.Entry<Vertex<String>, Double> entry : distances.entrySet()){
                System.out.println(entry.getKey().getData() + ": " + entry.getValue());
            }
        }
    }


# Thank you for your attention
