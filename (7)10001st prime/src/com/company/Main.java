package com.company;

import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<BigInteger> primeList = new ArrayList<BigInteger>();
        primeList.add(new BigInteger("2"));

        for(int i = 0; i < 10001; i++)
        {
            BigInteger j = primeList.get(i);
            do
            {
                j = j.add(BigInteger.ONE);
            }
            while(!j.isProbablePrime(100));

            primeList.add(j);
        }

        System.out.println(primeList.get(10000));

    }
}
