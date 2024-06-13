package Tree;
import java.util.*;

import javax.swing.tree.TreeNode;
public class TakeInputlevelwise2 {
	
	public static TreeNode<Integer> takeInput(){
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter root data");
		int rootData = s.nextInt();
		queueusingLL<TreeNode<Integer>> pendingnodes = new queueusingLL<>();
		TreeNode<Integer> root = new TreeNode<Integer>(rootData);
		pendingnodes.enqueue(root);
		while(!pendingnodes.isEmpty()) {
			try {
				TreeNode<Integer> frontNode = pendingnodes.dequeue();
				System.out.println("Enter num of children of " + frontNode.data);
				int numchildren = s.nextInt();
				for(int i=0; i< numchildren;i++) {
					System.out.println("Enter" + (i+1) + "th child of" + frontNode.data);
					int child = s.nextInt();
					TreeNode<Integer> childNode = new TreeNode<Integer>(child);
					frontNode.children.add(childNode);
					pendingnodes.enqueue(childNode);
				}
			}
			catch(queueemptyexception e){
				return null;
			}
		}
		return root;
	}
	
	public static int noofnodes(TreeNode<Integer>root) {
		if(root == null) {
			return 0;
		}
		int count = 1;
		for(int i=0;i<root.children.size();i++) {
			count += noofnodes(root.children.get(i)); 
		}
		return count;
	}

	public static int leafnode(TreeNode<Integer>root) {
		if(root == null) {
			return 0;
		}
		if(root.children.size()==0) {
			return 1;
		}
		int leafcount = 0;
		for(int i=0;i<root.children.size();i++) {
			leafcount+=leafnode(root.children.get(i));
		}
		return leafcount;
	}
	
	public static void printpreorder(TreeNode<Integer>root) {
		if(root == null) {
			return  ;
		}
		System.out.println(root.data+" ");
		for(int i=0;i<root.children.size();i++) {
			printpreorder(root.children.get(i));
		}
		
	}
	
	public static void printpostorder(TreeNode<Integer>root) {
		if(root == null) {
			return ;
		}
		for(int i=0;i<root.children.size();i++) {
			   printpostorder(root.children.get(i));
		}
		System.out.println(root.data);
	}
	
	public static void print(TreeNode<Integer>root) {
		String s = root.data+":";
		for(int i=0;i<root.children.size();i++) {
			s = s + root.children.get(i).data + ",";
		}
		System.out.println(s);
		for(int i = 0;i<root.children.size();i++) {
			print(root.children.get(i));
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode<Integer> root = takeInput();
		print(root);
		int ans = noofnodes(root);
		System.out.println(ans);
	}

}
