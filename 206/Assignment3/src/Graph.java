public class Graph 
{
	private Vertex vertices[];
	private int vNumToAdd = 0;
	private LinkedList edgeList[];
	private double adjMatrix[][];
	
	/**
	* Creates Graph object based on 
	* number of Vertices provided
	*
	* @param numOfVs
	*/
	public Graph(int numOfVs)
	{
		edgeList = new LinkedList[numOfVs];

		for (int i=0; i<edgeList.length; i++)
		{
			edgeList[i] = new LinkedList();
		}

		vertices = new Vertex[numOfVs];

		for (int i=0; i<numOfVs; i++)
		{
			vertices[i] = new Vertex(i, "" + i);
		}
		
		adjMatrix = new double[numOfVs][numOfVs];
		
		for (int r = 0; r < numOfVs; r++)
		{
			for (int c = 0; c < numOfVs; c++)
			{
				adjMatrix[r][c] = 0;
			}
		}
		
		vertices = new Vertex[numOfVs];
		for (int i=0; i<numOfVs; i++)
		{
			vertices[i] = new Vertex(i, "" + i);
		}
	}
	
	/**
	* Created a vertex in the graph
	* using the provided String name
	*
	* @param name
	*
	*/
	public void addVertex(String name)
	{
		vertices[vNumToAdd] = new Vertex(vNumToAdd, name);
		vNumToAdd++;
	}
	
	/**
	* Creates an undirected edge without weight
	* between two vertices
	*
	* @param vFrom, vTo
	*
	*/
	public void addEdge(int vFrom, int vTo)
	{
		edgeList[vFrom].addToBeginning(new Node(vTo));
		edgeList[vTo].addToBeginning(new Node(vFrom));
	}
	
	/**
	* Creates an directed edge without weight
	* between two vertices
	*
	* @param vFrom, vTo
	*
	*/
	public void addDirectedEdge(int vFrom, int vTo)
	{
		edgeList[vFrom].addToBeginning(new Node(vTo));
	}
	
	/**
	* Creates an undirected edge with weight
	* between two vertices
	*
	* @param vFrom, vTo, weight
	*
	*/
	public void addEdgeWithWeight(int vFrom, int vTo, double weight)
	{
		adjMatrix[vFrom][vTo] = weight;
		adjMatrix[vTo][vFrom] = weight;
	}
	
	/**
	* Creates a directed edge with weight
	* between two vertices
	*
	* @param vFrom, vTo, weight
	*
	*/
	public void addDirectedEdgeWithWeight(int vFrom, int vTo, double weight)
	{
		adjMatrix[vFrom][vTo] = weight;
	}
	
	/**
	* Method to determine the number of Vertices
	* in a graph
	*
	*/
	public int numberOfVs()
	{
		return edgeList.length;
	}
	
	/**
	* Navigates the graph using BFS (breadth-first search)
	* and prints the results
	*
	* @param startV
	*
	*/
	public String BFS(int startV)
	{
		final int UNVISITED = 0;
		final int WAITING = 1;
		final int VISITED = 2;
		
		QueueOfInts theQ = new QueueOfInts();
		String BFSoutput = "";
		int flags[] = new int[numberOfVs()];
		
		// set all v's to unvisited (done already b/c 0 is default for array of ints)
		
		theQ.enqueue(startV);
		flags[startV] = WAITING;

		while (!theQ.isEmpty())
		{
			int myV = theQ.dequeue();
			BFSoutput += vertices[myV].getName() + "(" + myV + "), ";
			flags[myV] = VISITED;
			
			Node tempNode = edgeList[myV].head;
			while (tempNode != null)
			{
				if (flags[tempNode.data] == UNVISITED)
				{
					theQ.enqueue(tempNode.data);
					flags[tempNode.data] = WAITING;
				}
				tempNode = tempNode.next;
			}
		}
		
		
		return BFSoutput;
	}
	
	/**
	* Navigates the graph using DFS (depth-first search)
	* and prints the results
	*
	* @param startV
	*
	*/
	public String DFS(int startV)
	{
		Stack myStack = new Stack();
		String DFSoutput = "";
		
		// set all vertices to UNVISITED
		for (int i=0; i<vertices.length; i++)
		{
			vertices[i].setUnvisited();
		}		
		
		myStack.push(startV);
		DFSoutput += vertices[startV].getName() + "(" + startV + "), ";
		vertices[startV].setVisited();
	
		while (!myStack.isEmpty())
		{
			int vertexNumAtTop = myStack.peek();
			
			// loop through the linked list at vertexNumAtTop in edgeList to find a vertex
			// that's adjacent to vertexNumAtTop (but is also, unvisited)

			Node temp = edgeList[vertexNumAtTop].head;
			while (temp != null && vertices[temp.data].isVisited())
			{
				temp = temp.next;
			}
			// get here I have temp which contains data whose value is a vertex that is adj to vertexNumAtTop
			// and is unvisited OR I have temp==null

			if (temp == null) // means I have no unvisited adj vertices to vertexNumAtTop
			{
				myStack.pop();
			}
			else
			{
				myStack.push(temp.data);
				DFSoutput += vertices[temp.data].getName() + "(" + temp.data + "), ";
				vertices[temp.data].setVisited();
			}
		}

		return DFSoutput;
	}
	
	/**
	* Determines shortest path between a
	* starting vertex and all other reachable 
	* vertices (without weights)
	*
	* @param startV
	*
	*/
	public String shortestPath(int startV)
	{
		String shortestPathOutput = "";
		
		// values represent number of steps from startV to other vertices
		int[] pathLen = new int[vertices.length];
		
		// set all vertices to UNVISITED
		for (int i=0; i<vertices.length; i++)
		{
			vertices[i].setUnvisited();
			pathLen[i] = Integer.MAX_VALUE;
		}
		
		// set pathLen from startV to startV to be 0
		pathLen[startV] = 0;
		
		final int UNVISITED = 0;
		final int WAITING = 1;
		final int VISITED = 2;
		
		QueueOfInts theQ = new QueueOfInts();
		int flags[] = new int[numberOfVs()];
		
		
		theQ.enqueue(startV);
		flags[startV] = WAITING;
		

		while (!theQ.isEmpty())
		{
			int myV = theQ.dequeue();
			shortestPathOutput += vertices[startV].getName() + " to " + vertices[myV].getName() + " path length = " + pathLen[myV] + "\n";
			flags[myV] = VISITED;
			
			Node tempNode = edgeList[myV].head;
			while (tempNode != null)
			{
				if (flags[tempNode.data] == UNVISITED)
				{
					pathLen[tempNode.data] = pathLen[myV]+1;
					theQ.enqueue(tempNode.data);
					flags[tempNode.data] = WAITING;
				}
				tempNode = tempNode.next;
			}
		}
		
		
		
		return shortestPathOutput;
	}
	
	/**
	* Based on a starting vertices, Dijkstras finds 
	* the shortest path (using weights) to all 
	* reachable vertices in the graph
	*
	* @param startV 
	*
	*/
	public String Dijkstras(int startV)
	{
		String dijkstrasOutput = "";
		
		// values represent path length from startV to other vertices
		int[] pathLen = new int[vertices.length];
		
		// create PriorityQueue
		PriorityQueue pQueue = new PriorityQueue(10000);
		
		// set all vertices to UNVISITED
		for (int i=0; i<vertices.length; i++)
		{
			vertices[i].setUnvisited();
			pathLen[i] = Integer.MAX_VALUE;
		}
		
		// set pathLen from startV to startV to be 0
		pathLen[startV] = 0;
		
		// add (item=startV, priority=0) to PQ
		pQueue.enqueue(startV, 0);
		
		while(!pQueue.isEmpty())
		{
			int v = pQueue.dequeue();
			if (vertices[v].isUnvisited())
			{
				vertices[v].setVisited();
				dijkstrasOutput += "Minimum weight path from " +  vertices[startV].getName() + " to " + vertices[v].getName() + " is " + pathLen[v] + "\n";
				
				for(int adjV = 0; adjV <vertices.length; adjV++)
				{
					double weight = adjMatrix[v][adjV];
					if(weight > 0)
					{
						if(pathLen[adjV] > (weight + pathLen[v]))
						{
							pathLen[adjV] = (int)(weight + pathLen[v]);
							pQueue.enqueue(adjV, pathLen[adjV]);
						}
					}
				}
			}
			
		}
		return dijkstrasOutput;
	}
}
