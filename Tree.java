Binary Tree:
Base Code:-
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTreeHeight {
    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = getHeight(root.left);
            int rightHeight = getHeight(root.right);

            // Return the maximum of left and right subtree heights, plus 1 for the current level
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public static void main(String[] args) {
        BinaryTreeHeight treeHeightFinder = new BinaryTreeHeight();

        // Example tree:
        //        1
        //       / \
        //      2   3
        //     / \
        //    4   5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        int height = treeHeightFinder.getHeight(root);
        System.out.println("Height of the binary tree: " + height);
    }
}

=========================================================================================================================
1. Tree Traversals
Time Complexity: O(N)
Auxiliary Space: If we don’t consider the size of the stack for function calls then O(1) otherwise O(h) where h is the height of the tree.
1- Inorder Traversal:
	Algorithm Inorder(tree)
		-Traverse the left subtree, i.e., call Inorder(left->subtree)
		-Visit the root.
		-Traverse the right subtree, i.e., call Inorder(right->subtree)
	Note: In the case of binary search trees (BST), Inorder traversal gives nodes in non-decreasing(sorted) order. 
	Code:
		// Given a binary tree, print its nodes in inorder
		void printInorder(Node node)
		{
			if (node == null)
				return;
	 
			// First recur on left child
			printInorder(node.left);
	 
			// Then print the data of node
			System.out.print(node.key + " ");
	 
			// Now recur on right child
			printInorder(node.right);
		}
		
2- Preorder Traversal:
	Algorithm Preorder(tree)
		-Visit the root.
		-Traverse the left subtree, i.e., call Preorder(left->subtree)
		-Traverse the right subtree, i.e., call Preorder(right->subtree) 
	Note: Preorder traversal is used to create a copy of the tree. Preorder traversal is also used to get prefix expressions on an expression tree.
	Code:
		// Given a binary tree, print its nodes in preorder
		void printPreorder(Node node)
		{
			if (node == null)
				return;
	 
			// First print data of node
			System.out.print(node.key + " ");
	 
			// Then recur on left subtree
			printPreorder(node.left);
	 
			// Now recur on right subtree
			printPreorder(node.right);
		}
		
3- PostOrder Traversal:
	Algorithm Preorder(tree)
		-Traverse the left subtree, i.e., call Postorder(left->subtree)
		-Traverse the right subtree, i.e., call Postorder(right->subtree)
		-Visit the root
	Note: Postorder traversal is used to delete the tree. Postorder traversal is also useful to get the postfix expression of an expression tree.
	Code:
		// Given a binary tree, print its nodes according to the "bottom-up" postorder traversal.
		void printPostorder(Node node)
		{
			if (node == null)
				return;
	 
			// First recur on left subtree
			printPostorder(node.left);
	 
			// Then recur on right subtree
			printPostorder(node.right);
	 
			// Now deal with the node
			System.out.print(node.key + " ");
		}
		
=========================================================================================================================
2. Find the Maximum Depth or Height of given Binary Tree
Time Complexity: O(N)
Auxiliary Space: O(N)
max_depth = max(max dept of left subtree,  max depth of right subtree) + 1  
link: https://www.geeksforgeeks.org/find-the-maximum-depth-or-height-of-a-tree/
Code:
	Method-1: Recursive approach
	public int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			int leftHeight = getHeight(root.left);
			int rightHeight = getHeight(root.right);

			// Return the maximum of left and right subtree heights, plus 1 for the current level
			return Math.max(leftHeight, rightHeight) + 1;
		}
	}
	
	Method-2: Using Level Order Traversal:
	public static int height(Node root) {
	 
		// Initialising a variable to count the
		// height of tree
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		int height = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Node temp = q.poll();
				if (temp.left != null) {
					q.add(temp.left);
				}
				if (temp.right != null) {
					q.add(temp.right);
				}
			}
			height++;
		}
		return height;
	}
	
=========================================================================================================================
3. Level Order Traversal using Queue
Time Complexity: O(N) where N is the number of nodes in the binary tree.
Auxiliary Space: O(N) where N is the number of nodes in the binary tree.
		1
	   / \
	  2   3
	 / \
	4   5
	Output:
	1
	2 3
	4 5
