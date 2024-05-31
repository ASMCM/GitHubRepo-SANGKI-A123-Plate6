import java.util.*;

public class Graph {
	private Map<Integer, List<Integer>> adjList;
	
	public Graph() {
        adjList = new HashMap<>();
    }

	public void addVertex(int vertex) {
        adjList.putIfAbsent(vertex, new ArrayList<>());
    }
	
	public void addEdge(int source_Sangki, int destination_Sangki) {
        adjList.get(source_Sangki).add(destination_Sangki);
        adjList.get(destination_Sangki).add(source_Sangki); // Assuming undirected graph
    }
	
	public int numberOfConnectedComponents() {
		int count = 0;
		for (int vertex = 0; vertex < adjList.size(); vertex++) {
			if (!isConnectedFromVertex(vertex)) {
				count++;
			}
		}
		return count;
	}
	
	public boolean isConnectedFromVertex(int startVertex) {
		Set<Integer> visited = new HashSet<>();
		Queue<Integer> queue = new LinkedList<>();

		queue.add(startVertex);
		visited.add(startVertex);

		while (!queue.isEmpty()) {
			int currentVertex = queue.poll();
			for (int neighbor : adjList.getOrDefault(currentVertex, Collections.emptyList())) {
				if (!visited.contains(neighbor)) {
					queue.add(neighbor);
					visited.add(neighbor);
				}
			}
		}

		return visited.size() == adjList.size();
	}
}