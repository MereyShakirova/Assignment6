public class Search<V> {
    private WeightedGraph<V> graph;
    public Search(WeightedGraph<V> graph){
        this.graph = graph;
    }
    public WeightedGraph<V> getGraph() {
        return graph;
    }
}
