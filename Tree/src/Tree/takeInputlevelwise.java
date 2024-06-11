package Tree;
import java.util.*;
public class takeInputlevelwise {
	
	public static TreeNode<Integer> takeInput(){
		Scanner s = new Scanner(System.in);
		System.out.println("Enter root data");
		int rootData = s.nextInt();
		queueusingLL<TreeNode<Integer>> pendingNodes = new queueusingLL<>();
		TreeNode<Integer> root = new TreeNode<Integer>(rootData);
		pendingNodes.enqueue(root);
		while(!pendingNodes.isEmpty()) {
			try {
				TreeNode<Integer> frontNode = pendingNodes.dequeue();
				System.out.println("Enter num of children of" + frontNode.data);
				int numchildren = s.nextInt();
				for(int i=0; i < numchildren;i++) {
					System.out.println("Enter" + (i+1) + "th child of " + frontNode.data);
					int child = s.nextInt();
					TreeNode<Integer> childNode = new TreeNode<Integer>(child);
					frontNode.children.add(childNode);
					pendingNodes.enqueue(childNode);
				}
			}
			catch(queueemptyexception e) {
				//shouldn't come here
				return null;
			}
		}
		return root;
	}
	
	public static void print(TreeNode<Integer>root) {
		String s = root.data+":";
		for(int i=0; i< root.children.size();i++) {
			s = s + root.children.get(i).data + ",";
		}
		System.out.println(s);
		for(int i = 0; i< root.children.size();i++) {
			print(root.children.get(i));
		}
	}
	
	public static void main(String[]args) {
	TreeNode<Integer> root = takeInput();
	print(root);
	}

}
