//Soorya Suresh
//soorya.suresh@stonybrook.edu
//Data Structures
//CSE 214

package bashterminal;

/**
 *
 * @author Soorya Suresh
 */
public class DirectoryNode {

    private String name;
    private boolean isFile;
    private DirectoryNode left;
    private DirectoryNode middle;
    private DirectoryNode right;
    private DirectoryNode parent;
/**
 * 
 * @param name is used to give the directory a name so when cd {dir} happens for example, it has a name to find
 * @param parent is used especially in presentWorkingDirectory in order to find the parents of each child so that it can all print out
 */
    public DirectoryNode(String name, DirectoryNode parent) {
        this.name = name;
        this.left = left;
        this.right = right;
        this.middle = middle;
        this.isFile = isFile;
        this.parent = parent;
    }
/**
 * 
 * @return the name of the node
 */
    public String getName() {
        return name;
    }
/**
 * 
 * @param name sets the name to this
 */
    public void setName(String name) {
        this.name = name;
    }
/**
 * 
 * @return the left of the node
 */
    public DirectoryNode getLeft() {
        return left;
    }
/**
 * 
 * @return the middle of the node
 */
    public DirectoryNode getMiddle() {
        return middle;
    }
/**
 * 
 * @return the right of the node
 */
    public DirectoryNode getRight() {
        return right;
    }
/**
 * 
 * @param left sets left to this
 */
    public void setLeft(DirectoryNode left) {
        this.left = left;
    }
/**
 * 
 * @param middle sets middle to this
 */
    public void setMiddle(DirectoryNode middle) {
        this.middle = middle;
    }
/**
 * 
 * @param right sets right to this
 */
    public void setRight(DirectoryNode right) {
        this.right = right;
    }
/**
 * 
 * @return if the object is a file or not
 */
    public boolean getIsFile() {
        return isFile;
    }
/**
 * 
 * @param isFile sets the boolean to this
 */
    public void setIsFile(boolean isFile) {
        this.isFile = isFile;
    }
/**
 * 
 * @return the parent of a child directory
 */
    public DirectoryNode getParent() {
        return parent;
    }
/**
 * 
 * @param newChild is taken to be added into the directory
 * @throws FullDirectoryException thrown in case of full directory
 * @throws NotADirectoryException if it is a file thats trying to be added
 */
    public void addChild(DirectoryNode newChild) throws FullDirectoryException, NotADirectoryException {
        if (newChild.getIsFile() == true) {
            throw new NotADirectoryException();
        }
        if (newChild.getIsFile() == false) {
            if (left == null) {
                left = newChild;
            } else if (middle == null) {
                middle = newChild;
            } else if (right == null) {
                right = newChild;
            } else {
                throw new FullDirectoryException();
            }
        }
    }

}
