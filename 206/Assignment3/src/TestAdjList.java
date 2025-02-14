public class TestAdjList {

	public static void main(String[] args) 
	{
		Graph g = new Graph(7);
		g.addVertex("Los Angeles, CA");
		g.addVertex("Portland, OR");
		g.addVertex("Denver, CO");
		g.addVertex("Austin, TX");
		g.addVertex("Chicago, IL");
		g.addVertex("NYC, NY");
		g.addVertex("Charleston, SC");
		
		
		g.addEdgeWithWeight(0,1,965);//LA to PDX
		g.addEdgeWithWeight(0,2,1022);//LA to DNV
		g.addEdgeWithWeight(0,3,1378);//LA to AX
		g.addEdgeWithWeight(1,2,1241);//PDX to DNV
		g.addEdgeWithWeight(2,4,1004);//DNV to CHI
		g.addEdgeWithWeight(2,3,921);//DNV to AX
		g.addEdgeWithWeight(3,6,1236);//AX to CHL
		g.addEdgeWithWeight(4,5,789);//CHI to NYC
		g.addEdgeWithWeight(5,6,759);//NYC to CHL
		
		String output = g.Dijkstras(5);
		System.out.println("Dijkstra's algorithm starting at NYC");
		System.out.println(output);
		
		
		/*
		Graph g = new Graph(10);
		g.addVertex("Zero");
		g.addVertex("One");
		g.addVertex("Two");
		g.addVertex("Three");
		g.addVertex("Four");
		g.addVertex("Five");
		g.addVertex("Six");
		g.addVertex("Seven");
		g.addVertex("Eight");
		g.addVertex("Nine");

		g.addEdge(0,1);
		g.addEdge(0,3);
		g.addEdge(0,6);
		g.addEdge(0,7);
		g.addEdge(1,6);
		g.addEdge(1,5);
		g.addEdge(1,2);
		g.addEdge(2,3);
		g.addEdge(2,8);
		g.addEdge(2,4);
		g.addEdge(4,9);
		g.addEdge(8,9);
		
		String output = g.BFS(3);
		System.out.println("BFS starting at 3");
		System.out.println(output);
		System.out.println("");

		output = g.DFS(3);
		System.out.println("DFS starting at 3");
		System.out.println(output);
		System.out.println("");
		
		output = g.shortestPath(3);
		System.out.println("Shortest paths starting at 3");
		System.out.println(output);

		Graph g2 = new Graph(10);
		g2.addVertex("Zero");
		g2.addVertex("One");
		g2.addVertex("Two");
		g2.addVertex("Three");
		g2.addVertex("Four");
		g2.addVertex("Five");
		g2.addVertex("Six");
		g2.addVertex("Seven");
		g2.addVertex("Eight");
		g2.addVertex("Nine");

		g2.addDirectedEdgeWithWeight(0,1,5);
		g2.addDirectedEdgeWithWeight(0,3,7);
		g2.addDirectedEdgeWithWeight(0,6,9);
		g2.addDirectedEdgeWithWeight(0,7,6);
		g2.addDirectedEdgeWithWeight(1,6,3);
		g2.addDirectedEdgeWithWeight(1,5,9);
		g2.addDirectedEdgeWithWeight(1,2,2);
		g2.addDirectedEdgeWithWeight(2,5,6);
		g2.addDirectedEdgeWithWeight(2,8,7);
		g2.addDirectedEdgeWithWeight(2,4,9);
		g2.addDirectedEdgeWithWeight(3,5,6);
		g2.addDirectedEdgeWithWeight(4,9,3);
		g2.addDirectedEdgeWithWeight(8,9,3);

		output = g2.Dijkstras(0);
		System.out.println("Dijkstra's algorithm starting at 0");
		System.out.println(output);

		 */
	}

}