Code:
	Method-1:
	public static void levelOrder(Node root) {
       if(root == null) {
           return;
       }
       Queue<Node> q = new LinkedList<>();
       q.add(root);
       q.add(null);
       while(!q.isEmpty()) {
           Node curr = q.remove();
           if(curr == null) {
               System.out.println();
               //queue empty
               if(q.isEmpty()) {
                   break;
               } else {
                   q.add(null);
               }
           } else {
               System.out.print(curr.data+" ");
               if(curr.left != null) {
                   q.add(curr.left);
               }
               if(curr.right != null) {
                   q.add(curr.right);
               }
           }
       }
   }

	Method-2:// Given a binary tree. Print its nodes in level order using queue(o/p: 1 2 3 4 5)
    void printLevelOrder()
    {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
 
            // poll() removes the present head.  
            Node tempNode = queue.poll();
            System.out.print(tempNode.data + " ");
 
            // Enqueue left child
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }
 
            // Enqueue right child
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }
	
=========================================================================================================================
4. Count of Nodes of Tree
Code:
	public static int countOfNodes(Node root) {
       if(root == null) {
           return 0;
       }


       int leftNodes = countOfNodes(root.left);
       int rightNodes = countOfNodes(root.right);
       return leftNodes + rightNodes + 1;
   }
   
=========================================================================================================================
5. Sum of Nodes of Tree
Code:
	public static int sumOfNodes(Node root) {
       if(root == null) {
           return 0;
       }


       int leftSum = sumOfNodes(root.left);
       int rightSum = sumOfNodes(root.right);
       return leftSum + rightSum + root.data;
   }
   
=========================================================================================================================
6. Print all leaf nodes of a Binary Tree from left to right
Algorithm:
	-Check if the given node is null. If null, then return from the function.
	-Check if it is a leaf node. If the node is a leaf node, then print its data.
	-If in the above step, the node is not a leaf node then check if the left and right children of node exist. If yes then call the function for left and right child of the node recursively.
Time Complexity: O(n), where n is the number of nodes in the binary tree. 
Auxiliary Space: O(n)
Code:
	Method-1:
	// Function to print leaf nodes from left to right 
	static void printLeafNodes(Node root) 
	{ 
		  
		// If node is null, return 
		if (root == null) 
			return; 
		  
		// If node is leaf node, print its data     
		if (root.left == null && 
			root.right == null) 
		{ 
			System.out.print(root.data + " ");
			return; 
		} 
		  
		// If left child exists, check for leaf 
		// recursively 
		if (root.left != null) 
			printLeafNodes(root.left); 
			  
		// If right child exists, check for leaf 
		// recursively 
		if (root.right != null) 
			printLeafNodes(root.right); 
	}
	
	Method-2: Iterative Method
	// fun to print leaf nodes from left to right
    static void printleafNodes(Node root)
    {
        // base case
        if (root == null)
            return;
 
        // implement iterative preorder traversal and start
        // storing leaf nodes.
        Stack<Node> st = new Stack<>();
        st.push(root);
 
        while (!st.isEmpty()) {
            root = st.peek();
            st.pop();
 
            // if node is leafnode, print its data
            if (root.left == null && root.right == null)
                System.out.print(root.data + " ");
 
            if (root.right != null)
                st.push(root.right);
            if (root.left != null)
                st.push(root.left);
        }
    }
	
	Method-3: Count Leaves in Binary Tree
	int countLeaves(Node node) 
    {
        if(node == null) {
         return 0;
        } 
        if(node.left == null && node.right == null) {
            return 1;
        }
        return countLeaves(node.left) + countLeaves(node.right);
    }
	
=========================================================================================================================
7. Diameter of a Binary Tree
The number of nodes on the longest path between two end nodes.
Algorithm:
	-The diameter of T’s left subtree.
	-The diameter of T’s right subtree.
	-The longest path between leaves that goes through the root of T (this can be computed from the heights of the subtrees of T).
