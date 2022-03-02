
public class TestTree {

	public static void main(String[] args) 
	{
		//Create tree with 8 at the root node
    	LinkedBinaryTree<Integer> intTree = new LinkedBinaryTree<>( 8 ) ;

    	//Get a reference to the root node of the tree
    	BinaryTreeNode<Integer> root   = intTree.getRootNode() ;
    	
    	//Create 7 nodes for the left side
    	BinaryTreeNode<Integer> node_1 = new BinaryTreeNode<>( 1 ) ;
    	BinaryTreeNode<Integer> node_2 = new BinaryTreeNode<>( 2 ) ;
    	BinaryTreeNode<Integer> node_3 = new BinaryTreeNode<>( 3 ) ;
    	BinaryTreeNode<Integer> node_4 = new BinaryTreeNode<>( 4 ) ;
    	BinaryTreeNode<Integer> node_5 = new BinaryTreeNode<>( 5 ) ;
    	BinaryTreeNode<Integer> node_6 = new BinaryTreeNode<>( 6 ) ;
    	BinaryTreeNode<Integer> node_7 = new BinaryTreeNode<>( 7 ) ;

    	//Create 7 nodes for the right side
    	BinaryTreeNode<Integer> node_9 = new BinaryTreeNode<>( 9 ) ;
    	BinaryTreeNode<Integer> node_10 = new BinaryTreeNode<>( 10 ) ;
    	BinaryTreeNode<Integer> node_11 = new BinaryTreeNode<>( 11 ) ;
    	BinaryTreeNode<Integer> node_12 = new BinaryTreeNode<>( 12 ) ;
    	BinaryTreeNode<Integer> node_13 = new BinaryTreeNode<>( 13 ) ;
    	BinaryTreeNode<Integer> node_14 = new BinaryTreeNode<>( 14 ) ;
    	BinaryTreeNode<Integer> node_15 = new BinaryTreeNode<>( 15 ) ;

    	//Put together left side ...indentation used as a visual cue
        root.setLeft( node_4 ) ;
            node_4.setLeft( node_2 ) ;
                node_2.setLeft( node_1 ) ;
                node_2.setRight( node_3 ) ;
    	    node_4.setRight( node_6 ) ;
                node_6.setLeft( node_5 ) ;
                node_6.setRight( node_7 ) ;

    	//Put together right side ...indentation used as a visual cue
        root.setRight( node_12 ) ;
            node_12.setLeft( node_10 ) ;
                node_10.setLeft( node_9 ) ;
                node_10.setRight( node_11 ) ;
    	    node_12.setRight( node_14 ) ;
                node_14.setLeft( node_13 ) ;
                node_14.setRight( node_15 ) ;

        //Print out tree and tree stats
    	System.out.println( intTree.toString() ) ;
    	System.out.println() ;
    	System.out.println( "Tree Height ..: " + intTree.getHeight() ) ;
    	System.out.println( "Tree Size ....: " + intTree.size() ) ;
	}

}
