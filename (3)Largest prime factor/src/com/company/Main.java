package com.company;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {

        BigInteger n = new BigInteger("600851475143");
        System.out.println(largestPrimeFactor(n, BigInteger.ONE));
    }

    public static BigInteger largestPrimeFactor(BigInteger n, BigInteger l)
    {
        BigInteger i = BigInteger.ONE;                      //starting greatest multiple

        while(i.compareTo(n) == -1)                         //bound my itself since itself could be prime and thus the greatest multiple
        {
            i = i.add(BigInteger.ONE);                      //this number gets increasing large and prime
            BigInteger[] m = n.divideAndRemainder(i);       // n/i.

            if(m[1].compareTo(BigInteger.ZERO) == 0)                      //if there is no remainder then i is a prime factor of n
            {
                if(l.compareTo(i) == 1)                     //if previously recorded largest prime factor is larger then i then us it recursively
                    return(largestPrimeFactor(m[0],l));
                else                                        //else use i which is larger than l
                    return(largestPrimeFactor(m[0],i));
            }

        }
        return l;
    }
}
