package com.company;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {

        BigInteger sum = BigInteger.ONE;
        BigInteger i = BigInteger.ONE;

        while(i.compareTo(new BigInteger("20")) < 0)
        {
            sum = sum.multiply(i);
            i = i.add(BigInteger.ONE);
        }

        System.out.println(sum);
    }
}
