
public class UseGraph {

	public static void main(String[] args) {
		Graph myGraph = new Graph(12);
		
		myGraph.makeEdge(0, 1);
		myGraph.makeEdge(0, 2);
		myGraph.makeEdge(2, 3);
		myGraph.makeEdge(2, 4);
		myGraph.makeEdge(3, 5);
		myGraph.makeEdge(3, 6);
		myGraph.makeEdge(4, 5);
		myGraph.makeEdge(5, 7);
		myGraph.makeEdge(5, 8);
		myGraph.makeEdge(6, 8);

		myGraph.makeEdge(9,10);
		myGraph.makeEdge(10,11);


		System.out.println(myGraph.BFS(5));
		System.out.println(myGraph.DFS(5));
	}

}