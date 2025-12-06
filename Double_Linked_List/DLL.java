package Double_Linked_List;

public class DLL {

	Node head;
	int size;

	public void InsertAtFirst(int value) {
		Node node = new Node(value);
		node.next = head;
		node.previous = null;
		if (head != null) {
			head.previous = node;
		}
		head = node;
		size++;

	}

	public void insertAtLast(int value) {
		Node node = new Node(value);
		node.next = null;

		if (head == null) {
			node.previous = null;
			head = node;
			return;
		}
		Node last = head;

		while (last.next != null) {
			last = last.next;
		}
		last.next = node;
		node.previous = last;
		size++;
	}

	public void InsertAtAfter(int value, int after) {

		Node p = find(after);

		if (p == null) {
			System.out.println("Does not exist");
			return;
		}

		Node node = new Node(value);
		node.next = p.next;
		p.next = node;
		node.previous = p;
		if (node.next != null) {
			node.next.previous = node;
		}

		size++;
	}



	// it is used to find the node
	public Node find(int value) {
		Node node = head;
		while (node != null) {
			if (node.value == value) {
				return node;
			}
			node = node.next;
		}
		return null;

	}
	
	public int deleteAtFirst() {
		
		if(head==null) {
			System.out.println("list is under flow");
			return -1;
		}
		
		int val=head.value;
		head=head.next;
//		head.previous=null;
		System.out.print("The removed item is: "+val);
		size--;
		return val;
		
		
	}
	
	public int deleteAtLast(){
		Node node=head;
		while(node.next.next!=null) {
			node=node.next;
		}
		int value=node.next.value;
		node.next=null;
		
		size--;
		System.out.print("The removed item is: "+value);
		return value;

	}
	
	public int deleteAtIndex(int index){
		Node node=head;
		for(int i=0;i<index-1;i++) {
			node=node.next;
		}
		int val=node.value;
		node=node.previous;
		node.next=node.next.next;
		
		size--;
		System.out.println("The removed item is: "+val);
		return val;
		
		
	}

	public int size() {
		return size;
	}

	public class Node {
		int value;
		Node next;
		Node previous;

		// constructors
		public Node(int value, Node next, Node previous) {
			this.value = value;
			this.next = next;
			this.previous = previous;
		}

		public Node(int value) {
			this.value = value;
		}

		public Node(int value, Node next) {

			this.value = value;
			this.next = next;
		}

	}

	public void dispaly() {
		Node node = head;
		while (node != null) {
			System.out.print(node.value + " ");
			node = node.next;
		}
		System.out.println();

	}

	public void PrintReverse() {
		Node n = head;
		Node last = null;
		while (n != null) {
			last = n;
			n = n.next;
		}
		System.out.println("Printing In reverse");
		while (last != null) {
			System.out.print(last.value + "-> ");
			last = last.previous;
		}
		System.out.println("START");
	}

}
