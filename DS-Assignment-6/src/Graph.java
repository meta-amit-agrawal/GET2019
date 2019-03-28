import java.util.List;

public interface Graph {

    /**
     * Method used to find if a graph is connected i.e., all nodes are
     * reachable, or not
     */
    public boolean isConnected();

    /**
     * Method to find list of all nodes that are reachable from the given source
     * node
     */
    public List<Integer> getReachableVerttices(int source);

    /**
     * Method to find minimum spanning tree of a graph
     */
    public int[] getMST();

    /**
     * Method to find the shortest path between the source and the destination
     */
    public int getShortestPath(int source, int destiination);

}