Time Complexity: O(N2)
Auxiliary Space: O(N) for call stack
Code:
	Method-1:
	// Method to calculate the diameter
    int diameter(Node root)
    {
        // base case if tree is empty
        if (root == null)
            return 0;
 
        // get the diameter of left and right sub-trees
        int ldiameter = diameter(root.left);
        int rdiameter = diameter(root.right);
		
		// get the height of left and right sub-trees
        int lheight = height(root.left);
        int rheight = height(root.right);
 
        /* Return max of following three
          1) Diameter of left subtree
          2) Diameter of right subtree
          3) Height of left subtree + height of right
          subtree + 1
         */
        return Math.max(lheight + rheight + 1,
                        Math.max(ldiameter, rdiameter));
    }
	// The function Compute the "height" of a tree. Height
    // is the number of nodes along the longest path from
    // the root node down to the farthest leaf node.
    static int height(Node node)
    {
        // base case tree is empty
        if (node == null)
            return 0;
 
        // If tree is not empty then height = 1 + max of
        //  left height and right heights
        return (1
                + Math.max(height(node.left),
                           height(node.right)));
    }
	
	Method-2:
	Time Complexity: O(N) 
	Auxiliary Space: O(N) due to recursive calls.

	// maintain the variable to store the max diameter at each node.(Note:- using the same height method)
    int diameter = 0;
    // Function to return the diameter of a Binary Tree.
    int diameter(Node root) { 
        calculateDiameter(root);
        return diameter;
    }
    
    int calculateDiameter(Node root) {
        
        if(root == null) {
            return 0;
        }
        int lHeight = calculateDiameter(root.left);
        int rHeight = calculateDiameter(root.right);
        
        diameter = Math.max(diameter, lHeight+rHeight+1);
        
        return (Math.max(lHeight, rHeight)+1);
    }
	
	Method-3: optimized code using a pair to return both the height and diameter
	class Pair {
		int height;
		int diameter;
    
		public Pair(int height, int diameter) {
			this.height = height;
			this.diameter = diameter;
		}
	}

	class Solution {
		
		// Function to return the diameter of a Binary Tree.
		int diameter(Node root) {
			
			Pair pair = calculateDiameter(root);
			return pair.diameter;
		}
		
		Pair calculateDiameter(Node root) {
			
			if(root == null) {
				return new Pair(0,0);
			}
			Pair leftPair = calculateDiameter(root.left);
			Pair rightPair = calculateDiameter(root.right);
			
			int height = 1 + Math.max(leftPair.height, rightPair.height);
			int diameter = Math.max(leftPair.height+rightPair.height+1, Math.max(leftPair.diameter, rightPair.diameter));
			
			return new Pair(height, diameter);
		}
	}
	
=========================================================================================================================
8.  Maximum path sum between two leaves of a binary tree
Time Complexity: O(N) where n is the number of nodes
Auxiliary Space: O(N)
Code:
	// An object of Res is passed around so that the same value can be used by multiple recursive calls.
	class Res {
		int val;
	}

	class BinaryTree {
		static Node root;

		// A utility function to find the maximum sum between any
		// two leaves.This function calculates two values:
		// 1) Maximum path sum between two leaves which is stored
		// in res.
		// 2) The maximum root to leaf path sum which is returned.
		int maxPathSumUtil(Node node, Res res) {

			// Base cases
			if (node == null)
				return 0;
			if (node.left == null && node.right == null)
				return node.data;

			// Find maximum sum in left and right subtree. Also
			// find maximum root to leaf sums in left and right
			// subtrees and store them in ls and rs
			int ls = maxPathSumUtil(node.left, res);
			int rs = maxPathSumUtil(node.right, res);

			// If both left and right children exist
			if (node.left != null && node.right != null) {

				// Update result if needed
				res.val = Math.max(res.val, ls + rs + node.data);

				// Return maximum possible value for root being
				// on one side
				return Math.max(ls, rs) + node.data;
			}

			// If any of the two children is empty, return
			// root sum for root being on one side
			return (node.left == null) ? rs + node.data : ls + node.data;
		}

		// The main function which returns sum of the maximum
		// sum path between two leaves. This function mainly
		// uses maxPathSumUtil()
		int maxPathSum() {
			Res res = new Res();
			res.val = Integer.MIN_VALUE;

			int val = maxPathSumUtil(root, res);
		
			if (root.left != null && root.right != null)
				return res.val;
			else {
				//--- for test case ---
				//		 7				 
				//	 / \			 
					// Null -3				 
				// value of res will be INT_MIN but the answer is 4, 
				// which is returned by the function maxPathSumUtil()
				return Math.max(res.val,val);
			}
		}
	}
	
