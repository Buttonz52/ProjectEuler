package com.company;

public class Main {

    public static void main(String[] args) {

        long sumOfSquares = 0;
        long squareOfSum = 0;

        for(long i = 1; i <= 100; i++)
        {
            sumOfSquares += i*i;
            squareOfSum += i;
        }

        squareOfSum *= squareOfSum;

        System.out.println(squareOfSum - sumOfSquares);
    }
}
