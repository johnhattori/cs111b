/*
 *
 * Author: John Hattori
 * Date  : 08/31/14
 * Homework 01
 * Course: CS111B
 * Class Name: GenIPADD.java
 * Objective: This class recieves an integer that represents 
 *            the number of IP addresses to generate. 
 *            If no integer is passed, generate one IP address.
 *
 */

import java.util.Random;
import java.util.ArrayList;

public class GenIPADD
{ 
    private ArrayList<String> ipAddresses = new ArrayList<String>();

//************************* GenIPADD() *****************************
    public GenIPADD(int howMany)
    {
        Random generator = new Random();
        
        for(int x = 0; x < howMany; x++)
        {    
            String ipadd = "";
            for(int i = 0; i < 4; i++)
            {
                int quad = generator.nextInt(256);
                ipadd += Integer.toString(quad);
                if(i != 3)
                {    
                    ipadd += ".";
                }    
            }
            this.ipAddresses.add(ipadd);
        }       
    }

    public GenIPADD() //if not args passed in, create one IP address.
    {
        this(1);
    }

//************ getIPAddresses (accessor for ipAddresses) ************
    public ArrayList<String> getIPAddresses()
    {
        return this.ipAddresses;
    }    

}
