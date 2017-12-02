package com.company;

import java.math.*;

public class Main {

    public static void main(String[] args) {

        for(int i = 1; i < 1000; i++)
        {
            for(int j = i; j < 1000; j++)
            {
                int a = i*i;
                int b = j*j;
                double c = Math.sqrt(a+b);

                if(c - (int)c == 0.0)
                {
//                    System.out.println(a);
//                    System.out.println(b);
//                    System.out.println(c);
                    if((i+j+c) == 1000.0)
                        System.out.println("a: " + i + "b: " + j + "c: " + c);
                }


            }
        }

    }
}

//    A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
//
//        a^2 + b^2 = c^2

//        For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
//
//        There exists exactly one Pythagorean triplet for which a + b + c = 1000.
//        Find the product abc.