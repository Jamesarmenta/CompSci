
public class SelectionSortCode {
	
	public static void selectionSort(Comparable list[]){
		int indexToSwap = list.length - 1;
		for (int pass=0; pass < list.length-1; pass++){
			int max = 0;
			for (int i = 1; i < list.length - pass; i++){
				if (list[i].compareTo(list[max]) > 0){
					max = i;
				}
			}
		
			Comparable temp = list[max];
			list[max] =  list[indexToSwap];
			list[indexToSwap] = temp;
			indexToSwap--;
		}
	}
	
	public static void displayList(Object list[]){
		for (int i=0; i<list.length; i++){
			System.out.println(list[i].toString());
		}
	}
	
	public static void main(String[] args) {

		StudentScore studentList[] = new StudentScore[10];
		
		studentList[0] = new StudentScore("Bob", 51);
		studentList[1] = new StudentScore("Bill", 92);
		studentList[2] = new StudentScore("Tim", 74);
		studentList[3] = new StudentScore("Jon", 100);
		studentList[4] = new StudentScore("Kim", 100);
		studentList[5] = new StudentScore("Nicki", 40);
		studentList[6] = new StudentScore("Zeus", 60);
		studentList[7] = new StudentScore("Jessica", 98);
		studentList[8] = new StudentScore("Holly", 79);
		studentList[9] = new StudentScore("Cortana", 90);

		System.out.println("Original list:");
		displayList(studentList);
		selectionSort(studentList);
		System.out.println();
		System.out.println("Sorted list:");
		displayList(studentList);

	}

}