package com.company;

public class Main {

    public static void main(String[] args) {

        int counter = 0;
        int diags = 1;
        int delta = 2;

        counter += diags;

        do
        {
            for (int i = 0; i < 4; i++)
            {
                diags += delta;
                counter += diags;
            }
            delta += 2;
        }
        while(delta < 1001);


        System.out.println(counter);

    }
}

//Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 spiral is formed as follows:
//
//21 22 23 24 25
//20  7  8  9 10
//19  6  1  2 11
//18  5  4  3 12
//17 16 15 14 13
//
//It can be verified that the sum of the numbers on the diagonals is 101.
//
//What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?