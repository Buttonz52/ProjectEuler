package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Integer> fibs = new ArrayList<Integer>();

        fibs.add(1);
        fibs.add(2);

        int i = 1;
        int max = 4000000;
        int sum = 2;

        while(fibs.get(i) < max)
        {

            fibs.add(getNextFib(fibs));
            i++;
            if(fibs.get(i) % 2 == 0)
                sum += fibs.get(i);
        }

        System.out.println(sum);
    }

    public static int getNextFib(List<Integer> fibs)
    {
        return fibs.get(fibs.size()-1) + fibs.get(fibs.size()-2);
    }

}
