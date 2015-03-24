public class DLListTester {

	public static void main(String[] args) 
	{
		DLList myDL = new DLList();
		myDL.addToBeginning(new DNode(333));
		myDL.addToBeginning(new DNode(111));
		myDL.clear();
		myDL.addToBeginning(new DNode(222));
		myDL.addAfter(222,90);
		myDL.addBefore(90,999);
		myDL.delete(90);
		myDL.addToBeginning(new DNode(9870));
		myDL.addAfter(999,90);
		
		myDL.printList();
		System.out.println("- - - - - - ");
		myDL.printListBackwards();
	}

}
