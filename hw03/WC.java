/*
 
 Author: jhattori 
 Date  : 09/12/14
 Program Name: WC.java
 Objective: This program mimics WC in UNIX. When -c is passed in as command line
            argurment, WC counts the number of characters in the file passed in.
            When -w, words are counted; and when -l, lines are counted. If just
            a file is passed in, then characer, word and line count returned. 
            This program assumes that the last argument passed in is the file to be read.
            (note: This program only deals with ascii text files.)
 
*/
 
//import java.awt.*;
//import java.applet.*;
import java.util.*;
import java.io.*;
//import javax.swing.*;
 
public class WC
{
//******************* die() *************************
    
    public static void die(String msg)
    {
        System.err.println(msg);
        System.exit(1);
    }

//****************** getFile() **********************
    
    public static void getFile(String args[])
    {
        if(args.length == 0)
        {
            die("You must enter a file name as an argument.");
        }
      
        File rf = new File(args[args.length - 1]);

        if (!rf.exists()) die("file does not exist");
        if (rf.isDirectory()) die("is a directory");
        if (!rf.isFile()) die("file  irregular");
        if (!rf.canRead()) die("file not readable.");
        
        if(args.length == 1)
        {
            lineCount(rf);
            wordCount(rf);
            charCount(rf);
            System.exit(0);
        }

        boolean doCharCount = false;
        boolean doWordCount = false;
        boolean doLineCount = false;
        for(int i = 0; i < args.length - 1; i++)
        {
            if(args[i].equals("-c"))
            {
                doCharCount = true;
            }
            else if(args[i].equals("-w"))
            {
                doWordCount = true;
            }
            else if(args[i].equals("-l"))
            {
                doLineCount = true;
            } 
            else
            {
                die("Unknown argument option " + args[i]);
            }
        }
        if(true == doLineCount) lineCount(rf); 
        if(true == doWordCount) wordCount(rf);
        if(true == doCharCount) charCount(rf);
    }    

//*************** charCount() *********************

    public static void charCount(File cf)
    {
        try
        {
            Scanner sc = new Scanner(cf);
            int charCount = 0;

            while (sc.hasNext()) 
            {
                charCount += sc.nextLine().length() + 1;
            }
        
            System.out.println("Number of characters: " + charCount);
            sc.close();
        
        }catch(FileNotFoundException e) {System.out.println("File not found.");}
    }
//*************** wordCount() *********************


    public static void wordCount(File wf)
    {
        try
        {
            Scanner sc = new Scanner(wf);
            int wordCount = 0;

            while (sc.hasNext()) 
            {
                String line = sc.nextLine();
                wordCount += line.split(" ").length;
            }
        
        System.out.println("Number of words: " + wordCount);
        sc.close();
        
        }catch(FileNotFoundException e) {System.out.println("File not found.");}
    }
//*************** lineCount() *********************        
    
    public static void lineCount(File lf)
    {
        try
        {
            Scanner sc = new Scanner(lf);
            int lineCount = 0;    
            while(sc.hasNext())
            {
                String line = sc.nextLine();
                lineCount ++;
            }
            System.out.println("The number of lines: " + lineCount);

        } catch(FileNotFoundException e){System.out.println("File not found.");}
    }

//****************** main() *************************
    
    public static void main(String args[])
    {
        getFile(args); 
    }
}
