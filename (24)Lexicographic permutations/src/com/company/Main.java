package com.company;

import java.util.ArrayList;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Long> set = new ArrayList<Long>();

        String str = "0123456789";
        int l = str.length();
        set = permute(str,0,l-1,set);
        System.out.println("Done Perms");
        Collections.sort(set, Comparator.comparing(Long::valueOf));
        System.out.println(set.get(999999));

    }
    public static List<Long> permute(String str, int l, int r, List<Long> set)
    {
        if (l == r)
            set.add(Long.parseLong(str));
        else
        {
            for (int i = l; i <= r; i++)
            {
                str = swap(str,l,i);
                permute(str, l+1, r, set);
                str = swap(str,l,i);
            }
        }

        return set;
    }

    public static String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}

//A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4.
//If all of the permutations are listed numerically or alphabetically, we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are:
//
//012   021   102   120   201   210
//
//What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?