=========================================================================================================================
9.  Determine if Two Trees are Identical
Time Complexity: O(min(N, M)), Where N and M are the sizes of the trees
Auxiliary Space: O(log min(N, M)), due to auxiliary stack space used by recursion calls
Code:
	//Function to check if two trees are identical.
	boolean isIdentical(Node root1, Node root2)
	{
	   // both empty
	   if(root1 == null && root2 == null) {
	        return true;
	    }
		// both non-empty -> compare them
	    if(root1 != null && root2 != null && root1.data == root2.data 
	    && isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right)) {
	        return true;
	    }
		// one empty, one not -> false
	    return false;
	}
	
=========================================================================================================================
10.  Symmetric Tree (Mirror Image of itself)
Time Complexity: O(N)
Auxiliary Space: O(h) where h is the maximum height of the tree
Code:
	// returns true if the tree is symmetric i.e
    // mirror image of itself
    boolean isSymmetric()
    {
        // check if tree is mirror of itself
        return isMirror(root, root);
    }
	// returns true if trees with roots as root1 and
    // root2 are mirror
    boolean isMirror(Node node1, Node node2)
    {
        // if both trees are empty, then they are mirror image
        if (node1 == null && node2 == null)
            return true;
 
        // For two trees to be mirror images, the following
        // three conditions must be true
        // 1.) Their root node's key must be same
        // 2.) left subtree of left tree and right subtree
        // of right tree have to be mirror images
        // 3.) right subtree of left tree and left subtree
        // of right tree have to be mirror images
        if (node1 != null && node2 != null
            && node1.key == node2.key)
            return (isMirror(node1.left, node2.right)
                    && isMirror(node1.right, node2.left));
 
        // if none of the above conditions is true then
        // root1 and root2 are not mirror images
        return false;
    }
	
=========================================================================================================================
11. Left View of Binary Tree
Time Complexity: O(N), The function does a simple traversal of the tree, so the complexity is O(n). 
Auxiliary Space: O(h), due to the stack space during recursive call. ‘h’ here is the height of the binary tree.
Code:
	Method-1: Recursion Approach
	//Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
        ArrayList<Integer> lView = new ArrayList<Integer>();
        leftViewBT(root, lView, 0);
        return lView;
    }
    
    void leftViewBT(Node root, ArrayList<Integer> lView, int level) {
        if(root == null) {
            return;
        }
        if(level == lView.size()) {
            lView.add(root.data);
        }
        leftViewBT(root.left, lView, level+1);
        leftViewBT(root.right, lView, level+1);
    }
	
	Method-2: Level Order Traversal
	// function to print left view of binary tree
    ArrayList<Integer> printLeftView(Node root)
    {
        if (root == null)
            return null;
 
		ArrayList<Integer> lView = new ArrayList<Integer>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
 
        while (!queue.isEmpty()) {
            // number of nodes at current level
            int n = queue.size();
 
            // Traverse all nodes of current level
            for (int i = 1; i <= n; i++) {
                Node temp = queue.poll();
 
                // Print the left most element at
                // the level
                if (i == 1)
                    lView.add(temp.data);
 
                // Add left node to queue
                if (temp.left != null)
                    queue.add(temp.left);
 
                // Add right node to queue
                if (temp.right != null)
                    queue.add(temp.right);
            }
        }
		return lView;
    }
	
