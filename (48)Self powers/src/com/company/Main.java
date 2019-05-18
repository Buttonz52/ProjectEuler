package com.company;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        BigInteger n = new BigInteger("1");
        BigInteger sum = new BigInteger("0");

        for (int i = 1; i <= 1000; i++)
        {
            sum = sum.add(n.pow(i));
            n = n.add(BigInteger.ONE);
        }

        System.out.println(sum);
        System.out.println(sum.toString().substring(sum.toString().length()-10,sum.toString().length()));

    }
}

//The series, 1^1 + 2^2 + 3^3 + ... + 10^10 = 10405071317.
//
//Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 10001000.