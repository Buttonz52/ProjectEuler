package com.company;

import java.math.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Integer> bag = new ArrayList<Integer>();
        int finalSum = 0;

        for (int i = 10; i < 1000000; i++)
        {
            String number = ""+i;
            int sum = 0;

            for (int j = 0; j < number.length(); j++)
                sum += Math.pow((number.charAt(j)-48),5);

            if(sum == i)
                bag.add(i);
        }

        for (int i = 0; i < bag.size(); i++)
            finalSum += bag.get(i);

        System.out.println("Done!");
        System.out.println("Sum: "+finalSum);

    }
}

//Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:
//
//1634 = 14 + 64 + 34 + 44
//8208 = 84 + 24 + 04 + 84
//9474 = 94 + 44 + 74 + 44
//As 1 = 14 is not a sum it is not included.
//
//The sum of these numbers is 1634 + 8208 + 9474 = 19316.
//
//Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.