//Soorya Suresh
//111458936
//soorya.suresh@stonybrook.edu
//Data Structures
//CSE 214
//R08 
//Johnny So
package bashterminal;

/**
 *
 * @author Soorya Suresh
 * @exception is used if the node that is put in is a file and it is put in a directory position
 */
class NotADirectoryException extends Exception {
    public NotADirectoryException(){
        System.out.println("Current Node is A File");
    }
    
}
