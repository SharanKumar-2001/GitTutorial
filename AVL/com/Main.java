package AVL.com;

public class Main {

	public static void main(String[] args) {
		AVL_Tree tree=new AVL_Tree();
		
		for(int i=0;i<1000;i++) {
			tree.insert(i);
		}
		
		System.out.println(tree.height());

	}

}
