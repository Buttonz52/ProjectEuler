package com.company;

import java.math.BigInteger;
import java.math.BigInteger.*;

public class Main {



    public static void main(String[] args) {

        BigInteger maxN = new BigInteger("0");
        BigInteger maxA = new BigInteger("0");
        BigInteger maxB = new BigInteger("0");

        final int range = 1000;

        for (int a = -(range-1); a <= (range-1) ; a++)
        {
            for (int b = -range; b <= range; b++)
            {
                BigInteger n = new BigInteger("-1");
                BigInteger ans;
                do
                {
                    BigInteger aa = new BigInteger(""+a);
                    BigInteger bb = new BigInteger(""+b);
                    n = n.add(BigInteger.ONE);
                    ans = quad(n,aa,bb);
                    if(n.compareTo(maxN) == 1)
                    {
                        maxN = n;
                        maxA = aa;
                        maxB = bb;
                    }


                    System.out.println("a: "+a+" b: "+b);

                }
                while(ans.isProbablePrime(10));
            }
        }
        System.out.println("maxA: "+maxA+ " maxB: "+ maxB);
        System.out.println("maxN: "+maxN);
        System.out.println(maxA.multiply(maxB));


    }

    public static BigInteger quad(BigInteger n, BigInteger a, BigInteger b) //n^2 + an + b
    {
        return n.pow(2).add(n.multiply(a)).add(b);
    }
}

//Euler discovered the remarkable quadratic formula:
//
//n2+n+41n2+n+41
//It turns out that the formula will produce 40 primes for the consecutive integer values 0≤n≤390≤n≤39.
// However, when n=40,402+40+41=40(40+1)+41n=40,402+40+41=40(40+1)+41 is divisible by 41, and certainly
// when n=41,412+41+41n=41,412+41+41 is clearly divisible by 41.
//
//The incredible formula n2−79n+1601n2−79n+1601 was discovered, which produces 80 primes for the
// consecutive values 0≤n≤790≤n≤79. The product of the coefficients, −79 and 1601, is −126479.
//
//Considering quadratics of the form:
//
//n2+an+bn2+an+b, where |a|<1000|a|<1000 and |b|≤1000|b|≤1000
//
//where |n||n| is the modulus/absolute value of nn
//e.g. |11|=11|11|=11 and |−4|=4|−4|=4
//Find the product of the coefficients, aa and bb, for the quadratic expression that produces
// the maximum number of primes for consecutive values of nn, starting with n=0n=0.
