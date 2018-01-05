package com.company;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<BigInteger> primeList = new ArrayList<BigInteger>();
        primeList.add(new BigInteger("2"));
        BigInteger j = primeList.get(0);
        int count = 0;

        while(j.compareTo(new BigInteger("1000000")) != 0)
        {
            j = j.add(BigInteger.ONE);

            if(j.isProbablePrime(10))
                primeList.add(j);
        }

        System.out.println("Done!");

        for (int i = 0; i < primeList.size(); i++)
        {
            System.out.println(i);
            if(checkCircular(i,primeList))
                count++;
        }

        System.out.println("Count: "+count);

    }

    private static boolean checkCircular(int i, List<BigInteger> primeList)
    {
        String primeString = primeList.get(i).toString();
        int primeLen = primeString.length();

        if(primeLen == 1)
            return true;
        else
        {
            for (int j = 1; j < primeLen; j++)
            {
                String testPrime = "";
                for (int k = 0; k < primeLen; k++)
                {
                    testPrime += primeString.charAt((j+k) % primeLen);
                }
                if(!primeList.contains(new BigInteger(testPrime)))
                    return false;
            }
            return true;
        }
    }
}

//The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, are themselves prime.
//
//There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.
//
//How many circular primes are there below one million?