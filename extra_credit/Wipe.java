/*
 
 Author: John Hattori 
 Date  : 09/20/14
 Program Name: Wipe.java
 Objective: This program takes files as CL arguments and trashes them by overwriting file with jibberish
            and then deleting them. If option -c is used, user is asked for confirmation.
 
*/
 
//import java.awt.*;
//import java.applet.*;
import java.util.*;
import java.io.*;
//import javax.swing.*;
 
public class Wipe
{

//******************* die() *************************
    
    public static void die(String msg)
    {
        System.err.println(msg);
        System.exit(1);
    }

//******************* askYesNo() ********************

    public static boolean askYesNo(String fileName)
    {
         Scanner sc = new Scanner(System.in);
         System.out.print("Are you sure you want to delete '" + fileName + "'? (y/n)");  
         while(true)
         {
              char ans =  Character.toUpperCase(sc.nextLine().charAt(0));
              if (ans == 'Y' || ans == 'N') return(ans == 'Y');
              System.err.println("Error: Y or N only");
         }
    }

//****************** getFile() **********************
    
    public static void getFile(String args[])
    {
        if(args.length == 0)
        {
            die("You must enter a file name as an argument.");
        }
        boolean ask = false;
        int start = 0;
        if(args[0].equals("-c"))
        {    
            ask = true;
            start = 1;
        }        
        for(int i = start; i < args.length; i++)
        {
            if(ask == false || (ask == true && askYesNo(args[i]) == true))
            {
                trash(args[i]);
            }
        }
    }    

//*************** trash() *********************

    public static void trash(String fileName)
    {
        
        File rf = new File(fileName);

        if (!rf.exists()) die("file does not exist");
        if (rf.isDirectory()) die("is a directory");
        if (!rf.isFile()) die("file  irregular");
        if (!rf.canRead()) die("file not readable.");
        
        try
        {
            long fileSize = rf.length();
            PrintWriter writer = new PrintWriter(fileName);
            Random generator = new Random();
            for(long i = 0; i < fileSize; i++)
            {
                char c = (char) (generator.nextInt(254) + 1);
                writer.print(c);    
                
            }
            writer.println("");            
            writer.close();
            rf.delete();
 
        }catch(FileNotFoundException e) {System.out.println("File not found.");}
    }


//****************** main() *************************
    
    public static void main(String args[])
    {
        getFile(args);            
    }
}
