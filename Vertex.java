import java.util.HashMap;
import java.util.Map;

public class Vertex<V> {
    private V data;
    private Map<Vertex<V>, Double> adjacentVertices = new HashMap<>();

    public Vertex(V data){
        this.data = data;
    }

    public void setData(V data){
        this.data = data;
    }
    public V getData(){
        return this.data;
    }

    public void addAdjacentVertex(Vertex<V> destination, double weight){
        adjacentVertices.put(destination, weight);
    }
    public double getEdgeWeight(Vertex<V> destination){
        return adjacentVertices.get(destination);
    }
    public void displayAdjacentVertices(){
        for (Vertex<V> v : adjacentVertices.keySet()){
            System.out.println("Adjacent vertex - "+v+", edge weight = "+getEdgeWeight(v));
        }
    }

}
