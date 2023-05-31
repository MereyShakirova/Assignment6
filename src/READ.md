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

### Search class:
#### *Explanation:*
#### *Here is the solution code:*
![](https://cbgd.ask.fm/fd3/71a30/7839/4756/8b72/0d5fc8e2f2c4/original/421914.jpg)

### BreadthFirstSearch class
#### *Explanation:*
#### *Here is the solution code:*
![](https://cbgd.ask.fm/fd3/71a30/7839/4756/8b72/0d5fc8e2f2c4/original/421914.jpg)

### DijkstraSearch class
#### *Explanation:*
#### *Here is the solution code:*
![](https://cbgd.ask.fm/fd3/71a30/7839/4756/8b72/0d5fc8e2f2c4/original/421914.jpg)
# Thank you for your attention
