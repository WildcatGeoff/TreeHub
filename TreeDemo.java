class Node{
   int value;
   Node left, right;
   
   public Node(int value){
      this.value = value;
      left = null;
      right = null;
   }

}

class BinarySearchTree{

   Node root;
   
   
   /*
   recursive insert method
   */
   public Node insert(Node root, int value){
      //base case
      if(root == null){
         root = new Node(value);
         return root;
      }
      
      //recursive step
      if(value < root.value){
         root.left = insert(root.left, value); 
      }else{
         root.right = insert(root.right, value);
      }
      
      return root;
   }
   
   
   
   /*
   pre-order traversal
   */
   public void preOrderTraversal(Node root){
      //implement me
	  if(root != null)
	  {
		System.out.println(root.value);
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
	  }
   }

   
   
   /*
   in-order traversal
   */
   public void inOrderTraversal(Node root){
      //implement me
	  if(root == null)
	  {
		  return;
	  }
	  
   }
   
   
   
   /*
   post-order traversal
   */
   public void postOrderTraversal(Node root){
      //implement me
	  if(root != null)
	  {
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
		System.out.println(root.value);
	  }
   }
   
   
   
   /*
   a method to find the node in the tree
   with a specific value
   */
   public boolean find(Node root, int key){
	   if(root.value == key)
	   {
		   return true;
	   }
	   else
	   {
		   find(root.left,key);
		   find(root.right,key);
	   }
	  //implement me
      return false;           
   }
   
   
   
   /*
   a method to find the node in the tree
   with a smallest key
   */
   public int getMin(Node root){
      //implement me
	  int min = Integer.MAX_VALUE;
	  if(root.value < min)
	  {
		  min = root.value;
	  }
	  int leftMin = getMin(root.left);
	  int rightMin = getMin(root.right);
	  if(leftMin < min)
	  {
		  min = leftMin;
	  }
	  if(rightMin < min)
	  {
		  min = rightMin;
	  }
	  return min;
   }
  
  
  
   /*
   a method to find the node in the tree
   with a largest key
   */
   public int getMax(Node root){
	  //implement me
   }
    int max = Integer.MIN_VALUE;
	  if(root.value > max)
	  {
		  max = root.value;
	  }
	  int leftMax = getMin(root.left);
	  int rightMax = getMin(root.right);
	  if(leftMax > max)
	  {
		  max = leftMax;
	  }
	  if(rightMax > max)
	  {
		  max = rightMax;
	  }
	  return max;
   
   
   /*
   this method will not compile until getMax
   is implemented
   */
   public Node delete(Node root, int key){
      
      if(root == null){
         return root;
      }else if(key < root.value){
         root.left = delete(root.left, key);
      }else if(key > root.value){
         root.right = delete(root.right, key);
      }else{
         //node has been found
         if(root.left==null && root.right==null){
            //case #1: leaf node
            root = null;
         }else if(root.right == null){
            //case #2 : only left child
            root = root.left;
         }else if(root.left == null){
            //case #2 : only right child
            root = root.right;
         }else{
            //case #3 : 2 children
            root.value = getMax(root.left);
            root.left = delete(root.left, root.value);
         }
      }
      return root;  
   }
   
   
   
}



public class TreeDemo{
   public static void main(String[] args){
      BinarySearchTree t1  = new BinarySearchTree();
      t1.insert(24);
      t1.insert(80);
      t1.insert(18);
      t1.insert(9);
      t1.insert(90);
      t1.insert(22);
            
      System.out.print("in-order :   ");
      t1.inOrderTraversal(t1.root);
      System.out.println();
           
      
   }  
}