package com.company;

public class Main {

    public static void main(String[] args) {

        int charCount = 0;
        String tmp = "";


        for(int i = 0; i < 1000; i++ )
        {
            tmp = getWord(i+1);
            charCount += tmp.length();
            System.out.println(tmp);
        }

//        for(int i = 1; i < 200; i++)
//            System.out.println(getWord(i));

        System.out.println(charCount);

    }

    public static String getWord(int n)
    {
        String soFar = "";
        int num = n;
        if(n == 1000)                   //thousands
            return "onethousand";

        if (n % 100 < 20){
            soFar = numNames[n % 100];
            n /= 100;
        }
        else {
            soFar = numNames[n % 10];
            n /= 10;

            soFar = tensNames[n % 10] + soFar;
            n /= 10;
        }
        if (n == 0) return soFar;

        if(num % 100 == 0)
            return numNames[n] + "hundred" + soFar;
        else
            return numNames[n] + "hundredand" + soFar;
    }

    private static final String[] tensNames = {
            "",
            "ten",
            "twenty",
            "thirty",
            "forty",
            "fifty",
            "sixty",
            "seventy",
            "eighty",
            "ninety"
    };

    private static final String[] numNames = {
            "",
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine",
            "ten",
            "eleven",
            "twelve",
            "thirteen",
            "fourteen",
            "fifteen",
            "sixteen",
            "seventeen",
            "eighteen",
            "nineteen"
    };
}
