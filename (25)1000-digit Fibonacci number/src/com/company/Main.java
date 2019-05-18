package com.company;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {

        BigInteger n = new BigInteger("1");
        String size = "";
        BigInteger prev1 = n;
        BigInteger prev2 = new BigInteger("1");
        int i = 2;  //since i = 0, i = 1 are not caught by F1 = 1, F2 = 1. We start with F3 = 2

        while(size.length() != 1000)
        {
            n = fib2(prev1,prev2);
            size = n.toString();
            //System.out.println(size + " " + i);
            prev2 = prev1;
            prev1 = n;
            i++;
        }
        System.out.println(size);
        System.out.println(i);

    }

    public static BigInteger fib2(BigInteger n1, BigInteger n2)
    {
        return n1.add(n2);
    }

//    public static Long fib(Long n)    //this fib takes too long
//    {
//        if(n <= 2)
//            return Long.valueOf(1);
//        else
//            return fib(n-1) + fib(n-2);
//    }


}

//The Fibonacci sequence is defined by the recurrence relation:
//
//Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.
//Hence the first 12 terms will be:
//
//F1 = 1
//F2 = 1
//F3 = 2
//F4 = 3
//F5 = 5
//F6 = 8
//F7 = 13
//F8 = 21
//F9 = 34
//F10 = 55
//F11 = 89
//F12 = 144
//The 12th term, F12, is the first term to contain three digits.
//
//What is the index of the first term in the Fibonacci sequence to contain 1000 digits?

//1
//1             //6(5),5,4,5,5,5,4,5,5,5
//2
//3
//5
//8
//13
//21
//34
//55
//89
//144
//233
//377
//610
//987
//1597
//2584
//4181
//6765
//10946
//17711
//28657
//46368
//75025
//121393
//196418
//317811
//514229
//832040
//1346269
//2178309
//3524578
//5702887
//9227465
//14930352
//24157817
//39088169
//63245986
//102334155
//165580141
//267914296
//433494437
//701408733
//1134903170
//1836311903
//2971215073
//4807526976
//7778742049
//12586269025
//20365011074
//32951280099
//53316291173
//86267571272