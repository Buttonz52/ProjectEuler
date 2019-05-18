package com.company;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<BigInteger> primeList = new ArrayList<BigInteger>();
        primeList.add(new BigInteger("2"));

        BigInteger sum = BigInteger.ZERO;

        for(int i = 0; i < 148933; i++)
        {
            BigInteger j = primeList.get(i);
            sum = sum.add(j);
            do
            {
                j = j.add(BigInteger.ONE);
            }
            while(!j.isProbablePrime(10));

            primeList.add(j);
        }

        System.out.println(primeList.get(148932));
        System.out.println(sum);
    }
}
