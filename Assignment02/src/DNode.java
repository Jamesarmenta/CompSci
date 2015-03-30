public class DNode
{
	public StudentScore data;
	public DNode next;
	public DNode prev;

	public DNode(StudentScore data)
	{
		this.data = data;
		this.next = null;
		this.prev = null;
	}
	
	public DNode(String name, int score)
	{
		this.data = new StudentScore(name, score);
		this.next = null;
		this.prev = null;
	}
}	