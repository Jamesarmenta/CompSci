public class Vertex 
{
	private int vNum;
	private String name;
	private VertexMode flag;
	
	public Vertex(int vN, String n)
	{
		vNum = vN;
		name = n;
		flag = VertexMode.UNVISITED;
	}
	
	public void setUnvisited()
	{
		flag = VertexMode.UNVISITED;
	}
	
	public void setVisited()
	{
		flag = VertexMode.VISITED;
	}
	
	public void setWaiting()
	{
		flag = VertexMode.WAITING;
	}	

	public boolean isVisited()
	{
		return flag == VertexMode.VISITED;
	}

	public boolean isUnvisited()
	{
		return flag == VertexMode.UNVISITED;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getVertexNumber()
	{
		return vNum;
	}

}
