package com.company;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {

        BigInteger two = new BigInteger("2");
        BigInteger num = two.pow(1000);

        String n = num.toString();
        //System.out.println(n);
        long ans = 0;

        for(long i = 0; i < n.length(); i++)
        {
            ans += Long.parseLong(n.charAt((int) i)+"");
        }

        System.out.println(ans);

    }
}
