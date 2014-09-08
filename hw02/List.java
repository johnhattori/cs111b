/*
 
 Author: jhattori 
 Date  : 09/05/14
 Program Name: List.java
 Objective: This program will display the contents of a file
            entered as a command line argument. If option -n
            is arg[0] the program will display the line number.
 
*/
 
//import java.awt.*;
//import java.applet.*;
import java.util.*;
import java.io.*;
//import javax.swing.*;
 
class List
{
   
    public static void die(String msg)
    {
         System.err.println(msg);
         System.exit(1);
    }

    public static void main(String args[])
   {

        if (args[0].equals( "-n" ))
        {
            File f = new File(args[1]);
            
            if (!f.exists()) die("file does not exist");
            if (f.isDirectory()) die("is a directory");
            if (!f.isFile()) die("file  irregular");
            if (!f.canRead()) die("file not readable.");     
                    
            try
            {
                String line;
                Scanner sc = new Scanner(f);
                int lineNum = 1;    
                while(sc.hasNext())
                {
                    line = sc.nextLine();
                    System.out.println(lineNum + ") " + line);
                    lineNum++;
                }
            }catch(FileNotFoundException e){}
        }
        else 
        {
            File f = new File(args[0]);
            
            if (!f.exists()) die("file does not exist");
            if (f.isDirectory()) die("is a directory");
            if (!f.isFile()) die("file  irregular");
            if (!f.canRead()) die("file not readable.");     
                    
            try
            {
                 String line;
                 Scanner sc = new Scanner(f);
                 while(sc.hasNext())
                 {
                      line = sc.nextLine();
                      System.out.println(line);
                 }
            }catch(FileNotFoundException e){}
        }
   }
}
