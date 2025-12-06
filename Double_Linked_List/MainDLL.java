package Double_Linked_List;

public class MainDLL {

	public static void main(String[] args) {
		DLL dlist=new DLL();
		
		dlist.InsertAtFirst(10);
		dlist.InsertAtFirst(20);
		dlist.InsertAtFirst(30);
		dlist.InsertAtFirst(40);
		dlist.InsertAtFirst(50);
		
		dlist.dispaly();
		
		dlist.deleteAtIndex(2);
		dlist.dispaly();
		
	
		
		System.out.println(dlist.size());


		
		

	}

}
