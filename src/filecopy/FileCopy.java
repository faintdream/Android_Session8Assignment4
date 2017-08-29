/*
 * This program makes a copy of a file using java io methods
 * 1. output content of file1
 * 2. copy content of file1 to file2
 * 3. output content of file2
 */
package filecopy;

import java.io.FileInputStream;                         // we are importing FileInputStream
import java.io.FileNotFoundException;                   // importing FileNotFoundException
import java.io.FileOutputStream;                        // importing FileOutputStream
import java.io.IOException;                             // importing IOException
import java.util.logging.Level;                         // importing  logging level
import java.util.logging.Logger;                        // importing logger 

public class FileCopy {                                 // main class 

    FileCopy(String source) throws FileNotFoundException, IOException {        //Parameterised contructor
        int reader = 0;                                          // here we accept source file name and display
        // its contents
        FileInputStream fin = new FileInputStream(source);        // creating object of FileINputStream
        System.out.println("");                                  // beautification
        System.out.println("");
        System.out.println("==============================");    ///

        System.out.println("File: " + source);
        System.out.println("Contents:");
        do {
            try {
                reader = fin.read();                               // read file content
                System.out.write(reader);                        //output content to console by passing reader
            } catch (IOException ex) {
                Logger.getLogger(FileCopy.class.getName()).log(Level.SEVERE, null, ex);
            }

        } while (reader != -1);                             // loop ends once reader  equals -1
        fin.close();
    }

    FileCopy(String source, String dest) throws FileNotFoundException, IOException {
        // another Paramerterised contructor 
        // which accepts source and dest file names
        // copies conent of file1 to file2

        FileInputStream fin = new FileInputStream(source);  // creating object of FileInputStream
        FileOutputStream fout = new FileOutputStream(dest); // creatring object of FileOutputStream
        int reader = 0;                                     //creating a reader variable to hold file content
        System.out.println("");
        System.out.println("");
        System.out.println("==============================");
        System.out.println("Source File: " + source);          //display source and dest file names
        System.out.println("Destination File: " + dest);
        do {
            if (reader != -1) {                     //if reader is not -1 
                reader = fin.read();                // read content to reader variable
            }
            fout.write(reader);                     //using fout object write the reader content to dest
        } while (reader != -1);                     // exit loop once reader is -1
        fin.close();                                // closing the FileInputStream object 
        fout.close();                               // closing the FileOutputStream object

        System.out.println("==============================");
    }

    public static void main(String[] args) throws FileNotFoundException, IOException { // main section       
        FileCopy objFC;                                         // defining object for FileCopy class
        objFC = new FileCopy("src/file1.txt");                  // passing FileCopy Single Param Constructor
        objFC = new FileCopy("src/file1.txt", "src/file2.txt"); // passing FileCopy Dual Param Constructor
        FileCopy objFC2 = new FileCopy("src/file2.txt");        // passing FileCopy Single Param Constructor again
        
        
    }

}
