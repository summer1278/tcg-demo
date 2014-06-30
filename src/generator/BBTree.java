package generator;


import java.util.ArrayList;

public class BBTree {
	private int left;
    private int top;
    private int right;
    private int bottom;
    
    private int rootX;
    private int rootY;
    
    private BBTree parent;
    private BBTree[] children;
    
    
    BBTree(int left, int top, int right, int bottom) {
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
    }
    
	
    // call from builder to add leaf nodes
    public void addChildren(BBTree... trees) {
    	ArrayList<BBTree> treeList = new ArrayList<BBTree>();
    	for(int i = 0 ; i < trees.length ; i++) {
    		BBTree currentTree = trees[i];
    		if (currentTree != null) {
    			treeList.add(currentTree);
    			// set currentTree's parent to this BBTree
    			// root will be null
    			currentTree.parent = this;
    		}
    	}
    	children = treeList.toArray(new BBTree[0]);
    }
    
    public void setRootLocation(int left, int top){
    	rootX = left;
    	rootY = top;
    }
    
    private BBTree getRoot() {
    	if (parent == null) {
    		// this is a root
    		return this;
    	}
    	else {
    		// parent tree's parent
    		return parent.getRoot();
    	}
    }
    
    // get 4 coordinates of left, top, right , bottom
    private int[] getAxes() {
    	BBTree rootTree = getRoot();
    	int x1 = rootTree.rootX + left;
    	int y1 = rootTree.rootY + top;
    	int x2 = rootTree.rootX + right;
    	int y2 = rootTree.rootY + bottom;
    	// construct the integer set and return
    	int[] axes = {x1,y1,x2,y2};
    	return axes;
    }
    
    private boolean isLeaf(){
    	// This BBTree is leaf when it has no child 
    	if (children == null) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    private boolean testCollide(BBTree aTree, BBTree bTree) {
    	int[] axesA = aTree.getAxes();
    	int[] axesB = bTree.getAxes();
    	
    	if ((axesA[2] > axesB[0])&&// aTree.right > bTree.left
    			(axesA[0] < axesB[2])&&// aTree.left < bTree.right
    			(axesA[1] < axesB[3])&&// aTree.top < bTree.bottom
    			(axesA[3] > axesB[1]))// aTree.bottom > bTree.top
    	{
    		return true;
    	}
    	/*boolean sit1 = false;
    	boolean sit2 = false;
    	if ((axesA[2] > axesB[0])&&// aTree.right > bTree.left
    			(axesA[0] < axesB[2]))// aTree.left < bTree.right
    	{
    		sit1 = true;
    	}
    	if((axesA[1] < axesB[3])&&// aTree.top < bTree.bottom
    			(axesA[3] > axesB[1]))// aTree.bottom > bTree.top
    	{
    		System.out.println("WINNNNNNNNNNNNNNNNNNNNNNNN!!!!!!!!!!!!!!!!");
    		sit2 = true;
    	}*/
    	return false;
    }
    
    public boolean testAllCollide(BBTree otherTree) {
    	if (testCollide(this, otherTree)) {
    		if (this.isLeaf() && otherTree.isLeaf()) {
    			// both are leaf nodes
    			//System.out.println("---------1----------");
    			return true;
    		}
    		// test child trees
			// this tree is leaf test this with other tree's child trees
    		else if (this.isLeaf() && !otherTree.isLeaf()) {
				for (int i = 0; i < otherTree.children.length ; i++){
					BBTree tempTree = otherTree.children[i];
					if (this.testAllCollide(tempTree)) {
						//System.out.println("---------2----------");
						return true;
					}
				}
    		}
			// otherwise, test otherTree with this tree
			else {
				for (int i = 0; i < this.children.length ; i++) {
					BBTree tempTree = this.children[i];
					if (otherTree.testAllCollide(tempTree)) {
						//System.out.println("---------3----------");
						return true;
					}
				}
			}
    	}
    	// else
		return false;
    }
    
    public boolean pointInArea(double x, double y) {
    	int[] axes = getAxes();
    	if ((axes[0] <= x)// left <= x 
    			&& (axes[2] >= x) // right >= x
    			&& (axes[1] <= y) // top <= y
    			&& (axes[3] >= y)) // bottom >=y
    	{
    		return true;
    	}
    	else {
    		return false;
    	}
    	
    }
    
   
}