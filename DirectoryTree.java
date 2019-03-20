//Soorya Suresh
//soorya.suresh@stonybrook.edu
//Data Structures

package bashterminal;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Soorya Suresh
 */
public class DirectoryTree {

    private DirectoryNode root;
    private DirectoryNode cursor;
/**
 * creates a DirectoryNode which has the name root and its parent is null
 * then root and cursor will equal the node
 */
    public DirectoryTree() {
        DirectoryNode dn = new DirectoryNode("root", null);
        root = dn;
        cursor = dn;
    }
/**
 * this method moves cursor to the root of the tree
 */
    public void resetCursor() {
        cursor = root;
    }
/**
 * 
 * @return the cursor
 */
    public DirectoryNode getCursor() {
        return cursor;
    }
/**
 * 
 * @param name is taken because its used to find the cursor that has that name and move over there
 * @throws NotADirectoryException in case a file is trying to be changed not a directory
 */
    public void changeDirectory(String name) throws NotADirectoryException {
        if (cursor.getLeft().getName().compareTo(name) == 0) {
            cursor = cursor.getLeft();
        } else if (cursor.getMiddle().getName().compareTo(name) == 0) {
            cursor = cursor.getMiddle();
        } else if (cursor.getRight().getName().compareTo(name) == 0) {
            cursor = cursor.getRight();
        } else {
            throw new NotADirectoryException();
        }
    }
/**
 * 
 * @return a string that has the directories listed with slashes 
 */
    public String presentWorkingDirectory() {
        DirectoryNode current = cursor;
        String str = "";
        while (current != null) {//if it doesn't work do .equals
            str = current.getName() + "/" + str;
            current = current.getParent();
        }
        return str;
    }
/**
 * 
 * @return a string of the directories with spaces in between
 */
    public String listDirectory() {
        String out = "";
        if (cursor.getLeft() != null) {
            out += cursor.getLeft().getName() + " ";
        }
        if (cursor.getMiddle() != null) {
            out += cursor.getMiddle().getName() + " ";
        }
        if (cursor.getRight() != null) {
            out += cursor.getRight().getName();
        }
        return out;
    }
/**
 * print out the entire tree with directories and files
 * @param cursor is taken to print out its left,middle,right
 * this is a recursive method
 */
    public void printDirectoryTree(DirectoryNode cursor) {
        if (cursor.getIsFile() == true) {
            System.out.println("  -" + cursor.getName());
        } else {
            System.out.println("|-" + cursor.getName());
        }
        if (cursor.getLeft() != null) {
            System.out.print("  ");
            printDirectoryTree(cursor.getLeft());
        }
        if (cursor.getMiddle() != null) {
            System.out.print("  ");
            printDirectoryTree(cursor.getMiddle());
        }
        if (cursor.getRight() != null) {
            System.out.print("  ");
            printDirectoryTree(cursor.getRight());
        }

    }
/**
 * 
 * @param name is taken in to make the directory with that name
 * @throws IllegalArgumentException in case the name doesn't fit the requirements
 * @throws FullDirectoryException if directory is full
 */
    public void makeDirectory(String name) throws IllegalArgumentException, FullDirectoryException {
        if (!name.contains(" ") && !name.contains("/")) {
            DirectoryNode dn = new DirectoryNode(name, cursor);
            dn.setIsFile(false);
            try {
                cursor.addChild(dn);
            } catch (NotADirectoryException ex) {
                Logger.getLogger(DirectoryTree.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            throw new IllegalArgumentException();
        }
    }
/**
 * 
 * @param name is taken in to make the file with that name
 * @throws IllegalArgumentException in case the name doesn't fit the requirements
 * @throws FullDirectoryException if directory is full
 */
    public void makeFile(String name) throws IllegalArgumentException, FullDirectoryException {
        if (!name.contains(" ") && !name.contains("/")) {
            DirectoryNode dn = new DirectoryNode(name, cursor);
            dn.setIsFile(true);
            if (cursor.getLeft() == null) {
                cursor.setLeft(dn);
            } else if (cursor.getMiddle() == null) {
                cursor.setMiddle(dn);
            } else if (cursor.getRight() == null) {
                cursor.setRight(dn);
            } else {
                throw new FullDirectoryException();
            }

        }
    }

}