=========================================================================================================================
12. Right View of Binary Tree
Time Complexity: O(N), The function does a simple traversal of the tree, so the complexity is O(n). 
Auxiliary Space: O(h), due to the stack space during recursive call. ‘h’ here is the height of the binary tree.
Code:
	Method-1: Recursion Approach
	//Function to return list containing elements of right view of binary tree.
    ArrayList<Integer> rightView(Node root)
    {
        ArrayList<Integer> rView = new ArrayList<Integer>();
        rightViewBT(root, rView, 0);
        return rView;
    }
    
    void rightViewBT(Node root, ArrayList<Integer> rView, int level) {
        if(root == null) {
            return;
        }
        if(level == rView.size()) {
            rView.add(root.data);
        }
		rightViewBT(root.right, rView, level+1);
        rightViewBT(root.left, rView, level+1);
    }
	
	Method-2: Level Order Traversal
	// function to print right view of binary tree
    ArrayList<Integer> printRightView(Node root)
    {
        if (root == null)
            return null;
 
		ArrayList<Integer> rView = new ArrayList<Integer>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
 
        while (!queue.isEmpty()) {
            // number of nodes at current level
            int n = queue.size();
 
            // Traverse all nodes of current level
            for (int i = 1; i <= n; i++) {
                Node temp = queue.poll();
 
                // Print the left most element at
                // the level
                if (i == 1)
                    rView.add(temp.data);
 
				// Add right node to queue
                if (temp.right != null)
                    queue.add(temp.right);
				
                // Add left node to queue
                if (temp.left != null)
                    queue.add(temp.left);
            }
        }
		return rView;
    }
	
=========================================================================================================================
13. Vertical Traversal of Binary Tree
Time Complexity: O(N log N), map in STL is typically implemented using a Self-Balancing Binary Search Tree where all operations take O(Log N) time. 
Auxiliary Space: O(N)
Code:
	Method-1: Recursion Approach
	//Function to store vertical order in map 'm'
    // 'hd' is horizontal distance of current node from
    // root. 'hd' is initially passed as 0.
    static ArrayList <Integer> verticalOrder(Node root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        int hd = 0;
        verticalOrderTraversal(root, hd, map);
        
        for(Map.Entry<Integer, ArrayList<Integer>> entry: map.entrySet()) {
            ans.addAll(entry.getValue());
        }
        return ans;
    }
    
    static void verticalOrderTraversal(Node root, int hd, TreeMap<Integer, ArrayList<Integer>> map) {
        
        if(root == null) {
            return;
        }
        // Add the current node to the corresponding horizontal distance in the map
        ArrayList<Integer> list = map.get(hd);
        if(list == null) {
            list = new ArrayList<>();
            list.add(root.data);
        } else {
            list.add(root.data);
        }
        map.put(hd, list);
        // Recursively traverse the left and right subtrees
        verticalOrderTraversal(root.left, hd-1, map);
        verticalOrderTraversal(root.right, hd+1, map);
    }
	
	Method-2: Level Order Traversal
	class Pair {
		int hd;
		Node node;
		
		Pair(int hd, Node node) {
			this.hd = hd;
			this.node = node;
		}
	}
	//Function to find the vertical order traversal of Binary Tree.
    static ArrayList <Integer> verticalOrder(Node root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        // Create queue to do level order traversal Every item of queue contains
        // node and horizontal distance
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, root));
        while(!q.isEmpty()) {
            Pair curr = q.remove();
            if(map.containsKey(curr.hd)) {
                map.get(curr.hd).add(curr.node.data);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(curr.node.data);
                map.put(curr.hd, list);
            }
            if(curr.node.left != null) {
                q.add(new Pair(curr.hd-1, curr.node.left));
            }
            if(curr.node.right != null) {
                q.add(new Pair(curr.hd+1, curr.node.right));
            }
        }
        
        for(Map.Entry<Integer, ArrayList<Integer>> entry: map.entrySet()) {
            ans.addAll(entry.getValue());
        }
        return ans;
    }
	
