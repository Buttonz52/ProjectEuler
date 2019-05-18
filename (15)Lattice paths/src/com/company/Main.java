package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        ArrayList<List<Long>> pTriangle = new ArrayList<List<Long>>();
        List<Long> ways = new ArrayList<Long>();
        int size = 2;
        int col = 40;

        for(long i = 0; i < col; i++)
        {
            List<Long> row = new ArrayList<Long>();
            row.add((long)1);            //last 1
            for(long j = 0; j < size-2; j++)
            {
                row.add( pTriangle.get((int) (i-1)).get((int) j) + pTriangle.get((int) (i-1)).get((int) (j+1)) );
            }
            row.add((long)1);            //last 1
            pTriangle.add(row);
            size++;
        }

        for(int i = 0; i < pTriangle.size(); i++)
        {
            if(i % 2 == 1)
            {
                ways.add(pTriangle.get(i).get(pTriangle.get(i).size()/2));
            }

        }

        for(int i = 0; i < ways.size(); i++)
        {
               // System.out.println(ways.get(i));
        }
        System.out.println(ways.get(19));

//        for(int m = 0; m < pTriangle.size(); m++)
//        {
//            for(int n = 0; n < pTriangle.get(m).size(); n++)
//            {
//                System.out.print(pTriangle.get(m).get(n));
//            }
//            System.out.println();
//        }
    }
}
