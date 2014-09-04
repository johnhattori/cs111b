/*
 *
 * Author: John Hattori
 * Date  : 08/31/14
 * Homework 01
 * Course: CS111B
 * Program Name: DemoGenIPADD.java
 * Objective: This program recieves an integer that represents 
 *            the number of IP addresses to generate. 
 *            If no integer is passed, generate one IP address.
 * 
 * 
 */


import java.util.ArrayList;

public class DemoGenIPADD
{
//************************** main() ********************************* 
    
    public static void main(String args[])
    {
        GenIPADD addresses; // declare GenIPADD type object.

        if(args.length == 0) // if no args passed in at command line,
                             // generate one IP address.
        {
            addresses = new GenIPADD();
        }

        else // generate args[0] IP addresses
        {
            addresses = new GenIPADD(Integer.parseInt(args[0])); 
        }
 
        ArrayList<String> ipaddresses = addresses.getIPAddresses();
        
        for(String ipadd : ipaddresses)
        {
            System.out.println(ipadd);
        }
        
    }
}