=========================================================================================================================
14. Top View of Binary Tree
Time complexity: O(N * log(N)), where N is the number of nodes in the given tree.
Auxiliary Space: O(N), As we store nodes in the map and queue.
Code:
	Method: Level Order Traversal

    class Pair {
		int hd;
		Node node;
		
		Pair(int hd, Node node) {
			this.hd = hd;
			this.node = node;
		}
	}

	class Solution
	{
		//Function to return a list of nodes visible from the top view 
		//from left to right in Binary Tree.
		static ArrayList<Integer> topView(Node root)
		{
		   ArrayList<Integer> ans = new ArrayList<>();
			if(root == null){
				return ans;
			}
			TreeMap<Integer, Integer> map = new TreeMap<>();
			Queue<Pair> q = new LinkedList<>();
			q.add(new Pair(0, root));
			while(!q.isEmpty()) {
				Pair curr = q.remove();
				if(!map.containsKey(curr.hd)) {
					map.put(curr.hd, curr.node.data);
				}
				if(curr.node.left != null) {
					q.add(new Pair(curr.hd-1, curr.node.left));
				}
				if(curr.node.right != null) {
					q.add(new Pair(curr.hd+1, curr.node.right));
				}
			}
			
			for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
				ans.add(entry.getValue());
			}
			return ans;
			
		}
	}
	
=========================================================================================================================
15. Bottom View of Binary Tree
Time complexity: O(N * log(N)), where N is the number of nodes in the given tree.
Auxiliary Space: O(N), As we store nodes in the map and queue.
Code:
	Method: Level Order Traversal

    class Pair {
		int hd;
		Node node;
		
		Pair(int hd, Node node) {
			this.hd = hd;
			this.node = node;
		}
	}

	class Solution
	{
		//Function to return a list containing the bottom view of the given tree.
		public ArrayList <Integer> bottomView(Node root)
		{
			ArrayList<Integer> ans = new ArrayList<>();
			if(root == null) {
				return ans;
			}
			TreeMap<Integer, Integer> map = new TreeMap<>();
			Queue<Pair> q = new LinkedList<>();
			q.add(new Pair(0, root));
			while(!q.isEmpty()) {
				Pair curr = q.remove();
				map.put(curr.hd, curr.node.data);
				if(curr.node.left != null) {
					q.add(new Pair(curr.hd-1, curr.node.left));
				}
				if(curr.node.right != null) {
					q.add(new Pair(curr.hd+1, curr.node.right));
				}
			}
			for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
				ans.add(entry.getValue());
			}
			return ans;
		}
	}
	
=========================================================================================================================
16. Connect Nodes at Same Level
Time Complexity: O(N)
Auxiliary Space: O(N)
       10                  10 ------> NULL
      / \                /    \
     3   5       =>     3 ----> 5 --------> NULL
    / \   \            /  \       \
   4   1   2          4 --> 1 ---> 2 -------> NULL
Code:
	Method: Level Order Traversal

	void connect(Node p)
    {
        // initialize queue to hold nodes at same level
        Queue<Node> q = new LinkedList<>();
 
        q.add(root); // adding nodes to the queue
 
        Node temp = null; // initializing prev to null
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                Node prev = temp;
                temp = q.poll();
 
                // i > 0 because when i is 0 prev points
                // the last node of previous level,
                // so we skip it
                if (i > 0)
                    prev.nextRight = temp;
 
                if (temp.left != null)
                    q.add(temp.left);
 
                if (temp.right != null)
                    q.add(temp.right);
            }
 
            // pointing last node of the nth level to null
            temp.nextRight = null;
        }
    }
	
=========================================================================================================================
17. Level order traversal in spiral form
Time Complexity: O(N)
Auxiliary Space: O(N)
       10                 
      / \               
     3   5       =>     10 3 5 2 1 4
    / \   \            
   4   1   2          
