//Soorya Suresh
//soorya.suresh@stonybrook.edu
//Data Structures

package bashterminal;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Soorya Suresh
 */
public class BashTerminal {

    /**
     * @param args the command line arguments before the while loop, reader will
     * take in the user input a new DirectoryTree is created to start up the
     * DirectoryTree class From then a while loop is running based on the input
     * not being equal to exit in there the if statements lead to what function
     * the user puts in pwd will print out the entire line that the cursor node goes through (eg: root/home/user/Documents)
     * the user puts in ls it will print a list of either the directories or files
     * the user puts in ls -R will print out in a formatted section of the entire directory tree with directories having |- and files with -
     * the user puts in cd {dir} it will move the cursor to the indicated name of child directory
     * the user puts cd / moves cursor to the root of the tree
     * the user puts in mkdir {name} which creates a new directory in that name
     * the user puts in touch {name} which creates a new file in that name
     * the user puts in exit which exits the program
     */
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        DirectoryTree dT = new DirectoryTree();
        System.out.println("Starting bash terminal");
        System.out.print("[sosuresh@host]: $");
        String input = reader.nextLine();
        while (!input.equals("exit")) {
            if (input.equals("pwd")) {
                System.out.println(dT.presentWorkingDirectory());

            } else if (input.equals("ls")) {
                System.out.println(dT.listDirectory());
            } else if (input.equals("ls -R")) {
                dT.printDirectoryTree(dT.getCursor());
            } else if (input.contains("cd") && !input.contains("/")) {
                String substring1 = input.substring(3, input.length());
                try {
                    dT.changeDirectory(substring1);
                } catch (NotADirectoryException ex) {
                    Logger.getLogger(BashTerminal.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (input.equals("cd /")) {
                dT.resetCursor();
            } else if (input.contains("mkdir")) {
                String substring2 = input.substring(6, input.length());
                try {
                    dT.makeDirectory(substring2);
                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(BashTerminal.class.getName()).log(Level.SEVERE, null, ex);
                } catch (FullDirectoryException ex) {
                    Logger.getLogger(BashTerminal.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (input.contains("touch")) {
                String substring3 = input.substring(6, input.length());
                try {
                    dT.makeFile(substring3);
                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(BashTerminal.class.getName()).log(Level.SEVERE, null, ex);
                } catch (FullDirectoryException ex) {
                    Logger.getLogger(BashTerminal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.print("[sosuresh@host]: $");
            input = reader.nextLine();
        }
        System.out.println("Program terminating normally");

    }

}
