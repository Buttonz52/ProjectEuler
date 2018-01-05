package com.company;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<BigInteger> primeList = new ArrayList<BigInteger>();
        primeList.add(new BigInteger("2"));
        BigInteger j = primeList.get(0);
        int sum = 0;

        while(j.compareTo(new BigInteger("1000000")) != 0)
        {
            j = j.add(BigInteger.ONE);

            if(j.isProbablePrime(10) && j.compareTo(new BigInteger("9")) == 1)
            {
                primeList.add(j);
                if(canTruncate(j))
                {
                    System.out.println(j);
                    sum += Integer.parseInt(j.toString());
                }
            }


        }

        System.out.println("Done!");
        System.out.println("Sum: "+sum);
    }

    private static boolean canTruncate(BigInteger n)
    {
        StringBuilder prime = new StringBuilder(n.toString());
        int primeLen = prime.length();

        //right truncating
        for (int i = 0; i < primeLen-1; i++)
        {
            prime.deleteCharAt(prime.length()-1);
            if(!new BigInteger(prime.toString()).isProbablePrime(10))
                return false;
        }

        prime = new StringBuilder(n.toString());
        primeLen = prime.length();

        //left truncating
        for (int i = 0; i < primeLen-1; i++)
        {
            prime.deleteCharAt(0);
            if(!new BigInteger(prime.toString()).isProbablePrime(10))
                return false;
        }

        return true;
    }
}

//The number 3797 has an interesting property. Being prime itself, it is possible to continuously remove
// digits from left to right, and remain prime at each stage: 3797, 797, 97, and 7. Similarly we can work
// from right to left: 3797, 379, 37, and 3.
//
//Find the sum of the only eleven primes that are both truncatable from left to right and right to left.
//
//NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.