Code:
	Method: Level Order Traversal

	// Function to perform level order traversal in a spiral form
    ArrayList<Integer> findSpiral(Node root) {
        // Initialize an ArrayList to store the nodes in spiral order
        ArrayList<Integer> ans = new ArrayList<>();
        // If the root is null, return an empty ArrayList
        if(root == null) {
            return ans;
        }
        // Initialize a deque to perform level order traversal
        Deque<Node> q = new LinkedList<>();
        // Add the root node to the deque to start traversal
        q.addLast(root);
        // Initialize a boolean variable to track the direction of traversal
        boolean reverse = true;
        
        // Loop until the deque is empty
        while(!q.isEmpty()) {
            // Get the number of nodes at the current level
            int size = q.size();
            // Iterate through the nodes at the current level
            for(int i = 0; i < size; i++) {
                // If traversal direction is reverse
                if(reverse) {
                    // Remove the last node from the deque
                    Node temp = q.removeLast();
                    // Add the node's data to the result ArrayList
                    ans.add(temp.data);
                    // If the removed node has a right child, add it to the front of the deque
                    if(temp.right != null) {
                        q.addFirst(temp.right);
                    }
                    // If the removed node has a left child, add it to the front of the deque
                    if(temp.left != null) {
                        q.addFirst(temp.left);
                    }
                } 
                // If traversal direction is not reverse
                else {
                    // Remove the first node from the deque
                    Node temp = q.removeFirst();
                    // Add the node's data to the result ArrayList
                    ans.add(temp.data);
                    // If the removed node has a left child, add it to the end of the deque
                    if(temp.left != null) {
                        q.addLast(temp.left);
                    }
                    // If the removed node has a right child, add it to the end of the deque
                    if(temp.right != null) {
                        q.addLast(temp.right);
                    }
                }
            }
            // Toggle the direction of traversal for the next level
            reverse = !reverse;
        }
        // Return the result ArrayList containing nodes in spiral order
        return ans;
    }
}

=========================================================================================================================
Binary Search Tree:
Time complexity: O(h), where h is the height of the BST.
Auxiliary Space: O(h), where h is the height of the BST. This is because the maximum amount of space needed to store the recursion stack would be h.
Implementation:-
// A utility function to insert
    // a new node with given key in BST
    Node insert(Node node, int key) {
        // If the tree is empty, return a new node
        if (node == null) {
            node = new Node(key);
            return node;
        }
 
        // Otherwise, recur down the tree
        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
 
        // Return the (unchanged) node pointer
        return node;
    }
 
    // Utility function to search a key in a BST
    Node search(Node root, int key) {
        // Base Cases: root is null or key is present at root
        if (root == null || root.key == key)
            return root;
 
        // Key is greater than root's key
        if (root.key < key)
            return search(root.right, key);
 
        // Key is smaller than root's key
        return search(root.left, key);
    }
	
=========================================================================================================================
Deletion in Binary Search Tree (BST):
->3 scenarios to delete a node in BST:
1. Delete a Leaf Node in BST:- Delete node and return null to parent.
2. Delete a Node with Single Child in BST:- Delete node and replace with child node.
		 8                        8
	   /  \          delete 2    /  \
	  2     9        -------> 	5    9  
	   \   /  \                     /  \
		5 6    10                  6    10
3. Delete a Node with Both Children in BST
	- Replace the value with inorder successor.
	- Delete the node for inorder successor.
	- inorder successor also has 0 or 1 child.
	- inorder successor: left most node in right subtree.
		8                          6
	   /  \          delete 8    /   \
	  2     9        -------> 	2     9  
	   \   /  \                  \   /  \
		5 6    10                 5 7    10
		    \						
			 7
Note: Inorder successor is needed only when the right child is not empty. In this particular case, the inorder successor can be obtained by finding the minimum value in the right child of the node.

Implementation:
	/* Given a binary search tree and a key, this function
       deletes the key and returns the new root */
    Node deleteNode(Node root, int key) {
        // Base case
        if (root == null)
            return root;
 
        // Recursive calls for ancestors of
        // node to be deleted
        if (root.key > key) {
            root.left = deleteNode(root.left, key);
            return root;
        } else if (root.key < key) {
            root.right = deleteNode(root.right, key);
            return root;
        } else {
			// We reach here when root is the node
			// to be deleted.(root.key == key)
			//case1:
			if(root.left == null && root.right == null) {
				return null;
			}
	 
			//case2: If one of the children is empty
			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			}
	 
			//case3: If both children exist
			// Find successor
			Node inorderSucc = inorderSuccessor(root.right);
			root.key = inorderSucc.key;
			// Delete successor
			root.right = delete(root.right, inorderSucc,data);
		}
		return root;
    }
	
	Node inorderSuccessor(Node root){
		while(root.left != null) {
			root = root.left;
		}
		return root;
	}Check for BST