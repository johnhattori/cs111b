/*
 
 Author: jhattori 
 Date  : 09/05/14
 Program Name: List.java
 Objective: This program will display the contents of a file
            entered as a command line argument. If option -n
            is arg[0] the program will display the line number.
            This program assumes that the last argument given
            is the file to be read.
 
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

        boolean printLineNum = false;

        if(args.length == 0)
        {
            die("You must enter a file name as an argument.");
        } 

        for(int i = 0; i < args.length - 1; i++)
        {
            if(args[i].equals("-n"))
            {    
                printLineNum = true;
            } else 
            {
                die("Unknown argument option " + args[i]);
            }
        }    

        File f = new File(args[args.length - 1]);

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
                if(true == printLineNum)
                {
                    System.out.print(lineNum + ") ");
                    lineNum++;
                }
                
                System.out.println(line);
            }
        }catch(FileNotFoundException e){}
    }
}
