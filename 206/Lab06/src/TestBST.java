
public class TestBST {

	public static void main(String[] args) {
		
		BSTree myBST = new BSTree();
		myBST.insert(9);
		
		if(myBST.contains(10))
		{
			System.out.println("Yup!!");
		}
		
		myBST.insert(10);
		
		if(myBST.contains(10))
		{
			System.out.println("Yup!!");
		}
	}

}
