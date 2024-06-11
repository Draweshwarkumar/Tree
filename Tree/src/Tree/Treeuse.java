package Tree;
import java.util.*;
public class Treeuse {
	
	public static TreeNode<Integer> takeInput(Scanner s){
	int n;
	System.out.println("Enter next node data");
	n = s.nextInt();
	TreeNode<Integer> root = new TreeNode<Integer>(n);
	System.out.println("Enter no of children for " + n);
	int childcount = s.nextInt();
	for(int i = 0; i < childcount;i++) {
		TreeNode<Integer> child = takeInput( s);
		root.children.add(child);
		
	}
	return root;
	}
	
	public static void print(TreeNode<Integer>root) {
		String s = root.data + ":";
		for(int i = 0; i < root.children.size();i++) {
			s = s + root.children.get(i).data + ",";
		}
		System.out.println(s);
		for(int i = 0; i < root.children.size();i++) {
			print(root.children.get(i));
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		TreeNode<Integer> root = new TreeNode<Integer>(4);
//		TreeNode<Integer> node1 = new TreeNode<Integer>(3);
//		TreeNode<Integer> node2 = new TreeNode<Integer>(5);
//		TreeNode<Integer> node3 = new TreeNode<Integer>(6);
//		TreeNode<Integer> node4 = new TreeNode<Integer>(7);
//		root.children.add(node1);
//		root.children.add(node2);
//		root.children.add(node3);
//		node3.children.add(node4);
//		
//		System.out.print(root);
		Scanner s = new Scanner(System.in);
		TreeNode<Integer> root = takeInput(s);
		print(root);
	

	}

}
 